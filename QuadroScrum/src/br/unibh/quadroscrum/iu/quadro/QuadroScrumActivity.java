package br.unibh.quadroscrum.iu.quadro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import br.unibh.quadroscrum.R;
import br.unibh.quadroscrum.controle.ControleSprint;

public class QuadroScrumActivity extends Activity{

	ControleSprint controle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		controle = new ControleSprint(this);
		
			setContentView(R.layout.quadro_scrum);
			
			TextView label = (TextView)findViewById(R.id.label_mestre);
			label.setText("Status:");
			Spinner status = (Spinner) findViewById(R.id.lista_mestre);
			
			ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
					this, R.array.status, android.R.layout.simple_spinner_item);
			
			adapter.setDropDownViewResource(
					android.R.layout.simple_spinner_dropdown_item);
			
			status.setAdapter(adapter);
			status.setSelection(0);
		
		
		
		
	}
	
}
