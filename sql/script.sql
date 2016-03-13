
CREATE TABLE evento (

	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	ano varchar(4),
	descricao varchar(100)
);

CREATE TABLE usuario (

	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome varchar(100),
    email varchar(50),
    login varchar(50),
    senha varchar(50),
    habilitado boolean
);


INSERT INTO usuario (nome, email, login, senha, habilitado) VALUES ('Roberto Alencar', 'roberto.alencar@jaboatao.ifpe.edu.br', 'roberto', 'Abc123', false);
INSERT INTO usuario (nome, email, login, senha, habilitado) VALUES ('Sérgio Santana', 'dpex@jaboatao.ifpe.edu.br', 'sergio', 'Abc123', true);
INSERT INTO usuario (nome, email, login, senha, habilitado) VALUES ('Mayara Luz', 'mayara.luz@jaboatao.ifpe.edu.br', 'mayara', 'Abc123', true);