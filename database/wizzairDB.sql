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
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`flights`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`flights` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `origin` VARCHAR(45) NOT NULL,
  `destination` VARCHAR(45) NOT NULL,
  `date_and_time` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`seats`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`seats` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `number` INT(11) NOT NULL,
  `letter` CHAR(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`passangers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`passangers` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`flights_has_passangers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`flights_has_passangers` (
  `flights_id` INT(11) NOT NULL,
  `passangers_id` INT(11) NOT NULL,
  `seat_id` INT(11) NOT NULL,
  PRIMARY KEY (`flights_id`, `passangers_id`, `seat_id`),
  INDEX `fk_flights_has_passangers_passangers1_idx` (`passangers_id` ASC),
  INDEX `fk_flights_has_passangers_flights_idx` (`flights_id` ASC),
  INDEX `fk_fights_has_seats_idx` (`seat_id` ASC),
  CONSTRAINT `fk_fights_has_seats`
    FOREIGN KEY (`seat_id`)
    REFERENCES `mydb`.`seats` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_flights_has_passangers_flights`
    FOREIGN KEY (`flights_id`)
    REFERENCES `mydb`.`flights` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_flights_has_passangers_passangers1`
    FOREIGN KEY (`passangers_id`)
    REFERENCES `mydb`.`passangers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `phone` VARCHAR(20) NULL DEFAULT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  INDEX `idx_users_id` (`id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`users_has_flights`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`users_has_flights` (
  `users_id` INT(11) NOT NULL,
  `flights_id` INT(11) NOT NULL,
  PRIMARY KEY (`users_id`, `flights_id`),
  INDEX `fk_users_has_flights_flights1_idx` (`flights_id` ASC),
  INDEX `fk_users_has_flights_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_users_has_flights_flights1`
    FOREIGN KEY (`flights_id`)
    REFERENCES `mydb`.`flights` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_has_flights_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `mydb`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
