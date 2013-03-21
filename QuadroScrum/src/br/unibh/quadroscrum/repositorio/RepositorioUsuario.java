package br.unibh.quadroscrum.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import br.unibh.quadroscrum.modelo.Usuario;

public class RepositorioUsuario {

	protected SQLiteDatabase db;
	private static final String TAG = "scrum";
	
	public RepositorioUsuario(Context contexto){
		this.db = contexto.openOrCreateDatabase(ScrumHelper.NOME_BANCO, Context.MODE_PRIVATE, null);
		Log.d(TAG, "Passou pelo RepositorioUsuario");
		
	}
	
	protected RepositorioUsuario() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Long salvar(Usuario usuario){
		
		Long id = usuario.getId();
		
		if(id != null){
			atualizar(usuario);
		}else{
			id = inserir(usuario);
		}
		
		return id;
	}
	
	//Insere usuario
	
	public Long inserir(Usuario usuario){
		ContentValues valores = new ContentValues();
		
		valores.put(Usuario.NOME_LOGIN, usuario.getLogin());
		valores.put(Usuario.NOME_SENHA, usuario.getSenha());
		
		Long id = inserir(valores);
		
		return id;
	}
	
	public Long inserir(ContentValues valores){
		
		Long id = db.insert(Usuario.NOME_TABELA, "", valores);
		
		return id;
	}
	
	public int atualizar(Usuario usuario){
		ContentValues valores = new ContentValues();
		valores.put(Usuario.NOME_LOGIN, usuario.getLogin());
		valores.put(Usuario.NOME_SENHA, usuario.getSenha());
		String _id = usuario.getId().toString();
		String where = Usuario.NOME_ID + " = ?";
		String[] whereArg = new String[] {_id};
		
		int cont = atualizar(valores, where, whereArg);
		
		return cont;		
		
		
	}
	
	public int atualizar(ContentValues valores, String where, String[] whereArg){
		
		int cont = db.update(Usuario.NOME_TABELA, valores, where, whereArg);
		
		return cont;
	}
	
	public int delete(Long id){
		String where = Usuario.NOME_ID + " = ?";
		
		String _id = id.toString();
		
		String[] whereArg = new String[] {_id};
		
		int cont = delete(where, whereArg);		
		
		return cont;
	}
	
	private int delete(String where, String[] whereArg){
		int cont = db.delete(Usuario.NOME_TABELA, where, whereArg);
		
		return cont;
	}
	
	public boolean existeUsuario(String login, String senha){
		
		String select = "SELECT * "+
						" FROM " + Usuario.NOME_TABELA+
						" WHERE " + Usuario.NOME_LOGIN + " = ? and " + Usuario.NOME_SENHA + " = ?";
		
		String[] selectArgs = new String[]{login,senha};
		try{
			Cursor c = db.rawQuery(select, selectArgs);
			
			if(c.moveToFirst()){
				fechar();
				return true;
			}else{
				fechar();
				return false;
			}
			
		}catch(SQLException e){
			Log.e(TAG, "Select falhou: " + e.toString());
			fechar();
			return false;
		}
		
	}
	
	public void fechar(){
		
		db.close();
	}
	
	
}
