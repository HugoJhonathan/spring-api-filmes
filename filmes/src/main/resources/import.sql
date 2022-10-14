INSERT INTO diretor(nome) VALUES ('Matt Reeves');
INSERT INTO diretor(nome) VALUES ('Matthew Vaughn');
INSERT INTO diretor(nome) VALUES ('Robert Zemeckis');
INSERT INTO diretor(nome) VALUES ('George Lucas');


INSERT INTO genero(nome) VALUES ('Ação');
INSERT INTO genero(nome) VALUES ('Aventura');
INSERT INTO genero(nome) VALUES ('Cinema de arte');
INSERT INTO genero(nome) VALUES ('Chanchada');
INSERT INTO genero(nome) VALUES ('Comédia');
INSERT INTO genero(nome) VALUES ('Comédia de ação');
INSERT INTO genero(nome) VALUES ('Comédia de terror');
INSERT INTO genero(nome) VALUES ('Comédia dramática');
INSERT INTO genero(nome) VALUES ('Comédia romântica');
INSERT INTO genero(nome) VALUES ('Dança');
INSERT INTO genero(nome) VALUES ('Documentário');
INSERT INTO genero(nome) VALUES ('Docuficção');
INSERT INTO genero(nome) VALUES ('Drama');
INSERT INTO genero(nome) VALUES ('Espionagem');
INSERT INTO genero(nome) VALUES ('Faroeste');
INSERT INTO genero(nome) VALUES ('Fantasia');
INSERT INTO genero(nome) VALUES ('Fantasia científica');
INSERT INTO genero(nome) VALUES ('Ficção científica');
INSERT INTO genero(nome) VALUES ('Filmes com truques');
INSERT INTO genero(nome) VALUES ('Filmes de guerra');
INSERT INTO genero(nome) VALUES ('Mistério');
INSERT INTO genero(nome) VALUES ('Musical');
INSERT INTO genero(nome) VALUES ('Filme policial');
INSERT INTO genero(nome) VALUES ('Romance');
INSERT INTO genero(nome) VALUES ('Terror');
INSERT INTO genero(nome) VALUES ('Thriller');


INSERT INTO filme(title, data, poster, orcamento, receita, diretor_id) VALUES ('Batman', "2022-01-01",'https://m.media-amazon.com/images/M/MV5BMDdmMTBiNTYtMDIzNi00NGVlLWIzMDYtZTk3MTQ3NGQxZGEwXkEyXkFqcGdeQXVyMzMwOTU5MDk@.jpg',185,770.3, 1);
INSERT INTO filme(title, data, poster, orcamento, receita, diretor_id) VALUES ('Kingsman: Serviço Secreto', "2014-01-01",'https://m.media-amazon.com/images/M/MV5BNTg3YTI1ZmUtMjM4MC00MzVkLTg2ODItMTczNjc3MzI2NjU0XkEyXkFqcGdeQXVyMTAyOTE2ODg0._V1_FMjpg_UX681_.jpg',81,414, 2);
INSERT INTO filme(title, data, poster, orcamento, receita, diretor_id) VALUES ('De Volta para o Futuro', "1975-01-01",'https://m.media-amazon.com/images/M/MV5BYzA0YTY4NTctYTg2Mi00MzNhLWJiMmYtNjNhMTk1MTBmZDU3XkEyXkFqcGdeQXVyMTAzMDM4MjM0._V1_.jpg',19,381, 3);
INSERT INTO filme(title, data, poster, orcamento, receita, diretor_id) VALUES ('Star Wars', "1977-05-25",'https://m.media-amazon.com/images/M/MV5BNzg4MjQxNTQtZmI5My00YjMwLWJlMjUtMmJlY2U2ZWFlNzY1XkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_FMjpg_UX828_.jpg',11,775.8, 4);


INSERT INTO generos_do_filme(id_filme, id_genero) VALUES (1,1);
INSERT INTO generos_do_filme(id_filme, id_genero) VALUES (1,23);
INSERT INTO generos_do_filme(id_filme, id_genero) VALUES (1,13);

INSERT INTO generos_do_filme(id_filme, id_genero) VALUES (2,1);
INSERT INTO generos_do_filme(id_filme, id_genero) VALUES (2,2);
INSERT INTO generos_do_filme(id_filme, id_genero) VALUES (2,5);
INSERT INTO generos_do_filme(id_filme, id_genero) VALUES (2,14);

INSERT INTO generos_do_filme(id_filme, id_genero) VALUES (3,2);
INSERT INTO generos_do_filme(id_filme, id_genero) VALUES (3,18);

INSERT INTO generos_do_filme(id_filme, id_genero) VALUES (4,1);
INSERT INTO generos_do_filme(id_filme, id_genero) VALUES (4,2);
INSERT INTO generos_do_filme(id_filme, id_genero) VALUES (4,16);