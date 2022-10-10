package com.bluetips.tcc.bluetips.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="tabela_Empresa")//EmpresaEntity=representa a tabela no banco de dados 
public class EmpresaEntity {

	@Id
	private String id;
	
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
