package br.unibh.quadroscrum.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import br.unibh.quadroscrum.modelo.Backlog;
import br.unibh.quadroscrum.modelo.Sprint;

public class BacklogRepositorio {

//**************************** CREATE *****************************************
	public static final String CREATE_TABELA_BACKLOG = 
			"CREATE TABLE " + Backlog.NOME_TABELA
			+ "( "
			+ Backlog.NOME_ID + " integer primary key autoincrement, "
			+ Backlog.NOME_TITULO + " varchar(50) not null, "
			+ Backlog.NOME_DESCRICAO + " varchar(50) not null, "
			+ Backlog.NOME_SPRINT + " integer, "
			+ Backlog.NOME_USUARIO + " integer, "
			+ Backlog.NOME_DATA_INSERCAO + " date, "
			+ Backlog.NOME_PRODUTO + " integer, "
			+ Backlog.NOME_STATUS + " integer, "
			+ Backlog.NOME_PRIORIDADE + " integer, "
			+ Backlog.NOME_TEMPO_ESTIMADO + " real, "
			+ Backlog.NOME_TRAVADO + " integer"
			+ ");";

//******************************** DROP **************************************
	public static final String DROP_TABELA_SPRINT = "DROP TABLE IF EXISTS "+
			Backlog.NOME_TABELA + ";";
	
	

	private SQLiteDatabase db;
	
	public BacklogRepositorio(Context contexto){
		this.db = contexto.openOrCreateDatabase(ScrumHelper.NOME_BANCO,
				Context.MODE_PRIVATE, null);
	}
	
	public void fechar(){
		
		this.db.close();
	}
	
//******************************** INSERT *************************************
	
	public Long inserir(Backlog backlog){
		
		ContentValues valores = new ContentValues();
		
		valores.put(Backlog.NOME_TITULO, backlog.getTitulo());
		valores.put(Backlog.NOME_DESCRICAO, backlog.getDescricao());
		valores.put(Backlog.NOME_SPRINT, backlog.getSprint().getId());
		valores.put(Backlog.NOME_USUARIO, backlog.getUsuario().getId());
		valores.put(Backlog.NOME_PRODUTO, backlog.getProduto().getId());
		valores.put(Backlog.NOME_STATUS, backlog.getStatus());
		valores.put(Backlog.NOME_PRIORIDADE, backlog.getPrioridade());
		valores.put(Backlog.NOME_TEMPO_ESTIMADO, backlog.getTempoEstimado());
		valores.put(Backlog.NOME_TRAVADO, backlog.getTravado());
		
		return inserir(valores);
	}
	
	private Long inserir(ContentValues valores){
		
		return db.insert(Backlog.NOME_TABELA, "", valores);
	}
	
	
//******************************* UPDATE **************************************
	
	public int atualizar(Backlog backlog){
		
		ContentValues valores = new ContentValues();
		
		valores.put(Backlog.NOME_TITULO, backlog.getTitulo());
		valores.put(Backlog.NOME_DESCRICAO, backlog.getDescricao());
		valores.put(Backlog.NOME_SPRINT, backlog.getSprint().getId());
		valores.put(Backlog.NOME_USUARIO, backlog.getUsuario().getId());
		valores.put(Backlog.NOME_PRODUTO, backlog.getProduto().getId());
		valores.put(Backlog.NOME_STATUS, backlog.getStatus());
		valores.put(Backlog.NOME_PRIORIDADE, backlog.getPrioridade());
		valores.put(Backlog.NOME_TEMPO_ESTIMADO, backlog.getTempoEstimado());
		valores.put(Backlog.NOME_TRAVADO, backlog.getTravado());
		
		String where = Backlog.NOME_ID + " = ?";
		String[] whereArg = new String[] {backlog.getId().toString()};
		
		return atualizar(valores, where, whereArg);
	}
	
	private int atualizar(ContentValues valores, String where,
			String[] whereArg){
		
		return db.update(Backlog.NOME_TABELA, valores, where, whereArg);
	}
	
//********************************* DELETE ************************************
	

	public int delete(Backlog backlog){
		String where = Backlog.NOME_ID + " = ?";
		
		String[] whereArg = new String[] {backlog.getId().toString()};
		
		return delete(where, whereArg);
	}

	private int delete(String where, String[] whereArg){
		
		return db.delete(Backlog.NOME_TABELA, where, whereArg);
		
	}
	
//******************************** SELECT ************************************
	
	
	
	
}
