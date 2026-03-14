create database loja;
use loja;
create table produto(
idProduto int auto_increment primary key,
nomeProduto varchar(60),
precoProduto double
);