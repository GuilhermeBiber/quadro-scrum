package br.unibh.quadroscrum.modelo;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class Usuario implements KvmSerializable {

	public static final String NOME_TABELA = "scrum_usuario";
	
	private Long id;
	private String email;
	private String senha;
	private Integer tipoUsuario; // 1: Steakholder, 2:ScrumMaster, 3:Team
	
	public static final String NOME_ID = "_id";
	public static final String NOME_SENHA = "senha";
	public static final String NOME_EMAIL = "email";
	public static final String NOME_TIPO_USUARIO = "tipo_usuario";

	public static final int INDICE_ID = 0;
	public static final int INDICE_EMAIL = 1;
	public static final int INDICE_SENHA = 2;
	public static final int INDICE_TIPO_USUARIO = 3;
	
	public Usuario(String email, String senha, int tipoUsuario) {
		this.email = email;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String login) {
		this.email = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Integer getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(Integer tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	public Long getId() {
		return id;
	}


	@Override
	public Object getProperty(int index) {
		switch(index){
			case 0:
				return this.email;
			case 1:
				return this.senha;
			case 2:
				return this.tipoUsuario;
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
				pi.name = "email";
				break;
			case 1:
				pi.type = String.class;
				pi.name = "senha";
				break;
			case 2:
				pi.type = Integer.class;
				pi.name = "tipoUsuario";
				break;
			default:
				break;
		}
		
	}


	@Override
	public void setProperty(int index, Object obj) {
		switch(index){
			case 0:
				this.email = (String)obj;
				break;
			case 1:
				this.senha = (String)obj;
				break;
			case 2:
				this.tipoUsuario = (Integer)obj;
				break;
			default:
				break;
		}
	}
	
	
	
	
	
}
