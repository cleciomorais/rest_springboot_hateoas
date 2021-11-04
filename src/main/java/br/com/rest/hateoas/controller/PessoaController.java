package br.com.rest.hateoas.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rest.hateoas.model.vo.PessoaVO;
import br.com.rest.hateoas.services.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController { 

	@Autowired
	PessoaService pessoaService;
	
	@GetMapping("/{id}")
	public PessoaVO findById(@PathVariable("id") Long id) {
		PessoaVO vo = pessoaService.findById(id); 
		vo.add( linkTo( methodOn( PessoaController.class ).findById(id) ).withSelfRel() );
		vo.add( linkTo( methodOn( PessoaController.class ).findAll() ).withRel("all") );
		vo.add( linkTo( methodOn( PessoaController.class ).delete(id) ).withRel("delete") ); 
		return vo;
	}

	@GetMapping("/all")
	public List<PessoaVO> findAll() {
		List<PessoaVO> vos = pessoaService.findAll(); 
		vos.stream().forEach( p -> { p.add( linkTo( methodOn( PessoaController.class ).findById(p.getIdPessoa()) ).withSelfRel() );
									 p.add( linkTo( methodOn( PessoaController.class ).delete(p.getIdPessoa()) ).withRel("delete") );
								   }) ;
		return vos;
	}
	
	@PostMapping("/add")
	public PessoaVO add(@RequestBody PessoaVO pessoa) {
		 
		PessoaVO vo = pessoaService.add(pessoa);
		vo.add( linkTo( methodOn( PessoaController.class ).findById(vo.getIdPessoa()) ).withSelfRel() );
		vo.add( linkTo( methodOn( PessoaController.class ).findAll() ).withRel("all") );
		vo.add( linkTo( methodOn( PessoaController.class ).delete(vo.getIdPessoa()) ).withRel("delete") ); 
		return vo;
	}

	@PutMapping("/update")
	public PessoaVO update(@RequestBody PessoaVO pessoa) {
		PessoaVO vo = pessoaService.update(pessoa);
		vo.add( linkTo( methodOn( PessoaController.class ).findById(vo.getIdPessoa()) ).withSelfRel() );
		vo.add( linkTo( methodOn( PessoaController.class ).findAll() ).withRel("all") );
		vo.add( linkTo( methodOn( PessoaController.class ).delete(vo.getIdPessoa()) ).withRel("delete") ); 
		return vo;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		pessoaService.delete(id); 
		return new  ResponseEntity<String>("Registro excluido. ID: " + id , HttpStatus.OK);
	}
	
}
