USE `cododb` ;

-- -----------------------------------------------------
-- Table `cododb`.`empresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cododb`.`empresa`
CREATE  TABLE IF NOT EXISTS `cododb`.`empresa` (
  `idempresa` INT NOT NULL ,
  `rut` VARCHAR(255) NULL ,
  `nombre` VARCHAR(255) NULL ,
  `direccion` VARCHAR(255) NULL ,
  `contacto` VARCHAR(255) NULL ,
  PRIMARY KEY (`idempresa`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cododb`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cododb`.`usuario`
CREATE  TABLE IF NOT EXISTS `cododb`.`usuario` (
  `rut` INT NOT NULL ,
  `clave` VARCHAR(255) NULL ,
  PRIMARY KEY (`rut`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cododb`.`boleta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cododb`.`boleta`
CREATE  TABLE IF NOT EXISTS `cododb`.`boleta` (
  `idboleta` INT NOT NULL ,
  `numero_factura` VARCHAR(255) NULL ,
  `fecha` DATE NULL ,
  `empresa_idempresa` INT NOT NULL ,
  PRIMARY KEY (`idboleta`, `empresa_idempresa`) ,
  INDEX `fk_boleta_empresa` (`empresa_idempresa` ASC) ,
  CONSTRAINT `fk_boleta_empresa`
    FOREIGN KEY (`empresa_idempresa` )
    REFERENCES `cododb`.`empresa` (`idempresa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cododb`.`factoring`
-- -----------------------------------------------------
DROP TABLE IF EXISTS  `cododb`.`factoring`
CREATE  TABLE IF NOT EXISTS `cododb`.`factoring` (
  `idfactoring` INT NOT NULL ,
  `nombre` VARCHAR(255) NULL ,
  PRIMARY KEY (`idfactoring`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cododb`.`mantencion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cododb`.`mantencion`
CREATE  TABLE IF NOT EXISTS `cododb`.`mantencion` (
  `idmantencion` INT NOT NULL ,
  `fecha_inicio` DATE NULL ,
  `fecha_fin` DATE NULL ,
  `lugar` VARCHAR(255) NULL ,
  `detalle` VARCHAR(255) NULL ,
  `comentario` VARCHAR(255) NULL ,
  `boleta_idboleta` INT NOT NULL ,
  PRIMARY KEY (`idmantencion`, `boleta_idboleta`) ,
  INDEX `fk_mantencion_boleta1` (`boleta_idboleta` ASC) ,
  CONSTRAINT `fk_mantencion_boleta1`
    FOREIGN KEY (`boleta_idboleta` )
    REFERENCES `cododb`.`boleta` (`idboleta` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cododb`.`pago`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cododb`.`pago`
CREATE  TABLE IF NOT EXISTS `cododb`.`pago` (
  `idpago` INT NOT NULL ,
  `fecha` DATE NULL ,
  `monto` FLOAT NULL ,
  `boleta_idboleta` INT NOT NULL ,
  `factoring_idfactoring` INT NOT NULL ,
  PRIMARY KEY (`idpago`, `boleta_idboleta`, `factoring_idfactoring`) ,
  INDEX `fk_pago_boleta1` (`boleta_idboleta` ASC) ,
  INDEX `fk_pago_factoring1` (`factoring_idfactoring` ASC) ,
  CONSTRAINT `fk_pago_boleta1`
    FOREIGN KEY (`boleta_idboleta` )
    REFERENCES `cododb`.`boleta` (`idboleta` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pago_factoring1`
    FOREIGN KEY (`factoring_idfactoring` )
    REFERENCES `cododb`.`factoring` (`idfactoring` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cododb`.`venta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cododb`.`venta`
CREATE  TABLE IF NOT EXISTS `cododb`.`venta` (
  `idventa` INT NOT NULL ,
  `cantidad` VARCHAR(255) NULL ,
  `proveedor` VARCHAR(255) NULL ,
  `preciocompra` VARCHAR(255) NULL ,
  `precioventa` VARCHAR(255) NULL ,
  `producto` VARCHAR(255) NULL ,
  `boleta_idboleta` INT NOT NULL ,
  PRIMARY KEY (`idventa`, `boleta_idboleta`) ,
  INDEX `fk_venta_boleta1` (`boleta_idboleta` ASC) ,
  CONSTRAINT `fk_venta_boleta1`
    FOREIGN KEY (`boleta_idboleta` )
    REFERENCES `cododb`.`boleta` (`idboleta` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


INSERT INTO `cododb`.`factoring` (`idfactoring`, `nombre`) VALUES (1, 'BCI');
INSERT INTO `cododb`.`factoring` (`idfactoring`, `nombre`) VALUES (2, 'YAKORA');
INSERT INTO `cododb`.`factoring` (`idfactoring`, `nombre`) VALUES (3, 'LYM');
