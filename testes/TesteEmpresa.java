package testes;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import codigoFonte.Empresa;
import codigoFonte.Funcionario;
import codigoFonte.Projeto;

public class TesteEmpresa {
	// empresa tem funcionarios e projetos
	
	Empresa empresa;
	
	@Before
	public void setup() {
		empresa = new Empresa();
	}
	
	@Test
	public void testeNenhumFuncionario() throws Exception {
		assertEquals(0, empresa.getQuantidadeFuncionarios());
	}
	
	@Test
	public void testeUmFuncionario() throws Exception {
		Funcionario funcionario = new Funcionario("João");
		empresa.adicionaFuncionario(funcionario);
		assertEquals(1, empresa.getQuantidadeFuncionarios());
	}
	
	@Test
	public void testeGetFuncionario() throws Exception {
		Funcionario joao = new Funcionario("João");
		empresa.adicionaFuncionario(joao);
		List<Funcionario> funcionarios = empresa.getFuncionarios();
		assertEquals("João", funcionarios.get(0).getNome());
	}
	
	@Test
	public void testeDoisFuncionarios() throws Exception {
		Funcionario joao = new Funcionario("João");
		Funcionario maria = new Funcionario("Maria");
		empresa.adicionaFuncionario(joao);
		empresa.adicionaFuncionario(maria);
		assertEquals(2, empresa.getQuantidadeFuncionarios());
	}
	
	@Test
	public void testeNenhumProjeto() throws Exception {
		assertEquals(0, empresa.getQuantidadeProjetos());
	}
	
	@Test
	public void testeUmProjeto() throws Exception {
		Projeto umProjeto = new Projeto("Projeto X");
		empresa.adicionaProjeto(umProjeto);
		assertEquals(1, empresa.getQuantidadeProjetos());
	}
	
	@Test
	public void testeGetProjeto() throws Exception {
		Projeto umProjeto = new Projeto("Projeto X");
		empresa.adicionaProjeto(umProjeto);
		List<Projeto> projetos = empresa.getProjetos();
		assertEquals("Projeto X", projetos.get(0).getNome());
	}
	
	@Test
	public void testeDoisProjetos() throws Exception {
		Projeto projetoX = new Projeto("Projeto X");
		Projeto projetoY = new Projeto("Projeto Y");
		empresa.adicionaProjeto(projetoX);
		empresa.adicionaProjeto(projetoY);
		assertEquals(2, empresa.getQuantidadeProjetos());
	}
}
