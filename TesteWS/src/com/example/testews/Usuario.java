package com.example.testews;


import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class Usuario implements KvmSerializable{


	private Long id;
	
	private String login;
	
	private String senha;
	
	private String email;

	//private List<Backlog> backlogs;
	
	public Usuario() {
	}



	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
			return this.login;
		case 2:
			return this.senha;
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
			pi.name = "login";
			break;
		case 2:
			pi.type = String.class;
			pi.name = "senha";
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
			this.login = (String)obj;
			break;
		case 2:
			this.senha = (String)obj;
			break;
		}		
	}
	
	
	
}
