package com.seguro.residencial;

import com.seguro.residencial.cotacoes.RegistrarCotacaoTests;
import com.seguro.residencial.itens.RegistrarItemEndereco;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({ RegistrarCotacaoTests.class, RegistrarItemEndereco.class})
public class ResidencialTests {
}
