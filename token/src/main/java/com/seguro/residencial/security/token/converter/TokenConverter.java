package com.seguro.residencial.security.token.converter;


import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.crypto.DirectDecrypter;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.SignedJWT;
import com.seguro.residencial.infra.auth.JwtConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

/**
 * @criado 19/09/2020 - 21:03
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 *
 * Classe responsavel para realizar a descriptografia do token
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TokenConverter {

    private final JwtConfiguration jwtConfiguration;

    @SneakyThrows
    public String decryptToken(String encryptedToken) {
        log.info("Token de descriptografia");

        JWEObject jweObject = JWEObject.parse(encryptedToken);

        DirectDecrypter directDecrypter = new DirectDecrypter(jwtConfiguration.getPrivateKey().getBytes());

        jweObject.decrypt(directDecrypter);

        log.info("Token descriptografado, retornando o token assinado. . . ");

        return jweObject.getPayload().toSignedJWT().serialize();
    }

    /***
     * Realiza a validação do token sempre quando o microservice realiza um requesição
     * @param signedToken
     */
    @SneakyThrows
    public void validateTokenSignature(String signedToken) {
        log.info("Iniciando método para validar a assinatura do token ...");

        SignedJWT signedJWT = SignedJWT.parse(signedToken);

        log.info("Token analisado! Recuperando a chave pública do token assinado");

        RSAKey publicKey = RSAKey.parse(signedJWT.getHeader().getJWK().toJSONObject());

        log.info("Chave pública recuperada, assinatura de validação. . . ");

        if (!signedJWT.verify(new RSASSAVerifier(publicKey)))
            throw new AccessDeniedException("Assinatura de token inválida!");

        log.info("O token tem uma assinatura válida");
    }


}
