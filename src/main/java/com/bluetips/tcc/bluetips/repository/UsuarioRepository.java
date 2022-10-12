package com.bluetips.tcc.bluetips.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bluetips.tcc.bluetips.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String>{
	
	UsuarioEntity findByCpf(String cpf);
}
