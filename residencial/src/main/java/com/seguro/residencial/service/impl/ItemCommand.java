package com.seguro.residencial.service.impl;

import com.seguro.residencial.domain.commands.itens.RegistrarItemCommand;
import com.seguro.residencial.domain.interfaces.repository.item.IItemEnderecoRepository;
import com.seguro.residencial.domain.interfaces.repository.item.IItemRepository;
import com.seguro.residencial.domain.models.root.coberturas.CoberturasPacoteRoot;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import com.seguro.residencial.domain.models.root.itens.ItemEndereco;
import com.seguro.residencial.domain.models.root.itens.ItemRoot;
import com.seguro.residencial.service.IItemCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @criado 15/12/2020 - 21:46
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Service
@AllArgsConstructor
public class ItemCommand implements IItemCommand {

    private final IItemRepository itemRepository;

    private final IItemEnderecoRepository iItemEnderecoRepository;

    @Override
    public void command(RegistrarItemCommand command) {

        var cotacao = new CotacaoRoot();
        cotacao.setCodigoCotacao(command.getIdCotacao());

        var item = new ItemRoot();
        item.setCotacao(cotacao);
        item.setId(command.getId());

        var pacoteCobertura = new CoberturasPacoteRoot();
        pacoteCobertura.setId(command.getIdPacoteCobertura());

        item.setCobertura(pacoteCobertura);
        item.setTipoRisco(command.getTipoRisco());

        item.setEnderecoItem(new ItemEndereco(UUID.randomUUID().toString(), item,
                command.getLogradouro(),
                command.getNumero(),
                command.getComplemento(),
                command.getCidade(),
                command.getUf(),
                command.getCep()));

        var objItem = itemRepository.save(item);

        iItemEnderecoRepository.save(objItem.getEnderecoItem());
    }
}
