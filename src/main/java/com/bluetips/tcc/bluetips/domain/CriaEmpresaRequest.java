package com.bluetips.tcc.bluetips.domain;

import lombok.Data;

@Data
public class CriaEmpresaRequest {

	private String nome;
	private String cnpj;
	private String porte;
	private String sobre;
	private String telefone;
	private String email;
	private String senha;
	
	//INICIO DO OBJETO ENDERECO (private Endereco endereco)
	private String cep;
	private String logradouro;
	private String bairro;
	private String uf;
	private String cidade;
	//FIM DO OBJETO ENDERECO

}
