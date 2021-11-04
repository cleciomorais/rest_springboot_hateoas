package br.com.rest.hateoas.mappers;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.rest.hateoas.mocks.MockPessoa;
import br.com.rest.hateoas.model.Pessoa;
import br.com.rest.hateoas.model.vo.PessoaVO;

public class DozerMapperTest {

	MockPessoa inputObject;

    @Before
    public void setUp() {
        inputObject = new MockPessoa();
    }

    @Test
    public void parseEntityToVoTest() {
    	Pessoa entidade = inputObject.mockEntidade();
        PessoaVO output = DozerMapper.parseObject(entidade, PessoaVO.class);
        Assert.assertEquals(Long.valueOf(0L), output.getIdPessoa());
        Assert.assertEquals("MOCK_PESSOA0", output.getNome());
        Assert.assertEquals("MOCK_SOBRENOME0", output.getSobreNome());
        Assert.assertEquals(entidade.getEnderecos().size(), output.getEnderecos().size());
        Assert.assertEquals(entidade.getEnderecos().get(0).getId(), output.getEnderecos().get(0).getIdEndereco());
        Assert.assertEquals(entidade.getEnderecos().get(0).getPessoa().getId(), output.getEnderecos().get(0).getPessoa().getIdPessoa());
        
        Assert.assertEquals("M", output.getGenero());
    }
    
    @Test
    public void parseVOToEntityTest() {
    	PessoaVO pesVo = inputObject.mockVO();
    	Pessoa entidade = DozerMapper.parseObject(pesVo, Pessoa.class);
    	Assert.assertEquals(Long.valueOf(0L), entidade.getId());
        Assert.assertEquals("MOCK_PESSOA0", entidade.getNome());
        Assert.assertEquals("MOCK_SOBRENOME0", entidade.getSobreNome());
        Assert.assertEquals("M", entidade.getGenero());
        Assert.assertEquals(pesVo.getEnderecos().size(), entidade.getEnderecos().size());
        Assert.assertEquals(pesVo.getEnderecos().get(0).getIdEndereco(), entidade.getEnderecos().get(0).getId());
        Assert.assertEquals(pesVo.getEnderecos().get(0).getPessoa().getIdPessoa(), entidade.getEnderecos().get(0).getPessoa().getId());
    }
    
    @Test
    public void parseEntityListToVOListTest() {
    	List<Pessoa> entidadeList = inputObject.mockListaEntidade();
        List<PessoaVO> voList = DozerMapper.parseListObjects(entidadeList, PessoaVO.class);
        
        PessoaVO voZero = voList.get(0);

        Assert.assertEquals(Long.valueOf(0L), voZero.getIdPessoa());
        Assert.assertEquals("MOCK_PESSOA0", voZero.getNome());
        Assert.assertEquals("MOCK_SOBRENOME0", voZero.getSobreNome());
        Assert.assertEquals("M", voZero.getGenero());
        Assert.assertEquals(entidadeList.get(0).getEnderecos().size(), voZero.getEnderecos().size());
        Assert.assertEquals(entidadeList.get(0).getEnderecos().get(0).getId(), voZero.getEnderecos().get(0).getIdEndereco());
        Assert.assertEquals(entidadeList.get(0).getEnderecos().get(0).getPessoa().getId(), voZero.getEnderecos().get(0).getPessoa().getIdPessoa());
        
        
        PessoaVO voSete = voList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), voSete.getIdPessoa());
        Assert.assertEquals("MOCK_PESSOA7", voSete.getNome());
        Assert.assertEquals("MOCK_SOBRENOME7", voSete.getSobreNome());
        Assert.assertEquals("F", voSete.getGenero());
        Assert.assertEquals(entidadeList.get(7).getEnderecos().size(), voSete.getEnderecos().size());
        Assert.assertEquals(entidadeList.get(7).getEnderecos().get(0).getId(), voSete.getEnderecos().get(0).getIdEndereco());
        Assert.assertEquals(entidadeList.get(7).getEnderecos().get(0).getPessoa().getId(), voSete.getEnderecos().get(0).getPessoa().getIdPessoa());
        
        
        PessoaVO voDoze = voList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), voDoze.getIdPessoa());
        Assert.assertEquals("MOCK_PESSOA12", voDoze.getNome());
        Assert.assertEquals("MOCK_SOBRENOME12", voDoze.getSobreNome());
        Assert.assertEquals("M", voDoze.getGenero());
        Assert.assertEquals(entidadeList.get(12).getEnderecos().size(), voDoze.getEnderecos().size());
        Assert.assertEquals(entidadeList.get(12).getEnderecos().get(0).getId(), voDoze.getEnderecos().get(0).getIdEndereco());
        Assert.assertEquals(entidadeList.get(12).getEnderecos().get(0).getPessoa().getId(), voDoze.getEnderecos().get(0).getPessoa().getIdPessoa());
        
    }
    
    @Test
    public void parseVOListToEntityListTest() {
    	List<PessoaVO> voList = inputObject.mockVOList();
        List<Pessoa> outputList = DozerMapper.parseListObjects(voList, Pessoa.class);
        
        Pessoa entidadeZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), entidadeZero.getId());
        Assert.assertEquals("MOCK_PESSOA0", entidadeZero.getNome());
        Assert.assertEquals("MOCK_SOBRENOME0", entidadeZero.getSobreNome());
        Assert.assertEquals("M", entidadeZero.getGenero());
        Assert.assertEquals(voList.get(0).getEnderecos().size(), entidadeZero.getEnderecos().size());
        Assert.assertEquals(voList.get(0).getEnderecos().get(0).getIdEndereco(), entidadeZero.getEnderecos().get(0).getId());
        Assert.assertEquals(voList.get(0).getEnderecos().get(0).getPessoa().getIdPessoa(), entidadeZero.getEnderecos().get(0).getPessoa().getId());
        
        
        Pessoa entidadeSete = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), entidadeSete.getId());
        Assert.assertEquals("MOCK_PESSOA7", entidadeSete.getNome());
        Assert.assertEquals("MOCK_SOBRENOME7", entidadeSete.getSobreNome());
        Assert.assertEquals("F", entidadeSete.getGenero());
        Assert.assertEquals(voList.get(7).getEnderecos().size(), entidadeSete.getEnderecos().size());
        Assert.assertEquals(voList.get(7).getEnderecos().get(0).getIdEndereco(), entidadeSete.getEnderecos().get(0).getId());
        Assert.assertEquals(voList.get(7).getEnderecos().get(0).getPessoa().getIdPessoa(), entidadeSete.getEnderecos().get(0).getPessoa().getId());
        
        
        Pessoa entidadeDoze = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), entidadeDoze.getId());
        Assert.assertEquals("MOCK_PESSOA12", entidadeDoze.getNome());
        Assert.assertEquals("MOCK_SOBRENOME12", entidadeDoze.getSobreNome());
        Assert.assertEquals("M", entidadeDoze.getGenero());
        Assert.assertEquals(voList.get(12).getEnderecos().size(), entidadeDoze.getEnderecos().size());
        Assert.assertEquals(voList.get(12).getEnderecos().get(0).getIdEndereco(), entidadeDoze.getEnderecos().get(0).getId());
        Assert.assertEquals(voList.get(12).getEnderecos().get(0).getPessoa().getIdPessoa(), entidadeDoze.getEnderecos().get(0).getPessoa().getId());
    }
    
}
