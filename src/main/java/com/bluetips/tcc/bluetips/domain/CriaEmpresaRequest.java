package com.bluetips.tcc.bluetips.domain;

import javax.persistence.Lob;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CriaEmpresaRequest {

	@NotEmpty(message="O nome não pode estar vazio.")
	private String nome;
	
	@NotEmpty(message="O CNPJ não pode estar vazio.")
	@Size(min=18, max=18)
	private String cnpj;
	
	@NotEmpty(message="O Porte não pode estar vazio.")
	private String porte;
	
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
	
	@NotEmpty(message="As senhas devem ser compativeis.")
	@Size(min=8, max=20)
	private String confirmSenha;
	
	//INICIO DO OBJETO ENDERECO (private Endereco endereco)
	
	@NotNull(message="O CPF não pode estar vazio.")
	@Size(min=9, max=9)
	private String cep;
	
	private String logradouro;
	private String bairro;
	private String uf;
	private String cidade;
	//FIM DO OBJETO ENDERECO
	
	//status atual da entidade
	private boolean status_empresa = true;
	
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getPorte() {
		return porte;
	}
	public void setPorte(String porte) {
		this.porte = porte;
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
	public String getConfirmSenha() {
		return confirmSenha;
	}
	public void setConfirmSenha(String confirmSenha) {
		this.confirmSenha = confirmSenha;
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
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public boolean isStatus_empresa() {
		return status_empresa;
	}
	public void setStatus_empresa(boolean status_empresa) {
		this.status_empresa = status_empresa;
	}

}
