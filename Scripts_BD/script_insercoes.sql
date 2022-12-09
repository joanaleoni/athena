use athena_bd;

# Populando a tabela disciplina
insert into disciplina values("0004824", "Modelagem de Software", 160), ("0006511", "Programação de Soluções Computacionais", 160), ("0006510", "Vida e Carreira", 60);

# Populando a tabela professor
insert into professor values(null, "Glauber Andrade dos Santos", '1976-02-26', "1111111", "11111111111", '2022-06-25', "Ciências da Computação", 'Pós-Graduação'), (null, "Aline Lermann Ferreira", '1984-03-04', "2222222", "22222222222", '2021-04-05', "Sistemas de Informação", 'Mestrado'), (null, "Elaine de Souza Vieira", '1990-08-20', "3333333", "33333333333", '2022-03-25', "Ciências da Computação", 'Bacharelado');

# Populando a tabela professor_ministra_disciplina
insert into professor_ministra_disciplina values(1, "0004824"), (1, "0006511"), (2, "0006511"), (3, "0006510");

# Populando a tabela aluno
insert into aluno values(null, "Joana Leoni Pereira", '2000-03-25', "111111", "11111111", "Sistemas de Informação", 1), (null, "Nicolas Araújo da Silveira Custódio", '2004-05-28', "222222", "22222222", "Ciências da Computação", 1);

# Populando a tabela disciplina_has_aluno
insert into disciplina_has_aluno values("0004824", 1), ("0004824", 2), ("0006510", 1), ("0006510", 2), ("0006511", 1), ("0006511", 2);
