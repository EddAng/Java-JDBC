create database pessoa;

use pessoa;

create table aluno(
idAluno int primary key auto_increment,
nomeAluno varchar(30),
idade int,
matricula int
);