
public class Pessoa implements Comparable<Pessoa>{
	private String nome;
	private int codigo;
	
	public Pessoa(String nome, int codigo) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public int getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return codigo + " " + nome;
	}

	@Override
	public int compareTo(Pessoa o) {
		return 1;
	}
	
}
