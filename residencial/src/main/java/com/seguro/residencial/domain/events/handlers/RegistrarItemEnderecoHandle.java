package com.seguro.residencial.domain.events.handlers;

import com.seguro.residencial.domain.events.itens.ItemEnderecoRegistradoEvent;
import com.seguro.residencial.domain.interfaces.repository.item.IItemEnderecoRepository;
import com.seguro.residencial.domain.models.root.itens.ItemEndereco;
import com.seguro.residencial.domain.models.root.itens.ItemRoot;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @criado 07/11/2020 - 19:28
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
//@Component
public class RegistrarItemEnderecoHandle {

    private final IItemEnderecoRepository enderecoRepository;

    public RegistrarItemEnderecoHandle(IItemEnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

//    @EventHandler
//    public void on(ItemEnderecoRegistradoEvent event) {
//
//        var item = new ItemRoot();
//        item.setId(event.getId());
//
//        var itemEdereco = new ItemEndereco(new Random().nextLong(),item,
//                event.getLogradouro(),
//                event.getNumero(),
//                event.getComplemento(),
//                event.getCidade(),
//                event.getUF(),
//                event.getCEP());
//
//        item.setEnderecoItem(itemEdereco);
//        enderecoRepository.save(itemEdereco);
//    }

}
