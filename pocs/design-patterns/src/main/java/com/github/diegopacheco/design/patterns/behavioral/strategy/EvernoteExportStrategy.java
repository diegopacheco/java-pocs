package com.github.diegopacheco.design.patterns.behavioral.strategy;

public class EvernoteExportStrategy implements ExportStrategy {
    @Override
    public void export(Object context) {
        // Do real Evernote integration....
        System.out.println("Exporting to Evernote app... " + context);
    }
}
