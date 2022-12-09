SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema athena_bd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema athena_bd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `athena_bd` DEFAULT CHARACTER SET utf8 ;
USE `athena_bd` ;

-- -----------------------------------------------------
-- Table `athena_bd`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `athena_bd`.`aluno` (
  `matricula` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `rg` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `curso` VARCHAR(45) NOT NULL,
  `fase` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`matricula`),
  UNIQUE INDEX `matricula_UNIQUE` (`matricula` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `athena_bd`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `athena_bd`.`professor` (
  `matricula` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `rg` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `data_admissao` DATE NOT NULL,
  `formacao` VARCHAR(45) NOT NULL,
  `nivel_titulacao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`matricula`),
  UNIQUE INDEX `matricula_UNIQUE` (`matricula` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `athena_bd`.`disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `athena_bd`.`disciplina` (
  `codigo` VARCHAR(10) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `carga_horaria` INT NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE INDEX `iddisciplina_UNIQUE` (`codigo` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `athena_bd`.`professor_ministra_disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `athena_bd`.`professor_ministra_disciplina` (
  `professor_matricula` INT NOT NULL,
  `disciplina_codigo` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`professor_matricula`, `disciplina_codigo`),
  INDEX `fk_professor_has_disciplina_disciplina1_idx` (`disciplina_codigo` ASC) VISIBLE,
  INDEX `fk_professor_has_disciplina_professor1_idx` (`professor_matricula` ASC) VISIBLE,
  CONSTRAINT `fk_professor_has_disciplina_professor1`
    FOREIGN KEY (`professor_matricula`)
    REFERENCES `athena_bd`.`professor` (`matricula`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_professor_has_disciplina_disciplina1`
    FOREIGN KEY (`disciplina_codigo`)
    REFERENCES `athena_bd`.`disciplina` (`codigo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `athena_bd`.`disciplina_has_aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `athena_bd`.`disciplina_has_aluno` (
  `disciplina_codigo` VARCHAR(10) NOT NULL,
  `aluno_matricula` INT NOT NULL,
  PRIMARY KEY (`disciplina_codigo`, `aluno_matricula`),
  INDEX `fk_disciplina_has_aluno_aluno1_idx` (`aluno_matricula` ASC) VISIBLE,
  INDEX `fk_disciplina_has_aluno_disciplina1_idx` (`disciplina_codigo` ASC) VISIBLE,
  CONSTRAINT `fk_disciplina_has_aluno_disciplina1`
    FOREIGN KEY (`disciplina_codigo`)
    REFERENCES `athena_bd`.`disciplina` (`codigo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_disciplina_has_aluno_aluno1`
    FOREIGN KEY (`aluno_matricula`)
    REFERENCES `athena_bd`.`aluno` (`matricula`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
