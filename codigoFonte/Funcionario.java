package codigoFonte;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
	
	private static int quantidadeFuncionario = 0;
	private int id;
	private String nome;
	private List<Ocorrencia> listaOcorrencias;
	private List<Projeto> listaProjetosEmQueTrabalha;
	
	public Funcionario(String nome) {
		this.id = quantidadeFuncionario;
		this.nome = nome;
		listaOcorrencias = new ArrayList<Ocorrencia>();
		listaProjetosEmQueTrabalha = new ArrayList<Projeto>();
		quantidadeFuncionario++;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getQuantidadeOcorrenciasAbertas() {
		return listaOcorrencias.size();
	}

	public void adicionaOcorrenciaResponsavel(Ocorrencia ocorrencia) throws Exception {
		if (listaOcorrencias.size() <= 9) {
			listaOcorrencias.add(ocorrencia);
		} else {
			throw new Exception("Um funcionário só pode ser responsável por no máximo 10 ocorrências abertas.");
		}
	}
	
	/*public void retirarOcorrencia(Ocorrencia ocorrencia) {
		listaOcorrencias.remove(ocorrencia);
	}*/

	public List<Ocorrencia> getOcorrenciasResponsavel() {
		return listaOcorrencias;
	}
	
	public void adicionaProjeto(Projeto projetoEmQueTrabalha) {
		listaProjetosEmQueTrabalha.add(projetoEmQueTrabalha);
	}
	
	public int getQuantidadeProjetosTrabalha() {
		return listaProjetosEmQueTrabalha.size();
	}
	
	public List<Projeto> getProjetosTrabalha() {
		return listaProjetosEmQueTrabalha;
	}

}
