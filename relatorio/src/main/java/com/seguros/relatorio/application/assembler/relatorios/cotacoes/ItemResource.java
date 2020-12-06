package com.seguros.relatorio.application.assembler.relatorios.cotacoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.PersistenceConstructor;

/**
 * @criado 05/12/2020 - 18:24
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
class ItemResource {
    private CoberturasPacoteResouce cobertura;
    private TipoRiscoResource tipoRisco;
    private ItemEnderecoResource enderecoItem;

    @Data
    @NoArgsConstructor
    public class TipoRiscoResource {

        @PersistenceConstructor
        public TipoRiscoResource(Long id, String descricao) {
            this.id = id;
            this.descricao = descricao;
        }

        private Long id;
        private String descricao;
    }
}
