package com.bluetips.tcc.bluetips.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity(name="Vaga")
public class VagasEntity {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="qtda")
	private String qtda;
	
	@Column(name="data_publicacao")
	private String data_publicacao;
	
	@Column(name="salario")
	private String salario;
	
	@Column(name="escolaridade")
	private String escolaridade;
	
	//-- NEW
	@Column(name="area")
	private String area;
	
	@Column(name="exigencias")
	private String exigencias;
	
	@Column(name="valorizado")
	private String valorizado;
	
	@Column(name="contrato")
	private String contrato;
	//--
	@Column(name="sobre")
	private String sobre;
	
	@Column(name="cnpj")
	private String cnpj;
	
//	private String senha;
	
	//INICIO DO OBJETO ENDERECO (private Endereco endereco)
	@Column(name="cep")
	private String cep;
	
	@Column(name="logradouro")
	private String logradouro;
	
	@Column(name="bairro")
	private String bairro;
	
	@Column(name="uf")
	private String uf;
	
	@Column(name="cidade")
	private String cidade;
	//FIM DO OBJETO ENDERECO
	
	//status atual da entidade
	@Column(name="status_vaga")
	private String status_vaga;
	
	@Lob
	@Column(name="foto")
	private String fotoBase64;
	
	
	public String getFotoBase64() {
		return fotoBase64;
	}
	public void setFotoBase64(String fotoBase64) {
		this.fotoBase64 = fotoBase64;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getData_publicacao() {
		return data_publicacao;
	}
	public void setData_publicacao(String data_publicacao) {
		this.data_publicacao = data_publicacao;
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
//	public String getSenha() {
//		return senha;
//	}
//	public void setSenha(String senha) {
//		this.senha = senha;
//	}
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
	public String getStatus_vaga() {
		return status_vaga;
	}
	public void setStatus_vaga(String status_vaga) {
		this.status_vaga = status_vaga;
	}
	
	
		
	
}
