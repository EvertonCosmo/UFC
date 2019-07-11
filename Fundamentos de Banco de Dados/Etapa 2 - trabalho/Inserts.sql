
 SET datestyle = dmy
-- CLIENTE -- 
INSERT INTO cliente VALUES(1,'Antonio');
INSERT INTO cliente VALUES(2,'Everton');
INSERT INTO cliente VALUES(3,'Cosmo');
INSERT INTO cliente VALUES(4,'Elton');
INSERT INTO cliente VALUES(5,'Rodrigues');
INSERT INTO cliente VALUES(6,'Matheus');
INSERT INTO cliente VALUES(7,'Matt');
INSERT INTO cliente VALUES(8,'Bruno');
INSERT INTO cliente VALUES(9,'Thiago');
INSERT INTO cliente VALUES(10,'Glória');

-- ENDEREÇOS
INSERT INTO endereco VALUES(1,'treze de maio','63700000','ceará','crateús');
INSERT INTO endereco VALUES(2,'moura fé','63711111','ceará','crateús');
INSERT INTO endereco VALUES(3,'treze de junho','12345678','ceará','sobral');
INSERT INTO endereco VALUES(4,'primeiro de abril','55555555','ceará','sobral');
INSERT INTO endereco VALUES(5,'coronel jiló','99999999','piauí','piauí');
INSERT INTO endereco VALUES(6,'padre cicero','88888888','ceará','sobral');
INSERT INTO endereco VALUES(7,'ituano','11111111','são paulo','são paulo');
INSERT INTO endereco VALUES(8,'carlos alberto','33333333','ceará','russas');
INSERT INTO endereco VALUES(9,'batista melo','44444444','ceará','russas');
INSERT INTO endereco VALUES(10,'batista sousa','55555555','ceará','russas');



-- FORMA DE PAGAMENTO
INSERT INTO forma_pagamento VALUES(1,'Boleto');
INSERT INTO forma_pagamento VALUES(2,'Cartão');

-- PAGAMENTO
INSERT INTO pagamento VALUES(1,300,1);
INSERT INTO pagamento VALUES(2,400,2);
INSERT INTO pagamento VALUES(3,200,1);
INSERT INTO pagamento VALUES(4,100,1);
INSERT INTO pagamento VALUES(5,450,2);
INSERT INTO pagamento VALUES(6,890,1);
INSERT INTO pagamento VALUES(7,800,1);
INSERT INTO pagamento VALUES(8,700,2);
INSERT INTO pagamento VALUES(9,300,1);
INSERT INTO pagamento VALUES(10,120,1);

-- PESSOA FISICA 
INSERT INTO pessoa_fisica VALUES(22211111132,1);
INSERT INTO pessoa_fisica VALUES(55511155531,2);
INSERT INTO pessoa_fisica VALUES(66666666666,3);
INSERT INTO pessoa_fisica VALUES(33333333333,4);
INSERT INTO pessoa_fisica VALUES(44444444444,5);
INSERT INTO pessoa_fisica VALUES(55555555555,6);
INSERT INTO pessoa_fisica VALUES(77777777777,7);
INSERT INTO pessoa_fisica VALUES(99999999999,8);
INSERT INTO pessoa_fisica VALUES(12345678901,9);
INSERT INTO pessoa_fisica VALUES(61190831112,10);


-- PESSOA JURIDICA
INSERT INTO pessoa_juridica VALUES(6342764731,6);
INSERT INTO pessoa_juridica VALUES(6678467856,5);
INSERT INTO pessoa_juridica VALUES(2498589348,4);
INSERT INTO pessoa_juridica VALUES(6953889384,3);
INSERT INTO pessoa_juridica VALUES(1240290590,2);
INSERT INTO pessoa_juridica VALUES(4658689818,1);
INSERT INTO pessoa_juridica VALUES(7878445542,7);
INSERT INTO pessoa_juridica VALUES(7457587899,8);
INSERT INTO pessoa_juridica VALUES(7858475388,9);
INSERT INTO pessoa_juridica VALUES(8875838838,10);

-- Pedido 

INSERT INTO pedido VALUES (1,'12/03/2018',5,2,2);
INSERT INTO pedido VALUES (2,'12/03/2018',85,1,1);
INSERT INTO pedido VALUES (3,'12/03/2019',10,2,3);
INSERT INTO pedido VALUES (4,'16/02/2018',16,2,4);
INSERT INTO pedido VALUES (5,'12/03/2018',85,1,5);
INSERT INTO pedido VALUES (6,'06/01/2015',3,2,6);
INSERT INTO pedido VALUES (7,'12/03/2018',85,1,7);
INSERT INTO pedido VALUES (8,'12/03/2018',11,2,8);
INSERT INTO pedido VALUES (9,'12/03/2018',98,2,9);
INSERT INTO pedido VALUES (10,'12/03/2018',76,1,10);


-- Produto 
INSERT INTO produto VALUES (1,'roupa1','camiseta',20,12,'Evandro','Masculino','M','09/01/2016');
INSERT INTO produto VALUES (2,'roupa2','camiseta',10,12,'Julio','Masculino','G','01/01/2016');
INSERT INTO produto VALUES (3,'roupa3','vestido',60,12,'Juliana','Feminino','G','01/01/2016');
INSERT INTO produto VALUES (4,'roupa4','vestido',40,19,'Alves','Masculino','P','02/11/2016');
INSERT INTO produto VALUES (5,'roupa5','vestido',30,20,'Maria','Feminino','M','02/07/2010');
INSERT INTO produto VALUES (6,'roupa6','camiseta',60,12,'Diego','Masculino','P','05/11/2018');
INSERT INTO produto VALUES (7,'roupa7','camiseta',70,12,'Carlos','Masculino','G','19/02/2014');
INSERT INTO produto VALUES (8,'roupa8','camisola',100,12,'Juliana','Masculino','G','21/05/2016');
INSERT INTO produto VALUES (9,'roupa9','camiseta',80,12,'Julio','Masculino','M','05/05/2009');
INSERT INTO produto VALUES (10,'roupa10','vestido',900,12,'Julio','Feminino','M','02/11/2002');


-- Telefone 

INSERT INTO telefone VALUES (1111111111,1);
INSERT INTO telefone VALUES (2222222222,1);
INSERT INTO telefone VALUES (3333333333,2);
INSERT INTO telefone VALUES (1232435546,3);
INSERT INTO telefone VALUES (9932888888,4);
INSERT INTO telefone VALUES (2124354532,5);
INSERT INTO telefone VALUES (5484858488,6);
INSERT INTO telefone VALUES (4545984857,7);
INSERT INTO telefone VALUES (1289913788,8);
INSERT INTO telefone VALUES (32873267377,9);
INSERT INTO telefone VALUES (12898219378,10);

--produto_pedido
 INSERT INTO pedido_produto VALUES (1,1);
 INSERT INTO pedido_produto VALUES (2,2);
 INSERT INTO pedido_produto VALUES (3,3);
 INSERT INTO pedido_produto VALUES (4,4);
 INSERT INTO pedido_produto VALUES (5,5);
 INSERT INTO pedido_produto VALUES (6,6);
 INSERT INTO pedido_produto VALUES (7,7);
 INSERT INTO pedido_produto VALUES (8,8);
 INSERT INTO pedido_produto VALUES (9,9);
 INSERT INTO pedido_produto VALUES (10,10);