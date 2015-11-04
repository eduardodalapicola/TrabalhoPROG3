

public class Emprestimo {
	private int codigoMidia;
	private String emprestimo;
	private String devolucao;
	public Emprestimo(int codigoMidia, int codigoUsuario, String emprestimo, String devolucao) {
		this.codigoMidia = codigoMidia;
		this.emprestimo = emprestimo;
		this.devolucao = devolucao;
	}
	public int getCodigoMidia() {
		return codigoMidia;
	}
	public String getEmprestimo() {
		return emprestimo;
	}
	public String getDevolucao() {
		return devolucao;
	}
	
	
}
