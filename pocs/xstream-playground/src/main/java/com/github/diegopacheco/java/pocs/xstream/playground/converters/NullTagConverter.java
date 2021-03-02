package com.github.diegopacheco.java.pocs.xstream.playground.converters;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class NullTagConverter implements Converter {

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        if (null==source || "".equals(source)){
           // Do nothing will force for empty tag e.g: <FacebookID/>
        }else{
            writer.setValue(source+"");
        }
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        return reader.getNodeName();
    }

    @Override
    public boolean canConvert(Class type) {
        return type.equals(String.class);
    }
}
