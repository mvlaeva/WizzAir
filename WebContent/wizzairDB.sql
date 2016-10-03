-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `first_name` VARCHAR(45) NOT NULL COMMENT '',
  `last_name` VARCHAR(45) NOT NULL COMMENT '',
  `username` VARCHAR(45) NOT NULL COMMENT '',
  `password` VARCHAR(100) NOT NULL COMMENT '',
  `phone` VARCHAR(20) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)  COMMENT '',
  UNIQUE INDEX `username_UNIQUE` (`username` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`passangers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`passangers` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `first_name` VARCHAR(45) NOT NULL COMMENT '',
  `last_name` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`flights`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`flights` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `origin` VARCHAR(45) NOT NULL COMMENT '',
  `destination` VARCHAR(45) NOT NULL COMMENT '',
  `date_and_time` VARCHAR(60) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`seats`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`seats` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `number` INT NOT NULL COMMENT '',
  `letter` CHAR(1) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`flights_has_passangers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`flights_has_passangers` (
  `flights_id` INT NOT NULL COMMENT '',
  `passangers_id` INT NOT NULL COMMENT '',
  `seat_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`flights_id`, `passangers_id`, `seat_id`)  COMMENT '',
  INDEX `fk_flights_has_passangers_passangers1_idx` (`passangers_id` ASC)  COMMENT '',
  INDEX `fk_flights_has_passangers_flights_idx` (`flights_id` ASC)  COMMENT '',
  INDEX `fk_fights_has_seats_idx` (`seat_id` ASC)  COMMENT '',
  CONSTRAINT `fk_flights_has_passangers_flights`
    FOREIGN KEY (`flights_id`)
    REFERENCES `mydb`.`flights` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_flights_has_passangers_passangers1`
    FOREIGN KEY (`passangers_id`)
    REFERENCES `mydb`.`passangers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fights_has_seats`
    FOREIGN KEY (`seat_id`)
    REFERENCES `mydb`.`seats` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`users_has_flights`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`users_has_flights` (
  `users_id` INT NOT NULL COMMENT '',
  `flights_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`users_id`, `flights_id`)  COMMENT '',
  INDEX `fk_users_has_flights_flights1_idx` (`flights_id` ASC)  COMMENT '',
  INDEX `fk_users_has_flights_users1_idx` (`users_id` ASC)  COMMENT '',
  CONSTRAINT `fk_users_has_flights_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `mydb`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_has_flights_flights1`
    FOREIGN KEY (`flights_id`)
    REFERENCES `mydb`.`flights` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
