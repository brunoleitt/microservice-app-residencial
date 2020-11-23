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
    private String id;
    private String nome;
    private String sobreNome;
    private String cpf;
    private String telefone;
    private String rg;
    private String email;
    private LocalDate dataNascimento;
    private String codigoCotacao;
    private Long idProfissao;
    private Long idSexo;
}
