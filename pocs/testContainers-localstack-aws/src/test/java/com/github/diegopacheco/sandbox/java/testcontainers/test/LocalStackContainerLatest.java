package com.github.diegopacheco.sandbox.java.testcontainers.test;

import static org.testcontainers.containers.BindMode.READ_WRITE;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.jetbrains.annotations.Nullable;
import org.junit.rules.ExternalResource;
import org.rnorth.ducttape.Preconditions;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.LogMessageWaitStrategy;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;

@SuppressWarnings("deprecation")
public class LocalStackContainerLatest extends ExternalResource { 
	
	@SuppressWarnings("rawtypes")
	@Nullable private GenericContainer delegate;
  private ServiceLatest[] services;

  @SuppressWarnings({ "rawtypes", "resource" })
	@Override
  protected void before() throws Throwable {

      Preconditions.check("services list must not be empty", services != null && services.length > 0);

      final String servicesList = Arrays
              .stream(services)
              .map(ServiceLatest::getLocalStackName)
              .collect(Collectors.joining(","));

      final Integer[] portsList = Arrays
              .stream(services)
              .map(ServiceLatest::getPort)
              .collect(Collectors.toSet()).toArray(new Integer[]{});

      delegate = new GenericContainer("localstack/localstack:latest")
                     .withExposedPorts(portsList)
                     .withFileSystemBind("//var/run/docker.sock", "/var/run/docker.sock", READ_WRITE)
                     .waitingFor(new LogMessageWaitStrategy().withRegEx(".*Ready\\.\n"))
                     .withEnv("SERVICES", servicesList);

      delegate.start();
  }

  @Override
  protected void after() {
      Preconditions.check("delegate must have been created by before()", delegate != null);
      delegate.stop();
  }

  public LocalStackContainerLatest withServices(ServiceLatest... s3) {
      this.services = s3;
      return this;
  }

  public AwsClientBuilder.EndpointConfiguration getEndpointConfiguration(ServiceLatest service) {

      if (delegate == null) {
          throw new IllegalStateException("LocalStack has not been started yet!");
      }

      final String address = delegate.getContainerIpAddress();
      String ipAddress = address;
      try {
          ipAddress = InetAddress.getByName(address).getHostAddress();
      } catch (UnknownHostException ignored) {

      }
      ipAddress = ipAddress + ".xip.io";
      while (true) {
          try {
              InetAddress.getAllByName(ipAddress);
              break;
          } catch (UnknownHostException ignored) {

          }
      }

      return new AwsClientBuilder.EndpointConfiguration(
              "http://" +
              ipAddress +
              ":" +
              delegate.getMappedPort(service.getPort()), "us-east-1");
  }

  public AWSCredentialsProvider getDefaultCredentialsProvider() {
      return new AWSStaticCredentialsProvider(new BasicAWSCredentials("accesskey", "secretkey"));
  }

  public enum ServiceLatest {
      API_GATEWAY("apigateway",             4567),
      KINESIS("kinesis",                 4568),
      DYNAMODB("dynamodb",        4569),
      DYNAMODB_STREAMS("dynamodbstreams",        4570),
//      ELASTICSEARCH("es",           4571),
      S3("s3",                    4572),
      FIREHOSE("firehose",                4573),
      LAMBDA("lambda",                  4574),
      SNS("sns",                     4575),
      SQS("sqs",                     4576),
      REDSHIFT("redshift",                4577),
//      ELASTICSEARCH_SERVICE("",   4578),
      SES("ses",                     4579),
      ROUTE53("route53",                 4580),
      CLOUDFORMATION("cloudformation",          4581),
      CLOUDWATCH("cloudwatch",              4582);

      private final String localStackName;
      private final int port;

      ServiceLatest(String localstackName, int port) {
          this.localStackName = localstackName;
          this.port = port;
      }

      public String getLocalStackName() {
          return localStackName;
      }

      public Integer getPort() { return port; }
  }
}
