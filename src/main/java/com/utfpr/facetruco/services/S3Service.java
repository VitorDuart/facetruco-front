package com.utfpr.facetruco.services;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.net.URL;
import java.io.InputStream;

import com.amazonaws.services.iotevents.model.Input;

// import software.amazon.awssdk.core.sync.RequestBody;
// import software.amazon.awssdk.services.s3.S3Client;
// import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class S3Service{
    private AmazonS3 s3Client = S3Connection.getClient();
    private final  String bucketName = "facetruco";

    public void uploadMedia(String fileObjKeyName, InputStream input, ObjectMetadata metadata){
        PutObjectRequest request = new PutObjectRequest(bucketName, fileObjKeyName, input, metadata);
        request.setCannedAcl(CannedAccessControlList.PublicRead);
        // request.setMetadata(metadata);
        s3Client.putObject(request);
    }
    
    public String getObjectURL(String objKeyName){
        URL u = s3Client.getUrl(bucketName, objKeyName);
        return u.toString();
    }
    
}