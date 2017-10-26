package codigoFonte;

import java.util.ArrayList;
import java.util.List;


public class Projeto {

	private String nome;
	private List<Ocorrencia> listaOcorrencias;
	
	public Projeto(String nome) {
		this.nome = nome;
		listaOcorrencias = new ArrayList<Ocorrencia>();
	}

	public String getNome() {
		return nome;
	}

	public int getQuantidadeOcorrencias() {
		return listaOcorrencias.size();
	}

	public void adicionaOcorrencia(Ocorrencia ocorrencia) throws Exception {
		listaOcorrencias.add(ocorrencia);	
	}

	public List<Ocorrencia> getOcorrencias() {
		return listaOcorrencias;
	}

}
