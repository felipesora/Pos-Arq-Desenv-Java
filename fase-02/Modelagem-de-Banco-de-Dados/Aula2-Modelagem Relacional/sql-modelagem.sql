CREATE TABLE Clientes (
	id_cliente int primary key,
    nome varchar(100),
    email varchar(100)
);

CREATE TABLE Pedidos (
	id_pedido int primary key,
	id_cliente int,
    data_pedido date,
    foreign key (id_cliente) references Clientes(id_cliente)
);

CREATE TABLE Produtos (
	id_produto int primary key,
	nome varchar(100),
    descricao varchar(100),
    preco decimal(10, 2)
);

CREATE TABLE Detalhes_Pedido (
	id_detalhe int primary key,
	id_pedido int,
    id_produto int,
    quantidade int,
    foreign key (id_pedido) references Pedidos(id_pedido),
	foreign key (id_produto) references Produtos(id_produto)
);

SELECT * FROM Clientes;
SELECT * FROM Pedidos;
SELECT * FROM Produtos;
SELECT * FROM Detalhes_Pedido;