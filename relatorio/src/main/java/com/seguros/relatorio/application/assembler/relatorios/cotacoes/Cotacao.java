package com.seguros.relatorio.application.assembler.relatorios.cotacoes;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import java.time.LocalDate;

/**
 * @criado 05/12/2020 - 18:22
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cotacao {

    @Id
    private String codigoCotacao;
    private LocalDate dataCotacao;
    private LocalDate  dataVigenciaInicial;
    private LocalDate  dataVigenciaFinal;
    private TipoCalculoResource tipoCalculo;
    private TipoVigenciaResource tipoVigencia;
    private StatusCotacaoResource status;
    private ItemResource item;
    private SeguradoResource segurado;
    private String TesteUsuario;

    @Getter
    @Setter
    @NoArgsConstructor
    public class TipoCalculoResource{

        @PersistenceConstructor
        public TipoCalculoResource(Long id, String descricao) {
            this.id = id;
            this.descricao = descricao;
        }

        private Long id;
        private String descricao;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public class TipoVigenciaResource{

        @PersistenceConstructor
        public TipoVigenciaResource(Long id, String descricao) {
            this.id = id;
            this.descricao = descricao;
        }

        private Long id;
        private String descricao;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public class StatusCotacaoResource{

        @PersistenceConstructor
        public StatusCotacaoResource(Long id, String descricao) {
            this.id = id;
            this.descricao = descricao;
        }

        private Long id;
        private String descricao;
    }

}
