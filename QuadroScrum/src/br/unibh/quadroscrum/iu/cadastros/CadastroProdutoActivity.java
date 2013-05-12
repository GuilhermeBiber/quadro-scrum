package br.unibh.quadroscrum.iu.cadastros;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.unibh.quadroscrum.R;
import br.unibh.quadroscrum.controle.ControleProduto;
import br.unibh.quadroscrum.modelo.Produto;

public class CadastroProdutoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.cadastro_produto);
		Button botao = (Button) findViewById(R.id.botao_salvar_produto);
		
		botao.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				
				EditText nome = (EditText) findViewById(R.id.nome_produto);
				ControleProduto constrole = new ControleProduto(v.getContext());
				
				Produto produto = new Produto(nome.getText().toString());
				
				if(constrole.existeProduto(produto)){
					Toast.makeText(v.getContext(), "Produto ja cadastrado!", Toast.LENGTH_LONG).show();					
				}else{
					if(constrole.inserirProduto(produto)){
						Toast.makeText(v.getContext(), "Produto cadastrado com sucesso!", Toast.LENGTH_LONG).show();
					}else{
						Toast.makeText(v.getContext(), "Produto NÃO cadastrado!", Toast.LENGTH_LONG).show();
					}
				}
			}
		});
	}
}
