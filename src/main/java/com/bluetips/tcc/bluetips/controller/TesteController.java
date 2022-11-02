package com.bluetips.tcc.bluetips.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

	@PostMapping("/v1/teste/download/{idDoUsuario}")
	public ResponseEntity<ByteArrayResource> download(@PathVariable Long idDoUsuario) {

		String imagemBase64 = testeService.download(idDoUsuario);

		byte[] data = Base64.getDecoder().decode(imagemBase64);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=imagemDoPerfil.jpg")//attachment;
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.contentLength(data.length)
				.body(new ByteArrayResource(data));

	}
}