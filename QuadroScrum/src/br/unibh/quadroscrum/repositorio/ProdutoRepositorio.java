package br.unibh.quadroscrum.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
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
	private static final String TAG = "scrum";
	public ProdutoRepositorio(Context contexto){
		this.db = contexto.openOrCreateDatabase(ScrumHelper.NOME_BANCO,
				Context.MODE_PRIVATE, null);
	}
	
	public void fechar(){
		
		this.db.close();
	}
	
	
//*************************** INSERT ******************************************
	
	public Long inserir(Produto produto){
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
	public int atualizar(Produto produto){
		
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
	
	public int delete(Produto produto){
		String where = Produto.NOME_ID + " = ?";
		
		String[] whereArg = new String[] {produto.getId().toString()};
		
		return delete(where,whereArg);
		
		
	}
	
	private int delete(String where, String[] whereArg){
		
		return db.delete(Produto.NOME_TABELA, where, whereArg);		
	}
	
//************************** SELECT *******************************************
	
	public Cursor existeProduto(Produto produto){
		String select = "SELECT * "
						+ "FROM " + Produto.NOME_TABELA
						+ "WHERE " + Produto.NOME_PRODUTO + "= ?";
		String[] selectArgs = new String[] {produto.getNome()};
		
		Cursor c = null;
		try {
			c = db.rawQuery(select, selectArgs);
		} catch (SQLException e) {
			Log.e(TAG, "Select falhou: " + e.toString());
			fechar();
		}
		
		return c;
	}
	
	public Cursor listarTodos(){
		
		String select = "SELECT * FROM " + Produto.NOME_TABELA + ";";
		
		Cursor c= null;
		c = db.rawQuery(select, null);
		
		return c;
	}
}
