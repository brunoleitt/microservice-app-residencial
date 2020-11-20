package com.seguro.residencial;

import com.seguro.residencial.cotacoes.RegistrarCotacaoTests;
import com.seguro.residencial.itens.CoberturasTests;
import com.seguro.residencial.itens.RegistrarItemTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({ RegistrarCotacaoTests.class, RegistrarItemTests.class, CoberturasTests.class})
public class ResidencialTests {
}
