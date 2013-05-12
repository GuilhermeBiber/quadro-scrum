package br.unibh.quadroscrum.ws.sprint;

import org.ksoap2.serialization.SoapSerializationEnvelope;

import br.unibh.quadroscrum.modelo.Sprint;

@SuppressWarnings("serial")
public class SprintList extends LiteralArrayListSprint {

	@Override
	protected Class getElementClass() {
		// TODO Auto-generated method stub
		return Sprint.class;
	}

    public void register(String ns, SoapSerializationEnvelope envelope) {
        super.register(envelope, ns, "return");
    }
    

}
