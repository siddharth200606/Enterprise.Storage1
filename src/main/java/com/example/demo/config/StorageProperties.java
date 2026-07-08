package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.storage")
public class StorageProperties {

	private String endpoints;
	private String accessKey;
	private String secretKey;
	private String region;

	public void setEndpoints(String endpoints) {
		this.endpoints = endpoints;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getEndpoints() {
		return endpoints;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public String getRegion() {
		return region;
	}

}
