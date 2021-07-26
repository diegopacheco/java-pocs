package com.github.diegopacheco.design.patterns.behavioral.strategy;

public class PDFExportStrategy implements ExportStrategy{

    @Override
    public void export(Object context) {
        // real PDF generation...
        System.out.println("Exporting to PDF... " + context);
    }

}
