-- (a)
SELECT isbn, titulo FROM livros WHERE ano_publicacao >= 2010 AND valor < 70.00 group by titulo,isbn

-- (b)
SELECT titulo, ano_publicacao FROM livros ORDER BY ano_publicacao DESC
-- (c)
SELECT titulo,valor FROM livros WHERE valor > 60.00 ORDER BY titulo ASC,valor DESC
SELECT titulo,valor FROM livros WHERE valor > 60.00 ORDER BY valor DESC
-- (d)
SELECT titulo,nome  FROM livros  NATURAL JOIN editoras  WHERE id_editora = id  ORDER BY nome
SELECT titulo,nome  FROM livros  NATURAL JOIN editoras  WHERE id_editora = id  ORDER BY titulo
-- (e)
SELECT nome,titulo,ano_publicacao FROM (SELECT nome, isbn FROM autores 
								RIGHT OUTER JOIN livros_autores ON id_autor = id) AS autor
								NATURAL JOIN livros WHERE autor.isbn=isbn AND ano_publicacao BETWEEN 2009 AND 2011
								
-- (f)
CREATE VIEW editora_autor AS (SELECT nome,id_autor FROM ((SELECT nome,isbn FROM livros l NATURAL JOIN editoras e WHERE l.id_editora = e.id) AS editora_livro
					LEFT OUTER JOIN livros_autores l1 ON editora_livro.isbn=l1.isbn) AS editora_livros)
							
SELECT e.nome,a.nome FROM editora_autor e LEFT OUTER JOIN autores a ON e.id_autor = a.id

-- (g)
SELECT nome, ano_publicacao FROM(SELECT nome,isbn FROM autores a NATURAL JOIN livros_autores la WHERE a.id = la.id_autor) AS nome_autor
		RIGHT OUTER JOIN (SELECT * FROM livros l1 WHERE ano_publicacao = (SELECT MAX(l2.ano_publicacao) FROM livros l2 WHERE l2.isbn = l2.isbn))
		AS l
		ON nome_autor.isbn = l.isbn
		GROUP BY nome,ano_publicacao

-- (h)

--USANDO A VIEW DA LETRA f

SELECT a.nome FROM editora_autor e  RIGHT OUTER JOIN autores a ON e.id_autor = a.id WHERE e.nome ='Melhoramentos'



-- (i)

CREATE VIEW editora_livro AS (SELECT  id_autor,titulo,nome FROM ((SELECT titulo,isbn,nome FROM livros l NATURAL JOIN editoras e WHERE l.id_editora = e.id) AS editora_livro
					LEFT OUTER JOIN livros_autores l1 ON editora_livro.isbn=l1.isbn) AS editora_livros)

SELECT e.titulo,a.nome,e.nome FROM editora_livro e RIGHT OUTER JOIN autores a ON a.id = e.id_autor

			