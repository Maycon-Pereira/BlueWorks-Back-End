package com.bluetips.tcc.bluetips.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bluetips.tcc.bluetips.entity.UsuarioEntity;
import com.bluetips.tcc.bluetips.entity.UsuarioVagaEntity;

@Repository
public interface UsuarioVagaRepository extends JpaRepository<UsuarioVagaEntity, UsuarioEntity>{

	//UsuarioVagaEntity findByCpf(UsuarioEntity usuario);
	

}
