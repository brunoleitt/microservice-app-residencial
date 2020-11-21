package com.seguro.residencial;

import com.seguro.residencial.cotacoes.RegistrarCotacaoTests;
import com.seguro.residencial.itens.CoberturasTests;
import com.seguro.residencial.itens.RegistrarItemTests;
import com.seguro.residencial.segurado.RegistrarSeguradoTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({ RegistrarCotacaoTests.class, RegistrarItemTests.class, CoberturasTests.class, RegistrarSeguradoTests.class})
public class ResidencialTests {
}
