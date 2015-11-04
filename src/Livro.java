import java.util.LinkedList;

public class Livro extends Midia /*implements Comparable<Livro>*/{
	private LinkedList<Pessoa> autores = new LinkedList<>();
	private int numeroPagina;
	
	public Livro(int codigo, String nome, Genero genero, double preco, char possui, char consumiu, char deseja,
			int numeroPagina) {
		super(codigo, nome, genero, preco, possui, consumiu, deseja);
		this.numeroPagina = numeroPagina;
	}


	public LinkedList<Pessoa> getAutores() {
		return autores;
	}


	public void setAutores(Pessoa autores) {
		this.autores.add(autores);
	}

	public int getNumeroPagina() {
		return numeroPagina;
	}
	
	@Override
	public String toString() {
		return super.toString()+" "+numeroPagina;
				
	}

//	@Override
//	public int compareTo(Livro l) {
//		return 1;
//	}

}
