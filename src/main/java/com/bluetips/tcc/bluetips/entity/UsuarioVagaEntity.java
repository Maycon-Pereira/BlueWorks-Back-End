package com.bluetips.tcc.bluetips.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity(name="Usuario_Vaga")
public class UsuarioVagaEntity {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(name="data_candidatura")
	private String data_candidatura;
	
	@JoinColumn(name="usuario_id")
	private String usuario;
	
	@JoinColumn(name="vaga_id")
	private String vaga;

	
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getVaga() {
		return vaga;
	}

	public void setVaga(String vaga) {
		this.vaga = vaga;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getData_candidatura() {
		return data_candidatura;
	}

	public void setData_candidatura(String data_candidatura) {
		this.data_candidatura = data_candidatura;
	}
	
}
