package com.bluetips.tcc.bluetips.config;

import java.util.Map;

public class ApiErro {
	
	private Map<String, String> erros;
	private String timestamp;
	
	public ApiErro(Map<String, String> erros) {
		this.erros = erros;
		String dataAtualFormatada = FormatacaoDataUtil.getDataAtualFormatada();
		this.timestamp = dataAtualFormatada;
	}
}
