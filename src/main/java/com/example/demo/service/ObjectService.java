package com.example.demo.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.CopyRequest;
import com.example.demo.dto.MoveRequest;
import com.example.demo.dto.RenameRequest;
import com.example.demo.entity.FileMetadata;

public interface ObjectService {
	
	FileMetadata upload(MultipartFile file, String bucketName, String uploadBy);
	
//	InputStream download(String metadataId);
	
//	void delete(String metadataId);
	
//	List<String> listObjects(String bucketName);
	
//	void copy(CopyRequest copyRequest);
	
//	void move(MoveRequest moveRequest);
	
//	void rename(RenameRequest renameRequest);
}
