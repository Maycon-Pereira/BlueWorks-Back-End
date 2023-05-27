package com.bluetips.tcc.bluetips.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="Usuario_Vaga")
public class UsuarioVagaEntity {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(name="status_usuario")
	private String status_usuario;
	
	@Column(name="status_vaga")
	private String status_vaga;
	
	@Column(name="data_candidatura")
	private String data_candidatura;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private UsuarioEntity usuario;
	
	@ManyToOne
	@JoinColumn(name="vaga_id")
	private VagasEntity vaga;

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus_usuario() {
		return status_usuario;
	}

	public void setStatus_usuario(String status_usuario) {
		this.status_usuario = status_usuario;
	}

	public String getStatus_vaga() {
		return status_vaga;
	}

	public void setStatus_vaga(String status_vaga) {
		this.status_vaga = status_vaga;
	}

	public String getData_candidatura() {
		return data_candidatura;
	}

	public void setData_candidatura(String data_candidatura) {
		this.data_candidatura = data_candidatura;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public VagasEntity getVaga() {
		return vaga;
	}

	public void setVaga(VagasEntity vaga) {
		this.vaga = vaga;
	}
	
}
