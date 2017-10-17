package com.blogspot.diegopacheco.jms.util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteUtils {

	public static byte[] readFully(InputStream stream) throws IOException {
	    byte[] buffer = new byte[8192];
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();

	    int bytesRead;
	    while ( (bytesRead = stream.read(buffer)) != -1){
	        baos.write(buffer, 0, bytesRead);
	    }
	    return baos.toByteArray();
	}

	public static byte[] loadFile(String sourcePath) throws IOException {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(sourcePath);
			return readFully(inputStream);
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}
	
	public static void readISWriteOS(InputStream stream,OutputStream os,int BUFFER_SIZE) throws IOException {
		byte bArray[] = new byte[BUFFER_SIZE];
		while( ( stream.read(bArray)) != -1 ){				
			os.write( bArray );
			bArray = new byte[BUFFER_SIZE];
		}			    
	}
	
	public static void writeOSwithIS(InputStream is,OutputStream os,int BUFFER_SIZE) throws IOException{
		int b = 0;
		byte bArray[] = new byte[BUFFER_SIZE];
		int inc = 0;
		while( ( b = is.read()) != -1 ){				
			bArray[inc] = (byte)b;
			if(inc==BUFFER_SIZE-1){
				os.write( bArray );
				inc = 0;
				bArray = new byte[BUFFER_SIZE];
			}
			inc++;
		}
		os.write( bArray );
	}

}
