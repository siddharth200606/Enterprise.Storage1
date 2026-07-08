package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "bucket_audit")
public class BucketAudit {

	@Id
	private String id;
	private String bucketName;
	private String operation;
	private Long timestamp;

	public BucketAudit() {
	}

	public BucketAudit(String id, String bucketName, String operation, Long timestamp) {
		super();
		this.id = id;
		this.bucketName = bucketName;
		this.operation = operation;
		this.timestamp = timestamp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

}

