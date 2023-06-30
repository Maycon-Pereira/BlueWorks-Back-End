package com.bluetips.tcc.bluetips.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bluetips.tcc.bluetips.domain.CriaEmpresaRequest;
import com.bluetips.tcc.bluetips.domain.CriaEmpresaResponse;
import com.bluetips.tcc.bluetips.domain.DeletaEmpresaResponse;
import com.bluetips.tcc.bluetips.entity.EmpresaEntity;
import com.bluetips.tcc.bluetips.service.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired// CRUD EMPRESA
	private EmpresaService empresaService;
	
	@PostMapping
	public CriaEmpresaResponse criaEmpesa(@Valid @RequestBody CriaEmpresaRequest request) {
		
		CriaEmpresaResponse response = empresaService.criaEmpesa(request);
		
		return response;
	}

	@GetMapping("/all")
	public List<EmpresaEntity> listaTodasEmpresas() {
		
		List<EmpresaEntity> response = empresaService.listaTodasEmpresas();
		return response;
	}
	
	@GetMapping("/{id}")
	public EmpresaEntity buscaEmpesaPorId(@PathVariable String id) {
		
		EmpresaEntity response = empresaService.buscaEmpesaPorId(id);
		return response;
	}

	@PutMapping("/{id}")
	public EmpresaEntity atualizaEmpresa(@PathVariable String id, @RequestBody CriaEmpresaRequest request) {
		
		EmpresaEntity response = empresaService.atualizaEmpresa(id, request);
		return response;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<DeletaEmpresaResponse> removeEmpresa(@PathVariable String id) {
		
		DeletaEmpresaResponse response = empresaService.removeEmpresa(id);
		
		if(response.isDeletado()) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	//IMAGEM UPLOAD E DOWNLOAD
	
	@PostMapping("/v2/image/upload/{id}")
	public ResponseEntity<Void> upload(@RequestParam MultipartFile file, @PathVariable String id) throws Exception {
		
		empresaService.upload(file, id);
		return ResponseEntity.accepted().build();
	}
	
	@GetMapping("/v2/image/download")
	public List<EmpresaEntity> download() {

		List<EmpresaEntity> response = empresaService.download();
		return response;
		
		}

}
