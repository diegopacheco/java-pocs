package com.github.diegopacheco.sandbox.java.testcontainers.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.github.diegopacheco.sandbox.java.testcontainers.AppConfig;
import com.github.diegopacheco.sandbox.java.testcontainers.test.LocalStackContainerLatest.ServiceLatest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class TestS3 {
	
  @Rule
  public LocalStackContainerLatest localstack = new LocalStackContainerLatest(). withServices(ServiceLatest.S3);
  
  @Test
  public void someTestMethod() {
      AmazonS3 s3 = AmazonS3ClientBuilder
                      .standard()
                      .withEndpointConfiguration(localstack.getEndpointConfiguration(ServiceLatest.S3))
                      .withCredentials(localstack.getDefaultCredentialsProvider())
                      .build();
      
              s3.createBucket("foo");
              s3.putObject("foo", "bar", "baz");
              System.out.println("Key Counts on S3>: " +  s3.listObjectsV2("foo").getKeyCount() );
  }
  
}
