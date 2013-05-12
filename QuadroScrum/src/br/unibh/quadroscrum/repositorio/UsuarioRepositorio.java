package br.unibh.quadroscrum.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import br.unibh.quadroscrum.modelo.Usuario;

public class UsuarioRepositorio {
	
	protected SQLiteDatabase db;
	private static final String TAG = "scrum";
	
	public UsuarioRepositorio(Context contexto){
		this.db = contexto.openOrCreateDatabase(ScrumHelper.NOME_BANCO,
				Context.MODE_PRIVATE, null);
		Log.d(TAG, "Passou pelo RepositorioUsuario");
		
	}
	
	protected UsuarioRepositorio() {
		// TODO Auto-generated constructor stub
	}

	public void fechar(){
		
		db.close();
	}
	
	
//******************************* INSERT **************************************
	
	public boolean inserir(Usuario usuario){
		ContentValues valores = new ContentValues();
		
		valores.put(Usuario.NOME_EMAIL, usuario.getEmail());
		valores.put(Usuario.NOME_SENHA, usuario.getSenha());
		valores.put(Usuario.NOME_TIPO_USUARIO, usuario.getTipoUsuario());
		
		Long id = inserir(valores);
		
		if (id != null){
			return true;
		}else{
			return false;
		}
	}
	
	private Long inserir(ContentValues valores){
		
		Long id = db.insert(Usuario.NOME_TABELA, "", valores);
		return id;
	}
	
	
//********************************** UPDATE **********************************
	public int atualizar(Usuario usuario){
		ContentValues valores = new ContentValues();
		valores.put(Usuario.NOME_SENHA, usuario.getSenha());
		String email = usuario.getEmail();
		String where = Usuario.NOME_EMAIL + " = ?";
		String[] whereArg = new String[] {email};
		
		int cont = atualizar(valores, where, whereArg);
		
		return cont;		
		
		
	}
	
	private int atualizar(ContentValues valores, String where,
			String[] whereArg){
		
		return db.update(Usuario.NOME_TABELA, valores, where, whereArg);
	}
	
	
//*********************************** DELETE *********************************
	public int delete(Usuario usuario){
		String where = Usuario.NOME_EMAIL + " = ?";
		
		String[] whereArg = new String[] {usuario.getEmail()};
		
		return delete(where, whereArg);		
		
	}
	
	private int delete(String where, String[] whereArg){
		
		return db.delete(Usuario.NOME_TABELA, where, whereArg);
		
	}
	
//********************************** SELECT **********************************
	public Cursor selectUsuarioLoginSenha(String email, String senha){
		
		String select = "SELECT * "+
				" FROM " + Usuario.NOME_TABELA+
				" WHERE " + Usuario.NOME_EMAIL + " = ? and "
				+ Usuario.NOME_SENHA + " = ?";

		String[] selectArgs = new String[]{email,senha};	
		Cursor c = null;
		try{
			c = db.rawQuery(select, selectArgs);
		}catch(SQLException e){
			Log.e(TAG, "Select falhou: " + e.toString());
			fechar();
		}
		return c;
	}
	
	
}
