package com.seguro.residencial.application.models.input.segurados;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @criado 21/11/2020 - 14:26
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
public class SeguradoInput {


    @ApiModelProperty(example = "Bruno", required = true)
    @NotNull
    private String nome;

    @ApiModelProperty(example = "Leite", required = true)
    @NotNull
    private String sobreNome;

    @ApiModelProperty(example = "99988877766", required = true)
    @NotNull
    @CPF(message = "cpf inválido")
    private String cpf;

    @ApiModelProperty(example = "11985964270", required = true)
    @Size(min = 11, max = 12, message = "O numero de telefone informado é invalido.")
    @NotNull
    private String telefone;

    @ApiModelProperty(example = "9898999", required = true)
    @NotNull
    private String rg;

    @ApiModelProperty(example = "brunoleitt@gmail.com", required = true)
    @Email()
    @NotNull
    private String email;

    @ApiModelProperty(example = "2021-11-10", required = true)
    @NotNull
    private LocalDate dataNascimento;

    @ApiModelProperty(example = "1", required = true)
    @NotNull
    private Long idProfissao;

    @ApiModelProperty(example = "1", required = true)
    @NotNull
    private Long idSexo;

}
