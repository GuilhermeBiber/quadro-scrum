package com.example.testews;

import java.util.ArrayList;
import java.util.Date;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Log;

public class BacklogWs {

	private static final String NAMESPACE = "http://ws.unibh.com/";
	private static final String URL = "http://10.0.2.2:8080/scrum-ws-0.0.1-SNAPSHOT/BaclogWs/BacklogWs?wsdl";
	
	public BacklogList baklogList(String data){
		
		SoapObject request = new SoapObject(NAMESPACE, "enviaBacklog");		
		
		request.addProperty("arg0", new Date().toString());
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.addMapping(NAMESPACE, "enviaBacklogResponse", BacklogList.class);
		envelope.addMapping(NAMESPACE, "return", Backlog.class);
		envelope.addMapping(NAMESPACE, "sprint", Sprint.class);
		envelope.addMapping(NAMESPACE, "usuario", Usuario.class);
		
		envelope.setOutputSoapObject(request);
		
		HttpTransportSE transport = new LivroHttpTransportSE(URL);
		
		
		try {
			transport.call("enviaBacklogResponse", envelope);
			Log.i("Response", envelope.bodyIn.toString());
			return ((BacklogList)envelope.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return null;
	}
}
