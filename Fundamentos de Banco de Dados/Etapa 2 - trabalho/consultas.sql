-- Quantidade de telefones de determinado cliente
SELECT COUNT(*) as numero_telefone FROM telefone,cliente WHERE telefone.cod_cliente = cliente.cod_cliente AND nome = 'Antonio'

SELECT * FROM telefone
-- codigo do pedido e nome do cliente, e quantidade de pedido do cliente com quantidade > 1 
SELECT p.cod_pedido, c.nome, COUNT(*) as quantidade FROM pedido p NATURAL JOIN cliente c GROUP BY p.cod_pedido,c.nome HAVING COUNT(*) > 0

-- Lista tipo, código do produto, e data do pedido
SELECT d.tipo,d.cod_produto,data_pedido FROM
		 (SELECT  * FROM pedido p LEFT OUTER JOIN pedido_produto  c ON p.cod_pedido=c.cod_pedido
		 	NATURAL JOIN produto WHERE cod_produto = cod_produto )  d

-- Lista cod_produto e data pedido que possuem frete maior igual a  85 e forma de pagamento boleto
 SELECT cod_produto,data_pedido FROM
		 (SELECT  * FROM pedido p LEFT OUTER JOIN pedido_produto  c ON p.cod_pedido=c.cod_pedido
		 	NATURAL JOIN produto WHERE cod_produto = cod_produto )  d 
				WHERE EXISTS (SELECT * FROM pedido_produto p
				 	WHERE p.cod_produto =d.cod_produto and d.valor_frete = 85) 
					AND EXISTS (SELECT * from pedido WHERE pedido.cod_pagamento = 1)
				
				 