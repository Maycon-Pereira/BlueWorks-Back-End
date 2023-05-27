package com.bluetips.tcc.bluetips.domain;

import javax.validation.constraints.NotEmpty;

import com.bluetips.tcc.bluetips.entity.EmpresaEntity;
import com.bluetips.tcc.bluetips.entity.VagasEntity;

public class EmpresaVagaRequest {

	@NotEmpty(message="O status_empresa não pode estar vazio.")
	private String status_empresa;
	
	@NotEmpty(message="O status_vaga não pode estar vazio.")
	private String status_vaga;
	
	@NotEmpty(message="A data_cadastro_vaga não pode estar vazio.")
	private String data_cadastro_vaga;
	
	@NotEmpty(message="A empresa não pode estar vazio.")
	private EmpresaEntity empresa;
	
	@NotEmpty(message="A vaga não pode estar vazio.")
	private VagasEntity vaga;
	
	
	
	
	public String getStatus_empresa() {
		return status_empresa;
	}
	public void setStatus_empresa(String status_empresa) {
		this.status_empresa = status_empresa;
	}
	public String getStatus_vaga() {
		return status_vaga;
	}
	public void setStatus_vaga(String status_vaga) {
		this.status_vaga = status_vaga;
	}
	public String getData_cadastro_vaga() {
		return data_cadastro_vaga;
	}
	public void setData_cadastro_vaga(String data_cadastro_vaga) {
		this.data_cadastro_vaga = data_cadastro_vaga;
	}
	public EmpresaEntity getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
	}
	public VagasEntity getVaga() {
		return vaga;
	}
	public void setVaga(VagasEntity vaga) {
		this.vaga = vaga;
	}
	
	
}
