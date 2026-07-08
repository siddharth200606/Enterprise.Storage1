package com.example.demo.serviceIml;

import java.time.Instant;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.FileMetadata;
import com.example.demo.exception.FileUploadException;
import com.example.demo.repository.FileMetadataRepository;
import com.example.demo.service.ObjectService;
import com.example.demo.util.CheckSumUtil;
import com.example.demo.util.FileStatus;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

@Service
public class ObjectServiceImpl implements ObjectService{

	private final S3Client s3Client;
    private final FileMetadataRepository repository;

    public ObjectServiceImpl(S3Client s3Client, FileMetadataRepository repository) {
        this.s3Client = s3Client;
        this.repository = repository;
    }
	
	
	public FileMetadata upload(MultipartFile file, String bucketName, String uploadBy) {
		
		try {
			String originalName = file.getOriginalFilename();
	        String extension = "";
	        int index = originalName.lastIndexOf(".");

	        if (index != -1) {
	            extension = originalName.substring(index);
	        }
	        
	        
	        String storedName = UUID.randomUUID() + extension;
	        String checksum = CheckSumUtil.sha256(file.getInputStream());
	        
	        
	        PutObjectRequest request = PutObjectRequest.builder()
	        									.bucket(bucketName)
	        									.key(storedName)
	        									.contentType(file.getContentType())
	        									.build();
	        
	        PutObjectResponse response = s3Client.putObject(request, RequestBody.fromBytes(file.getBytes()));
	        
	        FileMetadata metaData = new FileMetadata();
	        metaData.setOriginalName(originalName);
	        metaData.setStoredName(storedName);
	        metaData.setBucketName(bucketName);
	        metaData.setFileSize(file.getSize());
	        metaData.setContentType(file.getContentType());
	        metaData.setUploadedBy(uploadBy);
	        metaData.setUploadedAt(Instant.now());
	        metaData.setChecksum(checksum);
	        metaData.setEtag(response.eTag());
	        metaData.setStatus(FileStatus.ACTIVE);
	        
	        
	        return repository.save(metaData);
		}
		catch(Exception e) {
			throw new FileUploadException(e.getMessage());
		}
	
	}
	
}

