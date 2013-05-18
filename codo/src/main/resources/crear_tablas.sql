USE `cododb` ;

-- -----------------------------------------------------

-- Table `cododb`.`boleta`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `cododb`.`boleta` ;
CREATE  TABLE IF NOT EXISTS `cododb`.`boleta` (
  `idboleta` INT NOT NULL  AUTO_INCREMENT,
  `numero` VARCHAR(45) NULL ,
  `fecha` VARCHAR(45) NULL ,
  `idempresa` INT NULL ,
  PRIMARY KEY (`idboleta`)
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------

-- Table `cododb`.`empresa`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `cododb`.`empresa` ;
CREATE  TABLE IF NOT EXISTS `cododb`.`empresa` (
  `idempresa` INT NOT NULL AUTO_INCREMENT ,
  `rut` VARCHAR(45) NULL ,
  `nombre` VARCHAR(45) NULL ,
  `direccion` VARCHAR(45) NULL ,
  `contacto` VARCHAR(45) NULL ,
  `boleta_idboleta` INT NOT NULL ,
  PRIMARY KEY (`idempresa`) ,
  INDEX `fk_empresa_boleta1_idx` (`boleta_idboleta` ASC) ,
  CONSTRAINT `fk_empresa_boleta1`
    FOREIGN KEY (`boleta_idboleta` )
    REFERENCES `cododb`.`boleta` (`idboleta` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------

-- Table `cododb`.`pago`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `cododb`.`pago` ;
CREATE  TABLE IF NOT EXISTS `cododb`.`pago` (
  `idpago` INT NOT NULL AUTO_INCREMENT ,
  `fecha_vencimiento` VARCHAR(45) NULL ,
  `factoring` VARCHAR(45) NULL ,
  `monto` VARCHAR(45) NULL ,
  `estado` VARCHAR(45) NULL ,
  `idboleta` INT(11) NULL ,
  `boleta_idboleta` INT NOT NULL ,
  PRIMARY KEY (`idpago`)
    UNIQUE(`idpago`, `boleta_idboleta`) ,
  INDEX `fk_pago_boleta1_idx` (`boleta_idboleta` ASC) ,
  CONSTRAINT `fk_pago_boleta1`
    FOREIGN KEY (`boleta_idboleta` )
    REFERENCES `cododb`.`boleta` (`idboleta` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------

-- Table `cododb`.`usuario`

-- -----------------------------------------------------
DROP TABLE IF EXISTS `cododb`.`usuario` ;
CREATE  TABLE IF NOT EXISTS `cododb`.`usuario` (
  `rut` INT NOT NULL ,
  `clave` VARCHAR(45) NULL ,
  PRIMARY KEY (`rut`)
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------

-- Table `cododb`.`mantencion`

-- -----------------------------------------------------
DROP TABLE IF EXISTS `cododb`.`mantencion` ;
CREATE  TABLE IF NOT EXISTS `cododb`.`mantencion` (
  `idmantencion` INT NOT NULL AUTO_INCREMENT ,
  `fechainicio` VARCHAR(45) NULL ,
  `fechafin` VARCHAR(45) NULL ,
  `lugar` VARCHAR(45) NULL ,
  `detalle` VARCHAR(45) NULL ,
  `comentario` VARCHAR(45) NULL ,
  `boleta_idboleta` INT NOT NULL ,
  `idboleta` INT NULL ,
  PRIMARY KEY (`idmantencion`) ,
  INDEX `fk_mantencion_boleta1_idx` (`boleta_idboleta` ASC) ,
  CONSTRAINT `fk_mantencion_boleta1`
    FOREIGN KEY (`boleta_idboleta` )
    REFERENCES `cododb`.`boleta` (`idboleta` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------

-- Table `cododb`.`venta`

-- -----------------------------------------------------
DROP TABLE IF EXISTS `cododb`.`venta` ;
CREATE TABLE IF NOT EXISTS `cododb`.`venta` (
  `idventa` INT NOT NULL AUTO_INCREMENT ,
  `producto` VARCHAR(45) NULL ,
  `preciocompra` VARCHAR(45) NULL ,
  `precioventa` VARCHAR(45) NULL ,
  `cantidad` VARCHAR(45) NULL ,
  `proveedor` VARCHAR(45) NULL ,
  `idboleta` INT NULL ,
  `boleta_idboleta` INT NOT NULL ,
  PRIMARY KEY (`idventa`) ,
  INDEX `fk_venta_boleta1_idx` (`boleta_idboleta` ASC) ,
  CONSTRAINT `fk_venta_boleta1`
    FOREIGN KEY (`boleta_idboleta` )
    REFERENCES `cododb`.`boleta` (`idboleta` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;
