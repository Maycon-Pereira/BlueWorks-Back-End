package com.bluetips.tcc.bluetips.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name="Usuario")//UsuarioEntity=representa a tabela no banco de dados
public class UsuarioEntity {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="escolaridade")
	private String escolaridade;
	
	@Column(name="nascimento")
	private String nascimento; //data de nascimento
	
	@Column(name="sobre")
	private String sobre;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="confirmSenha")
	private String confirmSenha;
	
	//experiencia add
	
	//INICIO DO OBJETO ENDERECO (private Endereco endereco)
	@Column(name="cep")
	private String cep;
	
	@Column(name="logradouro")
	private String logradouro;
	
	@Column(name="")
	private String bairro;
	
	@Column(name="cidade")
	private String cidade;
	
	@Column(name="uf")
	private String uf;
	//FIM DO OBJETO ENDERECO
	
	@Column(name="empresaDeuLike")
	private boolean empresaDeuLike;
	
	@Column(name="usuarioDipensado")
	private boolean usuarioDipensado;
	
	@Column(name="nomeEmpresas")
	private String nomeEmpresas;
	
	//status atual da entidade
	@Column(name="status_usuario")
	private String status_usuario;
		
	@Lob
	@Column(name="foto")
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
	public String getStatus_usuario() {
		return status_usuario;
	}
	public void setStatus_usuario(String status_usuario) {
		this.status_usuario = status_usuario;
	}
	
	
	
}
