package com.github.diegopacheco.javapocs.s3;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.List;

public class S3App {
    private static final Logger logger = LoggerFactory.getLogger(S3App.class);
    
    private static final String MINIO_ENDPOINT = System.getenv().getOrDefault("MINIO_ENDPOINT", "http://localhost:8000");
    private static final String ACCESS_KEY = System.getenv().getOrDefault("MINIO_ACCESS_KEY", "test");
    private static final String SECRET_KEY = System.getenv().getOrDefault("MINIO_SECRET_KEY", "test12345");
    private static final String BUCKET_NAME = "test-bucket";

    public static void main(String[] args) {
        logger.info("Starting S3 Java Application with Java 21");
        
        S3App app = new S3App();
        app.run();
    }

    public void run() {
        try {
            S3Client s3Client = createS3Client();
            
            createBucket(s3Client);
            listBuckets(s3Client);
            uploadObject(s3Client);
            listObjects(s3Client);
            downloadObject(s3Client);
            
            logger.info("All operations completed successfully!");
            
        } catch (Exception e) {
            logger.error("Error occurred: ", e);
        }
    }

    private S3Client createS3Client() {
        logger.info("Creating S3 client for endpoint: {}", MINIO_ENDPOINT);
        
        return S3Client.builder()
                .endpointOverride(URI.create(MINIO_ENDPOINT))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(ACCESS_KEY, SECRET_KEY)))
                .region(Region.US_EAST_1)
                .forcePathStyle(true)
                .build();
    }

    private void createBucket(S3Client s3Client) {
        try {
            CreateBucketRequest createBucketRequest = CreateBucketRequest.builder()
                    .bucket(BUCKET_NAME)
                    .build();
            
            s3Client.createBucket(createBucketRequest);
            logger.info("Bucket '{}' created successfully", BUCKET_NAME);
        } catch (BucketAlreadyExistsException | BucketAlreadyOwnedByYouException e) {
            logger.info("Bucket '{}' already exists", BUCKET_NAME);
        } catch (Exception e) {
            logger.error("Failed to create bucket: ", e);
        }
    }

    private void listBuckets(S3Client s3Client) {
        try {
            ListBucketsResponse listBucketsResponse = s3Client.listBuckets();
            List<Bucket> buckets = listBucketsResponse.buckets();
            
            logger.info("Found {} buckets:", buckets.size());
            buckets.forEach(bucket -> logger.info("  - {}", bucket.name()));
        } catch (Exception e) {
            logger.error("Failed to list buckets: ", e);
        }
    }

    private void uploadObject(S3Client s3Client) {
        try {
            String key = "test-file.txt";
            String content = "Hello from Java 21 and Ceph!";
            
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(BUCKET_NAME)
                    .key(key)
                    .build();
            
            s3Client.putObject(putObjectRequest, RequestBody.fromString(content));
            logger.info("Object '{}' uploaded successfully", key);
        } catch (Exception e) {
            logger.error("Failed to upload object: ", e);
        }
    }

    private void listObjects(S3Client s3Client) {
        try {
            ListObjectsV2Request listObjectsRequest = ListObjectsV2Request.builder()
                    .bucket(BUCKET_NAME)
                    .build();
            
            ListObjectsV2Response listObjectsResponse = s3Client.listObjectsV2(listObjectsRequest);
            List<S3Object> objects = listObjectsResponse.contents();
            
            logger.info("Found {} objects in bucket '{}':", objects.size(), BUCKET_NAME);
            objects.forEach(obj -> logger.info("  - {} (size: {} bytes)", obj.key(), obj.size()));
        } catch (Exception e) {
            logger.error("Failed to list objects: ", e);
        }
    }

    private void downloadObject(S3Client s3Client) {
        try {
            String key = "test-file.txt";
            
            GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                    .bucket(BUCKET_NAME)
                    .key(key)
                    .build();
            
            String content = s3Client.getObjectAsBytes(getObjectRequest).asUtf8String();
            logger.info("Downloaded object '{}' content: {}", key, content);
        } catch (Exception e) {
            logger.error("Failed to download object: ", e);
        }
    }
}