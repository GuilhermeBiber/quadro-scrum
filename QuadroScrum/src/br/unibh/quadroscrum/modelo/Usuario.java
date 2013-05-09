package br.unibh.quadroscrum.modelo;

public class Usuario {

	public static final String NOME_TABELA = "scrum_usuario";
	
	private Long id;
	private String email;
	private String senha;
	private int tipoUsuario; // 1: Steakholder, 2:ScrumMaster, 3:Team
	
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


	public int getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	public Long getId() {
		return id;
	}
	
	
	
	
	
}
