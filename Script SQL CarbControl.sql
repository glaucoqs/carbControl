#CENTRO UNIVERSITARIO MUNICIPAL DE SAO JOSE
#ANALISE E DESENVOLVIMENTO DE SISTEMAS
#BANCO DE DADOS

#Trabalho final de Semestre - Projeto Calculadora de doses de Insulina (Banco de Dados)

#Alunos: 
#Bruno Perdigão
#Glauco Quadros Soares
#        
#Introdução:
#
#Este projeto tem por objetivo o desenvolvimento de um sistema que irá auxiliar 
#pessoas diabéticas a calcular suas doses de insulina, com base em sua resistência 
#insulínica (Razão Insuina/Carboidrato I/C) e a quantidade de carboidratos ingeridos em cada refeição.
#O sistema necessita de um banco de dados onde possa guardar as insformações 
#referentes aos alimentos que podem ser ingeridos, bem como informações 
#pertinentes ao cálculo de carboidratos.


#CRIAÇÃO DO BANCO DE DADOS E SUAS TABELAS


CREATE SCHEMA IF NOT EXISTS carbcontrol DEFAULT CHARACTER SET utf8 ;
USE carbcontrol;


# Tabela carbcontrol.usuario

CREATE TABLE IF NOT EXISTS carbcontrol.usuario (
  idusuario INT UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  idade INT UNSIGNED NOT NULL,
  peso FLOAT UNSIGNED NOT NULL,
  senha VARCHAR(45) NOT NULL,
  data_registro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  razao_ic INT UNSIGNED NOT NULL,
  PRIMARY KEY (idusuario),
  UNIQUE INDEX idusuario_UNIQUE (idusuario ASC))
ENGINE = InnoDB;


# Tabela carbcontrol.medida_caseira

CREATE TABLE IF NOT EXISTS carbcontrol.medida_caseira (
  idmedida_caseira INT UNSIGNED NOT NULL AUTO_INCREMENT,
  medida VARCHAR(45) NOT NULL,
  #peso FLOAT UNSIGNED NOT NULL,
  PRIMARY KEY (idmedida_caseira),
  UNIQUE INDEX idmedida_caseira_UNIQUE (idmedida_caseira ASC),
  UNIQUE INDEX tipo_UNIQUE (medida ASC))
ENGINE = InnoDB;



#Tabela carbcontrol.categoria

CREATE TABLE IF NOT EXISTS carbcontrol.categoria (
  idcategoria INT UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  PRIMARY KEY (idcategoria),
  UNIQUE INDEX idcategoria_UNIQUE (idcategoria ASC),
  UNIQUE INDEX nome_UNIQUE (nome ASC))
ENGINE = InnoDB;


#Tabela carbcontrol.alimento

