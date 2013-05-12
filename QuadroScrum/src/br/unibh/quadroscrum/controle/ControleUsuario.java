package br.unibh.quadroscrum.controle;

import android.content.Context;
import android.database.Cursor;
import br.unibh.quadroscrum.modelo.Usuario;
import br.unibh.quadroscrum.repositorio.UsuarioRepositorio;
import br.unibh.quadroscrum.repositorio.UsuarioRepositorioScript;


public class ControleUsuario {
	 Context contexto;
	 
	 public ControleUsuario(Context contexto){
		 this.contexto = contexto;
	 }
	 
	
	 public boolean logarUsuario(Usuario usuario){
		 
		 UsuarioRepositorioScript repositorio = 
					new UsuarioRepositorioScript(contexto);
			
			Cursor c = repositorio.selectUsuarioSenha(usuario.getEmail(),
					usuario.getSenha());
			
			if(c.moveToFirst()){
				c.close();
				repositorio.fechar();
				return true;
			}
			c.close();
			repositorio.fechar();
			return false;		
		 
	 }
	 
	 public boolean existeUsuario(Usuario usuario){
			
			UsuarioRepositorioScript repositorio = 
					new UsuarioRepositorioScript(contexto);
			
			Cursor c = repositorio.selectUsuario(usuario.getEmail());

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
		
		UsuarioRepositorio repositorio = new UsuarioRepositorio(contexto);
		
		return repositorio.inserir(usuario);
		
	}


}