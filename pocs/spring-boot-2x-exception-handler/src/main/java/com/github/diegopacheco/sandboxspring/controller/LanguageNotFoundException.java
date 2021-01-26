package com.github.diegopacheco.sandboxspring.controller;

public class LanguageNotFoundException extends RuntimeException{

    public LanguageNotFoundException(String msg){
        super(msg);
    }

}
