#VOLTANDO O IDENTITY DA PK
ALTER TABLE `usuario` AUTO_INCREMENT=1

#CRIANDO A TABELA nivel_acesso
CREATE TABLE nivel_acesso (
	id_nivel_acesso INT PRIMARY KEY NOT NULL AUTO_INCREMENT
    ,nivel_acesso VARCHAR(15) NOT NULL
);

#CRIANDO A TABELA usuario
CREATE TABLE usuario (
	id_usuario INT AUTO_INCREMENT
    ,usuario VARCHAR (30) NOT NULL
    ,senha VARCHAR(20) NOT NULL
    ,email VARCHAR(100) NOT NULL
    ,data_nascimento DATE NOT NULL
    ,id_nivel_acesso INT NOT NULL,
    CONSTRAINT PK_usuario PRIMARY KEY (id_usuario),
    CONSTRAINT FK_nivel_acesso FOREIGN KEY (id_nivel_acesso)
    REFERENCES nivel_acesso (id_nivel_acesso)
);

CREATE TABLE cedente (
	id_cedente INT PRIMARY KEY AUTO_INCREMENT
    ,nome_cedente VARCHAR(100) NOT NULL
    ,endereco VARCHAR(150) NULL
    ,email_cedente VARCHAR(100) NOT NULL

);

CREATE TABLE operacao (
	id_operacao INT AUTO_INCREMENT
    ,id_cedente INT NOT NULL
    ,id_usuario INT NOT NULL
    ,qtd_titulos INT NOT NULL
    ,valor_total DOUBLE,

    CONSTRAINT PK_operacao PRIMARY KEY (id_operacao),
    CONSTRAINT FK_cedente FOREIGN KEY (id_cedente)
	REFERENCES cedente (id_cedente),
    CONSTRAINT FK_usuario FOREIGN KEY (id_usuario)
    REFERENCES usuario (id_usuario)
);

SELECT id_operacao
,cedente.nome_cedente
,usuario.usuario
,qtd_titulos
,valor_total
from operacao
inner join cedente
on operacao.id_cedente = cedente.id_cedente
inner join usuario
on operacao.id_usuario = usuario.id_usuario