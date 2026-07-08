package com.example.demo.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.FileMetadata;
import com.example.demo.service.ObjectService;

@RestController
@RequestMapping("/api/objects")
public class ObjectController {

	private final ObjectService objectService;

	public ObjectController(ObjectService objectService) {
		super();
		this.objectService = objectService;
	}

	@PostMapping("/upload")
	public FileMetadata upload(@RequestParam MultipartFile file, @RequestParam String bucketName,
			@RequestParam String uploadedBy) {
		
		return objectService.upload(file, bucketName, uploadedBy);
	}
}

