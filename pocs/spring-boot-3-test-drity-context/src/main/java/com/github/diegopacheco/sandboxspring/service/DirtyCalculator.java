package com.github.diegopacheco.sandboxspring.service;

import org.springframework.stereotype.Service;

@Service
public class DirtyCalculator {

    private Integer va = 0;
    private Integer vb = 0;
    private Integer result = 0;

    public Integer sum(){
        result = va + vb;
        return result;
    }

    public Integer getVa() {
        return va;
    }

    public void setVa(Integer va) {
        this.va = va;
    }

    public Integer getVb() {
        return vb;
    }

    public void setVb(Integer vb) {
        this.vb = vb;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
