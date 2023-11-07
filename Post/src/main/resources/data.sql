DROP TABLE IF EXISTS post;

CREATE TABLE `post` (
  `post_id` int NOT NULL AUTO_INCREMENT,
  `text` varchar(100) NOT NULL,
  `usuario_id` int NOT NULL,
  PRIMARY KEY (`post_id`)
);

INSERT INTO `post` (`usuario_id`,`text`)
 VALUES (2,'06-11-primer comentario');
 
 INSERT INTO `post` (`usuario_id`,`text`)
 VALUES (1,'localhost');

  INSERT INTO `post` (`usuario_id`,`text`)
 VALUES (1,'musica');