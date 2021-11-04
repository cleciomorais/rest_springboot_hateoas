package br.com.rest.hateoas.model.vo;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder ({"id", "logradouro", "cidade", "bairro", "cep"})
public class EnderecoVO extends ResourceSupport implements Serializable {

	private static final long serialVersionUID = -5038128191942436772L;

	@Mapping("id")
	@JsonProperty("id")
	private Long idEndereco;

	private String logradouro;
	
	private String cidade;
	
	private String bairro;
	
	private String cep;
	
//	@JsonIgnoreProperties({"enderecos"})
	@JsonIgnore
	private PessoaVO pessoa;
	
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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

	public PessoaVO getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaVO pessoa) {
		this.pessoa = pessoa;
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

}
