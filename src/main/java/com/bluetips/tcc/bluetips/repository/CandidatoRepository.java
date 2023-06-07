package com.bluetips.tcc.bluetips.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bluetips.tcc.bluetips.entity.CandidatoEntity;

@Repository
public interface CandidatoRepository extends JpaRepository<CandidatoEntity, String>{
	
	CandidatoEntity findByCpf(String cpf);
	
	CandidatoEntity findByEmailAndSenha(String email, String senha);
}
