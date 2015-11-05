import java.util.LinkedList;
import java.util.function.Consumer;

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
		StringBuffer buffer = new StringBuffer();  
		for (Pessoa pessoa : autores) {
			buffer.append(pessoa.getCodigo()+",");
		}
		String temp = buffer.toString();
		return super.toString()+";"+temp+";"+numeroPagina+";";
	}


//	@Override
//	public int compareTo(Livro l) {
//		return 1;
//	}

}
