
DROP TABLE IF EXISTS usuario;

CREATE TABLE `usuario` (
  `usuario_id` INTEGER NOT NULL AUTO_INCREMENT,
  `celular` varchar(100) NOT NULL,
   `nombre` varchar(100) NOT NULL,
    `apellido` varchar(100) NOT NULL,
     `password` varchar(100) NOT NULL,
  PRIMARY KEY (`usuario_id`)
);

INSERT INTO `usuario` (`celular`,`nombre`,`apellido`,`password`)
 VALUES ('123456789','alejandro','lujan','comida');
 INSERT INTO `usuario` (`celular`,`nombre`,`apellido`,`password`)
  VALUES ('123789654','luis','lujan','pollo');
  INSERT INTO `usuario` (`celular`,`nombre`,`apellido`,`password`)
   VALUES ('963852741','nick','ya','youtube');
   INSERT INTO `usuario` (`celular`,`nombre`,`apellido`,`password`)
    VALUES ('147852369','diego','corales','rata');



