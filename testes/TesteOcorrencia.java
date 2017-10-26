package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import codigoFonte.Funcionario;
import codigoFonte.Ocorrencia;
import codigoFonte.PrioridadesOcorrencia;
import codigoFonte.TiposOcorrencia;

public class TesteOcorrencia {

	@Test
	public void testConstrutor() throws Exception {
		String resumo = "Resumo da ocorrência";
		Funcionario responsavel = new Funcionario("Joao");
		Ocorrencia umaOcorrencia = new Ocorrencia(resumo, responsavel, TiposOcorrencia.BUG,
				PrioridadesOcorrencia.MEDIA);

		assertEquals(resumo, umaOcorrencia.getResumo());
		assertEquals(responsavel, umaOcorrencia.getResponsavel());
		assertEquals("Aberta", umaOcorrencia.getEstado());
		assertEquals(TiposOcorrencia.BUG, umaOcorrencia.getTipo());
		assertEquals(PrioridadesOcorrencia.MEDIA, umaOcorrencia.getPrioridade());
	}

	@Test
	public void testeChaveUnica() {
		Funcionario responsavel = new Funcionario("Joao");
		Ocorrencia umaOcorrencia = new Ocorrencia("Resumo da ocorrencia", responsavel, TiposOcorrencia.BUG,
				PrioridadesOcorrencia.MEDIA);
		Ocorrencia outraOcorrencia = new Ocorrencia("Resumo da outra ocorrencia", responsavel, TiposOcorrencia.TAREFA,
				PrioridadesOcorrencia.ALTA);

		assertNotEquals(umaOcorrencia.getChave(), outraOcorrencia.getChave());
	}

	@Test
	public void testeChaveMenor() {
		Funcionario responsavel = new Funcionario("Joao");
		Ocorrencia umaOcorrencia = new Ocorrencia("Resumo da ocorrencia", responsavel, TiposOcorrencia.BUG,
				PrioridadesOcorrencia.MEDIA);
		Ocorrencia outraOcorrencia = new Ocorrencia("Resumo da outra ocorrencia", responsavel, TiposOcorrencia.TAREFA,
				PrioridadesOcorrencia.ALTA);

		assertTrue(umaOcorrencia.getChave() < outraOcorrencia.getChave());
	}

	@Test
	public void testeMudancaPrioridade() throws Exception {
		Funcionario responsavel = new Funcionario("Joao");
		Ocorrencia umaOcorrencia = new Ocorrencia("Resumo da ocorrência", responsavel, TiposOcorrencia.BUG,
				PrioridadesOcorrencia.MEDIA);

		umaOcorrencia.setPrioridade(PrioridadesOcorrencia.ALTA);
		assertEquals(PrioridadesOcorrencia.ALTA, umaOcorrencia.getPrioridade());
	}

	@Test(expected = Exception.class)
	public void testeMudancaPrioridade_invalida() throws Exception {
		Funcionario responsavel = new Funcionario("Joao");
		Ocorrencia umaOcorrencia = new Ocorrencia("Resumo da ocorrência", responsavel, TiposOcorrencia.BUG,
				PrioridadesOcorrencia.MEDIA);
		umaOcorrencia.completaOcorrencia();

		umaOcorrencia.setPrioridade(PrioridadesOcorrencia.ALTA);
	}

	@Test
	public void testeMudancaResponsavel() throws Exception {
		Funcionario responsavel = new Funcionario("Joao");
		Ocorrencia umaOcorrencia = new Ocorrencia("Resumo da ocorrência", responsavel, TiposOcorrencia.BUG,
				PrioridadesOcorrencia.MEDIA);
		Funcionario novoResponsavel = new Funcionario("Maria");

		umaOcorrencia.setResponsavel(novoResponsavel);
		assertEquals(novoResponsavel, umaOcorrencia.getResponsavel());
	}

	@Test(expected = Exception.class)
	public void testeMudancaResponsavel_invalida() throws Exception {
		Funcionario responsavel = new Funcionario("Joao");
		Ocorrencia umaOcorrencia = new Ocorrencia("Resumo da ocorrência", responsavel, TiposOcorrencia.BUG,
				PrioridadesOcorrencia.MEDIA);
		Funcionario novoResponsavel = new Funcionario("Maria");
		umaOcorrencia.completaOcorrencia();

		umaOcorrencia.setResponsavel(novoResponsavel);
	}

	@Test
	public void testeOcorrenciaCompletada() throws Exception {
		Funcionario responsavel = new Funcionario("Joao");
		Ocorrencia umaOcorrencia = new Ocorrencia("Resumo da ocorrência", responsavel, TiposOcorrencia.BUG,
				PrioridadesOcorrencia.MEDIA);
		umaOcorrencia.completaOcorrencia();

		assertEquals("Completada", umaOcorrencia.getEstado());
	}

	// Teste dos tipos de ocorência
	@Test
	public void testeTipoMelhoria() {
		assertEquals(TiposOcorrencia.MELHORIA, TiposOcorrencia.valueOf("MELHORIA"));
	}

	// Teste das prioridades de ocorrencia
	@Test(expected = IllegalArgumentException.class)
	public void testePrioridadeOcorrencia() {
		PrioridadesOcorrencia.valueOf("URGENTE");
	}
}
