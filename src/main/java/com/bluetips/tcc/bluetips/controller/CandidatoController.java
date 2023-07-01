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

import com.bluetips.tcc.bluetips.domain.CriaCandidatoRequest;
import com.bluetips.tcc.bluetips.domain.CriaCandidatoResponse;
import com.bluetips.tcc.bluetips.domain.DeleteCandidatoResponse;
import com.bluetips.tcc.bluetips.entity.CandidatoEntity;
import com.bluetips.tcc.bluetips.service.CandidatoService;

@RestController
@RequestMapping("/usuario")
public class CandidatoController {

	@Autowired
	private CandidatoService usuarioService;
	
	@PostMapping
	public CriaCandidatoResponse criaUsuario(@Valid @RequestBody CriaCandidatoRequest request) {
		
		CriaCandidatoResponse response = usuarioService.criaUsuario(request);
		
		return response;
	}
	
	@GetMapping("/all")
	public List<CandidatoEntity> listaTodosUsuarios() {
		
		List<CandidatoEntity> response = usuarioService.listaTodosUsuarios();
		return response;
	}
	
	@GetMapping("/{id}")
	public CandidatoEntity buscaUsuarioPorId(@PathVariable String id) {
	
		CandidatoEntity response = usuarioService.buscaUsuarioPorId(id);
		return response;
	}
	
	@PutMapping("{id}")
	public CandidatoEntity atualizaUsuario(@PathVariable String id, @RequestBody CriaCandidatoRequest request) {
		
		CandidatoEntity response = usuarioService.atualizaUsuario(id, request); 
		return response;
	}
	
	@PutMapping("/darLikeEmUsuario/{idUsuario}/{nomeEmpresa}")
	public ResponseEntity<Void> darLikeEmUsuario(@PathVariable String idUsuario, @PathVariable String nomeEmpresa) {
		usuarioService.darLikeEmUsuario(idUsuario, nomeEmpresa); 
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/naodarLikeEmUsuario/{idUsuario}/{nomeEmpresa}")
	public ResponseEntity<Void> naodarLikeEmUsuario(@PathVariable String idUsuario, @PathVariable String nomeEmpresa) {
		usuarioService.naodarLikeEmUsuario(idUsuario, nomeEmpresa); 
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/dispensarUsuario/{idUsuario}/{nomeEmpresa}")
	public ResponseEntity<Void> dispensarUsuario(@PathVariable String idUsuario, @PathVariable String nomeEmpresa) {
		usuarioService.dispensarUsuario(idUsuario, nomeEmpresa); 
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<DeleteCandidatoResponse> removeUsuario(@PathVariable String id) {
		
		DeleteCandidatoResponse response = usuarioService.removeUsuario(id);
		
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
	public List<CandidatoEntity> download() {

		List<CandidatoEntity> response = usuarioService.download();
		return response;
		
		}
	
}
