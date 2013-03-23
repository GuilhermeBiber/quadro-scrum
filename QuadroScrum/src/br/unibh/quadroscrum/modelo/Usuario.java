package br.unibh.quadroscrum.modelo;

public class Usuario {

	public static final String NOME_TABELA = "scrum_usuario";
	
	private Long id;
	private String login;
	private String senha;
	
	public static final String NOME_ID = "_id";
	public static final String NOME_LOGIN = "login";
	public static final String NOME_SENHA = "senha";
	public static final String NOME_EMAIL = "email";
	
	public static final int INDICE_ID = 0;
	public static final int INDICE_LOGIN = 1;
	public static final int INDICE_SENHA = 2;
	public static final int INDICE_EMAIL = 3;
	
	public Usuario(String login, String senha) {
		this.id = null;
		this.login = login;
		this.senha = senha;
	}
	
	

	public Usuario(Long id, String login, String senha) {
		this.id = id;
		this.login = login;
		this.senha = senha;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
	
	
	
}
