package com.bluetips.tcc.bluetips.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluetips.tcc.bluetips.domain.LoginRequest;
import com.bluetips.tcc.bluetips.domain.LoginResponse;
import com.bluetips.tcc.bluetips.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping("/efetuaLoginEmpresa")
	public ResponseEntity<LoginResponse> efetuaLoginEmpresa(@Valid @RequestBody LoginRequest request) {
		
		LoginResponse response = loginService.efetuaLoginEmpresa(request);
		
		if(response == null) {
			return new ResponseEntity<LoginResponse>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<LoginResponse>(response, HttpStatus.OK);
	}
	
	
	@PostMapping("/efetuaLoginCandidato")
	public ResponseEntity<Void> efetuaLoginCandidato(@Valid @RequestBody LoginRequest request) {
		
		boolean sucesso = loginService.efetuaLoginCandidato(request);
		
		if(sucesso) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	

}
