package com.example.testews;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

import org.ksoap2.serialization.*;

@SuppressWarnings("serial")
public abstract class LiteralArrayList extends ArrayList<Backlog> implements KvmSerializable {

	@Override
	public Object getProperty(int index) {
        return this;
	}

	@Override
	public int getPropertyCount() {
        return 1;
	}

	@Override
	public void setProperty(int index, Object value) {
        this.add((Backlog)value);
	}

	@Override
	public void getPropertyInfo(int index, Hashtable properties,
			PropertyInfo info) {
        info.name = getItemDescriptor();
        info.type = getElementClass();
	}

	public void register(SoapSerializationEnvelope envelope, String namespace, String name) {
		// using this.getClass() everywhere because .class doesn't 
	    // exist on j2me
	    envelope.addMapping(namespace, name, this.getClass());
	    registerElementClass(envelope, namespace);
	}

	private void registerElementClass(SoapSerializationEnvelope envelope, String namespace) {
		final Class elementClass = getElementClass();
	    try {
	    	if (elementClass.newInstance() instanceof KvmSerializable)
	    		envelope.addMapping(namespace, "", elementClass);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}

    abstract protected Class getElementClass();

    protected String getItemDescriptor() {
        return "return";
    }

}
