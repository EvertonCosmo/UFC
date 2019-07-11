CREATE TABLE cliente(
	cod_cliente INTEGER PRIMARY KEY NOT NULL UNIQUE,
	nome VARCHAR(20)
);

CREATE TABLE endereco(
	cod_cliente INTEGER PRIMARY KEY REFERENCES cliente(cod_cliente),
	end_rua VARCHAR(20),
	end_cep VARCHAR(10),
	end_estado VARCHAR(10),
	end_cidade VARCHAR(10)
);


CREATE TABLE pessoa_fisica(
	cpf VARCHAR(15) UNIQUE,
	cod_cliente INTEGER REFERENCES cliente(cod_cliente)
	
);
CREATE TABLE pessoa_juridica(
	cnpj VARCHAR(20) UNIQUE,
	cod_cliente INTEGER REFERENCES cliente(cod_cliente)
	
);


CREATE TABLE telefone(
	numero VARCHAR(11),
	cod_cliente INTEGER REFERENCES cliente(cod_cliente)
	
);


CREATE TABLE produto (
	cod_produto INTEGER PRIMARY KEY NOT NULL UNIQUE,
	marca VARCHAR(10),
	tipo VARCHAR(10),
	valor NUMERIC  ,
	quantidade INTEGER,
	estilista VARCHAR(10),
	genero VARCHAR(10),
	tamanho CHAR,
	ano DATE
);

CREATE TABLE forma_pagamento(
	cod_forma_pagamento INTEGER PRIMARY KEY NOT NULL,
	descricao VARCHAR(10)
)

CREATE TABLE pagamento(
	cod_pagamento INTEGER PRIMARY KEY NOT NULL,
	valor NUMERIC,
	cod_forma_pagamento INTEGER REFERENCES forma_pagamento(cod_forma_pagamento)
);
CREATE TABLE pedido(
	cod_pedido INTEGER PRIMARY KEY NOT NULL UNIQUE,
	data_pedido DATE,
	valor_frete NUMERIC,
	
	cod_pagamento INTEGER REFERENCES pagamento(cod_pagamento),
	cod_cliente INTEGER REFERENCES cliente(cod_cliente)
	
);

CREATE TABLE pedido_produto(
	cod_pedido INTEGER REFERENCES pedido(cod_pedido),
	cod_produto INTEGER REFERENCES produto(cod_produto)
);
