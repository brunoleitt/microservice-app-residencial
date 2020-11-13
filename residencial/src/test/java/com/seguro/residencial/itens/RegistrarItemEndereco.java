package com.seguro.residencial.itens;

import com.seguro.residencial.application.models.input.cotacao.RegistrarCotacaoInput;
import com.seguro.residencial.application.models.input.item.RegistrarItemInput;
import com.seguro.residencial.domain.aggregates.CotacaoAggregate;
import com.seguro.residencial.domain.commands.cotacoes.RegistrarCotacaoCommand;
import com.seguro.residencial.domain.events.RegistradaCotacaoEvent;
import com.seguro.residencial.domain.models.root.cotacoes.TipoCalculo;
import com.seguro.residencial.domain.models.root.cotacoes.TipoVigencia;
import com.seguro.residencial.web.api.controller.cotacoes.CotacaoController;
import com.seguro.residencial.web.api.controller.itens.ItemController;
import lombok.Getter;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

/**
 * @criado 31/10/2020 - 22:25
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@ExtendWith(MockitoExtension.class)
@Getter
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RegistrarItemEndereco {

    private static final Long tipoVigenciaAnual = 1L;
    private static final Long tipoCalculoCotacao = 1L;

    private static final UUID codigoCotacao = UUID.randomUUID();

    private static final Long id = new Random().nextLong();

    @InjectMocks
    ItemController itmItemController;

    @InjectMocks
    CotacaoController cotacaoController;

    private AggregateTestFixture<CotacaoAggregate> accountFixture;


    @Before
    public void setUp() {

    }

    @Test
    public void novoItem_DeveRetornaStatus201() {

        var tipoCalculo = new TipoCalculo();
        tipoCalculo.setId(tipoCalculoCotacao);

        var tipoVigencia = new TipoVigencia();
        tipoVigencia.setId(tipoCalculoCotacao);


        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        var input = new RegistrarCotacaoInput();
        input.setIdTipoCalculo(tipoCalculoCotacao);
        input.setIdTipoVigencia(tipoVigenciaAnual);
        input.setDataVigenciaInicial(LocalDate.now());

        var cotacaoRegistrada = cotacaoController.criarCotacao(input);

        var registrarItemEndereco = new RegistrarItemInput(
                cotacaoRegistrada.getCodigoCotacao(),
                        "Teste Logradouro",
                        "999",
                        "Teste Complemento",
                        "Teste Cidade",
                        "TT",
                        "00000000");


        itmItemController.registrarItem(registrarItemEndereco);
    }

    @Test
    public void novaCotacaoVigenciaInicialInferiorDataAtual_retornaStatus400() {

    }


    @Test
    public void novaCotacaoTipoCalculoInexistente_retornaStatus400() {

    }

    @Test
    public void novaCotacaoTipoVigenciaInexistente_retornaStatus400() {

    }
}
