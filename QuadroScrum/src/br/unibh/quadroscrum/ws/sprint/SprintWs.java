package br.unibh.quadroscrum.ws.sprint;

import java.util.Date;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalDate;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Log;
import br.unibh.quadroscrum.modelo.Produto;
import br.unibh.quadroscrum.modelo.Sprint;
import br.unibh.quadroscrum.ws.LivroHttpTransportSE;

public class SprintWs {

	private static final String NAMESPACE = "http://ws.unibh.com/";
	private static final String URL = 
		"http://10.0.2.2:8080/scrum-ws-0.0.1-SNAPSHOT/BaclogWs/BacklogWs?wsdl";
	
	public SprintList sprintList(Sprint sprint){
		
		SoapObject request = new SoapObject(NAMESPACE, "enviaSprint");
		
		request.addProperty("arg0", new Date());
		
		SoapSerializationEnvelope envelope = 
				new SoapSerializationEnvelope(SoapEnvelope.VER11);
		
		envelope.addMapping(NAMESPACE, "enviaSprintResponse", SprintList.class);
		envelope.addMapping(NAMESPACE, "return", Sprint.class);
		envelope.addMapping(NAMESPACE, "produto", Produto.class);
		new MarshalDate().register(envelope);
		
		envelope.setOutputSoapObject(request);
		
		HttpTransportSE transport = new LivroHttpTransportSE(URL);
		
		try{
			transport.call("enviaSprintResponse", envelope);
			return (SprintList)envelope.getResponse();
		}catch(Exception e){
			Log.e("ERRO", e.toString());
		}
		return null;
	}
}
