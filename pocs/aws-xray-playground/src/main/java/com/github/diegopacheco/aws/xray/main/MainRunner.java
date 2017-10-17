package com.github.diegopacheco.aws.xray.main;

import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

import com.amazonaws.xray.AWSXRay;
import com.amazonaws.xray.AWSXRayRecorder;
import com.amazonaws.xray.AWSXRayRecorderBuilder;
import com.amazonaws.xray.entities.Segment;
import com.amazonaws.xray.entities.Subsegment;
import com.amazonaws.xray.entities.SubsegmentImpl;
import com.amazonaws.xray.entities.TraceID;
import com.amazonaws.xray.plugins.EC2Plugin;
import com.amazonaws.xray.proxies.apache.http.HttpClientBuilder;
import com.amazonaws.xray.strategy.FixedSegmentNamingStrategy;
import com.amazonaws.xray.strategy.SegmentNamingStrategy;
import com.amazonaws.xray.strategy.sampling.LocalizedSamplingStrategy;

public class MainRunner {

	private static SegmentNamingStrategy segmentNamingStrategy;
	private static AWSXRayRecorder recorder = AWSXRay.getGlobalRecorder();

	static {
		AWSXRayRecorderBuilder builder = AWSXRayRecorderBuilder.standard().withPlugin(new EC2Plugin());
		URL ruleFile = MainRunner.class.getResource("/sampling-rules.json");
		builder.withSamplingStrategy(new LocalizedSamplingStrategy(ruleFile));
		AWSXRay.setGlobalRecorder(builder.build());
		segmentNamingStrategy = new FixedSegmentNamingStrategy("aws-xray-poc");
	}

	public static void approachA() throws Exception {
		String segmentName = segmentNamingStrategy.nameForRequest(null);
		Segment segment = recorder.beginSegment(segmentName, new TraceID(), null);

		Thread.sleep(2000);

		if (segment.end()) {
			recorder.sendSegment(segment);
		}
		System.out.println("Approach A - DONE");
	}

	public static void approachB() throws Exception {
		String segmentName = segmentNamingStrategy.nameForRequest(null) + "-b";
		Segment segment = recorder.beginSegment(segmentName, new TraceID(), null);

		Thread.sleep(2000);

		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet("http://google.com/");
		CloseableHttpResponse response = httpclient.execute(httpGet);
		try {
			HttpEntity entity = response.getEntity();
			System.out.println(entity);
		} finally {
			response.close();
		}

		if (segment.end()) {
			recorder.sendSegment(segment);
		}
		System.out.println("Approach B - DONE");
	}
	
	public static void approachC() throws Exception {
		String segmentName = segmentNamingStrategy.nameForRequest(null) + "-C";
		Segment segment = recorder.beginSegment(segmentName, new TraceID(), null);

		Thread.sleep(2000);

		Subsegment subsegment = AWSXRay.beginSubsegment("Twitter");
		subsegment.setNamespace("remote");
		Thread.sleep(1000);
		
		Subsegment subsegment2 = AWSXRay.beginSubsegment("Github");
		subsegment2.setNamespace("remote");
		Thread.sleep(1000);
		AWSXRay.endSubsegment();
		
		AWSXRay.endSubsegment();
		
		if (segment.end()) {
			recorder.sendSegment(segment);
		}
		System.out.println("Approach C - DONE");
	}
	
	public static void approachD() throws Exception {
		Segment s = AWSXRay.beginSegment("Facebook");
		s.setNamespace("remote");
		Thread.sleep(1000);
		AWSXRay.endSegment();
		System.out.println("Approach D - DONE");
	}


	public static void main(String[] args) {
		try {
			approachA();
			approachB();
			approachC();
			approachD();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
