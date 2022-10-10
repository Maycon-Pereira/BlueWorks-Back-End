package com.bluetips.tcc.bluetips.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluetips.tcc.bluetips.domain.CriaEmpresaRequest;
import com.bluetips.tcc.bluetips.domain.CriaEmpresaResponse;
import com.bluetips.tcc.bluetips.entity.EmpresaEntity;
import com.bluetips.tcc.bluetips.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public CriaEmpresaResponse criaEmpesa(CriaEmpresaRequest request) {

		EmpresaEntity empresaEntity = new EmpresaEntity();
		
		empresaEntity.setId(UUID.randomUUID().toString());
		
		empresaEntity.setNome(request.getNome());
		empresaEntity.setCnpj(request.getCnpj());
		empresaEntity.setPorte(request.getPorte());
		empresaEntity.setSobre(request.getSobre());
		empresaEntity.setTelefone(request.getTelefone());
		empresaEntity.setEmail(request.getEmail());
		empresaEntity.setSenha(request.getSenha());
		empresaEntity.setCep(request.getCep());
		empresaEntity.setLogradouro(request.getLogradouro());
		empresaEntity.setBairro(request.getBairro());
		empresaEntity.setUf(request.getUf());
		empresaEntity.setCidade(request.getCidade());

		//sempre vai inserir pq estamos gerando um ID aleatoriamente
		EmpresaEntity saved = empresaRepository.save(empresaEntity);
		
		CriaEmpresaResponse criaEmpresaResponse = new CriaEmpresaResponse();
		criaEmpresaResponse.setId(saved.getId());
		
		return criaEmpresaResponse;
	}
	
	
	public List<EmpresaEntity> listaTodasEmpresas() {
		
		List<EmpresaEntity> empresas = empresaRepository.findAll();
		
		return empresas;
	}
	
	public EmpresaEntity buscaEmpesaPorId(String id) {
		
		Optional<EmpresaEntity> procurado = empresaRepository.findById(id);
		if(procurado.isPresent()) {
			EmpresaEntity empresaEntity = procurado.get();
			return empresaEntity;
		}else {
			return null;
		}
		
	}
	
	public EmpresaEntity atualizaEmpresa(String id, CriaEmpresaRequest request) {
		
		EmpresaEntity empresaEntity = new EmpresaEntity();
		
		empresaEntity.setId(id);
		
		empresaEntity.setNome(request.getNome());
		empresaEntity.setCnpj(request.getCnpj());
		empresaEntity.setPorte(request.getPorte());
		empresaEntity.setSobre(request.getSobre());
		empresaEntity.setTelefone(request.getTelefone());
		empresaEntity.setEmail(request.getEmail());
		empresaEntity.setSenha(request.getSenha());
		empresaEntity.setCep(request.getCep());
		empresaEntity.setLogradouro(request.getLogradouro());
		empresaEntity.setBairro(request.getBairro());
		empresaEntity.setUf(request.getUf());
		empresaEntity.setCidade(request.getCidade());

		//sempre vai ATUALIZAR pq estamos recebendo um ID por paramentro
		EmpresaEntity saved = empresaRepository.save(empresaEntity);
		
		return saved;
	}
	
	public String removeEmpresa(String id) {
		
		EmpresaEntity procurado = this.buscaEmpesaPorId(id);
		if(procurado == null) {
			return "Empresa não encontrada";
		}else {
			try {
				empresaRepository.deleteById(id);
				return "Empresa removida com sucesso!!!";
			}catch(Exception erro) {
				throw new RuntimeException("Erro a tentar deletar uma empresa");
			}	
		}
		
	}
	
}
