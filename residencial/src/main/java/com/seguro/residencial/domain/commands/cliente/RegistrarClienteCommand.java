package com.seguro.residencial.domain.commands.cliente;

import com.seguro.residencial.domain.commands.validacoes.cliente.RegistrarClienteCommandValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDate;
import java.time.OffsetDateTime;

/**
 * @criado 21/11/2020 - 12:31
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@AllArgsConstructor
public class RegistrarClienteCommand {

    @TargetAggregateIdentifier
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

    public void isValid(){
        new RegistrarClienteCommandValidation(this).IsValid();
    }

    //TODO
    // 1- Cliente menor de idade não pode realizar cotação
    // 2- Cliente com idade entre 18 a 25 anos, só pode contratar pacote de coberturas


}
