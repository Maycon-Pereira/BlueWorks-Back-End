package com.bluetips.tcc.bluetips.domain;

import lombok.Data;

@Data
public class CriaVagasRequest {
	
	private String nome;
	private String tipo;
	private String qtda;
	private String salario;
	private String escolaridade;
	private String sobre;
	private String cnpj;
	private String senha;
	
	//INICIO DO OBJETO ENDERECO (private Endereco endereco)
	private String cep;
	private String logradouro;
	private String bairro;
	private String uf;
	private String cidade;
	//FIM DO OBJETO ENDERECO

}
