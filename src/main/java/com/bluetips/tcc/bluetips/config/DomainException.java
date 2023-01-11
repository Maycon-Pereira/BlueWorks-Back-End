package com.bluetips.tcc.bluetips.config;


public class DomainException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String mensagem;
	
    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMensagem() {
		return mensagem;
	}

	public Throwable getCausa() {
		return causa;
	}

	private Throwable causa;

    public DomainException(String mensagem) {
        super(mensagem);
        this.mensagem = mensagem;
    }

    public DomainException(String mensagem, Throwable causa) {
        super(mensagem, causa);
        this.mensagem = mensagem;
        this.causa = causa;
    }
}
