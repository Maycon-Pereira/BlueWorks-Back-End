package com.bluetips.tcc.bluetips.domain;

import javax.validation.constraints.NotEmpty;

public class CriaUsuarioVagaRequest {
	
	@NotEmpty
	private String idUsuario;
	
	@NotEmpty
	private String idVaga;

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getIdVaga() {
		return idVaga;
	}

	public void setIdVaga(String idVaga) {
		this.idVaga = idVaga;
	}

}
