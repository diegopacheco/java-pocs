package com.github.diegopacheco.zipkin.java.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nike.wingtips.Span;
import com.nike.wingtips.Tracer;
import com.nike.wingtips.zipkin.WingtipsToZipkinLifecycleListener;

@Configuration
@ComponentScan
@RestController
@SpringBootApplication
@EnableAutoConfiguration
public class WingtipsApplication {

	private static final Logger LOG = Logger.getLogger(WingtipsApplication.class.getName());

	public static void main(String[] args) {

		Tracer.getInstance().addSpanLifecycleListener(new WingtipsToZipkinLifecycleListener("microservice-A","main", "http://localhost:9411"));

		SpringApplication.run(WingtipsApplication.class, args);
	}

	@GetMapping("/")
	public String home() {
		LOG.log(Level.INFO, "you called /");
		return "OK";
	}
	
	@GetMapping("/trace")
	public String trace1() {
		LOG.log(Level.INFO, "you called /trace");
		
		try {
		    Span root = Tracer.getInstance().startRequestWithRootSpan("callDecorator");
		    Thread.sleep(2000L);
		    Tracer.getInstance().completeRequestSpan();
		    
		    Span child1 = Tracer.getInstance().startRequestWithChildSpan(root, "callSearch");
		    Thread.sleep(1000L);
		    Tracer.getInstance().completeRequestSpan();
		    
		    Tracer.getInstance().startRequestWithChildSpan(child1, "callProfile");
		    Thread.sleep(3000L);
		    String res = sendGet("");
		    Tracer.getInstance().completeRequestSpan();
		    
		    return res;
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
		finally {
		}
	}
	
	private String sendGet(String urlParam){
		try{
			String url = "http://localhost:8080/" + urlParam;
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			return response.toString();

		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}

}
