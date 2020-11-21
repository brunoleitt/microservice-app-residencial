package com.seguro.residencial.domain.events.clientes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.OffsetDateTime;

/**
 * @criado 21/11/2020 - 12:42
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@AllArgsConstructor
public class ClienteRegistradoEvent {
    private Long id;
    private String nome;
    private String sobreNome;
    private String cpf;
    private String telefone;
    private String rg;
    private String email;
    private LocalDate dataNascimento;
    private Long idCotacao;
    private Long idProfissao;
    private Long idSexo;
}
