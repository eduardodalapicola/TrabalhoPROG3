import java.sql.Date;

public class Serie extends Midia {
	private int numeroTemporada;
	private Date duracao;		

	public Serie(int codigo, String nome, Genero genero, double preco, char possui, char consumiu, char deseja,
			int numeroTemporada, Date duracao) {
		super(codigo, nome, genero, preco, possui, consumiu, deseja);
		this.numeroTemporada = numeroTemporada;
		this.duracao = duracao;
	}
	public int getNumeroTemporada() {
		return numeroTemporada;
	}
	public Date getDuracao() {
		return duracao;
	}
	
}
