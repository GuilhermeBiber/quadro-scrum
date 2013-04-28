package br.unibh.quadroscrum.controle;

import android.content.Context;
import android.database.Cursor;
import br.unibh.quadroscrum.modelo.Usuario;
import br.unibh.quadroscrum.repositorio.RepositorioUsuarioScript;


public class ControleUsuario {
	 Context contexto;
	 
	 public ControleUsuario(Context contexto){
		 this.contexto = contexto;
	 }
	 
	public boolean existeUsuario(String login, String senha){
		
		RepositorioUsuarioScript repositorio = new RepositorioUsuarioScript(contexto);
		
		Cursor c = repositorio.selectUsuarioLoginSenha(login, senha);
		
		if(c.moveToFirst()){
			repositorio.fechar();			
			return true;
		}else{
			repositorio.fechar();
			return false;		
		}
		

	}
	
public Long existeUsuario(Usuario usuario){
		
		RepositorioUsuarioScript repositorio = new RepositorioUsuarioScript(contexto);
		
		Cursor c = repositorio.selectUsuarioLoginSenha(usuario.getLogin(), usuario.getSenha());
		
		if(c.moveToFirst()){
			Long _id = c.getLong(Usuario.INDICE_ID);
			repositorio.fechar();
			return _id;
		}else{
			repositorio.fechar();
			return null;		
		}
		

	}
	
	
	public Long salvar(Usuario usuario){
		
		RepositorioUsuarioScript repositorio = new RepositorioUsuarioScript(contexto);
		
		Long id = usuario.getId();
		
		if(id != null){
			repositorio.atualizar(usuario);
		}else{
			id = repositorio.inserir(usuario);
		}
		repositorio.fechar();
		return id;
	}


}