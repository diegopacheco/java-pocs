package com.blogspot.diegopacheco.cxf.cglib.contract.impl;

import java.io.File;
import java.io.FileInputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.util.ByteArrayDataSource;

import com.blogspot.diegopacheco.cxf.cglib.contract.def.StreamService;

public class PDFStreamService implements StreamService {
	
	@Override
	public DataHandler getPDFAsStream(String userID) {		
		
		DataHandler dh = null;
		try {
			DataSource ds  = new ByteArrayDataSource(new FileInputStream(new File("C:\\tmp\\IN\\pdf-900kb.pdf")),"application/octet-stream");
			dh = new DataHandler(ds);
			return dh;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dh;
	}
	
}
