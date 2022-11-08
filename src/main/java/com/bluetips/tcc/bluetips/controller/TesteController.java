package com.bluetips.tcc.bluetips.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bluetips.tcc.bluetips.entity.TesteEntity;
import com.bluetips.tcc.bluetips.service.TesteService;

@RestController
public class TesteController {
	
	@Autowired
	private TesteService testeService;
	
	@PostMapping("/v1/teste/upload")
	public ResponseEntity<Void> upload(@RequestParam MultipartFile file) throws Exception {
		
		testeService.upload(file);
		return ResponseEntity.accepted().build();
	}

	@GetMapping("/v1/teste/download")
	public List<TesteEntity> download() {

		List<TesteEntity> response = testeService.download();
		return response;
		
		}
}