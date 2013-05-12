package br.unibh.quadroscrum.repositorio;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import br.unibh.quadroscrum.modelo.Usuario;


public class UsuarioRepositorioScript extends UsuarioRepositorio{

	
	private SQLiteOpenHelper dbHelper;
	private static final String TAG = "scrum";
	
	public static final String CREATE_TABELA_USUARIO = 
			"CREATE TABLE " + Usuario.NOME_TABELA
			+ "( "
			+ Usuario.NOME_ID + " integer primary key autoincrement, " // sequencial
			+ Usuario.NOME_EMAIL + " varchar(50) unique not null, "
			+ Usuario.NOME_SENHA + " varchar(50) not null, "
			+ Usuario.NOME_TIPO_USUARIO + " integer not null "
			+ ");";
	
	public static final String INSERT_USUARIO_MASTER = 
			"INSERT INTO " + Usuario.NOME_TABELA  +"("	
					+ Usuario.NOME_EMAIL + ", "
					+ Usuario.NOME_SENHA + ", "
					+ Usuario.NOME_TIPO_USUARIO + ")" 
			+ " VALUES ('master@master','1',2);";
	
	public static final String DROP_TABELA_USUARIO = "DROP TABLE IF EXISTS "
			+ Usuario.NOME_TABELA + ";";
	
	public UsuarioRepositorioScript(Context contexto) {
		
		dbHelper = new ScrumHelper(contexto);
		
		db = dbHelper.getWritableDatabase();
		Log.d(TAG, "Passou pelo RepositorioUsuarioScript");
	}
	
	public void fechar(){
		super.fechar();
		
		dbHelper.close();
	}

	
	
	
	
}
