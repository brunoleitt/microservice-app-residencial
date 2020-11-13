package com.seguro.residencial.application.services.itens;

import com.seguro.residencial.application.interfaces.IItemAppService;
import com.seguro.residencial.application.models.input.item.RegistrarItemInput;
import com.seguro.residencial.domain.commands.itens.RegistrarItemCommand;
import com.seguro.residencial.domain.exception.CotacaoNaoEncontradaException;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoQueryRepository;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.Random;

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

    @Override
    public void registrarItem(RegistrarItemInput item) {

        var cotacaoRoot = iCotacaoQueryRepository.consultarCotacao(item.getCodigoCotacao())
                .orElseThrow(() -> new CotacaoNaoEncontradaException(item.getCodigoCotacao()));

        var commandItem = new RegistrarItemCommand(new Random().nextLong(),
                cotacaoRoot.getId(), item.getLogradouro(),
                item.getNumero(),item.getComplemento(),
                item.getCidade(),item.getUf(),item.getCep());

        commandGateway.sendAndWait(commandItem);
    }

}
