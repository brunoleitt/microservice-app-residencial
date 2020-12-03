package com.seguros.relatorio.relatorio.domain.model.segurado;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @criado 02/12/2020 - 10:19
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

@Getter
@Setter
@NoArgsConstructor
public class SeguradoRoot {
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private String rg;
    private String telefone;
    private String profissao;
    private String sexo;
}
