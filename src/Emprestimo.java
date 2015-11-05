import java.text.SimpleDateFormat;
import java.util.Date;

public class Emprestimo implements Comparable<Emprestimo>{
	private Midia midia;
	private String nome;
	private Date emprestimo;
	private Date devolucao;
	
	public Emprestimo(Midia midia, String nome, Date emprestimo, Date devolucao) {
		this.midia = midia;
		this.nome = nome;
		this.emprestimo = emprestimo;
		this.devolucao = devolucao;
	}
	public Midia getMidia() {
		return midia;
	}
	public Date getEmprestimo() {
		return emprestimo;
	}
	public Date getDevolucao() {
		return devolucao;
	}

	public String getNome() {
		return nome;
	}
	@Override
	public int compareTo(Emprestimo o) {
		return o.getEmprestimo().compareTo(emprestimo);
	}
	
	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		if(midia != null)
			return midia.getCodigo()+ ";"+nome+ ";" + dateFormat.format(emprestimo) + ";" + dateFormat.format(devolucao);
		else 
			return "Inconsistências na entrada";
	}
	
}
