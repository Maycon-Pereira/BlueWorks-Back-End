package com.bluetips.tcc.bluetips.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluetips.tcc.bluetips.domain.CriaVagasRequest;
import com.bluetips.tcc.bluetips.domain.CriaVagasResponse;
import com.bluetips.tcc.bluetips.entity.VagasEntity;
import com.bluetips.tcc.bluetips.repository.VagasRepository;

@Service
public class VagasService {

	@Autowired
	private VagasRepository vagasRepository;
	
	public CriaVagasResponse criaVagas(CriaVagasRequest request) {
		
		VagasEntity vagasEntity = new VagasEntity();
		
		vagasEntity.setId(UUID.randomUUID().toString());
		
		vagasEntity.setNome(request.getNome());
		vagasEntity.setTipo(request.getTipo());
		vagasEntity.setQtda(request.getQtda());
		vagasEntity.setSalario(request.getSalario());
		vagasEntity.setEscolaridade(request.getEscolaridade());
		vagasEntity.setSobre(request.getSobre());
		vagasEntity.setCnpj(request.getCnpj());
		vagasEntity.setSenha(request.getSenha());
		vagasEntity.setCep(request.getCep());
		vagasEntity.setLogradouro(request.getLogradouro());
		vagasEntity.setBairro(request.getBairro());
		vagasEntity.setUf(request.getUf());
		vagasEntity.setCidade(request.getCidade());
		
		VagasEntity saved = vagasRepository.save(vagasEntity);
		
		CriaVagasResponse criaVagasResponse = new CriaVagasResponse();
		
		criaVagasResponse.setId(saved.getId());
				
		return criaVagasResponse;	
	}
	
	public List<VagasEntity> listaTodasVagas(){
		
		List<VagasEntity> vagas = vagasRepository.findAll();
		
		return vagas;
	}
	
	public VagasEntity buscaVagasPorId(String id) {
		
		Optional<VagasEntity> procurado = vagasRepository.findById(id);
		if(procurado.isPresent()) {
			VagasEntity vagasEntity = procurado.get();
			return vagasEntity;
		}else {
			return null;	
		}
		
		
	}
	
	public VagasEntity atualizaVagas(String id, CriaVagasRequest request) {
		
		VagasEntity vagasEntity = new VagasEntity();
		
		vagasEntity.setId(id);
		
		vagasEntity.setNome(request.getNome());
		vagasEntity.setTipo(request.getTipo());
		vagasEntity.setQtda(request.getQtda());
		vagasEntity.setSalario(request.getSalario());
		vagasEntity.setEscolaridade(request.getEscolaridade());
		vagasEntity.setSobre(request.getSobre());
		vagasEntity.setCnpj(request.getCnpj());
		vagasEntity.setSenha(request.getSenha());
		vagasEntity.setCep(request.getCep());
		vagasEntity.setLogradouro(request.getLogradouro());
		vagasEntity.setBairro(request.getBairro());
		vagasEntity.setUf(request.getUf());
		vagasEntity.setCidade(request.getCidade());
		
		VagasEntity saved = vagasRepository.save(vagasEntity);
		
		return saved;
	}
	
	public String removeVagas(String id) {
		
		VagasEntity procurado = this.buscaVagasPorId(id);
		if(procurado == null) {
			return "Vaga não encontrada";
		}else {
			try {
				vagasRepository.deleteById(id);
				return "Vaga removida com sucesso!!!";
			}catch(Exception erro) {
				throw new RuntimeException("Erro ao tentar deletar uma vaga");
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
