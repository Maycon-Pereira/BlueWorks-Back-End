package com.bluetips.tcc.bluetips.domain;

import lombok.Data;

@Data
public class CriaUsuarioRequest {

	private String nome;
	private String cpf;
	private String escolaridade;
	private String data; //data de nascimento
	private String sobre;
	private String telefone;
	private String email;
	private String senha;
	
	//INICIO DO OBJETO ENDERECO (private Endereco endereco)
	private String cep;
	private String bairro;
	private String cidade;
	private String uf;
	//FIM DO OBJETO ENDERECO
	
}
