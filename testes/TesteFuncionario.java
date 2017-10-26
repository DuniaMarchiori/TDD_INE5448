package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import codigoFonte.Funcionario;
import codigoFonte.Ocorrencia;
import codigoFonte.PrioridadesOcorrencia;
import codigoFonte.Projeto;
import codigoFonte.TiposOcorrencia;

public class TesteFuncionario {
	
	@Test
	public void testConstrutor() throws Exception {
		Funcionario maria = new Funcionario("Maria");
	
		assertEquals("Maria", maria.getNome());
	}
	
	@Test
	public void testeChaveUnica() {
		Funcionario maria = new Funcionario("Maria");
		Funcionario jose = new Funcionario("José");
		
		assertNotEquals(maria.getId(), jose.getId());
	}
	
	@Test
	public void testeChaveMenor() {
		Funcionario maria = new Funcionario("Maria");
		Funcionario jose = new Funcionario("José");
		
		assertTrue(maria.getId() < jose.getId());
	}
	
	@Test
	public void testeResponsavelPorNenhumaOcorrenciaAberta() throws Exception {
		Funcionario maria = new Funcionario("Maria");
		
		assertEquals(0, maria.getQuantidadeOcorrenciasAbertas());
	}
	
	@Test
	public void testeResposavelPorUmaOcorrenciaAberta() throws Exception {
		Funcionario maria = new Funcionario("Maria");
		
		Ocorrencia umaOcorrencia = new Ocorrencia("Resumo da ocorrência", maria, TiposOcorrencia.BUG, PrioridadesOcorrencia.MEDIA);
		maria.adicionaOcorrenciaResponsavel(umaOcorrencia);
		
		assertEquals(1, maria.getQuantidadeOcorrenciasAbertas());
		assertEquals(umaOcorrencia.getResumo(), maria.getOcorrenciasResponsavel().get(0).getResumo());
	}

	@Test
	public void testeResponsavelPorDezOcorrencias() throws Exception {
		Funcionario maria = new Funcionario("Maria");
		Ocorrencia umaOcorrencia = null;
		
		// cria 10 ocorrências
		for (int i = 0; i < 10; i++) {
			umaOcorrencia = new Ocorrencia("Resumo da ocorrência" + i, maria, TiposOcorrencia.BUG, PrioridadesOcorrencia.MEDIA);
			maria.adicionaOcorrenciaResponsavel(umaOcorrencia);
		}
		
		assertEquals(10, maria.getQuantidadeOcorrenciasAbertas());
		assertEquals(umaOcorrencia.getResumo(), maria.getOcorrenciasResponsavel().get(9).getResumo());
	}
	
	// Verifica se aceita mais de 10 ocorrencias
	@Test(expected=Exception.class)
	public void testeResponsavelPorOnzeOcorrencias() throws Exception {
		Funcionario maria = new Funcionario("Maria");
		Ocorrencia umaOcorrencia = null;
		
		// Cria 11 ocorrências
		for (int i = 0; i < 11; i++) {
			umaOcorrencia = new Ocorrencia("Resumo da ocorrência" + i, maria, TiposOcorrencia.BUG, PrioridadesOcorrencia.MEDIA);
			maria.adicionaOcorrenciaResponsavel(umaOcorrencia);
		}
	}
	
	@Test
	public void testeTrabalhaNenhumProjeto() throws Exception {
		Funcionario maria = new Funcionario("Maria");
		
		assertEquals(0, maria.getQuantidadeProjetosTrabalha());
	}
	
	@Test
	public void testeTrabalhaUmProjeto() throws Exception {
		Funcionario maria = new Funcionario("Maria");
		
		Projeto umProjeto = new Projeto("Nome do projeto");
		maria.adicionaProjeto(umProjeto);
		
		assertEquals(1, maria.getQuantidadeProjetosTrabalha());
		assertEquals(umProjeto.getNome(), maria.getProjetosTrabalha().get(0).getNome());
	}
}
