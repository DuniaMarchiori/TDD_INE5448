package testes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import codigoFonte.Funcionario;
import codigoFonte.Ocorrencia;
import codigoFonte.Projeto;
import codigoFonte.TiposOcorrencia;
import codigoFonte.PrioridadesOcorrencia;

public class TesteProjeto {
	
	@Test
	public void testeConstrutor() throws Exception {
		Projeto umProjeto = new Projeto("Projeto Z");	
		assertEquals("Projeto Z", umProjeto.getNome());
	}
	
	@Test
	public void testeNenhumaOcorrencia() throws Exception {
		Projeto umProjeto = new Projeto("Projeto Z");
		assertEquals(0, umProjeto.getQuantidadeOcorrencias());
	}
	
	
	@Test
	public void testeUmaOcorrencia() throws Exception {
		Projeto umProjeto = new Projeto("Projeto Z");
		umProjeto.adicionaOcorrencia(new Ocorrencia("Resumo da ocorrencia", new Funcionario("Fulano"), TiposOcorrencia.BUG, PrioridadesOcorrencia.MEDIA));
		assertEquals(1, umProjeto.getQuantidadeOcorrencias());
	}
	
	@Test
	public void testeDuasOcorrencia() throws Exception {
		Projeto umProjeto = new Projeto("Projeto Z");
		umProjeto.adicionaOcorrencia(new Ocorrencia("Resumo da ocorrencia 1", new Funcionario("Fulano"), TiposOcorrencia.BUG, PrioridadesOcorrencia.MEDIA));
		umProjeto.adicionaOcorrencia(new Ocorrencia("Resumo da ocorrencia 2", new Funcionario("Fulano"), TiposOcorrencia.MELHORIA, PrioridadesOcorrencia.ALTA));
		assertEquals(2, umProjeto.getQuantidadeOcorrencias());
	}
	
	@Test
	public void testeGetOcorrencia() throws Exception {
		Projeto umProjeto = new Projeto("Projeto Z");
		String resumo = "� um bug.";
		umProjeto.adicionaOcorrencia(new Ocorrencia(resumo, new Funcionario("Fulano"), TiposOcorrencia.BUG, PrioridadesOcorrencia.MEDIA));
		List<Ocorrencia> listaOcorrencias = umProjeto.getOcorrencias();
		assertEquals( resumo, listaOcorrencias.get(0).getResumo() );
	}
}
