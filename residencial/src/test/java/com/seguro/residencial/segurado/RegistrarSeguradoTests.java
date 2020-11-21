package com.seguro.residencial.segurado;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import util.ResourceUtils;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @criado 21/11/2020 - 18:04
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RegistrarSeguradoTests {

    private static final String jsonRegistrarSeguradoCorreto = ResourceUtils.getContentFromResource(
            "/json/correto/segurado/registrar-segurado.json");

    private static final String jsonRegistrarSeguradoMenorIdade = ResourceUtils.getContentFromResource(
            "/json/correto/segurado/registrar-segurado-menor-idade.json");

    private static final String jsonRegistrarSeguradoCPFinvalido = ResourceUtils.getContentFromResource(
            "/json/correto/segurado/registrar-segurado-cpf-invalido.json");

    private static final String jsonRegistrarSeguradoSexoInexistente = ResourceUtils.getContentFromResource(
            "/json/correto/segurado/registrar-segurado-sexo-inexistente.json");

    private static final String jsonRegistrarSeguradoProfissaoInexistente = ResourceUtils.getContentFromResource(
            "/json/correto/segurado/registrar-segurado-profissao-inexistente.json");

    private static final String jsonRegistrarSeguradoEmailInvalido = ResourceUtils.getContentFromResource(
            "/json/correto/segurado/registrar-segurado-email-invalido.json");

    private static final String jsonRegistrarSeguradoEmailObrigatorio = ResourceUtils.getContentFromResource(
            "/json/correto/segurado/registrar-segurado-email-obrigatorio.json");

    private static final String codigoCotacao = "49464a38-dbbb-4188-8b8b-37fad49425b3";

    @Before
    public void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = 8082;
        RestAssured.basePath = "/v1/cotacao";
    }

    @Test
    public void novoSegurado_DeveRetornaStatus201() {
        given()
                .body(jsonRegistrarSeguradoCorreto)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post("/{idCotacao}/cliente",codigoCotacao)
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void novoSeguradoMenorIdade_DeveRetornaStatus400() {

        given()
                .body(jsonRegistrarSeguradoMenorIdade)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post("/{idCotacao}/cliente",codigoCotacao)
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("detail", equalTo("Segurado não poder ser menor de idade."));
    }

    @Test
    public void novoSeguradoCPFInvalido_DeveRetornaStatus400() {

        given()
                .body(jsonRegistrarSeguradoCPFinvalido)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post("/{idCotacao}/cliente",codigoCotacao)
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("objects[0].userMessage", equalTo("cpf inválido"));
    }

    @Test
    public void novoSeguradoSexoInvalido_DeveRetornaStatus400() {

        given()
                .body(jsonRegistrarSeguradoSexoInexistente)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post("/{idCotacao}/cliente",codigoCotacao)
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("detail", equalTo("Codigo tipo de sexo não encontrada para id: 99"));

    }

    @Test
    public void novoSeguradoProfissaoInexistente_DeveRetornaStatus400() {

        given()
                .body(jsonRegistrarSeguradoProfissaoInexistente)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post("/{idCotacao}/cliente",codigoCotacao)
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("detail", equalTo("Codigo tipo de profissao não encontrada para id: 99"));

    }

    @Test
    public void novoSeguradoEmailInvalido_DeveRetornaStatus400() {

        given()
                .body(jsonRegistrarSeguradoEmailInvalido)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post("/{idCotacao}/cliente",codigoCotacao)
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("objects[0].userMessage", equalTo("Campo E-mail deve ser um endereço de e-mail válido"));

    }

    @Test
    public void novoSeguradoEmailObrigatorio_DeveRetornaStatus400() {

        given()
                .body(jsonRegistrarSeguradoEmailObrigatorio)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post("/{idCotacao}/cliente",codigoCotacao)
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("objects[0].userMessage", equalTo("Campo E-mail é obrigatório"));

    }

}
