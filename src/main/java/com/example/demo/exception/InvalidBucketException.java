package com.example.demo.exception;

public class InvalidBucketException
extends StorageException {

public InvalidBucketException(
    String message) {

super(message);
}
}
