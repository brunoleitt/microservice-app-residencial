-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema seguros
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `seguros` ;

-- -----------------------------------------------------
-- Schema seguros
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `seguros` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `seguros` ;

-- -----------------------------------------------------
-- Table `seguros`.`application_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguros`.`application_user` ;

CREATE TABLE IF NOT EXISTS `seguros`.`application_user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(255) NOT NULL,
  `role` VARCHAR(255) NOT NULL,
  `username` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `seguros`.`tipo_risco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguros`.`tipo_risco` ;

CREATE TABLE IF NOT EXISTS `seguros`.`tipo_risco` (
  `id` BIGINT NOT NULL,
  `descricao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `seguros`.`profissao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguros`.`profissao` ;

CREATE TABLE IF NOT EXISTS `seguros`.`profissao` (
  `id` BIGINT NOT NULL,
  `descricao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `seguros`.`cobertura_pacote`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguros`.`cobertura_pacote` ;

CREATE TABLE IF NOT EXISTS `seguros`.`cobertura_pacote` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(30) NOT NULL,
  `premio_base_cotacao` DOUBLE NOT NULL,
  `premio_liquido_cotacao` DOUBLE NOT NULL,
  `id_tipo_risco` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_cobertura_pacote_tipo_risco`
    FOREIGN KEY (`id_tipo_risco`)
    REFERENCES `seguros`.`tipo_risco` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `seguros`.`cobertura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguros`.`cobertura` ;

CREATE TABLE IF NOT EXISTS `seguros`.`cobertura` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(100) NOT NULL,
  `imagem_cobertura` VARCHAR(30) NOT NULL,
  `valor_importancia_segurada` DOUBLE NOT NULL,
  `id_pacote_cobertura` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_cobertura_pacote_cobertura`
    FOREIGN KEY (`id_pacote_cobertura`)
    REFERENCES `seguros`.`cobertura_pacote` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `seguros`.`cobertura_servicos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguros`.`cobertura_servicos` ;

CREATE TABLE IF NOT EXISTS `seguros`.`cobertura_servicos` (
  `id_coberturas_servicos` BIGINT NOT NULL,
  `descricao` VARCHAR(30) NOT NULL,
  `detalhe_servicos` VARCHAR(300) NOT NULL,
  `url_imagem_servico` VARCHAR(100) NOT NULL,
  `id_pacote_cobertura` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id_coberturas_servicos`),
  CONSTRAINT `fk_cobertura_pacote_cobertura_serv`
    FOREIGN KEY (`id_pacote_cobertura`)
    REFERENCES `seguros`.`cobertura_pacote` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `seguros`.`status_cotacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguros`.`status_cotacao` ;

CREATE TABLE IF NOT EXISTS `seguros`.`status_cotacao` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `seguros`.`tipo_calculo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguros`.`tipo_calculo` ;

CREATE TABLE IF NOT EXISTS `seguros`.`tipo_calculo` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `seguros`.`tipo_vigencia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguros`.`tipo_vigencia` ;

CREATE TABLE IF NOT EXISTS `seguros`.`tipo_vigencia` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `seguros`.`cotacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguros`.`cotacao` ;

CREATE TABLE IF NOT EXISTS `seguros`.`cotacao` (
  `codigo_cotacao` VARCHAR(255) NOT NULL,
  `data_atualizacao` DATETIME(6) NULL DEFAULT NULL,
  `data_cotacao` DATE NULL DEFAULT NULL,
  `data_vigencia_final` DATE NULL DEFAULT NULL,
  `data_vigencia_inicial` DATE NULL DEFAULT NULL,
  `id_status_cotacao` BIGINT NOT NULL,
  `id_tipo_calculo` BIGINT NOT NULL,
  `id_tipo_vigencia` BIGINT NOT NULL,
  PRIMARY KEY (`codigo_cotacao`),
  CONSTRAINT `fk_status_cotacao`
    FOREIGN KEY (`id_status_cotacao`)
    REFERENCES `seguros`.`status_cotacao` (`id`),
  CONSTRAINT `fk_tipo_calculo_cotacao`
    FOREIGN KEY (`id_tipo_calculo`)
    REFERENCES `seguros`.`tipo_calculo` (`id`),
  CONSTRAINT `fk_tipo_vigencia_cotacao`
    FOREIGN KEY (`id_tipo_vigencia`)
    REFERENCES `seguros`.`tipo_vigencia` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `seguros`.`item_endereco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguros`.`item_endereco` ;

CREATE TABLE IF NOT EXISTS `seguros`.`item_endereco` (
  `id` VARCHAR(50) NOT NULL,
  `cep` VARCHAR(8) NOT NULL,
  `cidade` VARCHAR(20) NOT NULL,
  `complemento` VARCHAR(30) NOT NULL,
  `logradouro` VARCHAR(30) NOT NULL,
  `numero` VARCHAR(10) NOT NULL,
  `uf` VARCHAR(2) NOT NULL,
  `id_item` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_item_itemEndereco`
    FOREIGN KEY (`id_item`)
    REFERENCES `seguros`.`item` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `seguros`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguros`.`item` ;

CREATE TABLE IF NOT EXISTS `seguros`.`item` (
  `id` VARCHAR(50) NOT NULL,
  `id_pacote_cobertura` BIGINT NULL DEFAULT NULL,
  `id_cotacao` VARCHAR(255) NULL DEFAULT NULL,
  `id_tipo_risco` BIGINT NULL DEFAULT NULL,
  `endereco_item_id` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_cotacaoItem`
    FOREIGN KEY (`id_cotacao`)
    REFERENCES `seguros`.`cotacao` (`codigo_cotacao`),
  CONSTRAINT `fk_pacoteCobertura`
    FOREIGN KEY (`id_pacote_cobertura`)
    REFERENCES `seguros`.`cobertura_pacote` (`id`),
  CONSTRAINT `fk_tipoRisco`
    FOREIGN KEY (`id_tipo_risco`)
    REFERENCES `seguros`.`tipo_risco` (`id`),
  CONSTRAINT `FKe8jowhdlfoo71wu0fbtel2uiv`
    FOREIGN KEY (`endereco_item_id`)
    REFERENCES `seguros`.`item_endereco` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `seguros`.`profissao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguros`.`profissao` ;

CREATE TABLE IF NOT EXISTS `seguros`.`profissao` (
  `id` BIGINT NOT NULL,
  `descricao` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `seguros`.`questionario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguros`.`questionario` ;

CREATE TABLE IF NOT EXISTS `seguros`.`questionario` (
  `id` VARCHAR(50) NOT NULL,
  `possui_anti_furto` BIT(1) NOT NULL,
  `id_cotacao` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_cotacaoQuestionario`
    FOREIGN KEY (`id_cotacao`)
    REFERENCES `seguros`.`cotacao` (`codigo_cotacao`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `seguros`.`sexo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguros`.`sexo` ;

CREATE TABLE IF NOT EXISTS `seguros`.`sexo` (
  `id` BIGINT NOT NULL,
  `descricao` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `seguros`.`segurado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguros`.`segurado` ;

CREATE TABLE IF NOT EXISTS `seguros`.`segurado` (
  `id` VARCHAR(50) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `data_nascimento` DATE NULL DEFAULT NULL,
  `email` VARCHAR(30) NOT NULL,
  `nome` VARCHAR(30) NOT NULL,
  `rg` VARCHAR(10) NOT NULL,
  `sobre_nome` VARCHAR(30) NOT NULL,
  `telefone` VARCHAR(12) NOT NULL,
  `id_cotacao` VARCHAR(255) NOT NULL,
  `id_profissao` BIGINT NOT NULL,
  `id_sexo` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_cotacaoSegurado`
    FOREIGN KEY (`id_cotacao`)
    REFERENCES `seguros`.`cotacao` (`codigo_cotacao`),
  CONSTRAINT `fk_profissaoSegurado`
    FOREIGN KEY (`id_profissao`)
    REFERENCES `seguros`.`profissao` (`id`),
  CONSTRAINT `fk_sexoSegurado`
    FOREIGN KEY (`id_sexo`)
    REFERENCES `seguros`.`sexo` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
