package com.bluetips.tcc.bluetips.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name="Usuario")//UsuarioEntity=representa a tabela no banco de dados
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	private String nome;
	private String cpf;
	private String escolaridade;
	private String nascimento; //data de nascimento
	private String sobre;
	private String telefone;
	private String email;
	private String senha;
	private String confirmSenha;
	
	//experiencia add
	
	//INICIO DO OBJETO ENDERECO (private Endereco endereco)
	private String cep;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String uf;
	//FIM DO OBJETO ENDERECO
	
	
	private boolean empresaDeuLike;
	private boolean usuarioDipensado;
	
	private String nomeEmpresas;
	
	//status atual da entidade
	private boolean status_usuario = true;
		
	@Lob
	private String fotoBase64;
	
	
	public String getFotoBase64() {
		return fotoBase64;
	}
	public void setFotoBase64(String fotoBase64) {
		this.fotoBase64 = fotoBase64;
	}
	
	public boolean isEmpresaDeuLike() {
		return empresaDeuLike;
	}
	public void setEmpresaDeuLike(boolean empresaDeuLike) {
		this.empresaDeuLike = empresaDeuLike;
	}
	public String getNomeEmpresas() {
		return nomeEmpresas;
	}
	public void setNomeEmpresas(String nomeEmpresas) {
		this.nomeEmpresas = nomeEmpresas;
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
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
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
	public boolean isUsuarioDipensado() {
		return usuarioDipensado;
	}
	public void setUsuarioDipensado(boolean usuarioDipensado) {
		this.usuarioDipensado = usuarioDipensado;
	}
	public boolean isStatus_usuario() {
		return status_usuario;
	}
	public void setStatus_usuario(boolean status_usuario) {
		this.status_usuario = status_usuario;
	}
	
	
}
