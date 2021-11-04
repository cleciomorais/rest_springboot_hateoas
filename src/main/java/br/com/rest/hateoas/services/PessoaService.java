package br.com.rest.hateoas.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rest.hateoas.mappers.DozerMapper;
import br.com.rest.hateoas.model.Endereco;
import br.com.rest.hateoas.model.Pessoa;
import br.com.rest.hateoas.model.vo.PessoaVO;
import br.com.rest.hateoas.repository.EnderecoRepository;
import br.com.rest.hateoas.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepo;
	
	@Autowired
	EnderecoRepository enderecoRepo;

	public List<PessoaVO> findAll() {
		return DozerMapper.parseListObjects(pessoaRepo.findAll() , PessoaVO.class);
	}
	
	public PessoaVO findById(Long id) {
		Pessoa pes = pessoaRepo.findById( id ).orElseThrow(() -> new RuntimeException("Registro não encontrado!"));
		return DozerMapper.parseObject(pes, PessoaVO.class);
	}
	
	public PessoaVO add(PessoaVO pessoa) {
		Pessoa pes = DozerMapper.parseObject(pessoa, Pessoa.class);
		
		List<Endereco> enderecos = pes.getEnderecos(); 
		pes.setEnderecos( new ArrayList<Endereco>());
		
		for (Endereco endereco : enderecos) {
			endereco.setPessoa(pes);
			pes.getEnderecos().add(endereco);
		}
		
		return DozerMapper.parseObject(pessoaRepo.save(pes), PessoaVO.class);
	}
	
	public PessoaVO update(PessoaVO pessoa) {
		Pessoa entidade = pessoaRepo.findById( pessoa.getIdPessoa() ).orElseThrow(() -> new RuntimeException("Registro não encontrado!") ) ;
		
		entidade.setNome(pessoa.getNome());
		entidade.setSobreNome(pessoa.getSobreNome());
		entidade.setGenero(pessoa.getGenero());
		entidade.setDtNascimento(pessoa.getDtNascimento());
		
		return DozerMapper.parseObject(pessoaRepo.save(entidade), PessoaVO.class);
	}
	
	public void delete(Long id) {
		Pessoa p = pessoaRepo.findById( id ).orElseThrow(() -> new  RuntimeException("Registro não encontrado!")) ;
		pessoaRepo.delete( p ) ;
	}
	
}
