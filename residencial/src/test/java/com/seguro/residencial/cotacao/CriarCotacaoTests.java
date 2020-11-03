package com.seguro.residencial.cotacao;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import util.ResourceUtils;

import static io.restassured.RestAssured.given;

/**
 * @criado 31/10/2020 - 22:25
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class CriarCotacaoTests {

    private String jsonCriarCotacaoCorreto;

    private String jsonCriarCotacaoDataInicioVigenciaInferiorDataAtual;

    private String jsonCriarCotacaoTipoCalculoInexisten;

    private String jsonCriarCotacaoTipoVigenciaInexisten;

    @Before
    public void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = 8082;
        RestAssured.basePath = "/v1/residencial/cotacao";

        jsonCriarCotacaoCorreto = ResourceUtils.getContentFromResource(
                "/json/correto/criar-cotacao.json");

        jsonCriarCotacaoDataInicioVigenciaInferiorDataAtual = ResourceUtils.getContentFromResource(
                "/json/incorreto/criar-cotacao-data-inicio-vigencia-errada.json");

        jsonCriarCotacaoTipoCalculoInexisten = ResourceUtils.getContentFromResource(
                "/json/incorreto/criar-cotacao-tipo-calculo-inexistente.json");

        jsonCriarCotacaoTipoVigenciaInexisten = ResourceUtils.getContentFromResource(
                "/json/incorreto/criar-cotacao-tipo-vigencia-inexistente.json");
    }

    @Test
    public void novaCotacaoVigenciaAnual_DeveRetornaStatus201() {
        given()
                .body(jsonCriarCotacaoCorreto)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void novaCotacaoVigenciaInicialInferiorDataAtual_retornaStatus400() {
        given()
                .body(jsonCriarCotacaoDataInicioVigenciaInferiorDataAtual)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }


    @Test
    public void novaCotacaoTipoCalculoInexistente_retornaStatus400() {
        given()
                .body(jsonCriarCotacaoTipoCalculoInexisten)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void novaCotacaoTipoVigenciaInexistente_retornaStatus400() {
        given()
                .body(jsonCriarCotacaoTipoVigenciaInexisten)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }
}
