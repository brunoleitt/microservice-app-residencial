package com.seguros.relatorio;

import com.seguros.relatorio.application.interfaces.IImpressaoAppService;
import com.seguros.relatorio.domain.model.coberturas.Coberturas;
import com.seguros.relatorio.domain.model.coberturas.CoberturasServicos;
import com.seguros.relatorio.domain.model.coberturas.PacoteCoberturaRoot;
import com.seguros.relatorio.domain.model.cotacoes.Cotacao;
import com.seguros.relatorio.domain.model.itens.ItemEndereco;
import com.seguros.relatorio.domain.model.itens.ItemRoot;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class RelatorioApplicationTests {


    @Autowired
    private IImpressaoAppService impressaoAppService;

    @Test
    void contextLoads() {
    }


    @Test
    public void cadastrarCotacaoImpressao(){

        var servicos = new CoberturasServicos("Eletricista");
        var servico2 = new CoberturasServicos("Encanador");

        List<CoberturasServicos> coberturasServicos = new ArrayList<>();
        coberturasServicos.add(servicos);
        coberturasServicos.add(servico2);

        var cobertura_1 = new Coberturas("Incêndio, Explosão e Fumaça","200");
        var cobertura_2 = new Coberturas("Vendaval, Ciclone ou Chuva de Granizo","63000");

        List<Coberturas> coberturas = new ArrayList<>();
        coberturas.add(cobertura_1);
        coberturas.add(cobertura_2);
        

        var pacoteCobertura = new PacoteCoberturaRoot("Basica","1400","1800",coberturas,coberturasServicos);

        var enderecoItem = new ItemEndereco("05734140","Recife","Teste complemento",
                "teste logradouro","1160","pe");

        var item = new ItemRoot("APTO",enderecoItem,pacoteCobertura);

        var objCotacao = new Cotacao("8eb8cff8-1a38-45f5-a7db-333a8fe3acbb","2020-11-24",
                                 "2021-11-10","2022-11-10","CALCULADA","COTACAO","ANUAL",item);


        var cotacao =  impressaoAppService.registrarImpressaoCotacao(objCotacao);
    }



}
