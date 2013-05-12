package br.unibh.quadroscrum.ws;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Log;

public class LivroHttpTransportSE extends HttpTransportSE{

	public LivroHttpTransportSE(String s){
		super(s);
	}
	
	@Override
	public void call(String s, SoapEnvelope envelope) throws IOException,
			XmlPullParserException {
		byte bytes[] = createRequestData(envelope);
		String strEnvelope = new String(bytes);
		
		Log.i("ENVELOPE", strEnvelope);
		
		
		super.call(s, envelope);
		
	}
	
	
}

