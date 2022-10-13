package com.bluetips.tcc.bluetips.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="tabela_Vagas")
public class VagasEntity {
	
	@Id
	private String id;
	
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
