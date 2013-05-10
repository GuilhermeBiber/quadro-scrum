package br.unibh.quadroscrum.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import br.unibh.quadroscrum.modelo.Produto;

public class ProdutoRepositorio {

//**************************** CREATE *****************************************	
	public static final String CREATE_TABELA_PRODUTO = 
			"CREATE TABLE " + Produto.NOME_TABELA 
			+"("
			+Produto.NOME_ID + " integer primary key autoincrement, "
			+Produto.NOME_PRODUTO + " varchar(50) not null, "
			+Produto.NOME_DATA_INSECAO + " date "
			+");"; 
	
//*************************** DROP ********************************************	
	public static final String DROP_TABELA_PRODUTO = "DROP TABLE IF EXISTS "
			+ Produto.NOME_TABELA+";";
	
	
	
	private SQLiteDatabase db;
	
	public ProdutoRepositorio(Context contexto){
		this.db = contexto.openOrCreateDatabase(ScrumHelper.NOME_BANCO,
				Context.MODE_PRIVATE, null);
	}
	
	public void fechar(){
		
		this.db.close();
	}
	
	
//*************************** INSERT ******************************************
	
	private Long inserir(Produto produto){
		ContentValues valores= new ContentValues();
		
		valores.put(Produto.NOME_PRODUTO, produto.getNome());
		
		Long id = inserir(valores);
		
		return id;
		
	}
	
	private Long inserir(ContentValues valores){
		
		Long id = db.insert(Produto.NOME_TABELA, "", valores);
		
		return id;
		
	}
	
	
//***************************** UPDATE ****************************************
	private int atualizar(Produto produto){
		
		ContentValues valores= new ContentValues();
		valores.put(Produto.NOME_PRODUTO, produto.getNome());
		
		String where = Produto.NOME_ID + " + ?";
		String[] whereArg = new String[] {produto.getNome()};
		
		return atualizar(valores, where, whereArg);
		
	}
	
	private int atualizar(ContentValues valores, String where,
			String[] whereArg){
		
		return db.update(Produto.NOME_TABELA, valores, where, whereArg);
		
	}
	
//**************************** DELETE *****************************************
	
	private int delete(Produto produto){
		String where = Produto.NOME_ID + " = ?";
		
		String[] whereArg = new String[] {produto.getId().toString()};
		
		return delete(where,whereArg);
		
		
	}
	
	private int delete(String where, String[] whereArg){
		
		return db.delete(Produto.NOME_TABELA, where, whereArg);		
	}
	
//************************** SELECT *******************************************
	
}
