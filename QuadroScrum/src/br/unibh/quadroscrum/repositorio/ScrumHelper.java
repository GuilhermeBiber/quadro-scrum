package br.unibh.quadroscrum.repositorio;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ScrumHelper extends SQLiteOpenHelper {

	public static final String NOME_BANCO = "scrum";
	public static int VERSAO_BANCO = 1;

	private static final String TAG = "scrum";



	public ScrumHelper(Context contexto) {
		super(contexto, NOME_BANCO, null, VERSAO_BANCO);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try{
			db.execSQL(RepositorioUsuarioScript.createTabelaUsuario);		
		}catch(SQLException e){
			Log.e(TAG, "Problemas ao criar tabela\n" + e.toString());
		}
		Log.d(TAG, "Banco criado");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL(RepositorioUsuarioScript.dropTabelaUsuario);
		Log.d(TAG, "Banco Destruido");
		
		onCreate(db);

	}

}
