package br.com.rest.hateoas.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 4386576854595544583L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "SOBRENOME", nullable = false, length = 50)
	private String sobreNome;
	
	@Column(name = "DTNASCIMENTO", nullable = true)
	private Date dtNascimento;

	@Column(name = "GENERO", nullable = false, length = 1)
	private String genero;
	
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL , fetch = FetchType.LAZY , orphanRemoval = true)
	private List<Endereco> enderecos;

	public Pessoa() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

		public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}


	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	public Pessoa(Long id, String nome, String sobreNome, Date dtNascimento, String genero) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.dtNascimento = dtNascimento;
		this.genero = genero;
	}

}
