

import java.util.LinkedList;

public class Filme extends Midia /*implements Comparable<Filme>*/ {
	private int diretor;
	private LinkedList<Pessoa> Actors = new LinkedList<>();
	private int duracao;

	public Filme(int codigo, String nome, Genero genero, double preco, char possui, char consumiu, char deseja,
			int diretor, int duracao) {
		super(codigo, nome, genero, preco, possui, consumiu, deseja);
		this.diretor = diretor;
		this.duracao = duracao;
	}

	public int getDiretor() {
		return diretor;
	}
	public int getDuracao() {
		return duracao;
	}
	public void adicionaAtor(Pessoa p){
		Actors.add(p);
	}
	
//	@Override
//	public int compareTo(Filme f) {
//		return 1;
//	}
}
