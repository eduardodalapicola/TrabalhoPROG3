import java.util.LinkedList;

public class Serie extends Midia /*implements Comparable<Serie>*/{
	private int numeroTemporada;
	private String nomeSerie;
	private LinkedList<Pessoa> actors = new LinkedList<>();
	private int duracao;		

	public Serie(int codigo, String nome, Genero genero, double preco, char possui, char consumiu, char deseja,
			int numeroTemporada, String nomeSerie, int duracao) {
		super(codigo, nome, genero, preco, possui, consumiu, deseja);
		this.numeroTemporada = numeroTemporada;
		this.nomeSerie = nomeSerie;
		this.duracao = duracao;
	}

	public String getNomeSerie() {
		return nomeSerie;
	}

	public int getNumeroTemporada() {
		return numeroTemporada;
	}
	public int getDuracao() {
		return duracao;
	}
	@Override
	public String toString() {
		return super.toString() + numeroTemporada + duracao;
	}
	public void adicionaActors(Pessoa p){
		actors.add(p);
	}
	
//	@Override
//	public int compareTo(Serie s) {
//		return 1;
//	}
	
}
