package com.bluetips.tcc.bluetips.domain;

public class DeleteCandidatoResponse {

	private String mensagem;
	private boolean deletado;

	public boolean isDeletado() {
		return deletado;
	}

	public void setDeletado(boolean removeu) {
		this.deletado = removeu;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