CREATE TABLE IF NOT EXISTS carbcontrol.alimento (
  idalimento INT UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  kcal INT UNSIGNED NOT NULL,
  peso_porcao FLOAT UNSIGNED NOT NULL,
  carb_porcao FLOAT UNSIGNED NOT NULL,
  medida_caseira_idmedida_caseira INT UNSIGNED NOT NULL,
  categoria_idcategoria INT UNSIGNED NOT NULL,
  PRIMARY KEY (idalimento, medida_caseira_idmedida_caseira, categoria_idcategoria),
  UNIQUE INDEX idalimento_UNIQUE (idalimento ASC),
  UNIQUE INDEX nome_UNIQUE (nome ASC),
  INDEX fk_alimento_medida_caseira_idx (medida_caseira_idmedida_caseira ASC),
  INDEX fk_alimento_categoria1_idx (categoria_idcategoria ASC),
  CONSTRAINT fk_alimento_medida_caseira
    FOREIGN KEY (medida_caseira_idmedida_caseira)
    REFERENCES carbcontrol.medida_caseira (idmedida_caseira)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_alimento_categoria1
    FOREIGN KEY (categoria_idcategoria)
    REFERENCES carbcontrol.categoria (idcategoria)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


#Tabela carbcontrol.porcao

CREATE TABLE IF NOT EXISTS carbcontrol.porcao (
  idporcao INT NOT NULL AUTO_INCREMENT,
  porcao_consumida FLOAT NOT NULL,
  alimento_idalimento INT UNSIGNED NOT NULL,
  alimento_medida_caseira_idmedida_caseira INT UNSIGNED NOT NULL,
  alimento_categoria_idcategoria INT UNSIGNED NOT NULL,
  PRIMARY KEY (idporcao, alimento_idalimento, alimento_medida_caseira_idmedida_caseira, alimento_categoria_idcategoria),
  INDEX fk_porcao_alimento1_idx (alimento_idalimento ASC, alimento_medida_caseira_idmedida_caseira ASC, alimento_categoria_idcategoria ASC),
  CONSTRAINT fk_porcao_alimento1
    FOREIGN KEY (alimento_idalimento , alimento_medida_caseira_idmedida_caseira , alimento_categoria_idcategoria)
    REFERENCES carbcontrol.alimento (idalimento , medida_caseira_idmedida_caseira , categoria_idcategoria)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



#Tabela carbcontrol.Prato

CREATE TABLE IF NOT EXISTS carbcontrol.Prato (
  idPrato INT NOT NULL AUTO_INCREMENT,
  total_carb FLOAT UNSIGNED NOT NULL,
  alimento_idalimento INT UNSIGNED NOT NULL,
  alimento_medida_caseira_idmedida_caseira INT UNSIGNED NOT NULL,
  alimento_categoria_idcategoria INT UNSIGNED NOT NULL,
  porcao_idporcao INT NOT NULL,
  PRIMARY KEY (idPrato, alimento_idalimento, alimento_medida_caseira_idmedida_caseira, alimento_categoria_idcategoria, porcao_idporcao),
  INDEX fk_Prato_porcao1_idx (porcao_idporcao ASC),
  CONSTRAINT fk_Prato_porcao1
    FOREIGN KEY (porcao_idporcao)
    REFERENCES carbcontrol.porcao (idporcao)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



#Tabela carbcontrol.historico_refeicao

CREATE TABLE IF NOT EXISTS carbcontrol.historico_refeicao (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  data DATETIME NOT NULL,
  insulina_aplicada INT UNSIGNED NULL,
  usuario_idusuario INT UNSIGNED NOT NULL,
  Prato_idPrato INT NOT NULL,
  Prato_alimento_idalimento INT UNSIGNED NOT NULL,
  Prato_alimento_medida_caseira_idmedida_caseira INT UNSIGNED NOT NULL,
  Prato_alimento_categoria_idcategoria INT UNSIGNED NOT NULL,
  PRIMARY KEY (id, usuario_idusuario, Prato_idPrato, Prato_alimento_idalimento, Prato_alimento_medida_caseira_idmedida_caseira, Prato_alimento_categoria_idcategoria),
  INDEX fk_historico_refeicao_usuario1_idx (usuario_idusuario ASC),
  INDEX fk_historico_refeicao_Prato1_idx (Prato_idPrato ASC, Prato_alimento_idalimento ASC, Prato_alimento_medida_caseira_idmedida_caseira ASC, Prato_alimento_categoria_idcategoria ASC),
  CONSTRAINT fk_historico_refeicao_usuario1
    FOREIGN KEY (usuario_idusuario)
    REFERENCES carbcontrol.usuario (idusuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_historico_refeicao_Prato1
    FOREIGN KEY (Prato_idPrato , Prato_alimento_idalimento , Prato_alimento_medida_caseira_idmedida_caseira , Prato_alimento_categoria_idcategoria)
    REFERENCES carbcontrol.Prato (idPrato , alimento_idalimento , alimento_medida_caseira_idmedida_caseira , alimento_categoria_idcategoria)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


#INCLUSÃO DE DADOS (CATEGORIA)

INSERT INTO carbcontrol.categoria (nome) 
VALUES 

('cereais_e_derivados'),
('hortalicas'),
('frutas'),
('leguminosas_oleoginosas'),
('oleos_e_gorduras'),
('leite_e_derivados'),
('bebidas'),
('carnes_e_ovos'),
('pratos_prontos'),
('paes_torradas_e_biscoitos'),
('fast_food'),
('doces');

#INCLUSÃO DE DADOS (USUARIO)

INSERT INTO carbcontrol.usuario (nome, email, idade, peso, senha, razao_ic) 
VALUES 

('Glauco Quadros Soares', 'glaucoqs@hotmail.com', '31', '98', '1234', '6'),
('Bruno Perdigão', 'bperdigao@gmail.com', '36', '75', '4321', '15'),
('Andrey Abreu', 'andreiy23@gmail.com', '33', '95', '2222', '14');

#INCLUSÃO DE DADOS (MEDIDA CASEIRA)

INSERT INTO carbcontrol.medida_caseira (medida) 

VALUES 
('unidade'),
('fatia'),
('colher_sopa'),
('colher_cha'),
('colher_sobremesa'),
('1_xicara'),
('1/2_xicara'),
('3/4_xicara'),
('1/2_unidade'),
('1_copo'),
('1/2_copo'),
('1/3_copo'),
('1_pote'),
('1_frasco'),
('em_pesquisa'),
('1_porcao'),
('1_bola'),
('1_taca'),
('dose'),
('1_garrafa'),
('1_folha'),
('1_ramo');


#INCLUSÃO DE DADOS (ALIMENTOS)

INSERT INTO carbcontrol.alimento (nome, kcal, peso_porcao, carb_porcao, medida_caseira_idmedida_caseira, categoria_idcategoria) 

VALUES 
('Arroz branco cozido', 24, 20, 5, 3, 1),
('Batata frita', 70, 25, 9, 3, 1),
('Pão francês', 154, 50, 30, 1, 1),
('Brócolis cozido', 4, 10, 0.4, 3, 2),
('Tomate', 4, 15, 1, 2, 2),
('Banana maçã', 74, 65, 17, 1, 3),
('Açaí', 438, 240, 72, 10, 3),
('Amendoim', 97, 17, 1, 3, 4),
('Feijão', 15, 20, 3, 3, 4),
('Maionese', 179, 27, 0, 3, 5),
('Manteiga', 242, 32, 0, 3, 5),
('Leite de vaca integral', 146, 240, 12, 1, 6),
('Toddynho tradicional', 185, 200, 32, 1, 6),
('Coca Cola', 85, 200, 21, 10, 7),
('Cerveja com álcool', 122, 290, 11, 10, 7),
('Bacon', 41, 10, 0, 2, 8),
('Ovo de gainha cru/cozido', 143, 100, 1.6, 1, 8),
('Lasanha à Bolonhesa Sadia', 455, 325, 43, 9, 9),
('Hot Pocket X-Burger', 364, 145, 34, 1, 9),
('Biscoito CLUB SOCIAL Oiginal', 121, 26, 14, 1, 10),
('Biscoito Negresco', 47, 10, 7, 1, 10),
('Big Mac Mc Donalds', 483, 212, 43, 1, 11),
('Sorvete Casquinha Mista Mc Donalds', 192, 113, 31, 1, 11),
('Chocolate Charge', 187, 40, 24, 1, 12),
('Bala de Goma Gomets DORI', 20, 5, 5, 1, 12);


