package com.blogspot.diegopacheco.jms.activemq.blob.jetty;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import org.mortbay.jetty.Request;

import com.blogspot.diegopacheco.jms.util.ByteUtils;

/**
 * 
 * @author Diego Pacheco
 *
 */
public class PDFUploadServlet extends HttpServlet { 

	private static final long serialVersionUID = 1L;	
	private final int BUFFER_SIZE = 1048576; // 1 MB
	
	@Override
	public void service(ServletRequest request, ServletResponse response)throws ServletException, IOException {
		String filename = "pdf-119mb.upload.pdf";
		String filepath = "C:/tmp/uploads/" + filename;			
		FileOutputStream fos = new FileOutputStream(filepath);
	
		ByteUtils.readISWriteOS( request.getInputStream(), fos ,BUFFER_SIZE);				
        ((Request)request).setHandled(true);
	}
	
		
}
