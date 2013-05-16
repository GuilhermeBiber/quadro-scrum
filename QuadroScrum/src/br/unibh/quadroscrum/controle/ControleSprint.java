package br.unibh.quadroscrum.controle;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import br.unibh.quadroscrum.iu.listas.SprintAdapter;
import br.unibh.quadroscrum.modelo.Produto;
import br.unibh.quadroscrum.modelo.Sprint;
import br.unibh.quadroscrum.repositorio.SprintRepositorio;

public class ControleSprint {

	Context contexto; 
	SprintRepositorio repositorio;

	public ControleSprint(Context contexto){
		this.contexto = contexto;
		this.repositorio = new SprintRepositorio(contexto);
	}
	
	public Sprint existeSprintIniciada(Produto produto){
		
		Cursor c = repositorio.selectSprintIniciada();
		
		if (c.moveToFirst()){
			
			return getSprint(c);
		}
		return null;
	}
	
	public Sprint getSprint(Cursor c){
		
		Sprint sprint = new Sprint();		
		
		sprint.setId(c.getLong(Sprint.INDICE_ID));
		sprint.setTitulo(c.getString(Sprint.INDICE_TITULO));
		sprint.setIniciada(c.getInt(Sprint.INDICE_INICIADA));
		sprint.setFinalizada(c.getInt(Sprint.INDICE_FINALIZADA));
		sprint.setDescricao(c.getString(Sprint.INDICE_DESCRICAO));
		
		Produto produto = new Produto();
		produto.setId(c.getLong(Produto.INDICE_ID));
		sprint.setProduto(produto);
		
		return sprint;
	}
	
	private ArrayList<Sprint> getProdutoSprint(Produto produto){
		
		Cursor c = repositorio.listarPorProduto(produto.getId());
		if(c.moveToFirst()){
			ArrayList<Sprint> listaSprint = new ArrayList<Sprint>();

			listaSprint.add(getSprint(c));			
			
			return listaSprint;
		}
		
		
		return null;
		
	}
	
	public SprintAdapter setAdapter(Produto produto){
		
		return new SprintAdapter(contexto, getProdutoSprint(produto));
	}
}
