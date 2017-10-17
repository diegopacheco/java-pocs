package com.blogspot.diegopacheco.cache.playground.cacheserver.rest.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.Writer;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ContentProducer;
import org.apache.http.entity.EntityTemplate;
import org.apache.http.impl.client.DefaultHttpClient;

import com.thoughtworks.xstream.XStream;

/**
 * 
 * @author Diego Pacheco
 *
 */
public class HttpClientRESTBaby {
	
	private static final String REST_CACHE_SERVER = "localhost:8080/ehcache-server-jboss-1.0.0/rest";
	
	private enum HTTP_METHOD { GET, PUT };
	
	private XStream xstream = new XStream();
	
	private boolean mute = false;
	
	
	public void createCache(String cacheName) throws Throwable{
		execute(HTTP_METHOD.PUT,cacheName, null);
	}
	
	public String getCache(String cacheName) throws Throwable{
		return execute(HTTP_METHOD.GET,cacheName, null);
	}
	
	public void addEntry(String cacheName,String key,Serializable value)throws Throwable{		
		execute(HTTP_METHOD.PUT,cacheName + "/" + key, value);
	}
	
	public String getEntry(String cacheName,String key) throws Throwable{
		return execute(HTTP_METHOD.GET,cacheName + "/" + key, null);
	}
	
	private String execute(HTTP_METHOD method,String path,final Serializable value)throws Throwable{
		
		HttpClient httpclient = new DefaultHttpClient();
		URI uri = URIUtils.createURI("http", REST_CACHE_SERVER, -1, path, null, null);
		HttpRequestBase httpMethod = null;
		
		switch(method){
			case PUT:
				httpMethod = new HttpPut(uri); 	
				if (value!=null){
					ContentProducer cp = new ContentProducer() {
					    public void writeTo(OutputStream outstream) throws IOException {
					        Writer writer = new OutputStreamWriter(outstream, "UTF-8");
					        writer.write(xstream.toXML(value));
					        writer.flush();
					    }
					};
					HttpEntity entity = new EntityTemplate(cp);
				    ((HttpPut)httpMethod).setEntity(entity);
				}
			break;
			case GET:
				httpMethod = new HttpGet(uri); 	
			break;	
		}			
		
		if(mute==false)
			System.out.println("++" + httpMethod.getURI());		
		
		HttpResponse response = httpclient.execute(httpMethod);
		
		BufferedHttpEntity entity = new BufferedHttpEntity(response.getEntity());
		if (entity != null) {
			if(mute==false){
				System.out.println(" +Result["); 
				System.out.print("  ");
				entity.writeTo(System.out);
				System.out.println("\n +]");
			}
		}		
		
		if(mute==false){
			System.out.println(" +" + response.getStatusLine().getStatusCode());
			System.out.println(" +" + response.getStatusLine().getReasonPhrase());
			System.out.println(" +" + response.getStatusLine().toString() + "\n");
		}
				
		return inputStreamToStringBuffer(entity.getContent()).toString(); 
	}
	
	private StringBuffer inputStreamToStringBuffer(InputStream is) throws Throwable{
		
		StringBuffer   sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		String s = null;
		while( (s = br.readLine()) != null  ){ 
			sb.append(s);
		}
		return sb;
	}

	public void setMute(boolean mute) {
		this.mute = mute;
	}	

}
