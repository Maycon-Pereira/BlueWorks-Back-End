package com.bluetips.tcc.bluetips.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="tabela_Usuario")//UsuarioEntity=representa a tabela no banco de dados
public class UsuarioEntity {

	@Id
	private String id;
	
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
