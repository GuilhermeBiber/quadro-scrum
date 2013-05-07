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

public class LoginActivity extends Activity{
	
	private static final String TAG = "scrum";

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.login);
		
		Log.i(TAG, "onCreate");
		Button botaoEntrar = (Button) findViewById(R.id.botao_entrada);
		
		botaoEntrar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText email = (EditText) findViewById(R.id.email);
				EditText senha = (EditText) findViewById(R.id.senha);
				
				ControleUsuario controle = new ControleUsuario(v.getContext());
				
				if(( controle.existeUsuario(email.getText().toString(), senha.getText().toString()))){
					
					startActivity(new Intent(v.getContext(),CadastroUsuarioActicity.class));
					
				}else{
					
					Toast.makeText(v.getContext(), "Favor digite um usuario e uma senha válida!", Toast.LENGTH_LONG).show();
				
				}
			}
		});
		

	}



	
	
	
	
	
	
}
