package com.bluetips.tcc.bluetips.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bluetips.tcc.bluetips.entity.EmpresaEntity;
import com.bluetips.tcc.bluetips.entity.EmpresaVagaEntity;

@Repository
public interface EmpresaVagaRepository extends JpaRepository<EmpresaVagaEntity, EmpresaEntity>{

	//EmpresaVagaEntity findById(EmpresaEntity id);
}
