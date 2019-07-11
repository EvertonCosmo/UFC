CREATE TABLE editoras(
	id INTEGER PRIMARY KEY,
	nome VARCHAR(50)
	
);
CREATE TABLE autores(
	id INTEGER PRIMARY KEY, 
	nome VARCHAR(50)
	
);

CREATE TABLE livros(
	isbn CHAR(13) PRIMARY KEY,
	titulo text,
	ano_publicacao INTEGER,
	qtd_estoque INTEGER,
	valor DECIMAL(10,2),
	id_editora INTEGER REFERENCES editoras(id)
	
);
CREATE TABLE livros_autores(
	isbn CHAR(13) REFERENCES livros(isbn),
	id_autor INTEGER REFERENCES autores(id)
	
);

INSERT INTO editoras VALUES (1,'Ática');
INSERT INTO editoras VALUES (2,'FTD');
INSERT INTO editoras VALUES (3,'Melhoramentos');
INSERT INTO editoras VALUES (4,'Novatec');
INSERT INTO editoras VALUES (5,'Bookman');

INSERT INTO livros VALUES (213,'Banco De Dados',2011,2,50.00,4);
INSERT INTO livros VALUES (425,'Sistemas Operacionais',2010,3,80.00,3);
INSERT INTO livros VALUES (732,'Lógica De Programação',2009,1,60.00,2);
INSERT INTO livros VALUES (441,'Programação Orientada a Objetos',2012,1,70.00,1);
INSERT INTO livros VALUES (659,'Java para Nerds',2010,3,90.00);
INSERT INTO livros VALUES (863,'Engenharia de Software',2010,2,40.00,2);
INSERT INTO livros VALUES (376,'Redes de Computadores',2008,1,100.00,3);

ALTER TABLE livros ALTER COLUMN titulo TYPE text;


INSERT INTO autores VALUES (1,'João');
INSERT INTO autores VALUES (2,'Maria');
INSERT INTO autores VALUES (3,'José');
INSERT INTO autores VALUES (4,'Lúcia');
INSERT INTO autores VALUES (5,'Carlos');
INSERT INTO autores VALUES (6,'Pedro');
INSERT INTO autores VALUES (7,'Ana');

INSERT INTO livros_autores VALUES (732,1);
INSERT INTO livros_autores VALUES (425,3);
INSERT INTO livros_autores VALUES (659,4);
INSERT INTO livros_autores VALUES (441,2);
INSERT INTO livros_autores VALUES (659,1);
INSERT INTO livros_autores VALUES (425,5);
INSERT INTO livros_autores VALUES (213,3);
	