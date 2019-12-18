package com.utfpr.facetruco.services;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

// import software.amazon.awssdk.regions.Region;
// import software.amazon.awssdk.services.s3.S3Client;

public class S3Connection{
    private static  AmazonS3 s3Client;
    // private static S3Client s3;
    // private static  Region clientRegion = Region.SA_EAST_1;
    private static Regions clientRegion = Regions.SA_EAST_1;
    
    public synchronized static AmazonS3 getClient() {

        if(s3Client == null)
            
            s3Client = AmazonS3ClientBuilder.standard()
            .withRegion(clientRegion)
            .build();
            // s3 = S3Client.builder().region(clientRegion).build();
        return s3Client;       
    }
}