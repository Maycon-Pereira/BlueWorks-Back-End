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

import com.bluetips.tcc.bluetips.domain.CriaUsuarioRequest;
import com.bluetips.tcc.bluetips.domain.CriaUsuarioResponse;
import com.bluetips.tcc.bluetips.entity.UsuarioEntity;
import com.bluetips.tcc.bluetips.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public CriaUsuarioResponse criaUsuario(@RequestBody CriaUsuarioRequest request) {
		
		CriaUsuarioResponse response = usuarioService.criaUsuario(request);
		
		return response;
	}
	
	@GetMapping
	public List<UsuarioEntity> listaTodosUsuarios() {
		
		List<UsuarioEntity> response = usuarioService.listaTodosUsuarios();
		return response;
	}
	
	@GetMapping("/{id}")
	public UsuarioEntity buscaUsuarioPorId(@PathVariable String id) {
	
		UsuarioEntity response = usuarioService.buscaUsuarioPorId(id);
		return response;
	}
	
	@PutMapping("{id}")
	public UsuarioEntity atualizaUsuario(@PathVariable String id, @RequestBody CriaUsuarioRequest request) {
		
		UsuarioEntity response = usuarioService.atualizaUsuario(id, request); 
		return response;
	}
	
	@DeleteMapping("{id}")
	public String removeUsuario(@PathVariable String id) {
		
		String response = usuarioService.removeUsuario(id);
		return response;
	}
	
}
