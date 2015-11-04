

public class Midia {
	private int codigo;
	private String nome;
	private Genero genero;
	private double preco;
	private char possui;
	private char consumiu;
	private char deseja;

	public Midia(int codigo, String nome, Genero genero, double preco, char possui, char consumiu, char deseja) {
		this.codigo = codigo;
		this.nome = nome;
		this.genero = genero;
		this.preco = preco;
		this.possui = possui;
		this.consumiu = consumiu;
		this.deseja = deseja;
	}
	
	public char getPossui() {
		return possui;
	}

	public char getConsumiu() {
		return consumiu;
	}

	public char getDeseja() {
		return deseja;
	}

	public double getPreco() {
		return preco;
	}
	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public Genero getGenero() {
		return genero;
	}
	
	@Override
	public String toString() {
		if(genero!=null)
			return codigo +" "+nome+" "+genero.getNome()+" "+genero.getSigla()+
				" "+preco+" "+possui+" "+consumiu+" "+deseja;
		else
			return codigo +" "+nome+
					" "+preco+" "+possui+" "+consumiu+" "+deseja;
	}
	
}
