package com.github.diegopacheco.sandbox.java.aws;

import java.util.Arrays;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.Address;
import com.amazonaws.services.ec2.model.DescribeAddressesResult;

public class JavaIPSMain {

	public static void main(String[] args) {
		
		String accessKey = System.getProperty("aws-access-key", "");
		String secretKey = System.getProperty("aws-secret-key","");
		
		System.out.println("ARGS: " + Arrays.toString(args));
		System.out.println("Using AWS ACCESS KEY: " + accessKey);
		System.out.println("Using AWS SECRET KEY: " + secretKey);
		
		BasicAWSCredentials creds = new BasicAWSCredentials(accessKey,secretKey);
		
		final AmazonEC2 ec2 = AmazonEC2ClientBuilder.
								standard().
								withRegion(Regions.US_WEST_2).
								withCredentials(new AWSStaticCredentialsProvider(creds)).
								build();

		DescribeAddressesResult response = ec2.describeAddresses();

		for(Address address : response.getAddresses()) {
		    System.out.printf(
		            "Found address with public IP %s, " +
		            "domain %s, " +
		            "allocation id %s " +
		            "and NIC id %s",
		            address.getPublicIp(),
		            address.getDomain(),
		            address.getAllocationId(),
		            address.getNetworkInterfaceId());
		}
		
	}

}
