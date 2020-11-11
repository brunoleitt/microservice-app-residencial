package com.seguro.residencial.domain.interfaces.repository.item;

import com.seguro.residencial.domain.models.root.itens.ItemRoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @criado 07/11/2020 - 17:00
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Repository
public interface IItemRepository extends JpaRepository<ItemRoot,Long> {

}
