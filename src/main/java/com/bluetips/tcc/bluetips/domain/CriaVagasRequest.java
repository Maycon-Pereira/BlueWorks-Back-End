package com.bluetips.tcc.bluetips.domain;

import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CriaVagasRequest {
	
	@NotEmpty(message="O nome não pode estar vazio.")
	private String nome;
	
	@NotEmpty(message="O tipo não pode estar vazio.")
	private String tipo;
	
	@Size(min=1)
	private String qtda;
	
	@NotEmpty(message="A data não pode estar vazio.")
	private String data;
	
	
	@Size(min=3)
	private String salario;
	
	@NotEmpty(message="A escolaridade não pode estar vazio.")
	private String escolaridade;
	
	//-- Especializacao !
	@NotEmpty(message="A area não pode estar vazio.")
	private String area;
	
	@NotEmpty(message="As exigencias não pode estar vazio.")
	private String exigencias;
	
	private String valorizado;
	
	@NotEmpty(message="O contrato não pode estar vazio.")
	private String contrato;
	//--
	
	@NotEmpty(message="O Sobre não pode estar vazio.")
	private String sobre;
	
	@NotEmpty(message="O CNPJ não pode estar vazio.")
	@Size(min=14, max=14)
	private String cnpj;
	
	@NotEmpty(message="A senha não pode estar vazio.")
	@Size(min=8, max=20)
	private String senha;
	
	//INICIO DO OBJETO ENDERECO (private Endereco endereco)
	
	@NotNull(message="O CPF não pode estar vazio.")
	@Size(min=8, max=8)
	private String cep;
	
	private String logradouro;
	private String bairro;
	private String uf;
	private String cidade;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getQtda() {
		return qtda;
	}
	public void setQtda(String qtda) {
		this.qtda = qtda;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	public String getSobre() {
		return sobre;
	}
	public void setSobre(String sobre) {
		this.sobre = sobre;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

//NEW
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getExigencias() {
		return exigencias;
	}
	public void setExigencias(String exigencias) {
		this.exigencias = exigencias;
	}
	public String getValorizado() {
		return valorizado;
	}
	public void setValorizado(String valorizado) {
		this.valorizado = valorizado;
	}
	public String getContrato() {
		return contrato;
	}
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	
}
