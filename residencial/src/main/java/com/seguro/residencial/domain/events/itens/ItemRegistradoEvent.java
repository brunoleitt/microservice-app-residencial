package com.seguro.residencial.domain.events.itens;

import com.seguro.residencial.domain.models.root.itens.TipoRisco;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @criado 07/11/2020 - 15:44
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@AllArgsConstructor
public class ItemRegistradoEvent {

    private String id;
    private String codigoCotacao;
    private TipoRisco tipoRisco;
    private Long idPacoteCobertura;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;
    private String cep;

}
