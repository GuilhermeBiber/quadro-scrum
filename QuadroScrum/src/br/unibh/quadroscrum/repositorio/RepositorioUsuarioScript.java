package br.unibh.quadroscrum.repositorio;

import br.unibh.quadroscrum.modelo.Usuario;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class RepositorioUsuarioScript extends RepositorioUsuario{

	
	private SQLiteOpenHelper dbHelper;
	private static final String TAG = "scrum";
	
	public static final String createTabelaUsuario = "CREATE TABLE " + Usuario.NOME_TABELA
			+ "( "
			+ Usuario.NOME_ID + "integer primary key autoincrement," // sequencial
			+ Usuario.NOME_LOGIN + " varchar(100) not null,"
			+ Usuario.NOME_SENHA +  " varchar(50) not null"
			+ ");";
	
	public static final String dropTabelaUsuario = "DROP TABLE IF EXISTS "+ Usuario.NOME_TABELA + ";";
	
	public RepositorioUsuarioScript(Context contexto) {
		
		dbHelper = new ScrumHelper(contexto);
		
		db = dbHelper.getWritableDatabase();
		Log.d(TAG, "Passou pelo RepositorioUsuarioScript");
	}
	
	public void fechar(){
		super.fechar();
		
		dbHelper.close();
	}

	
	
	
	
}
