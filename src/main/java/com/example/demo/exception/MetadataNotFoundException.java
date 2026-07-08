package com.example.demo.exception;

public class MetadataNotFoundException extends StorageException {

	public MetadataNotFoundException(String id) {

		super("Metadata not found : " + id);
	}
}