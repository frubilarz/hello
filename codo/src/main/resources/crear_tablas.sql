USE `cododb` ;


-- -----------------------------------------------------

-- Table `cododb`.`boleta`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `cododb`.`boleta` ;

CREATE  TABLE IF NOT EXISTS `cododb`.`boleta` (
  `idboleta` INT(11) NOT NULL ,
  `fecha` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `idempresa` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`idboleta`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;





-- -----------------------------------------------------

-- Table `cododb`.`empresa`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `cododb`.`empresa` ;

CREATE  TABLE IF NOT EXISTS `cododb`.`empresa` (
  `idempresa` INT(11) NOT NULL ,

  `rut` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,

  `nombre` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,

  `direccion` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,

  `contactor` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,

  PRIMARY KEY (`idempresa`) )

ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8

COLLATE = utf8_spanish_ci;





-- -----------------------------------------------------

-- Table `cododb`.`factoring`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `cododb`.`factoring` ;



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

DROP TABLE IF EXISTS `cododb`.`mantencion` ;



CREATE  TABLE IF NOT EXISTS `cododb`.`mantencion` (

  `idmantencion` INT(11) NOT NULL ,

  `fechainicio` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,

  `fechafinl` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,

  `lugarl` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,

  `detalle` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,

  `comentario` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,

  `idboleta` INT(11) NULL DEFAULT NULL ,

  PRIMARY KEY (`idmantencion`) )

ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8

COLLATE = utf8_spanish_ci;





-- -----------------------------------------------------

-- Table `cododb`.`pago`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `cododb`.`pago` ;



CREATE  TABLE IF NOT EXISTS `cododb`.`pago` (

  `idpago` INT(11) NOT NULL ,

  `fechavencimiento` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,

  `monto` FLOAT NULL DEFAULT NULL ,

  `estado` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,

  `idboleta` INT(11) NULL DEFAULT NULL ,

  `idfactoring` INT(11) NULL DEFAULT NULL ,

  PRIMARY KEY (`idpago`) )

ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8

COLLATE = utf8_spanish_ci;





-- -----------------------------------------------------

-- Table `cododb`.`usuario`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `cododb`.`usuario` ;



CREATE  TABLE IF NOT EXISTS `cododb`.`usuario` (

  `rut` INT(11) NOT NULL ,

  `clave` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,

  PRIMARY KEY (`rut`) )

ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8

COLLATE = utf8_spanish_ci;





-- -----------------------------------------------------

-- Table `cododb`.`venta`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `cododb`.`venta` ;



CREATE  TABLE IF NOT EXISTS `cododb`.`venta` (

  `idventa` INT(11) NOT NULL ,

  `cantidad` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,

  `proveedor` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,

  `preciocompra` FLOAT NULL DEFAULT NULL ,

  `precioventa` FLOAT NULL DEFAULT NULL ,

  `producto` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,

  `idboleta` INT(11) NULL DEFAULT NULL ,

  PRIMARY KEY (`idventa`) )

ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8

COLLATE = utf8_spanish_ci;

INSERT INTO `cododb`.`factoring` (`idfactoring`, `nombre`) VALUES (1, 'BCI');
INSERT INTO `cododb`.`factoring` (`idfactoring`, `nombre`) VALUES (2, 'YAKORA');
INSERT INTO `cododb`.`factoring` (`idfactoring`, `nombre`) VALUES (3, 'LYM');
