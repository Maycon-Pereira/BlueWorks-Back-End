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

import com.bluetips.tcc.bluetips.domain.CriaUsuarioRequest;
import com.bluetips.tcc.bluetips.domain.CriaUsuarioResponse;
import com.bluetips.tcc.bluetips.domain.DeleteUsuarioResponse;
import com.bluetips.tcc.bluetips.entity.UsuarioEntity;
import com.bluetips.tcc.bluetips.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public CriaUsuarioResponse criaUsuario(@Valid @RequestBody CriaUsuarioRequest request) {
		
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
	
	@PutMapping("/darLikeEmUsuario/{idUsuario}/{nomeEmpresa}")
	public ResponseEntity<Void> darLikeEmUsuario(@PathVariable String idUsuario, @PathVariable String nomeEmpresa) {
		usuarioService.darLikeEmUsuario(idUsuario, nomeEmpresa); 
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<DeleteUsuarioResponse> removeUsuario(@PathVariable String id) {
		
		DeleteUsuarioResponse response = usuarioService.removeUsuario(id);
		
		if(response.isDeletado()) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	//IMAGEM UPLOAD E DOWNLOAD
	
	@PostMapping("/v2/image/upload/{id}")
	public ResponseEntity<Void> upload(@RequestParam MultipartFile file, @PathVariable String id) throws Exception {
		
		usuarioService.upload(file, id);
		return ResponseEntity.accepted().build();
	}
	
	@GetMapping("/v2/image/download")
	public List<UsuarioEntity> download() {

		List<UsuarioEntity> response = usuarioService.download();
		return response;
		
		}
	
}
