package br.unibh.quadroscrum.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.unibh.quadroscrum.modelo.Sprint;

public class SprintRepositorio {

//******************************** CREATE *************************************
	public static final String CREATE_TABELA_SPRINT = 
			"CREATE TABLE " + Sprint.NOME_TABELA
			+ "("
			+ Sprint.NOME_ID + " integer primary key autoincrement, "
			+ Sprint.NOME_TITULO + " varchar(50) not null, "
			+ Sprint.NOME_DESCRICAO + " varchar(50), "
			+ Sprint.NOME_PRODUTO + " integer not null, "
			+ Sprint.NOME_DATA_INSERCAO + " date, "
			+ Sprint.NOME_DATA_INICIO + " date, "
			+ Sprint.NOME_DATA_FIM + " date, "
			
			+ ");";
	
//**************************** DROP *******************************************
	public static final String DROP_TABELA_SPRINT = "DROP TABLE IF EXISTS "+
			Sprint.NOME_TABELA + ";";
	
	
	private SQLiteDatabase db;
	
	public SprintRepositorio(Context contexto){
		this.db = contexto.openOrCreateDatabase(ScrumHelper.NOME_BANCO,
				Context.MODE_PRIVATE, null);
	}
	
	public void fechar(){
		
		this.db.close();
	}
	
//*************************** INSERT *****************************************
	public Long inserir(Sprint sprint){
		ContentValues valores = new ContentValues();
		
		valores.put(Sprint.NOME_TITULO, sprint.getTitulo());
		valores.put(Sprint.NOME_DESCRICAO, sprint.getDescricao());
		valores.put(Sprint.NOME_PRODUTO, sprint.getProduto().getId());
		
		return inserir(valores);
	}
	
	private Long inserir(ContentValues valores){
		
		return db.insert(Sprint.NOME_TABELA, "", valores);
	}
	
//*********************** UPDATE *********************************************
	
	public int atualizar(Sprint sprint){
		
		ContentValues valores = new ContentValues();
		
		valores.put(Sprint.NOME_TITULO, sprint.getTitulo());
		valores.put(Sprint.NOME_DESCRICAO, sprint.getDescricao());
		valores.put(Sprint.NOME_PRODUTO, sprint.getProduto().getId());
		
		String where = Sprint.NOME_ID + " = ?";
		String[] whereArg = new String[] {sprint.getId().toString()};
		
		return atualizar(valores, where, whereArg);
	}
	
	private int atualizar(ContentValues valores, String where,
			String[] whereArg){
		
		return db.update(Sprint.NOME_TABELA, valores, where, whereArg);
	}
	
//**************************** DELETE ****************************************
	
	public int delete(Sprint sprint){
		String where = Sprint.NOME_ID + " = ?";
		
		String[] whereArg = new String[] {sprint.getId().toString()};
		
		return delete(where, whereArg);
	}

	private int delete(String where, String[] whereArg){
		
		return db.delete(Sprint.NOME_TABELA, where, whereArg);
		
	}
	
//******************************** SELECT ************************************
	
	public Cursor selectSprintIniciada(){
		
		String select = "SELECT * FROM " + Sprint.NOME_TABELA 
				+ " WHERE " + Sprint.NOME_INICIADA + " = 1 AND "
				+ Sprint.NOME_FINALIZADA + " = 0";
		Cursor c = db.rawQuery(select, null);
		
		return c;
		
	}
	
	public Cursor listarPorProduto(Long idProduto ){
		
		String select = "SELECT * FROM " + Sprint.NOME_TABELA 
				+ " WHERE " + Sprint.NOME_PRODUTO + " = ?";
		
		String[] selectArgs = new String[] {idProduto.toString()};
		
		Cursor c = db.rawQuery(select, selectArgs);
		
		return c;
		
	}
	
}