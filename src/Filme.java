

import java.util.LinkedList;

public class Filme extends Midia /*implements Comparable<Filme>*/ {
	private int diretor;
	private LinkedList<Pessoa> actors = new LinkedList<>();
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
		actors.add(p);
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();  
		for (Pessoa pessoa : actors) {
			buffer.append(pessoa.getCodigo()+",");
		}
		String temp = buffer.toString();
		return super.toString() + ";" + temp + diretor+ ";" + duracao;
	}
	
//	@Override
//	public int compareTo(Filme f) {
//		return 1;
//	}
}
