package br.unibh.quadroscrum.iu;

import br.unibh.quadroscrum.R;
import br.unibh.quadroscrum.controle.ControleUsuario;
import br.unibh.quadroscrum.modelo.Usuario;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroUsuarioActicity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.cadastro_usuario);
		
		
		
		
		Button botaoInesrir = (Button) findViewById(R.id.botao_salvar);
		
		botaoInesrir.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		
				EditText login = (EditText) findViewById(R.id.login);
				EditText senha = (EditText) findViewById(R.id.senha);
				
				Usuario usuario = new Usuario(login.getText().toString(), senha.getText().toString());
				
				ControleUsuario controle = new ControleUsuario(v.getContext());
				
				if(controle.existeUsuario(usuario) != null){
					
					Toast.makeText(v.getContext(), "Usuario ja existe no sistema", Toast.LENGTH_LONG).show();
				}else{
					if(controle.salvar(usuario) != 0){					
						Toast.makeText(v.getContext(), "Usuario Inserido com sucesso", Toast.LENGTH_LONG).show();
					}else{
						Toast.makeText(v.getContext(), "Usuario NÃO INSERIDO", Toast.LENGTH_LONG).show();
					}
				}
			}
				
		});
		
	}
}
