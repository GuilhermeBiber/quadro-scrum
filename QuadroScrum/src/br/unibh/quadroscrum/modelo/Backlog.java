package br.unibh.quadroscrum.modelo;

import java.util.Date;

public class Backlog {
	
	public static final String NOME_TABELA = "scrum_backlog";
	
	private Long id;
	private String titulo;
	private String descricao;
	private Sprint sprint;
	private Usuario usuario;
	private Date dataInsecao;
	private Produto produto;
	private Long status;
	private int prioridade;
	private int tempoEstimado;
	private int travado;
	
	public static final String NOME_ID = "_id";
	public static final String NOME_TITULO = "titulo";
	public static final String NOME_DESCRICAO = "descricao";
	public static final String NOME_SPRINT = "_id_sprint";
	public static final String NOME_USUARIO = "_id_usuario";
	public static final String NOME_DATA_INSERCAO = "data_insercao";
	public static final String NOME_PRODUTO = "_id_produto";
	public static final String NOME_STATUS = "_id_status";
	public static final String NOME_PRIORIDADE = "prioridade";
	public static final String NOME_TEMPO_ESTIMADO = "tempo_estimado";
	public static final String NOME_TRAVADO = "travado";
	
	public static final int INDICE_ID = 0;
	public static final int INDICE_TITULO = 1;
	public static final int INDICE_DESCRICAO = 2;
	public static final int INDICE_SPRINT = 3;
	public static final int INDICE_USUARIO = 4;
	public static final int INDICE_DATA_INSERCAO = 5;
	public static final int INDICE_PRODUTO = 6;
	public static final int INDICE_STATUS = 7;
	public static final int INDICE_PRIORIDADE = 8;
	public static final int INDICE_TEMPO_ESTIMADO = 9;
	public static final int INDICE_TRAVADO = 10;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Sprint getSprint() {
		return sprint;
	}
	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getDataInsecao() {
		return dataInsecao;
	}
	public void setDataInsecao(Date dataInsecao) {
		this.dataInsecao = dataInsecao;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	public int getTempoEstimado() {
		return tempoEstimado;
	}
	public void setTempoEstimado(int tempoEstimado) {
		this.tempoEstimado = tempoEstimado;
	}
	public int getTravado() {
		return travado;
	}
	public void setTravado(int travado) {
		this.travado = travado;
	}	
	
	
}
