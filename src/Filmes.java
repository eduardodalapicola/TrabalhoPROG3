
//import java.util.LinkedList;

public class Filmes extends Midia {
	private String diretor;
//	private LinkedList<String> mainActors = new LinkedList<>();
	private int duracao;

	public Filmes(int codigo, String nome, Genero genero, double preco, char possui, char consumiu, char deseja,
		String diretor, int duracao) {
	super(codigo, nome, genero, preco, possui, consumiu, deseja);
	this.diretor = diretor;
	this.duracao = duracao;
}
	public String getDiretor() {
		return diretor;
	}
	public int getDuracao() {
		return duracao;
	}
}
