package br.unibh.quadroscrum.ws.backlog;

import java.util.Date;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalDate;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Log;
import br.unibh.quadroscrum.modelo.Backlog;
import br.unibh.quadroscrum.modelo.Produto;
import br.unibh.quadroscrum.modelo.Sprint;
import br.unibh.quadroscrum.modelo.Usuario;
import br.unibh.quadroscrum.ws.LivroHttpTransportSE;

public class BacklogWs {

	private static final String NAMESPACE = "http://ws.unibh.com/";
	private static final String URL = 
		"http://10.0.2.2:8080/scrum-ws-0.0.1-SNAPSHOT/BaclogWs/BacklogWs?wsdl";
	
	public BacklogList baklogList(Backlog backlog){
		
		SoapObject request = new SoapObject(NAMESPACE, "enviaBacklog");		
		
		request.addProperty("arg0", new Date());
		
		SoapSerializationEnvelope envelope =
				new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.addMapping(NAMESPACE, "enviaBacklogResponse",
				BacklogList.class);
		envelope.addMapping(NAMESPACE, "return", Backlog.class);
		envelope.addMapping(NAMESPACE, "produto", Produto.class);
		envelope.addMapping(NAMESPACE, "sprint", Sprint.class);
		envelope.addMapping(NAMESPACE, "usuario", Usuario.class);
		new MarshalDate().register(envelope);
		
		envelope.setOutputSoapObject(request);
		
		HttpTransportSE transport = new LivroHttpTransportSE(URL);
		
		
		try {
			transport.call("enviaBacklogResponse", envelope);
			Log.i("Response", envelope.bodyIn.toString());
			return ((BacklogList)envelope.getResponse());
		} catch (Exception e) {
			Log.e("ERRO", e.toString());
		}		
		
		return null;
	}
}
