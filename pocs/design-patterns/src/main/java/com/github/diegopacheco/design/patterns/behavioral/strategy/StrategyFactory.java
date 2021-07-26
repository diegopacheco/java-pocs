package com.github.diegopacheco.design.patterns.behavioral.strategy;

public class StrategyFactory {

    public static ExportStrategy resolve(String filename){
        if (filename.contains(".html")){
            return new HTMLExportStrategy();
        }
        if (filename.contains(".pdf")){
            return new PDFExportStrategy();
        }
        if (filename.contains(".evernote")){
            return new EvernoteExportStrategy();
        }
        // Default strategy
        return new PDFExportStrategy();
    }

}
