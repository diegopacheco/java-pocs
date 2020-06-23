package com.github.diegopacheco.sandboxspring.client;

import java.io.Serializable;

public interface Contract extends Serializable{
    public Double sum(Double va,Double vb);
    public Double mul(Double va,Double vb);
    public Double sub(Double va,Double vb);
    public Double div(Double va,Double vb);
}