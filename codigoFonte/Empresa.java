package codigoFonte;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Empresa {
	
	private List<Funcionario> listaFuncionarios;
	private List<Projeto> listaProjetos;
	
	public Empresa() {
		listaFuncionarios = new ArrayList<Funcionario>();
		listaProjetos = new ArrayList<Projeto>();
	}

	public int getQuantidadeFuncionarios() {
		return listaFuncionarios.size();
	}

	public void adicionaFuncionario(Funcionario funcionario) {
		listaFuncionarios.add(funcionario);
	}

	public int getQuantidadeProjetos() {
		return listaProjetos.size();
	}

	public void adicionaProjeto(Projeto projeto) {
		listaProjetos.add(projeto);
	}

	public List<Funcionario> getFuncionarios() {
		return listaFuncionarios;
	}

	public List<Projeto> getProjetos() {
		return listaProjetos;
	}
}
