package codigoFonte;

public class Ocorrencia {
	
	private static int quantidadeocorrencias = 0;
	
	private int chave;
	private String resumo;
	private Funcionario responsavel;
	private TiposOcorrencia tipo;
	private PrioridadesOcorrencia prioridade;
	private String estado;

	public Ocorrencia(String resumo, Funcionario responsavel, TiposOcorrencia tipo, PrioridadesOcorrencia prioridade) {
		this.chave = quantidadeocorrencias;
		this.resumo = resumo;
		this.responsavel = responsavel;
		this.tipo = tipo;
		this.prioridade = prioridade;
		estado = "Aberta";
		quantidadeocorrencias++;
	}

	public int getChave() {
		return chave;
	}

	public String getResumo() {
		return resumo;
	}

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public String getEstado() {
		return estado;
	}

	public TiposOcorrencia getTipo() {
		return tipo;
	}
	
	public PrioridadesOcorrencia getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(PrioridadesOcorrencia novaPrioridade) throws Exception {
		if (estado == "Aberta") {
			prioridade = novaPrioridade;		
		} else {
			throw new Exception("A prioridade só pode sofrer mudanças enquanto a ocorrência está aberta.");
		}		
	}

	public void completaOcorrencia() {
		estado = "Completada";		
	}

	public void setResponsavel(Funcionario novoResponsavel) throws Exception {
		if (estado == "Aberta") {
			responsavel = novoResponsavel;		
		} else {
			throw new Exception("O responsável só pode sofrer mudanças enquanto a ocorrência está aberta.");
		}	
	}
	
}
