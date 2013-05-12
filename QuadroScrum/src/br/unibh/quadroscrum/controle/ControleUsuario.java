package br.unibh.quadroscrum.controle;

import android.content.Context;
import android.database.Cursor;
import br.unibh.quadroscrum.modelo.Usuario;
import br.unibh.quadroscrum.repositorio.UsuarioRepositorioScript;


public class ControleUsuario {
	 Context contexto;
	 
	 public ControleUsuario(Context contexto){
		 this.contexto = contexto;
	 }
	 
	
public boolean existeUsuario(Usuario usuario){
		
		UsuarioRepositorioScript repositorio = new UsuarioRepositorioScript(contexto);
		
		Cursor c = repositorio.selectUsuarioLoginSenha(usuario.getEmail(), usuario.getSenha());
		
		if(c.moveToFirst()){
			c.close();
			repositorio.fechar();
			return true;
		}else{
			c.close();
			repositorio.fechar();
			return false;		
		}
		

	}
	
	
	public boolean inserir(Usuario usuario){
		
		UsuarioRepositorioScript repositorio = new UsuarioRepositorioScript(contexto);
		
		return repositorio.inserir(usuario);
		
	}


}