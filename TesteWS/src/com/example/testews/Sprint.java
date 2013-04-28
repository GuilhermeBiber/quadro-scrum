package com.example.testews;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class Sprint implements KvmSerializable{
	

	private Long id;
	
	private String titulo;
	
	private String descricao;
	
	//private List<Backlog> backlogs;

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

	@Override
	public Object getProperty(int index) {
		switch(index){
		case 0:
			return this.descricao;
		case 1:
			return this.id;
		case 2:
			return this.titulo;
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
			pi.type = String.class;
			pi.name = "descricao";
			break;
		case 1:
			pi.type = Long.class;
			pi.name = "id";
			break;
		case 2:
			pi.type = String.class;
			pi.name = "titulo";
			break;
		}
	}

	@Override
	public void setProperty(int index, Object obj) {
		switch(index){
		case 0:
			this.descricao = (String)obj;
			break;
		case 1:
			this.id = (Long)obj;
			break;
		case 2:
			this.titulo = (String)obj;
			break;
		}
	}	
	

}
