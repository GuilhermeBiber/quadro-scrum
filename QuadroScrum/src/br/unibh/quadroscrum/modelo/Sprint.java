package br.unibh.quadroscrum.modelo;

import java.util.Date;
import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class Sprint implements KvmSerializable{

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
	@Override
	public Object getProperty(int index) {
		switch(index){
			case 0:
				return this.dataFim;
			case 1:
				return this.dataInicio;
			case 2:
				return this.dataInsercao;
			case 3:
				return this.descricao;
			case 4:
				return this.id;
			case 5:
				return this.produto;
			case 6:
				return this.titulo;
		}
		return null;
	}
	@Override
	public int getPropertyCount() {
		return 7;
	}
	@Override
	public void getPropertyInfo(int index, Hashtable ht, PropertyInfo pi) {
		switch(index){
			case 0:
				pi.type = Date.class;
				pi.name = "dataFim";
				break;
			case 1:
				pi.type = Date.class;
				pi.name = "dataInicio";
				break;
			case 2:
				pi.type = Date.class;
				pi.name = "dataInsercao";
				break;
			case 3:
				pi.type = String.class;
				pi.name = "descricao";
				break;
			case 4:
				pi.type = Long.class;
				pi.name = "id";
				break;
			case 5:
				pi.type = Produto.class;
				pi.name =  "produto";
				break;
			case 6:
				pi.type = String.class;
				pi.name = "titulo";
				break;
			default:
				break;
		}
	}
	@Override
	public void setProperty(int index, Object obj) {
		switch(index){
			case 0:
				this.dataFim = (Date)obj;
				break;
			case 1:
				this.dataInicio = (Date)obj;
				break;
			case 2:
				this.dataInsercao = (Date)obj;
				break;
			case 3:
				this.descricao = (String)obj;
				break;
			case 4:
				this.id = (Long)obj;
				break;
			case 5:
				this.produto = (Produto)obj;
				break;
			case 6:
				this.titulo = (String)obj;
				break;
			default:
				break;
		}
		
	}
	@Override
	public String toString() {
		return "Sprint [id=" + id + ", titulo=" + titulo + ", descricao="
				+ descricao + ", produto=" + produto + ", dataInsercao="
				+ dataInsercao + ", dataInicio=" + dataInicio + ", dataFim="
				+ dataFim + "]";
	}
	
	

}
