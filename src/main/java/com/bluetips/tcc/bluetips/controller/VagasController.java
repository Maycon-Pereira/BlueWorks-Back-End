package com.bluetips.tcc.bluetips.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluetips.tcc.bluetips.domain.CriaVagasRequest;
import com.bluetips.tcc.bluetips.domain.CriaVagasResponse;
import com.bluetips.tcc.bluetips.entity.VagasEntity;
import com.bluetips.tcc.bluetips.service.VagasService;

@RestController
@RequestMapping("/vagas")
public class VagasController {

	@Autowired
	private VagasService vagasService;
	
	@PostMapping
	public CriaVagasResponse criaVagas(@RequestBody CriaVagasRequest request) {
		
		CriaVagasResponse response = vagasService.criaVagas(request);
		
		return response;
	}
	
	@GetMapping
	public List<VagasEntity> listaTodasVagas(){
	
		List<VagasEntity> response = vagasService.listaTodasVagas();		
		return response;
	}
	
	@GetMapping("/{id}")
	public VagasEntity buscaVagasPorId(@PathVariable String id) {
		
		VagasEntity response = vagasService.buscaVagasPorId(id);
		return response;
	}
	
	@PutMapping("/{id}")
	public VagasEntity atualizaVagas(@PathVariable String id, @RequestBody CriaVagasRequest request) {
		
		VagasEntity response = vagasService.atualizaVagas(id, request);
		return response;
	}
	
	@DeleteMapping("/{id}")
	public String removeVagas(@PathVariable String id) {
		
		String response = vagasService.removeVagas(id);
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
}
