package com.github.diegopacheco.sandbox.java.proxy.littleproxy.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Client {
	public static void main(String[] args) throws Exception {
		
		System.setProperty("http.useProxy",  "true");
		System.setProperty("http.nonProxyHosts", "");
		System.setProperty("http.proxyHost", "localhost");
        System.setProperty("http.proxyPort", "8888");
        
        System.setProperty("https.useProxy",  "true");
		System.setProperty("https.nonProxyHosts", "");
		System.setProperty("https.proxyHost", "localhost");
        System.setProperty("https.proxyPort", "8888");        
		
        //URL url = new URL("https://api.github.com/users/diegopacheco/repos");
        URL url = new URL("http://www.wikipedia.com");
        //URL url = new URL("http://www.error.com");
        
        URLConnection cnn = url.openConnection();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(cnn.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) 
		System.out.println(inputLine);
		in.close();
        
	}
}
