package com.bluetips.tcc.bluetips.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bluetips.tcc.bluetips.domain.CriaCandidatoRequest;
import com.bluetips.tcc.bluetips.domain.CriaCandidatoResponse;
import com.bluetips.tcc.bluetips.domain.DeleteCandidatoResponse;
import com.bluetips.tcc.bluetips.entity.CandidatoEntity;
import com.bluetips.tcc.bluetips.repository.CandidatoRepository;

@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoRepository usuarioRepository;
	
	public CriaCandidatoResponse criaUsuario(CriaCandidatoRequest request) {
		
		CandidatoEntity usuarioEntity = new CandidatoEntity();
		
		usuarioEntity.setId(UUID.randomUUID().toString());
		
		usuarioEntity.setNome(request.getNome());
		usuarioEntity.setCpf(request.getCpf());
		usuarioEntity.setEscolaridade(request.getEscolaridade());
		usuarioEntity.setNascimento(request.getNascimento());
		usuarioEntity.setSobre(request.getSobre());
		usuarioEntity.setTelefone(request.getTelefone());
		usuarioEntity.setEmail(request.getEmail());
		usuarioEntity.setSenha(request.getSenha());
		usuarioEntity.setConfirmSenha(request.getConfirmSenha());
		usuarioEntity.setCep(request.getCep());
		usuarioEntity.setLogradouro(request.getLogradouro());
		usuarioEntity.setBairro(request.getBairro());
		usuarioEntity.setCidade(request.getCidade());
		usuarioEntity.setUf(request.getUf());
		usuarioEntity.setStatus_usuario(request.getStatus_usuario());
		
		CandidatoEntity saved = usuarioRepository.save(usuarioEntity);
		
		CriaCandidatoResponse criaUsuarioResponse = new CriaCandidatoResponse();
		criaUsuarioResponse.setId(saved.getId());
				
		return criaUsuarioResponse;
	}
	
	public List<CandidatoEntity> listaTodosUsuarios() {
		
		List<CandidatoEntity> usuarios = usuarioRepository.findAll();
		
		return usuarios;
	}
	
	public CandidatoEntity buscaUsuarioPorId(String id) {
		Optional<CandidatoEntity> procurado = usuarioRepository.findById(id);
		if(procurado.isPresent()) {
			CandidatoEntity usuarioEntity = procurado.get();
			return usuarioEntity;
		}else {
			return null;	
		}
	}
	
	public CandidatoEntity atualizaUsuario(String id, CriaCandidatoRequest request) {
	
		CandidatoEntity usuarioEntity = new CandidatoEntity();
		
		usuarioEntity.setId(id);
		
		usuarioEntity.setNome(request.getNome());
		usuarioEntity.setCpf(request.getCpf());
		usuarioEntity.setEscolaridade(request.getEscolaridade());
		usuarioEntity.setNascimento(request.getNascimento());
		usuarioEntity.setSobre(request.getSobre());
		usuarioEntity.setTelefone(request.getTelefone());
		usuarioEntity.setEmail(request.getEmail());
		usuarioEntity.setSenha(request.getSenha());
		usuarioEntity.setConfirmSenha(request.getConfirmSenha());
		usuarioEntity.setCep(request.getCep());
		usuarioEntity.setLogradouro(request.getLogradouro());
		usuarioEntity.setBairro(request.getBairro());
		usuarioEntity.setCidade(request.getCidade());
		usuarioEntity.setUf(request.getUf());
		usuarioEntity.setStatus_usuario(request.getStatus_usuario());
		
		CandidatoEntity saved = usuarioRepository.save(usuarioEntity);
		
		return saved;
	}
	
public void darLikeEmUsuario(String idUsuario, String nomeEmpresa) {
		
		Optional<CandidatoEntity> procurado = usuarioRepository.findById(idUsuario);
		if(!procurado.isPresent()) {
			throw new RuntimeException("usuario não encontrado");
		}
		
		CandidatoEntity usuarioEntity = procurado.get();
		usuarioEntity.setEmpresaDeuLike(true);
		
		String nomes = this.concatenaNomesEmpresa(usuarioEntity.getNomeEmpresas(), nomeEmpresa);
		
		usuarioEntity.setNomeEmpresas(nomes);
		
		usuarioRepository.save(usuarioEntity);
	}

public void naodarLikeEmUsuario(String idUsuario, String nomeEmpresa) {
	
	Optional<CandidatoEntity> procurado = usuarioRepository.findById(idUsuario);
	if(!procurado.isPresent()) {
		throw new RuntimeException("usuario não encontrado");
	}
	
	CandidatoEntity usuarioEntity = procurado.get();
	usuarioEntity.setEmpresaDeuLike(false);
	
	String nomes = this.concatenaNomesEmpresa(usuarioEntity.getNomeEmpresas(), nomeEmpresa);
	
	usuarioEntity.setNomeEmpresas(nomes);
	
	usuarioRepository.save(usuarioEntity);
}
	
public void dispensarUsuario(String idUsuario, String nomeEmpresa) {
	
	Optional<CandidatoEntity> procurado = usuarioRepository.findById(idUsuario);
	if(!procurado.isPresent()) {
		throw new RuntimeException("usuario não encontrado");
	}
	
	CandidatoEntity usuarioEntity = procurado.get();
	usuarioEntity.setUsuarioDipensado(true);
	
	String nomes = this.concatenaNomesEmpresa(usuarioEntity.getNomeEmpresas(), nomeEmpresa);
	
	usuarioEntity.setNomeEmpresas(nomes);
	
	usuarioRepository.save(usuarioEntity);
}


	private String concatenaNomesEmpresa(String nomeEmpresaAtual, String novoNomeEmpresa) {
		
		StringBuilder sb = new StringBuilder();
		if(nomeEmpresaAtual != null) {
			sb.append(nomeEmpresaAtual);
			sb.append(',');			
		}
		sb.append(novoNomeEmpresa);
		return sb.toString();
	}
	
	public DeleteCandidatoResponse removeUsuario(String id) {
		
		DeleteCandidatoResponse deleteUsuarioResponse = new DeleteCandidatoResponse();
		CandidatoEntity procurado = this.buscaUsuarioPorId(id);
		if(procurado == null) {
			deleteUsuarioResponse.setMensagem("Usuario não encontrada");
			deleteUsuarioResponse.setDeletado(false);
			return deleteUsuarioResponse;
		}else {
			try {
				usuarioRepository.deleteById(id);
				
				deleteUsuarioResponse.setMensagem("Usuario removido com sucesso!!!");
				deleteUsuarioResponse.setDeletado(true);
				return deleteUsuarioResponse;
			}catch(Exception erro) {
				throw new RuntimeException("Erro ao tentar remover um usuario!");
			}
		}
		
	}
	
	
	//IMAGEM UPLOAD E DOWNLOAD
		public void upload(MultipartFile file, String id) throws Exception {
			Optional<CandidatoEntity> procurado = usuarioRepository.findById(id);
			
			if(!procurado.isPresent()) {
				throw new RuntimeException("usuario não encontrado");
			}
			CandidatoEntity usuarioEntity = procurado.get();
			
			byte[] image = Base64.encodeBase64(file.getBytes());
			String imagemBase64 = new String(image);
			usuarioEntity.setFotoBase64(imagemBase64);
			// este sÃ© nosso insert na tabela Empresa:
			usuarioRepository.save(usuarioEntity);
		}

		public List<CandidatoEntity> download() {

			List<CandidatoEntity> lista = usuarioRepository.findAll();
			return lista;
			
		}
	
	
}
