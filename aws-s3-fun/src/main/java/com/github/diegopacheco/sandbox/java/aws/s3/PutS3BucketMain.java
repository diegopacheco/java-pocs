package com.github.diegopacheco.sandbox.java.aws.s3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.UploadPartRequest;

public class PutS3BucketMain {
	public static void main(String[] args) throws Throwable {
		
		AmazonS3 s3Client = new AmazonS3Client(new ProfileCredentialsProvider());

		String bucketName = "diego-test-bucket-s3";
		String key = "conf";
		
		List<PartETag> partETags = new ArrayList<PartETag>();
		InitiateMultipartUploadRequest initRequest = new InitiateMultipartUploadRequest(bucketName,key);
		InitiateMultipartUploadResult initResponse = s3Client.initiateMultipartUpload(initRequest);

		File file = new File(new File(".").getCanonicalPath() + "/src/main/resources/data.json");
		long contentLength = file.length();

		// Set part size to 5 MB.
		long partSize = 5 * 1024 * 1024; 

		try {
		    long filePosition = 0;
		    for (int i = 1; filePosition < contentLength; i++) {
		        // Last part can be less than 5 MB. Adjust part size.
		    	partSize = Math.min(partSize, (contentLength - filePosition));
		    	
		        // Create request to upload a part.
		        UploadPartRequest uploadRequest = new UploadPartRequest()
		            .withBucketName(bucketName).withKey(key)
		            .withUploadId(initResponse.getUploadId()).withPartNumber(i)
		            .withFileOffset(filePosition)
		            .withFile(file)
		            .withPartSize(partSize);

		        // Upload part and add response to our list.
		        partETags.add(s3Client.uploadPart(uploadRequest).getPartETag());
		        filePosition += partSize;
		    }

		    // Step 3: Complete.
		    CompleteMultipartUploadRequest compRequest = new 
		                CompleteMultipartUploadRequest(bucketName, 
		                							   key, 
		                                               initResponse.getUploadId(), 
		                                               partETags);

		    s3Client.completeMultipartUpload(compRequest);
		} catch (Exception e) {
		    s3Client.abortMultipartUpload(new AbortMultipartUploadRequest(bucketName, key, initResponse.getUploadId()));
		    e.printStackTrace();
		}
	}
}
