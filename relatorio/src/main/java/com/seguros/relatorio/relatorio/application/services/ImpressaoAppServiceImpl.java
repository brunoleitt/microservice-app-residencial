package com.seguros.relatorio.relatorio.application.services;

import com.seguros.relatorio.relatorio.application.assembler.ObjectMapperUtils;
import com.seguros.relatorio.relatorio.application.interfaces.IImpressaoAppService;
import com.seguros.relatorio.relatorio.application.models.views.cotacoes.CotacaoViewModel;
import com.seguros.relatorio.relatorio.domain.exception.CotacaoNaoEntradaException;
import com.seguros.relatorio.relatorio.domain.model.coberturas.Coberturas;
import com.seguros.relatorio.relatorio.domain.model.coberturas.CoberturasServicos;
import com.seguros.relatorio.relatorio.domain.model.coberturas.PacoteCoberturaRoot;
import com.seguros.relatorio.relatorio.domain.model.cotacoes.Cotacao;
import com.seguros.relatorio.relatorio.domain.model.itens.ItemEndereco;
import com.seguros.relatorio.relatorio.domain.model.itens.ItemRoot;
import com.seguros.relatorio.relatorio.domain.repository.ICotacaoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @criado 02/12/2020 - 10:46
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@AllArgsConstructor
@Slf4j
@Service
public class ImpressaoAppServiceImpl implements IImpressaoAppService {

    private final ICotacaoRepository cotacaoRepository;

    @Override
    public CotacaoViewModel consultaCotacao(String codigoCotacao) {
        var cotacao = cotacaoRepository.findById(codigoCotacao)
                .orElseThrow(() -> new CotacaoNaoEntradaException(codigoCotacao));

        return ObjectMapperUtils.map(cotacao,CotacaoViewModel.class);
    }

    @Override
    public Cotacao registrarImpressaoCotacao(Cotacao cotacao) {

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

        return cotacaoRepository.save(objCotacao);
    }
}
