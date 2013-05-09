package br.unibh.quadroscrum.modelo;

import java.util.Date;

public class Produto {
	
	public static final String NOME_TABELA = "scrum_produto";
	
	private Long id;
	private String nome;
	private Date dataInsercao;
	
	
	public static final String NOME_ID = "_id";
	public static final String NOME_PRODUTO = "nome";
	public static final String NOME_DATA_INSECAO = "data_insercao";
	
	public static final int INDICE_ID = 0;
	public static final int INDICE_DESCRICAO = 1;
	public static final int INDICE_DATA_INSERCAO = 2;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataInsercao() {
		return dataInsercao;
	}
	public void setDataInsercao(Date dataInsercao) {
		this.dataInsercao = dataInsercao;
	}
	
	
}
