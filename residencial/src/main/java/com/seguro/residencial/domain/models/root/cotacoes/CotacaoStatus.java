package com.seguro.residencial.domain.models.root.cotacoes;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @criado 27/10/2020 - 13:43
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
public enum CotacaoStatus {

    CRIADA("Criada"),
    CALCULADA("Calculada"),
    AGUARDANDO_PAGAMENTO("Aguardando Pagamento"),
    PAGAMENTO_CONFIRMADO("Efeitvada");

    private String descricao;

    CotacaoStatus(String descricao) {
        this.descricao = descricao;
    }
}
