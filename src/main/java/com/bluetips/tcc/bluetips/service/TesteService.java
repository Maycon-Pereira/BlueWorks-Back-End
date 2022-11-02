package com.bluetips.tcc.bluetips.service;

import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bluetips.tcc.bluetips.entity.TesteEntity;
import com.bluetips.tcc.bluetips.repository.TesteRepository;

@Service
public class TesteService {

	@Autowired
	private TesteRepository testeRepository;

	public void upload(MultipartFile file) throws Exception {
		byte[] image = Base64.encodeBase64(file.getBytes());
		String imagemBase64 = new String(image);
		TesteEntity tabelaUsuario = new TesteEntity();
		tabelaUsuario.setFotoBase64(imagemBase64);
		// este sÃ© nosso insert na tabela Usuario:
		testeRepository.save(tabelaUsuario);
	}

	public String download(Long idDoUsuario) {

		Optional<TesteEntity> usuarioProcurado = testeRepository.findById(idDoUsuario);
		if(usuarioProcurado.isPresent()){
			TesteEntity tabelaUsuario = usuarioProcurado.get();
			String fotoBase64 = tabelaUsuario.getFotoBase64();
			return fotoBase64;
		}else{
			return "Usuario não encontrado";
		}
	}

}

