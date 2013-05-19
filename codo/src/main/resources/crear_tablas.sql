USE `cododb` ;

-- -----------------------------------------------------
-- Table `cododb`.`empresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cododb`.`empresa`
CREATE  TABLE IF NOT EXISTS `cododb`.`empresa` (
  `idempresa` INT(11) NOT NULL ,
  `rut` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `nombre` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `direccion` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `contacto` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  PRIMARY KEY (`idempresa`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

-- -----------------------------------------------------
-- Table `cododb`.`usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cododb`.`usuario` (
  `rut` INT(11) NOT NULL ,
  `clave` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  PRIMARY KEY (`rut`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;




-- -----------------------------------------------------
-- Table `cododbas`.`boleta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cododb`.`boleta`
CREATE  TABLE IF NOT EXISTS `cododb`.`boleta` (
  `idboleta` INT(11) NOT NULL ,
  `fecha` DATE NULL DEFAULT NULL ,
  `empresa_idempresa` INT(11) NOT NULL ,
  PRIMARY KEY (`idboleta`, `empresa_idempresa`) ,
  INDEX `fk_boleta_empresa` (`empresa_idempresa` ASC) ,
  CONSTRAINT `fk_boleta_empresa`
    FOREIGN KEY (`empresa_idempresa` )
    REFERENCES `cododb`.`empresa` (`idempresa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `cododb`.`factoring`
-- -----------------------------------------------------
DROP TABLE IF EXISTS  `cododb`.`factoring`
CREATE  TABLE IF NOT EXISTS `cododb`.`factoring` (
  `idfactoring` INT(11) NOT NULL ,
  `nombre` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  PRIMARY KEY (`idfactoring`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;



-- -----------------------------------------------------
-- Table `cododb`.`mantencion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cododb`.`mantencion`
CREATE  TABLE IF NOT EXISTS `cododb`.`mantencion` (
  `idmantencion` INT(11) NOT NULL ,
  `fecha_inicio` DATE NULL DEFAULT NULL ,
  `fecha_fin` DATE NULL DEFAULT NULL ,
  `lugar` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `detalle` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `comentario` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `boleta_idboleta` INT(11) NOT NULL ,
  PRIMARY KEY (`idmantencion`, `boleta_idboleta`) ,
  INDEX `fk_mantencion_boleta1` (`boleta_idboleta` ASC) ,
  CONSTRAINT `fk_mantencion_boleta1`
    FOREIGN KEY (`boleta_idboleta` )
    REFERENCES `cododb`.`boleta` (`idboleta` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `cododb`.`pago`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cododb`.`pago`
CREATE  TABLE IF NOT EXISTS `cododb`.`pago` (
  `idpago` INT(11) NOT NULL ,
  `fecha` DATE NULL DEFAULT NULL ,
  `monto` FLOAT NULL DEFAULT NULL ,
  `estado` VARCHAR(45) NULL ,
  `boleta_idboleta` INT(11) NOT NULL ,
  `factoring_idfactoring` INT(11) NOT NULL ,
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
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `cododb`.`venta`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cododb`.`venta` (
  `idventa` INT(11) NOT NULL ,
  `cantidad` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `proveedor` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `preciocompra` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `precioventa` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `producto` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `boleta_idboleta` INT(11) NOT NULL ,
  PRIMARY KEY (`idventa`, `boleta_idboleta`) ,
  INDEX `fk_venta_boleta1` (`boleta_idboleta` ASC) ,
  CONSTRAINT `fk_venta_boleta1`
    FOREIGN KEY (`boleta_idboleta` )
    REFERENCES `cododb`.`boleta` (`idboleta` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


INSERT INTO `cododb`.`factoring` (`idfactoring`, `nombre`) VALUES (1, 'BCI');
INSERT INTO `cododb`.`factoring` (`idfactoring`, `nombre`) VALUES (2, 'YAKORA');
INSERT INTO `cododb`.`factoring` (`idfactoring`, `nombre`) VALUES (3, 'LYM');
