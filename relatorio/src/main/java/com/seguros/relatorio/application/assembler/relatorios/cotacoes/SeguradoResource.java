package com.seguros.relatorio.application.assembler.relatorios.cotacoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.PersistenceConstructor;

import java.time.LocalDate;

/**
 * @criado 05/12/2020 - 18:44
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeguradoResource {

    private String nome;
    private String sobreNome;
    private String cpf;
    private String telefone;
    private String rg;
    private String email;
    private LocalDate dataNascimento;
    private ProfissaoResource profissao;
    private SexoResource sexo;


    @Data
    @NoArgsConstructor
    public class ProfissaoResource{


        @PersistenceConstructor
        public ProfissaoResource(Long id, String descricao) {
            this.id = id;
            this.descricao = descricao;
        }

        private Long id;
        private String descricao;
    }

    @Data
    @NoArgsConstructor
    public class SexoResource{

        @PersistenceConstructor
        public SexoResource(Long id, String descricao) {
            this.id = id;
            this.descricao = descricao;
        }

        private Long id;
        private String descricao;
    }

}
