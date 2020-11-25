package com.seguro.residencial.itens;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lombok.Getter;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import util.ResourceUtils;

import static io.restassured.RestAssured.given;

/**
 * @criado 31/10/2020 - 22:25
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RegistrarItemTests {

    private static final String jsonRegistrarCotacaoCorreto = ResourceUtils.getContentFromResource(
            "/json/correto/cotacoes/registrar-cotacao.json");

    private static final String jsonRegistrarItemCorreto = ResourceUtils.getContentFromResource(
            "/json/correto/itens/registrar-item.json");

    private static final String jsonRegistrarItemEnderecoSemCepErrado = ResourceUtils.getContentFromResource(
            "/json/correto/itens/registrar-item-sem-campo-cep.json");

    private static final String jsonRegistrarItemEnderecoCepErrado = ResourceUtils.getContentFromResource(
            "/json/correto/itens/registrar-item-cep-errado.json");

    private static final String jsonRegistrarItemCoberturaInexistente = ResourceUtils.getContentFromResource(
            "/json/correto/itens/registrar-item-cobertura-inexistente.json");



    @Before
    public void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = 8082;
        RestAssured.basePath = "/v1/cotacao";
    }

    @Test
    public void novoItem_DeveRetornaStatus201() {

        String codCotacao =  given()
                .body(jsonRegistrarCotacaoCorreto)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post()
                .then()
                .statusCode(HttpStatus.CREATED.value()).extract().path("codigoCotacao");


        given()
                .body(jsonRegistrarItemCorreto)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post("/{idCotacao}/item",codCotacao)
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void novoItemEnderecoSemCampoCep_DeveRetornaStatus400() {
        String codCotacao =  given()
                .body(jsonRegistrarCotacaoCorreto)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post()
                .then()
                .statusCode(HttpStatus.CREATED.value()).extract().path("codigoCotacao");


        given()
                .body(jsonRegistrarItemEnderecoSemCepErrado)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post("/{idCotacao}/item",codCotacao)
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void novoItemEnderecoCepErrado_DeveRetornaStatus400() {
        String codCotacao =  given()
                .body(jsonRegistrarCotacaoCorreto)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post()
                .then()
                .statusCode(HttpStatus.CREATED.value()).extract().path("codigoCotacao");


        given()
                .body(jsonRegistrarItemEnderecoSemCepErrado)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post("/{idCotacao}/item",codCotacao)
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void novoItemPacoteCoberturaNaoExiste_DeveRetornaStatus400() {
        String codCotacao =  given()
                .body(jsonRegistrarCotacaoCorreto)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post()
                .then()
                .statusCode(HttpStatus.CREATED.value()).extract().path("codigoCotacao");


        given()
                .body(jsonRegistrarItemCoberturaInexistente)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post("/{idCotacao}/item",codCotacao)
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

}
