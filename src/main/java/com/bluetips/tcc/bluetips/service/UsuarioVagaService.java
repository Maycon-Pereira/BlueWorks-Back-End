package com.bluetips.tcc.bluetips.service;

import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluetips.tcc.bluetips.domain.CriaUsuarioVagaRequest;
import com.bluetips.tcc.bluetips.domain.CriaUsuarioVagaResponse;
import com.bluetips.tcc.bluetips.entity.UsuarioEntity;
import com.bluetips.tcc.bluetips.entity.UsuarioVagaEntity;
import com.bluetips.tcc.bluetips.entity.VagasEntity;
import com.bluetips.tcc.bluetips.repository.UsuarioRepository;
import com.bluetips.tcc.bluetips.repository.UsuarioVagaRepository;
import com.bluetips.tcc.bluetips.repository.VagasRepository;
import com.bluetips.tcc.bluetips.util.DataUtil;

@Service
public class UsuarioVagaService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private VagasRepository vagasRepository;
	
	@Autowired
	private UsuarioVagaRepository usuarioVagaRepository;
	
	public CriaUsuarioVagaResponse criaCandidatura(CriaUsuarioVagaRequest request) {

		Optional<UsuarioEntity> usuarioProcurado = usuarioRepository.findById(request.getIdUsuario());
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
		usuarioVagaEntity.setUsuario(request.getIdUsuario());
		usuarioVagaEntity.setVaga(request.getIdVaga());
		
		UsuarioVagaEntity saved = usuarioVagaRepository.save(usuarioVagaEntity);
		
		CriaUsuarioVagaResponse response = new CriaUsuarioVagaResponse();
		response.setId(saved.getId());
		
		return response;
	}
	
}
