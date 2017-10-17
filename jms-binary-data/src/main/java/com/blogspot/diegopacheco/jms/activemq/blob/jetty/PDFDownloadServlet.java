package com.blogspot.diegopacheco.jms.activemq.blob.jetty;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.jetty.Request;

import com.blogspot.diegopacheco.jms.util.ByteUtils;

/**
 * 
 * @author Diego Pacheco
 *
 */
public class PDFDownloadServlet extends HttpServlet { 

	private static final long serialVersionUID = 1L;	
	private final int BUFFER_SIZE = 1048576; // 1 MB
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String filename = "pdf-119mb.pdf";
		String filepath = (new File(new File(".").getCanonicalPath() + "\\src\\main\\data\\" + filename )).getPath();			
		FileInputStream fis = new FileInputStream(filepath);
		
		response.setContentType("application/pdf");
        response.setStatus(HttpServletResponse.SC_OK);
		response.setContentLength(fis.available());				
		response.setHeader("Content-Disposition","inline; filename=" + filename);  
		response.setHeader("Cache-Control", "no-cache");  
		response.setHeader("Pragma", "No-cache");
		response.setDateHeader("Expires", 0);			  
		
		ByteUtils.readISWriteOS( fis, response.getOutputStream() ,BUFFER_SIZE);				
        ((Request)request).setHandled(true);
	}
		
}
