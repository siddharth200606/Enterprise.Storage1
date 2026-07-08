package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BucketRequest;

public interface BucketService {

	void createBucket(BucketRequest bucketRequest);
	
	boolean bucketExists(String bucketName);
	
	List<String> listBuckets();
	
    void deleteBucket(String bucketName);
}
