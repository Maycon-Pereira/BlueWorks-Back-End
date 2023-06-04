package com.bluetips.tcc.bluetips.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bluetips.tcc.bluetips.entity.CandidatoEntity;
import com.bluetips.tcc.bluetips.entity.UsuarioVagaEntity;

@Repository
public interface CandidatoVagaRepository extends JpaRepository<UsuarioVagaEntity, CandidatoEntity>{

	//UsuarioVagaEntity findByCpf(UsuarioEntity usuario);
	

}
