package br.unibh.quadroscrum.ws.produto;

import org.ksoap2.serialization.SoapSerializationEnvelope;

import br.unibh.quadroscrum.modelo.Produto;

@SuppressWarnings("serial")
public class ProdutoList extends LiteralArrayListProduto {

	@Override
	protected Class getElementClass() {
		// TODO Auto-generated method stub
		return Produto.class;
	}

    public void register(String ns, SoapSerializationEnvelope envelope) {
        super.register(envelope, ns, "return");
    }
    

}
