-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema my
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema my
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `my` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `my` ;

-- -----------------------------------------------------
-- Table `my`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my`.`category` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `title` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 191
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `my`.`items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my`.`items` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `quantity` INT NULL DEFAULT NULL,
  `title` VARCHAR(1500) NOT NULL,
  `price` FLOAT NOT NULL,
  `photo` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 178
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `my`.`category_has_items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my`.`category_has_items` (
  `category_id` BIGINT NOT NULL,
  `items_id` INT NOT NULL,
  PRIMARY KEY (`category_id`, `items_id`),
  INDEX `fk_category_has_items_items1_idx` (`items_id` ASC) VISIBLE,
  INDEX `fk_category_has_items_category1_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_category_has_items_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `my`.`category` (`id`),
  CONSTRAINT `fk_category_has_items_items1`
    FOREIGN KEY (`items_id`)
    REFERENCES `my`.`items` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `my`.`transaction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my`.`transaction` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `item_id` BIGINT NOT NULL,
  `quantity` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `my`.`items_has_transaction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my`.`items_has_transaction` (
  `items_id` INT NOT NULL,
  `transaction_id` BIGINT NOT NULL,
  PRIMARY KEY (`items_id`, `transaction_id`),
  INDEX `fk_items_has_transaction_transaction1_idx` (`transaction_id` ASC) VISIBLE,
  INDEX `fk_items_has_transaction_items1_idx` (`items_id` ASC) VISIBLE,
  CONSTRAINT `fk_items_has_transaction_items1`
    FOREIGN KEY (`items_id`)
    REFERENCES `my`.`items` (`id`),
  CONSTRAINT `fk_items_has_transaction_transaction1`
    FOREIGN KEY (`transaction_id`)
    REFERENCES `my`.`transaction` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `my`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my`.`roles` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `my`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `surname` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(50) NOT NULL,
  `mobile` VARCHAR(45) NOT NULL,
  `password` VARCHAR(200) NULL DEFAULT NULL,
  `role` INT NOT NULL,
  `profile` VARCHAR(500) NULL DEFAULT NULL,
  `img` VARCHAR(200) NULL DEFAULT NULL,
  `orders` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_users_roles1_idx` (`role` ASC) VISIBLE,
  CONSTRAINT `fk_users_roles1`
    FOREIGN KEY (`role`)
    REFERENCES `my`.`roles` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 173
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `my`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my`.`orders` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user` INT NOT NULL,
  `created` VARCHAR(45) NULL DEFAULT NULL,
  `summary` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_order_users1_idx` (`user` ASC) VISIBLE,
  CONSTRAINT `fk_order_users1`
    FOREIGN KEY (`user`)
    REFERENCES `my`.`users` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 41
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `my`.`order_has_transaction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my`.`order_has_transaction` (
  `order_id` BIGINT NOT NULL,
  `transaction_id` BIGINT NOT NULL,
  PRIMARY KEY (`order_id`, `transaction_id`),
  INDEX `fk_order_has_transaction_transaction1_idx` (`transaction_id` ASC) VISIBLE,
  INDEX `fk_order_has_transaction_order1_idx` (`order_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_has_transaction_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `my`.`orders` (`id`),
  CONSTRAINT `fk_order_has_transaction_transaction1`
    FOREIGN KEY (`transaction_id`)
    REFERENCES `my`.`transaction` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
INSERT INTO `my`.`roles` (`id`, `name`) VALUES ('5', 'Unknown');
INSERT INTO `my`.`roles` (`id`, `name`) VALUES ('1', 'Admin');
INSERT INTO `my`.`roles` (`id`, `name`) VALUES ('2', 'Cashier');
INSERT INTO `my`.`roles` (`id`, `name`) VALUES ('3', 'Senior cashier');
INSERT INTO `my`.`roles` (`id`, `name`) VALUES ('4', 'Commodity expert');

ALTER TABLE `my`.`order_has_transaction` 
ADD CONSTRAINT `fk_order_has_transaction_order1`
  FOREIGN KEY (`order_id`)
  REFERENCES `my`.`orders` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ALTER TABLE `my`.`order_has_transaction` 
ADD CONSTRAINT `fk_order_has_transaction_transaction1`
  FOREIGN KEY (`transaction_id`)
  REFERENCES `my`.`transaction` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ALTER TABLE `my`.`category_has_items` 
ADD CONSTRAINT `fk_category_has_items_category1`
  FOREIGN KEY (`category_id`)
  REFERENCES `my`.`category` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk_category_has_items_items1`
  FOREIGN KEY (`items_id`)
  REFERENCES `my`.`items` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ALTER TABLE `my`.`items_has_transaction` 
ADD CONSTRAINT `fk_items_has_transaction_items1`
  FOREIGN KEY (`items_id`)
  REFERENCES `my`.`items` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk_items_has_transaction_transaction1`
  FOREIGN KEY (`transaction_id`)
  REFERENCES `my`.`transaction` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
