package br.unibh.quadroscrum.controle;

import br.unibh.quadroscrum.modelo.Backlog;
import br.unibh.quadroscrum.repositorio.BacklogRepositorio;
import android.content.Context;

public class ControleBacklog {
	Context contexto;
	BacklogRepositorio repositorio;
	
	
	public ControleBacklog(Context contexto){
		this.contexto = contexto;
		this.repositorio = new BacklogRepositorio(contexto);
	}
	
	public boolean insereBacklog(Backlog backlog){
		
		Long id = repositorio.inserir(backlog);
		if(id != -1){
			repositorio.fechar();
			return true;
		}
		
		repositorio.fechar();
		return false;
	}
}
