package com.example.testews;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapPrimitive;

import android.util.Log;


public class Backlog implements KvmSerializable {
	
	private Long id;

	private String titulo;
	
	private String descricao;

	private Usuario usuario;

	private Date dataInsercao;
	
	private Sprint sprint;

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDataInsercao() {
		return dataInsercao;
	}

	public void setDataInsercao(Date dataInsercao) {
		this.dataInsercao = dataInsercao;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	@Override
	public String toString() {
		return "Backlog [id=" + id + ", titulo=" + titulo + ", descricao="
				+ descricao + ", usuario=" + usuario + ", dataInsercao="
				+ dataInsercao + ", sprint=" + sprint + "]";
	}

	@Override
	public Object getProperty(int index) {
		switch(index) {
		case 0:
			return this.dataInsercao;
		case 1:
			return this.descricao;
		case 2: 
			return this.id;
		case 3:
			return this.sprint;
		case 4:
			return this.titulo;
		case 5:
			return this.usuario;
		}
		return null;
	}

	@Override
	public int getPropertyCount() {
		return 6;
	}

	@Override
	public void getPropertyInfo(int index, Hashtable ht, PropertyInfo pi) {
		switch(index) {
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
			pi.type = Sprint.class;
			pi.name = "sprint";
			break;
		case 4:
			pi.type = String.class;
			pi.name = "titulo";
			break;
		case 5:
			pi.type = Usuario.class;
			pi.name = "usuario";
			break;
		}
	}

	@Override
	public void setProperty(int index, Object obj) {
		switch(index) {
		case 0:
			//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			format.setLenient(true);
			try {
				//Log.i("Valor desconhecido", obj.toString());
				this.dataInsercao = format.parse(obj.toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 1:
			this.descricao = (String) obj;
			break;
		case 2: 
			this.id = Long.parseLong(obj.toString());
			break;
		case 3:
			this.sprint = (Sprint) obj;
			break;
		case 4:
			this.titulo = (String) obj;
			break;
		case 5:
			Log.i("Valor desconhecido", obj.toString());
			this.usuario = (Usuario) obj;
			break;
		}
	}
	
	
	
}
