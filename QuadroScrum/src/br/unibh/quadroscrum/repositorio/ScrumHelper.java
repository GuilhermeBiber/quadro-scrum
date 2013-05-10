package br.unibh.quadroscrum.repositorio;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ScrumHelper extends SQLiteOpenHelper {

	public static final String NOME_BANCO = "scrum.db";
	public static int VERSAO_BANCO = 1;

	private static final String TAG = "scrum";



	public ScrumHelper(Context contexto) {
		super(contexto, NOME_BANCO, null, VERSAO_BANCO);
		Log.i(TAG, "Passou pelo helper");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try{
			db.execSQL(UsuarioRepositorioScript.CREATE_TABELA_USUARIO);
			db.execSQL(UsuarioRepositorioScript.INSERT_USUARIO_MASTER);
			db.execSQL(ProdutoRepositorio.CREATE_TABELA_PRODUTO);
			db.execSQL(SprintRepositorio.CREATE_TABELA_SPRINT);
			db.execSQL(BacklogRepositorio.CREATE_TABELA_BACKLOG);
		}catch(SQLException e){
			Log.e(TAG, "Problemas ao criar tabela\n" + e.toString());
		}
		Log.d(TAG, "Banco criado");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL(UsuarioRepositorioScript.DROP_TABELA_USUARIO);
		db.execSQL(ProdutoRepositorio.DROP_TABELA_PRODUTO);
		db.execSQL(SprintRepositorio.DROP_TABELA_SPRINT);
		db.execSQL(BacklogRepositorio.DROP_TABELA_SPRINT);
		Log.d(TAG, "Banco Destruido");
		
		onCreate(db);

	}

}
