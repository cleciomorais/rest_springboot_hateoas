package br.com.rest.hateoas.model.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder ({"id", "nome", "sobrenome", "genero", "dtNascimento", "enderecos"})
public class PessoaVO extends ResourceSupport implements Serializable {

	private static final long serialVersionUID = 1587156941598874501L;

	@Mapping("id")
	@JsonProperty("id")
	private Long idPessoa;

	private String nome;

	private String sobreNome;

	private String genero;

	private Date dtNascimento;

	private List<EnderecoVO> enderecos;

	public PessoaVO() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<EnderecoVO> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoVO> enderecos) {
		this.enderecos = enderecos;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

}
