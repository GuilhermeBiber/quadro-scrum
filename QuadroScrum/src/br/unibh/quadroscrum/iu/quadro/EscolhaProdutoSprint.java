package br.unibh.quadroscrum.iu.quadro;

import java.util.ArrayList;

import org.w3c.dom.ls.LSInput;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;
import br.unibh.quadroscrum.R;
import br.unibh.quadroscrum.controle.ControleProduto;
import br.unibh.quadroscrum.controle.ControleSprint;
import br.unibh.quadroscrum.modelo.Produto;

public class EscolhaProdutoSprint extends Activity{

	private ControleProduto controleProduto;
	private ControleSprint controleSprint;
	private static final String TAG = "PASSOU";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.quadro_scrum);
		
		TextView label = (TextView)findViewById(R.id.label_mestre);
		
		label.setText("Produto:");
		
		Spinner sppinerProduto = (Spinner)findViewById(R.id.lista_mestre);
		
		controleProduto = new ControleProduto(this);
		Log.i(TAG, "Criou controle");
		ArrayList<Produto> produtolList= controleProduto.getListProdutos(null);
		
		ArrayAdapter<Produto> adapterProduto = new ArrayAdapter<Produto>(this,
				android.R.layout.simple_spinner_item, produtolList);
		
		adapterProduto.setDropDownViewResource(
				android.R.layout.simple_spinner_dropdown_item);
		
		sppinerProduto.setAdapter(adapterProduto);
		Log.i(TAG, "Setou adapter");
		sppinerProduto.setOnItemSelectedListener(new OnItemSelectedListener(){
			@Override
			public void onItemSelected(AdapterView<?> adapterProduto, 
					View spinner, int pisition, long id) 
			{
				ExpandableListView listSprint = 
						(ExpandableListView) findViewById(R.id.lista_detalhe);
				
				Produto produto = new Produto();
				
				produto.setId(id);
				
				listSprint.setAdapter(controleSprint.setAdapter(produto));
				
				
				
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {				
			}
		});
		
		
		
		
		
	}
	
	

	

	
	
}
