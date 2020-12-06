package com.seguro.residencial.application.assembler;

import com.seguro.residencial.application.models.view.api.CotacaoModel;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CotacaoModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public CotacaoModel toModel(CotacaoRoot pedido) {
		return modelMapper.map(pedido, CotacaoModel.class);
	}

}
