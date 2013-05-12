package br.unibh.quadroscrum.iu.cadastros;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import br.unibh.quadroscrum.R;
import br.unibh.quadroscrum.controle.ControleUsuario;
import br.unibh.quadroscrum.modelo.Usuario;

public class CadastroUsuarioActicity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.cadastro_usuario);
		Spinner tipo = (Spinner) findViewById(R.id.tipo_usuario);
		
		ArrayAdapter<CharSequence> tipos = ArrayAdapter.createFromResource(this,
				R.array.tipo_usuario, 
				android.R.layout.simple_spinner_item);
		tipos.setDropDownViewResource(
				android.R.layout.simple_spinner_dropdown_item);

		
		tipo.setAdapter(tipos);
		
		
		Button botaoInesrir = (Button) findViewById(R.id.botao_salvar_usuario);
		
		botaoInesrir.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		
				EditText email = (EditText) findViewById(R.id.email);
				EditText senha = (EditText) findViewById(R.id.senha);
				Spinner tipo = (Spinner) findViewById(R.id.tipo_usuario);
				
				Usuario usuario = new Usuario(email.getText().toString(), senha.getText().toString(), tipo.getSelectedItemPosition());
				Log.i("scrum", usuario.toString());
				ControleUsuario controle = new ControleUsuario(v.getContext());
				
				if(controle.existeUsuario(usuario)){
					
					Toast.makeText(v.getContext(), "Usuario ja existe no sistema", Toast.LENGTH_LONG).show();
				}else{
					if(controle.inserir(usuario)){					
						Toast.makeText(v.getContext(), "Usuario Inserido com sucesso", Toast.LENGTH_LONG).show();
					}else{
						Toast.makeText(v.getContext(), "Usuario NÃO INSERIDO", Toast.LENGTH_LONG).show();
					}
				}
			}
				
		});
		
	}

}
