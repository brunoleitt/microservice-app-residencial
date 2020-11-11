package com.seguro.residencial.domain.events.handlers;

import com.seguro.residencial.domain.events.itens.ItemRegistradoEvent;
import com.seguro.residencial.domain.interfaces.repository.item.IItemEnderecoRepository;
import com.seguro.residencial.domain.interfaces.repository.item.IItemRepository;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import com.seguro.residencial.domain.models.root.itens.ItemEndereco;
import com.seguro.residencial.domain.models.root.itens.ItemRoot;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * @criado 07/11/2020 - 16:58
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Slf4j
@Component
@AllArgsConstructor
public class RegistrarItemCommandHandle {

    private final IItemRepository itemRepository;

    private final IItemEnderecoRepository iItemEnderecoRepository;

    @EventHandler
    @Transactional
    public Long on(ItemRegistradoEvent event) {

        var cotacao = new CotacaoRoot();
        cotacao.setId(event.getIdCotacao());

        var item = new ItemRoot();
        item.setCotacao(cotacao);

        item.setEnderecoItem(new ItemEndereco(new Random().nextLong(), item,
                event.getLogradouro(),
                event.getNumero(),
                event.getComplemento(),
                event.getCidade(),
                event.getUf(),
                event.getCep()));

        var objItem = itemRepository.save(item);

        iItemEnderecoRepository.save(objItem.getEnderecoItem());

        return objItem.getId();
    }

}
