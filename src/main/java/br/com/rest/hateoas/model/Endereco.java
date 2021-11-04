package br.com.rest.hateoas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PESSOA_ENDERECO")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 3829275587915265978L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "LOGRADOURO", nullable = false, length = 50)
	private String logradouro;
	
	@Column(name = "CIDADE", nullable = true, length = 50)
	private String cidade;
	
	@Column(name = "BAIRRO", nullable = true, length = 50)
	private String bairro;
	
	@Column(name = "CEP", nullable = true, length = 9)
	private String cep;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PESSOA_ID")
	private Pessoa pessoa;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
