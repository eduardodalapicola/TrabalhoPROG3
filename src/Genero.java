
public class Genero implements Comparable<Genero>{
	private String sigla;
	private String nome;
	
	public Genero(String sigla, String nome) {
		this.sigla = sigla;
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public String getNome() {
		return nome;
	}
	@Override
	public int compareTo(Genero o) {
		return 1;
	}
	@Override
	public String toString() {
		return sigla + " " + nome;
	}
}
