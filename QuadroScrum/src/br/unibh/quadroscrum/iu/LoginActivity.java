package br.unibh.quadroscrum.iu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.unibh.quadroscrum.R;
import br.unibh.quadroscrum.controle.ControleUsuario;
import br.unibh.quadroscrum.iu.cadastros.CadastroUsuarioActivity;
import br.unibh.quadroscrum.modelo.Backlog;
import br.unibh.quadroscrum.modelo.Usuario;
import br.unibh.quadroscrum.ws.backlog.BacklogList;
import br.unibh.quadroscrum.ws.backlog.BacklogWs;

public class LoginActivity extends Activity  implements Runnable{
	
	private static final String TAG = "scrum";

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		new Thread(this).run();
		
		
		setContentView(R.layout.login);
		
		Log.i(TAG, "onCreate");
		Button botaoEntrar = (Button) findViewById(R.id.botao_entrada);
		
		botaoEntrar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText email = (EditText) findViewById(R.id.email);
				EditText senha = (EditText) findViewById(R.id.senha);
				
				ControleUsuario controle = new ControleUsuario(v.getContext());
				Usuario usuario= new Usuario();
				
				usuario.setEmail(email.getText().toString());
				usuario.setSenha(senha.getText().toString());
				
				if(controle.logarUsuario(usuario)){
					
					startActivity(new Intent(v.getContext()
							,CadastroUsuarioActivity.class));
					
				}else{
					
					Toast.makeText(v.getContext(), "Favor digite um usuario " 
							+ "e/ou uma senha válida!", 
							Toast.LENGTH_LONG).show();
				
				}
			}
		});
		

	}


	@Override
	public void run() {
		
		BacklogWs ws = new BacklogWs();
		
		BacklogList backlogList = ws.baklogList(new Backlog());
		
		for (Backlog backlog : backlogList) {
			
		}
		
	}



	
	
	
	
	
	
}
