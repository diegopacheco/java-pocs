package com.github.diegopacheco.sandbox.java.jasper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.view.JasperViewer;

public class SimpleReport {
	
	static {
		System.setProperty("java.awt.headless", "false");
	}
	
	public static void main(String[] args) {
		
	    try {
	        OutputStream os = new FileOutputStream("/tmp/file-report.pdf");
	        java.util.Map<String,Object> reportParams = new HashMap();
	        
	        String compiledFile = "/tmp/products.jasper";
	        String jrxmlFile = "/home/diego/home2/diego/github/diegopacheco/Diego-Pacheco-Sandbox/scripts/java/jasper/src/main/resources/products.jrxml";
	        
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/RWS_DB?user=root&password=&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
	        
	        JasperCompileManager.compileReportToFile(jrxmlFile, compiledFile);
	        
	        JasperReport jasperReport = (JasperReport)JRLoader.loadObject( new FileInputStream(compiledFile) );  
	        
	        JasperPrint  jrprint = JasperFillManager.fillReport(jasperReport, reportParams, con);
	        
	        JasperExportManager.exportReportToPdfFile(jrprint,"/tmp/products.pdf");
	        
	        JasperViewer jasperViewer = new JasperViewer(jrprint);
	        jasperViewer.setVisible(true);
	        
	        JRPdfExporter  exporter = new JRPdfExporter();
	        exporter.setExporterInput(new SimpleExporterInput(jrprint));
	        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(os));      
	        exporter.exportReport();
	        
	        System.out.println(os);
	        os.flush();
	        os.close();
	        
	      } catch(Exception  e) {
	        e.printStackTrace();
	      }


		
	}
}
