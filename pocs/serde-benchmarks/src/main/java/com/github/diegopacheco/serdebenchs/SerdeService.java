package com.github.diegopacheco.serdebenchs;

public interface SerdeService<I,O> {
    public O serialize(I i);
    public I deserialize(O o);
}