package com.bluetips.tcc.bluetips.service;

import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluetips.tcc.bluetips.domain.CriaCandidatoVagaRequest;
import com.bluetips.tcc.bluetips.domain.CriaCandidatoVagaResponse;
import com.bluetips.tcc.bluetips.entity.CandidatoEntity;
import com.bluetips.tcc.bluetips.entity.UsuarioVagaEntity;
import com.bluetips.tcc.bluetips.entity.VagasEntity;
import com.bluetips.tcc.bluetips.repository.CandidatoRepository;
import com.bluetips.tcc.bluetips.repository.CandidatoVagaRepository;
import com.bluetips.tcc.bluetips.repository.VagasRepository;
import com.bluetips.tcc.bluetips.util.DataUtil;

@Service
public class CandidatoVagaService {

	@Autowired
	private CandidatoRepository usuarioRepository;

	@Autowired
	private VagasRepository vagasRepository;
	
	@Autowired
	private CandidatoVagaRepository usuarioVagaRepository;
	
	public CriaCandidatoVagaResponse criaCandidatura(CriaCandidatoVagaRequest request) {

		Optional<CandidatoEntity> usuarioProcurado = usuarioRepository.findById(request.getIdUsuario());
		if(!usuarioProcurado.isPresent()) {
			throw new EntityNotFoundException("Usuario não encontrado");
		}
		Optional<VagasEntity> vagaProcurada = vagasRepository.findById(request.getIdVaga());
		if(!vagaProcurada.isPresent()) {
			throw new EntityNotFoundException("Vaga não encontrada");
		}
		
		UsuarioVagaEntity usuarioVagaEntity = new UsuarioVagaEntity();
		usuarioVagaEntity.setId(UUID.randomUUID().toString());
		usuarioVagaEntity.setData_candidatura(DataUtil.getDataAtualFormatada());
		usuarioVagaEntity.setUsuario_id(request.getIdUsuario());
		usuarioVagaEntity.setVaga_id(request.getIdVaga());
		
		UsuarioVagaEntity saved = usuarioVagaRepository.save(usuarioVagaEntity);
		
		CriaCandidatoVagaResponse response = new CriaCandidatoVagaResponse();
		response.setId(saved.getId());
		
		return response;
	}
	
}
