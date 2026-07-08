package com.example.demo.exception;


public class BucketAlreadyExistsException extends StorageException {

	public BucketAlreadyExistsException(String bucketName) {

		super("Bucket already exists : " + bucketName);
	}
}