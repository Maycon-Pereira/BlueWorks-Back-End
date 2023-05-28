package com.bluetips.tcc.bluetips.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bluetips.tcc.bluetips.domain.CriaVagasRequest;
import com.bluetips.tcc.bluetips.domain.CriaVagasResponse;
import com.bluetips.tcc.bluetips.domain.DeletaVagaResponse;
import com.bluetips.tcc.bluetips.entity.EmpresaEntity;
import com.bluetips.tcc.bluetips.entity.VagasEntity;
import com.bluetips.tcc.bluetips.repository.EmpresaRepository;
import com.bluetips.tcc.bluetips.repository.VagasRepository;
import com.bluetips.tcc.bluetips.util.DataUtil;

@Service
public class VagasService {

	@Autowired
	private VagasRepository vagasRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public CriaVagasResponse criaVagas(CriaVagasRequest request) {
	
		Optional<EmpresaEntity> procurado = empresaRepository.findById(request.getId_empresa());
		if(!procurado.isPresent()) {
			throw new EntityNotFoundException("Id da empresa informado não existe");
		}
		
		VagasEntity vagasEntity = new VagasEntity();
		vagasEntity.setId(UUID.randomUUID().toString());
		vagasEntity.setId_empresa(request.getId_empresa());
		vagasEntity.setNome(request.getNome());
		vagasEntity.setTipo(request.getTipo());
		vagasEntity.setQtda(request.getQtda());
		vagasEntity.setData_publicacao(DataUtil.getDataAtualFormatada());
		vagasEntity.setSalario(request.getSalario());
		vagasEntity.setEscolaridade(request.getEscolaridade());
		vagasEntity.setArea(request.getArea());
		vagasEntity.setExigencias(request.getExigencias());
		vagasEntity.setValorizado(request.getValorizado());
		vagasEntity.setContrato(request.getContrato());
		vagasEntity.setSobre(request.getSobre());
		vagasEntity.setCnpj(request.getCnpj());
//		vagasEntity.setSenha(request.getSenha());
		vagasEntity.setCep(request.getCep());
		vagasEntity.setLogradouro(request.getLogradouro());
		vagasEntity.setBairro(request.getBairro());
		vagasEntity.setUf(request.getUf());
		vagasEntity.setCidade(request.getCidade());
		vagasEntity.setStatus_vaga(request.getStatus_vaga());
		
		//Salva os dados do relacionamento entre a empresa e a vaga
		VagasEntity savedVagasEntity = vagasRepository.save(vagasEntity);
		
		CriaVagasResponse criaVagasResponse = new CriaVagasResponse();
		criaVagasResponse.setId(savedVagasEntity.getId());
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
		
		Optional<VagasEntity> procurado = vagasRepository.findById(id);
		
		if(!procurado.isPresent()) {
			throw new RuntimeException("Vaga não encontrada");
		}
		VagasEntity vagasEntity = procurado.get();
		vagasEntity.setNome(request.getNome());
		vagasEntity.setTipo(request.getTipo());
		vagasEntity.setQtda(request.getQtda());
		vagasEntity.setData_atualizacao(DataUtil.getDataAtualFormatada());
		vagasEntity.setSalario(request.getSalario());
		vagasEntity.setEscolaridade(request.getEscolaridade());
		vagasEntity.setArea(request.getArea());
		vagasEntity.setExigencias(request.getExigencias());
		vagasEntity.setValorizado(request.getValorizado());
		vagasEntity.setContrato(request.getContrato());
		vagasEntity.setSobre(request.getSobre());
		vagasEntity.setCnpj(request.getCnpj());
//		vagasEntity.setSenha(request.getSenha());
		vagasEntity.setCep(request.getCep());
		vagasEntity.setLogradouro(request.getLogradouro());
		vagasEntity.setBairro(request.getBairro());
		vagasEntity.setUf(request.getUf());
		vagasEntity.setCidade(request.getCidade());
		vagasEntity.setStatus_vaga(request.getStatus_vaga());
		
		//neste caso sempre será um "update" porque o id já existe
		VagasEntity saved = vagasRepository.save(vagasEntity);
		
		return saved;
	}
	
	public DeletaVagaResponse removeVagas(String id) {
		
		DeletaVagaResponse deletaVagaResponse = new DeletaVagaResponse();
		VagasEntity procurado = this.buscaVagasPorId(id);
		if(procurado == null) {
			deletaVagaResponse.setMensagem("Vaga não encontrada");
			deletaVagaResponse.setDeletado(false);
			return deletaVagaResponse;
		}else {
			try {
				vagasRepository.deleteById(id);
				
				deletaVagaResponse.setMensagem("Vaga removida com sucesso!!!");
				deletaVagaResponse.setDeletado(true);
				return deletaVagaResponse;
			}catch(Exception erro) {
				throw new RuntimeException("Erro ao tentar remover uma vaga");
			}
		}
		
	}
	
	//IMAGEM UPLOAD E DOWNLOAD
			public void upload(MultipartFile file, String id) throws Exception {
				Optional<VagasEntity> procurado = vagasRepository.findById(id);
				
				if(!procurado.isPresent()) {
					throw new RuntimeException("Vaga não encontrada");
				}
				VagasEntity vagasEntity = procurado.get();
				
				
				byte[] image = Base64.encodeBase64(file.getBytes());
				String imagemBase64 = new String(image);
				vagasEntity.setFotoBase64(imagemBase64);
				// este sÃ© nosso insert na tabela Empresa:
				vagasRepository.save(vagasEntity);
			}

			public List<VagasEntity> download() {

				List<VagasEntity> lista = vagasRepository.findAll();
				return lista;
				
			}	
	
}
