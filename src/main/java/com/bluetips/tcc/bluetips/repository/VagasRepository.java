package com.bluetips.tcc.bluetips.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bluetips.tcc.bluetips.entity.VagasEntity;

@Repository
public interface VagasRepository extends JpaRepository<VagasEntity, String>{

	VagasEntity findByCnpj(String cnpj);
	
}
