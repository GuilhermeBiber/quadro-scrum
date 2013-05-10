package br.unibh.quadroscrum.modelo;

import java.util.Date;
import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class Produto  implements KvmSerializable{
	
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
	@Override
	public Object getProperty(int index) {
		switch(index){
			case 0:
				return this.dataInsercao;
			case 1:
				return this.nome;
			case 2:
				return this.id;
		}
		return null;
	}
	@Override
	public int getPropertyCount() {
		return 3;
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
			default:
				break;
		}
	}
	@Override
	public void setProperty(int index, Object obj) {
		switch (index) {
		case 0:
			this.dataInsercao = (Date)obj;
			break;
		case 1:
			this.nome = (String)obj;
			break;
		case 2:
			this.id = (Long)obj;
			break;
		default:
			break;
		}
	}
	
	
}
