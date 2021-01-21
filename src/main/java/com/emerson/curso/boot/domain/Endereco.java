package com.emerson.curso.boot.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "ENDERECOS")
public class Endereco extends AbstractEntity<Long> {
	
	@Column(name = "LOGRADOURO", nullable = false)
	private String logradouro;
	
	@Column(name = "BAIRRO", nullable = false)
	private String bairro;
	
	@Column(name = "CIDADE", nullable = false)
	private String cidade;
	
	@Column(name = "UF", nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	private UF uf;

	@Column(name = "CEP", nullable = false, length = 9)
	private String cep;
	
	@Column(name = "NUMERO", nullable = false, length = 5)
	private Integer numero;
	
	@Column(name = "COMPLEMENTO")
	private String complemento;

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

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}
