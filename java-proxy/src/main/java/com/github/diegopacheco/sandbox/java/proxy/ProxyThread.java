package com.github.diegopacheco.sandbox.java.proxy;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.StringTokenizer;

import javax.net.ssl.HttpsURLConnection;

public class ProxyThread extends Thread {
	
    private Socket socket = null;
    private static final int BUFFER_SIZE = 32768;
    
    public ProxyThread(Socket socket) {
        super("ProxyThread");
        this.socket = socket;
    }

    public void run() {
        try {
        	DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        	
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            String urlToCall = extractURL(in);

            ConnectionHelper cn = call(urlToCall, out);
            
            wrtieResponseBack(out, cn);

            closeResources(out, in, cn.getBr());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	private void wrtieResponseBack(DataOutputStream out, ConnectionHelper cn) throws IOException {
		try {
			
			if (cn.getIs() != null ){
				byte by[] = new byte[ BUFFER_SIZE ];
			    int index =  cn.getIs().read( by, 0, BUFFER_SIZE );
			    while ( index != -1 )
			    {
			      out.write( by, 0, index );
			      index = cn.getIs().read( by, 0, BUFFER_SIZE );
			    }
			}
		    out.flush();

		} catch (Exception e) {
			out.write(e.toString().getBytes(Charset.forName("UTF-8")));
			return;
		}
	}
    
    private ConnectionHelper call(String urlToCall,DataOutputStream out) throws Exception{
    	
    	ConnectionHelper ch = new ConnectionHelper();
    	
        URL url = new URL(urlToCall);
        URLConnection conn =  (urlToCall.contains("https://")) ? (HttpsURLConnection) url.openConnection() : url.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(false);
        
        InputStream is = null;
        try {
            is = conn.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is,Charset.forName("UTF-8")));
            ch.setBr(rd);
            ch.setIs(is);
            return ch;
        } catch (Exception e) {
        	 out.write(e.toString().getBytes(Charset.forName("UTF-8")));
        	 ch.setBr(null);
             ch.setIs(null);
        	 return ch;
        }
    }

	private void closeResources(DataOutputStream out, BufferedReader in, BufferedReader rd) throws IOException {
		if (rd != null) {
		    rd.close();
		}
		if (out != null) {
		    out.close();
		}
		if (in != null) {
		    in.close();
		}
		if (socket != null) {
		    socket.close();
		}
	}

	private String extractURL(BufferedReader in) throws IOException {
		String inputLine;
		int cnt = 0;
		String urlToCall = "";
		while ((inputLine = in.readLine()) != null) {
		    try {
		        StringTokenizer tok = new StringTokenizer(inputLine);
		        tok.nextToken();
		    } catch (Exception e) {
		        break;
		    }
		    if (cnt == 0) {
		        String[] tokens = inputLine.split(" ");
		        urlToCall = tokens[1];
		        System.out.println("Request for : " + urlToCall);
		        break;
		    }
		    cnt++;
		}
		
    	if (urlToCall.contains(":443")){
    		urlToCall = urlToCall.replace(":443","");
    		urlToCall = "https://" + urlToCall;
    	}
		
		return urlToCall;
	}
	
	public static char[] byteToChar(byte[] bytes){
		return new String(bytes,Charset.forName("UTF-8")).toCharArray();
	}
	
}
