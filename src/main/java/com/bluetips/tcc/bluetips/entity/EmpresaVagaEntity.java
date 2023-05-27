package com.bluetips.tcc.bluetips.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="Empresa_Vaga")
public class EmpresaVagaEntity {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(name="status_empresa")
	private String status_empresa;
	
	@Column(name="status_vaga")
	private String status_vaga;
	
	@Column(name="data_cadastro_vaga")
	private String data_cadastro_vaga;
	
	@ManyToOne
	@JoinColumn(name="empresa_id")
	private EmpresaEntity empresa;
	
	@ManyToOne
	@JoinColumn(name="vaga_id")
	private VagasEntity vaga;
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
