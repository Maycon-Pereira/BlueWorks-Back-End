package com.bluetips.tcc.bluetips.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluetips.tcc.bluetips.domain.CriaUsuarioRequest;
import com.bluetips.tcc.bluetips.domain.CriaUsuarioResponse;
import com.bluetips.tcc.bluetips.entity.UsuarioEntity;
import com.bluetips.tcc.bluetips.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public CriaUsuarioResponse criaUsuario(CriaUsuarioRequest request) {
		
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		
		usuarioEntity.setId(UUID.randomUUID().toString());
		
		usuarioEntity.setNome(request.getNome());
		usuarioEntity.setCpf(request.getCpf());
		usuarioEntity.setEscolaridade(request.getEscolaridade());
		usuarioEntity.setData(request.getData());
		usuarioEntity.setSobre(request.getSobre());
		usuarioEntity.setTelefone(request.getTelefone());
		usuarioEntity.setEmail(request.getEmail());
		usuarioEntity.setSenha(request.getSenha());
		usuarioEntity.setCep(request.getCep());
		usuarioEntity.setBairro(request.getBairro());
		usuarioEntity.setCidade(request.getCidade());
		usuarioEntity.setUf(request.getUf());
		
		UsuarioEntity saved = usuarioRepository.save(usuarioEntity);
		
		CriaUsuarioResponse criaUsuarioResponse = new CriaUsuarioResponse();
		criaUsuarioResponse.setId(saved.getId());
				
		return criaUsuarioResponse;
	}
	
	public List<UsuarioEntity> listaTodosUsuarios() {
		
		List<UsuarioEntity> usuarios = usuarioRepository.findAll();
		
		return usuarios;
	}
	
	public UsuarioEntity buscaUsuarioPorId(String id) {
		Optional<UsuarioEntity> procurado = usuarioRepository.findById(id);
		if(procurado.isPresent()) {
			UsuarioEntity usuarioEntity = procurado.get();
			return usuarioEntity;
		}else {
			return null;	
		}
	}
	
	public UsuarioEntity atualizaUsuario(String id, CriaUsuarioRequest request) {
	
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		
		usuarioEntity.setId(id);
		
		usuarioEntity.setNome(request.getNome());
		usuarioEntity.setCpf(request.getCpf());
		usuarioEntity.setEscolaridade(request.getEscolaridade());
		usuarioEntity.setData(request.getData());
		usuarioEntity.setSobre(request.getSobre());
		usuarioEntity.setTelefone(request.getTelefone());
		usuarioEntity.setEmail(request.getEmail());
		usuarioEntity.setSenha(request.getSenha());
		usuarioEntity.setCep(request.getCep());
		usuarioEntity.setBairro(request.getBairro());
		usuarioEntity.setCidade(request.getCidade());
		usuarioEntity.setUf(request.getUf());
		
		UsuarioEntity saved = usuarioRepository.save(usuarioEntity);
		
		return saved;
	}
	
	public String removeUsuario(String id) {
		
		UsuarioEntity procurado = this.buscaUsuarioPorId(id);
		if(procurado == null) {
			return "Usuario não encontrado";
		}else {
			try {
				usuarioRepository.deleteById(id);
				return "Usuario Removido com sucesso!!!";
			}catch(Exception erro) {
				throw new RuntimeException("Erro ao tentar deletar um usuario!");
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
