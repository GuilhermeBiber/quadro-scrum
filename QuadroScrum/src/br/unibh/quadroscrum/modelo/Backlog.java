package br.unibh.quadroscrum.modelo;

import java.util.Date;
import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class Backlog implements KvmSerializable{
	
	public static final String NOME_TABELA = "scrum_backlog";
	
	private Long id;
	private String titulo;
	private String descricao;
	private Sprint sprint;
	private Usuario usuario;
	private Date dataInsercao;
	private Produto produto;
	private Integer status;
	private Integer prioridade;
	private Integer tempoEstimado;
	private Integer travado;
	
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
		return dataInsercao;
	}
	public void setDataInsecao(Date dataInsecao) {
		this.dataInsercao = dataInsecao;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}
	public Integer getTempoEstimado() {
		return tempoEstimado;
	}
	public void setTempoEstimado(Integer tempoEstimado) {
		this.tempoEstimado = tempoEstimado;
	}
	public Integer getTravado() {
		return travado;
	}
	public void setTravado(Integer travado) {
		this.travado = travado;
	}
	
	@Override
	public Object getProperty(int index) {
		switch(index){
			case 0:
				return this.dataInsercao;
			case 1:
				return this.descricao;
			case 2:
				return this.id;
			case 3:
				return this.prioridade;
			case 4:
				return this.produto;
			case 5:
				return this.sprint;
			case 6:
				return this.status;
			case 7:
				return this.tempoEstimado;
			case 8:
				return this.titulo;
			case 9:
				return this.travado;
			case 10:
				return this.usuario;
		}
		return null;
	}
	@Override
	public int getPropertyCount() {
		return 11;
	}
	@Override
	public void getPropertyInfo(int index, Hashtable ht, PropertyInfo pi) {
		switch(index){
			case 0:
				pi.type = Date.class;
				pi.name = "dataInsercao";
				break;
			case 1:
				pi.type = String.class;
				pi.name = "descricao";
				break;
			case 2:
				pi.type = Long.class;
				pi.name = "id";
				break;
			case 3:
				pi.type = Integer.class;
				pi.name = "prioridade";
				break;
			case 4:
				pi.type = Produto.class;
				pi.name = "produto";
				break;
			case 5:
				pi.type = Sprint.class;
				pi.name = "sprint";
				break;
			case 6:
				pi.type = Integer.class;
				pi.name = "status";
				break;
			case 7:
				pi.type = Integer.class;
				pi.name = "tempoEstimado";
				break;
			case 8:
				pi.type = String.class;
				pi.name = "titulo";
				break;
			case 9:
				pi.type = Integer.class;
				pi.name = "travado";
				break;
			case 10:
				pi.type = Usuario.class;
				pi.name = "usuario";
				break;
		}		
	}
	@Override
	public void setProperty(int index, Object obj) {
		
		switch(index){
			case 0:
				this.dataInsercao = (Date)obj;
				break;
			case 1:
				this.descricao = (String)obj;
				break;
			case 2:
				this.id = (Long)obj;
				break;
			case 3:
				this.prioridade = (Integer)obj;
				break;
			case 4:
				this.produto = (Produto)obj;
				break;
			case 5:
				this.sprint = (Sprint)obj;
				break;
			case 6:
				this.status = (Integer)obj;
				break;
			case 7:
				this.tempoEstimado = (Integer)obj;
				break;
			case 8:
				this.titulo = (String)obj;
				break;
			case 9:
				this.travado = (Integer)obj;
				break;
			case 10:
				this.usuario = (Usuario)obj;
				break;
		}
	}
	@Override
	public String toString() {
		return "Backlog [id=" + id + ", titulo=" + titulo + ", descricao="
				+ descricao + ", sprint=" + sprint.toString()
				+ ", usuario=" + usuario.toString() 
				+ ", dataInsercao=" + dataInsercao 
				+ ", produto=" + produto.toString() + ", status=" + status 
				+ ", prioridade=" + prioridade
				+ ", tempoEstimado=" + tempoEstimado + ", travado=" + travado
				+ "]";
	}	
	
	
}
