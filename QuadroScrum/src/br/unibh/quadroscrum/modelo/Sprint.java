package br.unibh.quadroscrum.modelo;

import java.util.Date;

public class Sprint {

	public static final String NOME_TABELA = "scrum_sprint";
	
	private Long id;
	private String titulo;
	private String descricao;
	private Produto produto;
	private Date dataInsercao;
	private Date dataInicio;
	private Date dataFim;
	
	public static final String NOME_ID = "_id";
	public static final String NOME_TITULO = "titulo";
	public static final String NOME_DESCRICAO = "descricao";
	public static final String NOME_PRODUTO = "id_produto";
	public static final String NOME_DATA_INSERCAO = "data_insercao";
	public static final String NOME_DATA_INICIO = "data_inicio";
	public static final String NOME_DATA_FIM = "data_fim";
	
	public static final int INDICE_ID = 0;
	public static final int INDICE_TITULO = 1;
	public static final int INDICE_DESCRICAO = 2;
	public static final int INDICE_PRODUTO = 3;
	public static final int INDICE_DATA_INSERCAO = 4;
	public static final int INDICE_DATA_INICIO = 5;
	public static final int INDICE_DATA_FIM = 6;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Date getDataInsercao() {
		return dataInsercao;
	}
	public void setDataInsercao(Date dataInsercao) {
		this.dataInsercao = dataInsercao;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
	

}
