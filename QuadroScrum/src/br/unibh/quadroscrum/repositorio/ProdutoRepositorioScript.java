package br.unibh.quadroscrum.repositorio;

import br.unibh.quadroscrum.modelo.Produto;

public class ProdutoRepositorioScript {
	
	public static final String CREATE_TABELA_PRODUTO = 
			"CREATE TABLE" + Produto.NOME_TABELA 
			+"("
			+Produto.NOME_ID + "integer primary key autoincrement"
			+Produto.NOME_PRODUTO + "varchar(50) not null,"
			+Produto.NOME_DATA_INSECAO + "date not null"
			+");"; 
	
	public static final String DROP_TABELA_PRODUTO = "DROP TABLE IF EXISTS "+ Produto.NOME_TABELA+";";

}
