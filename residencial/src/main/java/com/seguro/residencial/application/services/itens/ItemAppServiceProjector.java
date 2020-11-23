package com.seguro.residencial.application.services.itens;

import com.seguro.residencial.application.interfaces.IItemAppService;
import com.seguro.residencial.application.models.input.item.RegistrarItemInput;
import com.seguro.residencial.domain.commands.itens.RegistrarItemCommand;
import com.seguro.residencial.domain.exception.CotacaoNaoEncontradaException;
import com.seguro.residencial.domain.exception.coberturas.PacoteCoberturaNaoEncontradaException;
import com.seguro.residencial.domain.exception.itens.TipoRiscoNaoEncontradaException;
import com.seguro.residencial.domain.interfaces.repository.coberturas.IPacoteCoberturasRespository;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoQueryRepository;
import com.seguro.residencial.domain.interfaces.repository.item.ITipoRisco;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

/**
 * @criado 07/11/2020 - 17:45
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Service
@AllArgsConstructor
public class ItemAppServiceProjector implements IItemAppService {

    private final CommandGateway commandGateway;

    private final ICotacaoQueryRepository iCotacaoQueryRepository;

    private final ITipoRisco iTipoRisco;

    //TODO private final IPacoteCoberturasRespository iPacoteCoberturas;

    @Override
    public void registrarItem(String idCotacao, RegistrarItemInput item) {

        var cotacaoRoot = iCotacaoQueryRepository.consultarCotacao(idCotacao)
                .orElseThrow(() -> new CotacaoNaoEncontradaException(idCotacao));

        var tipoRisco = iTipoRisco.findById(item.getIdTipoRisco())
                .orElseThrow(() -> new TipoRiscoNaoEncontradaException(item.getIdTipoRisco()));

        var commandItem = new RegistrarItemCommand(UUID.randomUUID().toString(),
                tipoRisco,item.getIdPacoteCobertura(),
                cotacaoRoot.getCodigoCotacao(), item.getLogradouro(),
                item.getNumero(),item.getComplemento(),
                item.getCidade(),item.getUf(),item.getCep());

        commandGateway.send(commandItem);
    }

}
