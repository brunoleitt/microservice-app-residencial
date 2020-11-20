package com.seguro.residencial.itens;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lombok.Getter;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;

/**
 * @criado 20/11/2020 - 19:06
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CoberturasTests {

    private final static Long idTipoRiscoCasa = 1L;
    private final static Long idPacoteCoberturaPlus = 2L;

    @Before
    public void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = 8082;
        RestAssured.basePath = "/v1/coberturas/consulta/";
    }

    @Test
    public void consultaPacoteCoberturas_DeveRetornaStatus200() {
        given()
                .pathParam("idTipoRisco", idTipoRiscoCasa)
                .pathParam("idTipoCobertura", idPacoteCoberturaPlus)
                .accept(ContentType.JSON)
                .when()
                .get("/tiporisco/{idTipoRisco}/coberturas/{idTipoCobertura}/pacote-cobertura")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void consultaPacoteServicos_DeveRetornaStatus200() {
        given()
                .pathParam("idTipoRisco", idTipoRiscoCasa)
                .pathParam("idTipoCobertura", idPacoteCoberturaPlus)
                .accept(ContentType.JSON)
                .when()
                .get("/tiporisco/{idTipoRisco}/coberturas/{idTipoCobertura}/pacote-servicos")
                .then()
                .statusCode(HttpStatus.OK.value());
    }


}
