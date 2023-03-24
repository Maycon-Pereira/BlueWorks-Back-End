package com.bluetips.tcc.bluetips.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity(name="tabela_Vagas")
public class VagasEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	private String nome;
	private String tipo;
	private String qtda;
	private String data_publicacao;
	private String salario;
	private String escolaridade;
	
	//-- NEW
	private String area;
	private String exigencias;
	private String valorizado;
	private String contrato;
	//--
	
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
	
	@Lob
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
