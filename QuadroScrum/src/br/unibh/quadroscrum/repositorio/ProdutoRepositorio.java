package br.unibh.quadroscrum.repositorio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ProdutoRepositorio {

	private SQLiteDatabase db;
	
	public ProdutoRepositorio(Context contexto){
		this.db = contexto.openOrCreateDatabase(ScrumHelper.NOME_BANCO, Context.MODE_PRIVATE, null);
	}
	
	public void fechar(){
		
		this.db.close();
	}
	
	
	
	
	
	
}
