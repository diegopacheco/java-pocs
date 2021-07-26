package com.github.diegopacheco.design.patterns.behavioral.strategy;

public class HTMLExportStrategy implements ExportStrategy{

    @Override
    public void export(Object context) {
        // Do real HTML export...
        System.out.println("Exporting to HTML... ");
    }
}
