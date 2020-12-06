package com.seguros.relatorio;

import com.seguros.relatorio.application.interfaces.IImpressaoAppService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

        //var cotacao =  impressaoAppService.registrarImpressaoCotacao(objCotacao);
    }



}
