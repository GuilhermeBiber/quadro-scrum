package br.unibh.quadroscrum.modelo;

import java.util.Date;

public class Backlog {
	
	private Long _id;
	private String titulo;
	private String descricao;
	private int estado;
	private Long _idSprint;
	private Long _idUsuario;
	private Date dataInsecao;
	private Long _idProduto;
	private Long _idStatus;
	private int prioridade;
	private int tempoEstimado;
	private char travado;
	
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
	public char getTravado() {
		return travado;
	}
	public void setTravado(char travado) {
		this.travado = travado;
	}
	public static final String NOME_ID = "_id";
	public static final String NOME_TITULO = "titulo";
	public static final String NOME_DESCRICAO = "descricao";
	public static final String NOME_ESTADO = "estado";
	public static final String NOME_SPRINT = "_id_sprint";
	public static final String NOME_USUARIO = "_id_usuario";
	public static final String NOME_INSERCAO = "data_insercao";
	
	public static final int INDICE_ID = 0;
	public static final int INDICE_TITULO = 1;
	public static final int INDICE_DESCRICAO = 2;
	public static final int INDICE_ESTADO = 3;
	public static final int INDICE_SPRINT = 4;
	public static final int INDICE_USUARIO = 5;
	public static final int INDICE_INSERCAO = 6;
	
	
	public Long get_id() {
		return _id;
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
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public Long get_idSprint() {
		return _idSprint;
	}
	public void set_idSprint(Long _idSprint) {
		this._idSprint = _idSprint;
	}
	public Long get_idUsuario() {
		return _idUsuario;
	}
	public void set_idUsuario(Long _idUsuario) {
		this._idUsuario = _idUsuario;
	}
	public Date getDataInsecao() {
		return dataInsecao;
	}
	public void setDataInsecao(Date dataInsecao) {
		this.dataInsecao = dataInsecao;
	}
	public Long get_idProduto() {
		return _idProduto;
	}
	public void set_idProduto(Long _idProduto) {
		this._idProduto = _idProduto;
	}
	public Long get_idStatus() {
		return _idStatus;
	}
	public void set_idStatus(Long _idStatus) {
		this._idStatus = _idStatus;
	}
	
	
	
	
}
