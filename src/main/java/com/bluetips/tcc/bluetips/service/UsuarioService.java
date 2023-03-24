package com.bluetips.tcc.bluetips.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bluetips.tcc.bluetips.domain.CriaUsuarioRequest;
import com.bluetips.tcc.bluetips.domain.CriaUsuarioResponse;
import com.bluetips.tcc.bluetips.domain.DeleteUsuarioResponse;
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
		
		UsuarioEntity saved = usuarioRepository.save(usuarioEntity);
		
		return saved;
	}
	
public void darLikeEmUsuario(String idUsuario, String nomeEmpresa) {
		
		Optional<UsuarioEntity> procurado = usuarioRepository.findById(idUsuario);
		if(!procurado.isPresent()) {
			throw new RuntimeException("usuario não encontrado");
		}
		
		UsuarioEntity usuarioEntity = procurado.get();
		usuarioEntity.setEmpresaDeuLike(true);
		
		String nomes = this.concatenaNomesEmpresa(usuarioEntity.getNomeEmpresas(), nomeEmpresa);
		
		usuarioEntity.setNomeEmpresas(nomes);
		
		usuarioRepository.save(usuarioEntity);
	}

public void naodarLikeEmUsuario(String idUsuario, String nomeEmpresa) {
	
	Optional<UsuarioEntity> procurado = usuarioRepository.findById(idUsuario);
	if(!procurado.isPresent()) {
		throw new RuntimeException("usuario não encontrado");
	}
	
	UsuarioEntity usuarioEntity = procurado.get();
	usuarioEntity.setEmpresaDeuLike(false);
	
	String nomes = this.concatenaNomesEmpresa(usuarioEntity.getNomeEmpresas(), nomeEmpresa);
	
	usuarioEntity.setNomeEmpresas(nomes);
	
	usuarioRepository.save(usuarioEntity);
}
	
public void dispensarUsuario(String idUsuario, String nomeEmpresa) {
	
	Optional<UsuarioEntity> procurado = usuarioRepository.findById(idUsuario);
	if(!procurado.isPresent()) {
		throw new RuntimeException("usuario não encontrado");
	}
	
	UsuarioEntity usuarioEntity = procurado.get();
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
	
	public DeleteUsuarioResponse removeUsuario(String id) {
		
		DeleteUsuarioResponse deleteUsuarioResponse = new DeleteUsuarioResponse();
		UsuarioEntity procurado = this.buscaUsuarioPorId(id);
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
			Optional<UsuarioEntity> procurado = usuarioRepository.findById(id);
			
			if(!procurado.isPresent()) {
				throw new RuntimeException("usuario não encontrado");
			}
			UsuarioEntity usuarioEntity = procurado.get();
			
			byte[] image = Base64.encodeBase64(file.getBytes());
			String imagemBase64 = new String(image);
			usuarioEntity.setFotoBase64(imagemBase64);
			// este sÃ© nosso insert na tabela Empresa:
			usuarioRepository.save(usuarioEntity);
		}

		public List<UsuarioEntity> download() {

			List<UsuarioEntity> lista = usuarioRepository.findAll();
			return lista;
			
		}
	
	
}
