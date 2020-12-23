-- -----------------------------------------------------
-- Table `seguros`.`profissao`
-- -----------------------------------------------------
INSERT INTO `profissao` VALUES (1,'Analista'),(2,'Eletricista'),(3,'Jogador'),(4,'Administrador'),(5,'Juiz'),(6,'Advogado'),(7,'Medico');

-- -----------------------------------------------------
-- Table `seguros`.`sexo`
-- -----------------------------------------------------
INSERT INTO `sexo` VALUES (1,'Masculino'),(2,'Masculino');

-- -----------------------------------------------------
-- Table `seguros`.`status_cotacao`
-- -----------------------------------------------------
INSERT INTO `status_cotacao` VALUES (1,'CRIADA'),(2,'CALCULADA'),(3,'AGUARDANDO_PAGAMENTO'),(4,'PAGAMENTO_APROVADO'),(5,'PAGAMENTO_CANCELADO');

-- -----------------------------------------------------
-- Table `seguros`.`tipo_calculo`
-- -----------------------------------------------------
INSERT INTO `tipo_calculo` VALUES (1,'Cotacao'),(2,'Proposta');

-- -----------------------------------------------------
-- Table `seguros`.`tipo_risco`
-- -----------------------------------------------------
INSERT INTO `tipo_risco` VALUES (1,'Casa'),(2,'Apto');

-- -----------------------------------------------------
-- Table `seguros`.`tipo_vigencia`
-- -----------------------------------------------------
INSERT INTO `tipo_vigencia` VALUES (1,'ANUAL'),(2,'BIANUAL');

-- -----------------------------------------------------
-- Table `seguros`.`cobertura_pacote`
-- -----------------------------------------------------
INSERT INTO `cobertura_pacote` VALUES (1,'Basica',1200,1700,1),(2,'Plus',1200,1700,1),(3,'Top Plus',1400,1800,1),(4,'Basica',1000,1500,2),(5,'Plus',1200,1700,2),(6,'Top Plus',1400,1800,2);

-- -----------------------------------------------------
-- Table `seguros`.`cobertura`
-- -----------------------------------------------------
INSERT INTO `cobertura` VALUES (1,'Incêndio, Explosão e Fumaça','path',200,1),(2,'Incêndio, Explosão e Fumaça','path',345,2),(3,'Vendaval, Ciclone ou Chuva de Granizo','path',466,2),(4,'Substracão de Bens','path',20,2),(5,'Incêndio, Explosão e Fumaça','path',1,3),(6,'Vendaval, Ciclone ou Chuva de Granizo','path',23,3),(7,'Substracão de Bens','path',5,3),(8,'Responsabilidade Civil Familiar','path',6,3),(9,'Substracão de Bens','path',200,3),(10,'Roubo e Furto','path',133,3),(11,'Incêndio, Explosão e Fumaça','path',1,4),(12,'Incêndio, Explosão e Fumaça','PATH',23,5),(13,'Vendaval, Ciclone ou Chuva de Granizo','path',5,5),(14,'Substracão de Bens','path',6,5),(15,'Incêndio, Explosão e Fumaça','path',200,6),(16,'Vendaval, Ciclone ou Chuva de Granizo','path',133,6),(17,'Substracão de Bens','path',1,6),(18,'Responsabilidade Civil Familiar\'','path',23,6),(19,'Substracão de Bens','path',5,6),(20,'Responsabilidade Civil Familiar','path',200,6);


-- -----------------------------------------------------
-- Table `seguros`.`cobertura_servicos`
-- -----------------------------------------------------' ||
INSERT INTO `cobertura_servicos` VALUES
(1,'Hidráulica','Conte com a mão de obra especializada de encanadores da Porto Seguro para reparar problemas de vazamento de torneiras, sifões, cubas, conexões de chuveiros entre outros.','path',1),
(2,'Reparos Elétricos','Os profissionais da Porto Seguro vão até sua casa, caso ocorra algum problema com as instalações elétricas: restabelecimento de energia, troca de resistências etc.','path',1),
(3,'Hidráulica','Conte com a mão de obra especializada de encanadores da Porto Seguro para reparar problemas de vazamento de torneiras, sifões, cubas, conexões de chuveiros entre outros.','path',2),
(4,'Reparos Elétricos','Os profissionais da Porto Seguro vão até sua casa, caso ocorra algum problema com as instalações elétricas: restabelecimento de energia, troca de resistências etc.','path',2),
(5,'Eletrodomésticos de','Nossos profissionais também estão disponíveis para te ajudar, caso seu eletrodoméstico pare de funcionar ou apresente algum problema no funcionamento.','path',2),
(6,'Hidráulica','Conte com a mão de obra especializada de encanadores da Porto Seguro para reparar problemas de vazamento de torneiras, sifões, cubas, conexões de chuveiros entre outros.','path',3),
(7,'Reparos Elétricos','Os profissionais da Porto Seguro vão até sua casa, caso ocorra algum problema com as instalações elétricas: restabelecimento de energia, troca de resistências etc.','path',3),
(8,'Eletrodomésticos de','Nossos profissionais também estão disponíveis para te ajudar, caso seu eletrodoméstico pare de funcionar ou apresente algum problema no funcionamento.','path',3),
(9,'Chaveiro','Com este serviço, nossos prestadores fazem abertura de porta e portões, inclusive a confecção de uma nova chave, em caso de perda, quebra ou roubo.','path',3),
(10,'Desentupimento','Se houver algum entupimento em pias, vasos sanitários, sifões ou ralos, nossos encanadores resolvem tudo para você e sua família.','path',3),
(11,'Hidráulica','Conte com a mão de obra especializada de encanadores da Porto Seguro para reparar problemas de vazamento de torneiras, sifões, cubas, conexões de chuveiros entre outros.','path',4),
(12,'Hidráulica','Conte com a mão de obra especializada de encanadores da Porto Seguro para reparar problemas de vazamento de torneiras, sifões, cubas, conexões de chuveiros entre outros.','path',5),
(13,'Reparos Elétricos','Os profissionais da Porto Seguro vão até sua casa, caso ocorra algum problema com as instalações elétricas: restabelecimento de energia, troca de resistências etc.','path',5),
(14,'Eletrodomésticos de','Nossos profissionais também estão disponíveis para te ajudar, caso seu eletrodoméstico pare de funcionar ou apresente algum problema no funcionamento.','path',5),
(15,'Hidráulica','Conte com a mão de obra especializada de encanadores da Porto Seguro para reparar problemas de vazamento de torneiras, sifões, cubas, conexões de chuveiros entre outros.','path',6),
(16,'Reparos Elétricos','Os profissionais da Porto Seguro vão até sua casa, caso ocorra algum problema com as instalações elétricas: restabelecimento de energia, troca de resistências etc.','path',6),
(17,'Eletrodomésticos de','Nossos profissionais também estão disponíveis para te ajudar, caso seu eletrodoméstico pare de funcionar ou apresente algum problema no funcionamento.','path',6),
(18,'Chaveiro','Com este serviço, nossos prestadores fazem abertura de porta e portões, inclusive a confecção de uma nova chave, em caso de perda, quebra ou roubo.','path',6),
(19,'Desentupimento','Se houver algum entupimento em pias, vasos sanitários, sifões ou ralos, nossos encanadores resolvem tudo para você e sua família.','path',6);






