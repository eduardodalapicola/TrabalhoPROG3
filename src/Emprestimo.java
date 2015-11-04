import java.util.Date;

public class Emprestimo implements Comparable<Emprestimo>{
	private int codigoMidia;
	private Date emprestimo;
	private Date devolucao;
	
	public Emprestimo(int codigoMidia, Date emprestimo, Date devolucao) {	
		this.codigoMidia = codigoMidia;
		this.emprestimo = emprestimo;
		this.devolucao = devolucao;
	}
	public int getCodigoMidia() {
		return codigoMidia;
	}
	public Date getEmprestimo() {
		return emprestimo;
	}
	public Date getDevolucao() {
		return devolucao;
	}
	
	@Override
	public int compareTo(Emprestimo o) {
		return 1;
	}
	
	@Override
	public String toString() {
		return codigoMidia + " " + emprestimo + " " + devolucao;
	}
	
}
