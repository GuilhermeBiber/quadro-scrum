package com.example.testews;


import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity implements Runnable{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		
		new Thread(this).start();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void run() {


		BacklogWs ws = new BacklogWs();
		BacklogList listBacklog= ws.baklogList(null);
		for (Backlog backlog : listBacklog) {
			Log.i("WEB", backlog.toString());
		}
		
	}

}
