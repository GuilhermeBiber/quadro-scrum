package br.unibh.quadroscrum.ws.backlog;

import org.ksoap2.serialization.SoapSerializationEnvelope;

import br.unibh.quadroscrum.modelo.Backlog;

@SuppressWarnings("serial")
public class BacklogList extends LiteralArrayListBacklog {

	@Override
	protected Class getElementClass() {
		// TODO Auto-generated method stub
		return Backlog.class;
	}

    public void register(String ns, SoapSerializationEnvelope envelope) {
        super.register(envelope, ns, "return");
    }
    

}
