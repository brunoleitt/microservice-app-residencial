package com.seguro.residencial.application.models.view.messages.relatorios.cotacoes;

import com.seguro.residencial.domain.models.root.segurados.Profissao;
import com.seguro.residencial.domain.models.root.segurados.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private Profissao profissao;
    private Sexo sexo;

}
