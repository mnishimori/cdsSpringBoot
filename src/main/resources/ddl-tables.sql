-- para o spring executar este script, o nome do arquivo deve ser data.sql
create table cliente (
	id integer primary key auto_increment,
	nome varchar(100) not null,
	cpf varchar(11) 
);

create table produto (
	id integer primary key auto_increment,
	descricao varchar(100) not null,
	preco_unitario numeric(16,2)
);

create table pedido (
	id integer primary key auto_increment,
	cliente_id integer references cliente (id),
	data_pedido timestamp,
	total numeric(16,2),
	status varchar(20)
);

create table item_pedido (
	id integer primary key auto_increment,
	pedido_id integer references pedido (id),
	produto_id integer references produto (id),
	quantidade numeric(16,2)
)
