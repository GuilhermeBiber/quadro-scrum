package br.unibh.quadroscrum.iu;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.unibh.quadroscrum.R;
import br.unibh.quadroscrum.modelo.Usuario;
import br.unibh.quadroscrum.repositorio.RepositorioUsuario;
import br.unibh.quadroscrum.repositorio.RepositorioUsuarioScript;

public class LoginActivity extends Activity{


	RepositorioUsuario repositorio;
	private static final String TAG = "scrum";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		repositorio = new RepositorioUsuarioScript(this);
		
		
		setContentView(R.layout.login);
		
		Log.i(TAG, "onCreate");
		Button botaoEntrar = (Button) findViewById(R.id.botao_entrada);
		
		botaoEntrar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText login = (EditText) findViewById(R.id.login);
				EditText senha = (EditText) findViewById(R.id.senha);
				
				repositorio = new RepositorioUsuarioScript(v.getContext());
				
				if(repositorio.existeUsuario(login.getText().toString(), senha.getText().toString())){
					Toast.makeText(v.getContext(), "Usuario Dentro", Toast.LENGTH_LONG).show();
				}else{
					Toast.makeText(v.getContext(), "Usuario Fora", Toast.LENGTH_LONG).show();
				}
			}
		});
		
		Button botaoInesrir = (Button) findViewById(R.id.botao_inserir);
		
		botaoInesrir.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		
				EditText login = (EditText) findViewById(R.id.login);
				EditText senha = (EditText) findViewById(R.id.senha);
				
				Usuario usuario = new Usuario(login.getText().toString(), senha.getText().toString());
				
				repositorio = new RepositorioUsuario(v.getContext());
				
				if(repositorio.salvar(usuario) != 0){
					Toast.makeText(v.getContext(), "Usuario Inserido com sucesso", Toast.LENGTH_LONG).show();
				}else{
					Toast.makeText(v.getContext(), "Usuario NÃO INSERIDO", Toast.LENGTH_LONG).show();
				}
				
				
				
				
			}
		});
	}



	
	
	
	
	
	
}
