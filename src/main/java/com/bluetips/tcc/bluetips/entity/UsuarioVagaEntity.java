package com.bluetips.tcc.bluetips.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Usuario_Vaga")
public class UsuarioVagaEntity {

	@Id
	@Column(name = "id", columnDefinition = "text")
	private String id;
	
	@Column(name="data_candidatura")
	private String data_candidatura;
	
	private String usuario_id;
	
	private String vaga_id;

	
	
	

	public String getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(String usuario_id) {
		this.usuario_id = usuario_id;
	}
	
	public String getVaga_id() {
		return vaga_id;
	}

	public void setVaga_id(String vaga_id) {
		this.vaga_id = vaga_id;
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
