package com.seguro.residencial.security.token.creator;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.DirectEncrypter;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.seguro.residencial.core.model.ApplicationUser;
import com.seguro.residencial.core.property.JwtConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

/**
 * @criado 19/09/2020 - 21:03
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TokenCreator {

    private final JwtConfiguration jwtConfiguration;

    /*
     * - Criação dos cleans
     *
     * - Os microservicos não mantem dados na seceção(STATELESS). Precisamos passar tudo o que pode ser utilizado
     * nos outros microservices.
     * */
    @SneakyThrows
    public SignedJWT createSignedJWT(Authentication auth) {
        log.info("Começando a criar o JWT assinado");

        ApplicationUser applicationUser = (ApplicationUser) auth.getPrincipal();

        /*Criando as cleans*/
        JWTClaimsSet jwtClaimSet = createJWTClaimSet(auth, applicationUser);

        KeyPair rsaKeys = generateKeyPair();

        log.info("Construindo JWK a partir das chaves RSA");
        //Geração de chave publica e privada
        JWK jwk = new RSAKey.Builder((RSAPublicKey) rsaKeys.getPublic()).keyID(UUID.randomUUID().toString()).build();

        SignedJWT signedJWT = new SignedJWT(new JWSHeader.Builder(JWSAlgorithm.RS256)
                .jwk(jwk) //Chave gerada publica
                .type(JOSEObjectType.JWT)
                .build(), jwtClaimSet);

        log.info("Assinando o token com a chave RSA privada");
        RSASSASigner signer = new RSASSASigner(rsaKeys.getPrivate());

        signedJWT.sign(signer);

        log.info("Token serializado '{}'", signedJWT.serialize());
        return signedJWT;
    }

    /*
     *  Os microservicos não mantem dados na seceção(STATELESS). Precisamos passar tudo o que pode ser utilizado
     * nos outros microservices.
     * */
    private JWTClaimsSet createJWTClaimSet(Authentication auth, ApplicationUser applicationUser) {
        log.info("Criando o objeto JwtClaimSet para '{}'", applicationUser);

        return new JWTClaimsSet.Builder()
                .subject(applicationUser.getUsername())
                .claim("authorities", auth.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(toList()))
                .claim("userId",applicationUser.getId())
                .issuer("http://seguros.residencial")
                .issueTime(new Date())
                .expirationTime(new Date(System.currentTimeMillis() + (jwtConfiguration.getExpiration() * 1000)))
                .build();
    }

    @SneakyThrows
    private KeyPair generateKeyPair() {
        log.info("Geração RSA 2048 bits Keys");

        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");

        generator.initialize(2048);

        return generator.genKeyPair();
    }

    public String encryptToken(SignedJWT signedJWT) throws JOSEException {
        log.info("Iniciando o metodo de encryptToken");

        DirectEncrypter directEncrypter = new DirectEncrypter(jwtConfiguration.getPrivateKey().getBytes());

        JWEObject jweObject = new JWEObject(new JWEHeader.Builder(JWEAlgorithm.DIR, EncryptionMethod.A128CBC_HS256)
                .contentType("JWT")
                .build(), new Payload(signedJWT));

        log.info("Criptografando o token com a chave privada do sistema");

        jweObject.encrypt(directEncrypter);

        log.info("Token criptografado");

        return jweObject.serialize();
    }

}
