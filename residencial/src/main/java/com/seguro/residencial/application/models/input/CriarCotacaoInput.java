package com.seguro.residencial.application.models.input;

import com.seguro.residencial.domain.models.root.clientes.ClienteRoot;
import com.seguro.residencial.domain.models.root.itens.ItemRoot;
import com.seguro.residencial.domain.models.root.questionarios.QuestionarioRoot;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @criado 12/10/2020 - 15:38
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 *
 */
@Getter
@Setter
public class CriarCotacaoInput {

    private Long idTipoCalculo;

    private Long idTipoVigencia;

    private LocalDate dataVigenciaInicial;

    public String codigoCotacao = UUID.randomUUID().toString();

    private LocalDate dataCotacao = LocalDate.now();

    private ItemRoot item;

    private QuestionarioRoot questionario;

    private ClienteRoot cliente;

}
