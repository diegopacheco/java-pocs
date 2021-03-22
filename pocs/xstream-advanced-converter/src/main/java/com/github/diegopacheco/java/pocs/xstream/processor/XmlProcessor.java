package com.github.diegopacheco.java.pocs.xstream.processor;

public interface XmlProcessor {
    String preDeserialize(String xml);
    String postSerialize(String xml);
}
