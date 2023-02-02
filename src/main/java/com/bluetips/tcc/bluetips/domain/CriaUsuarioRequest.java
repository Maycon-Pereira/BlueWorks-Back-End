package com.bluetips.tcc.bluetips.domain;

import javax.persistence.Lob;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CriaUsuarioRequest {

	@NotEmpty(message="O nome não pode estar vazio.")
	private String nome;
	
	@NotEmpty(message="O CPF não pode estar vazio.")
	@Size(min=14, max=14)
	private String cpf;
	
	@NotEmpty(message="A escolaridade não pode estar vazio.")
	private String escolaridade;
	
	@NotEmpty(message="A data não pode estar vazio.")
	private String data; //data de nascimento
	
	@NotEmpty(message="O Sobre não pode estar vazio.")
	private String sobre;
	
	//
	private String telefone;
	
	@NotEmpty(message="O Email não pode estar vazio.")
	@Email
	private String email;
	
	@NotEmpty(message="A senha não pode estar vazio.")
	@Size(min=8, max=20)
	private String senha;
	
	//INICIO DO OBJETO ENDERECO (private Endereco endereco)
	
	@NotNull
	@Size(min=9, max=9)
	private String cep;
	
	private String logradouro;
	private String bairro;
	private String cidade;
	private String uf;
	//FIM DO OBJETO ENDERECO
	
	@Lob
	private String fotoBase64;
	
	public String getFotoBase64() {
		return fotoBase64;
	}
	public void setFotoBase64(String fotoBase64) {
		this.fotoBase64 = fotoBase64;
	}
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getSobre() {
		return sobre;
	}
	public void setSobre(String sobre) {
		this.sobre = sobre;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
}
