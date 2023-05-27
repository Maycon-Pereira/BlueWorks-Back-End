package com.bluetips.tcc.bluetips.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bluetips.tcc.bluetips.domain.CriaVagasRequest;
import com.bluetips.tcc.bluetips.domain.CriaVagasResponse;
import com.bluetips.tcc.bluetips.domain.DeletaVagaResponse;
import com.bluetips.tcc.bluetips.domain.EmpresaVagaRequest;
import com.bluetips.tcc.bluetips.entity.EmpresaVagaEntity;
import com.bluetips.tcc.bluetips.entity.VagasEntity;
import com.bluetips.tcc.bluetips.repository.EmpresaVagaRepository;
import com.bluetips.tcc.bluetips.repository.VagasRepository;

@Service
public class VagasService {

	@Autowired
	private VagasRepository vagasRepository;
	
	@Autowired
	private EmpresaVagaRepository empresaVagaRepository;
	
	public CriaVagasResponse criaVagas(CriaVagasRequest request, EmpresaVagaRequest requestEmpresaVaga) {
		
		VagasEntity vagasEntity = new VagasEntity();
		EmpresaVagaEntity empresaVagaEntity = new EmpresaVagaEntity();
		
		vagasEntity.setId(UUID.randomUUID().toString());
		
		vagasEntity.setNome(request.getNome());
		vagasEntity.setTipo(request.getTipo());
		vagasEntity.setQtda(request.getQtda());
		vagasEntity.setData_publicacao(request.getData_publicacao());
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
		
		empresaVagaEntity.setId(UUID.randomUUID().toString());
		empresaVagaEntity.setStatus_empresa(requestEmpresaVaga.getStatus_empresa());
		empresaVagaEntity.setStatus_vaga(requestEmpresaVaga.getStatus_vaga());
		empresaVagaEntity.setData_cadastro_vaga(requestEmpresaVaga.getData_cadastro_vaga());
		empresaVagaEntity.setEmpresa(requestEmpresaVaga.getEmpresa());
		empresaVagaEntity.setVaga(savedVagasEntity);// Associa a vaga à empresa
		
		
		EmpresaVagaEntity savedEmpresaVagaEntity = empresaVagaRepository.save(empresaVagaEntity);
		
		
		CriaVagasResponse criaVagasResponse = new CriaVagasResponse();
		
		criaVagasResponse.setId(savedEmpresaVagaEntity.getId());
				
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
		vagasEntity.setData_publicacao(request.getData_publicacao());
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
					throw new RuntimeException("usuario não encontrado");
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
