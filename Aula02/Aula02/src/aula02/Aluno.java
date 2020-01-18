package aula02;

public class Aluno extends PessoaFisica {
	
	private String nome;
	private String matricula;
	
	public Aluno(String nome) {
		this.nome = nome;
	}
	
	public Aluno() {
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Aluno salvar(Aluno aluno) throws Exception {
		try {
			return null;
		}catch (Exception e){
			throw new Exception();
		}
	}
}
