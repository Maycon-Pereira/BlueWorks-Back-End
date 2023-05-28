package com.bluetips.tcc.bluetips.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluetips.tcc.bluetips.domain.CriaUsuarioVagaRequest;
import com.bluetips.tcc.bluetips.domain.CriaUsuarioVagaResponse;
import com.bluetips.tcc.bluetips.service.UsuarioVagaService;

@RestController
@RequestMapping("/usuarioVaga")
public class UsuarioVagaController {

	@Autowired
	private UsuarioVagaService usuarioVagaService;
	
	@PostMapping("/candidatura")
	public CriaUsuarioVagaResponse criaCandidatura(@Valid @RequestBody CriaUsuarioVagaRequest request) {
		
		CriaUsuarioVagaResponse response = usuarioVagaService.criaCandidatura(request);
		
		return response;
	}
		
}
