package com.bluetips.tcc.bluetips.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluetips.tcc.bluetips.domain.LoginRequest;
import com.bluetips.tcc.bluetips.domain.LoginResponse;
import com.bluetips.tcc.bluetips.entity.CandidatoEntity;
import com.bluetips.tcc.bluetips.entity.EmpresaEntity;
import com.bluetips.tcc.bluetips.repository.CandidatoRepository;
import com.bluetips.tcc.bluetips.repository.EmpresaRepository;

@Transactional
@Service
public class LoginService {

	@Autowired
	EmpresaRepository empresaRepository;
	@Autowired
	CandidatoRepository candidatoRepository;
	
	public LoginResponse efetuaLoginEmpresa(LoginRequest loginRequest) {
		EmpresaEntity empresa = empresaRepository.findByEmailAndSenha(loginRequest.getEmail(), loginRequest.getSenha());
		if(empresa != null) {
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setId(empresa.getId());
			return loginResponse;
		}
		
		return null;
	}
	public boolean efetuaLoginCandidato(LoginRequest loginRequest) {
		
		CandidatoEntity candidato = candidatoRepository.findByEmailAndSenha(loginRequest.getEmail(), loginRequest.getSenha());
		if(candidato != null) {
			return true;
		}
		
		return false;
	}
	
}
