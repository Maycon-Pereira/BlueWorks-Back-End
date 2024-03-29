package com.bluetips.tcc.bluetips.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluetips.tcc.bluetips.domain.CriaCandidatoVagaRequest;
import com.bluetips.tcc.bluetips.domain.CriaCandidatoVagaResponse;
import com.bluetips.tcc.bluetips.entity.UsuarioVagaEntity;
import com.bluetips.tcc.bluetips.service.CandidatoVagaService;

@RestController
@RequestMapping("/usuarioVaga")
public class CandidatoVagaController {

	@Autowired
	private CandidatoVagaService usuarioVagaService;
	
	@PostMapping("/candidatura")
	public CriaCandidatoVagaResponse criaCandidatura(@Valid @RequestBody CriaCandidatoVagaRequest request) {
		
		CriaCandidatoVagaResponse response = usuarioVagaService.criaCandidatura(request);
		
		return response;
	}
	
	@GetMapping("/listarTodosUsuarioVaga")
	public List<UsuarioVagaEntity> listaTodosUsuarioVaga() {
		
		List<UsuarioVagaEntity> response = usuarioVagaService.listaTodosUsuarioVaga();
		return response;
	}
		
}
