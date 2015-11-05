
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Sistema {
	private TreeSet<Genero> cadastroGenero = new TreeSet<>();
	private TreeSet<Pessoa> cadastroPessoa = new TreeSet<>();
	private LinkedHashSet<Midia> inventarioMidia = new LinkedHashSet<>();
	private TreeSet<Emprestimo> controleEmprestimo = new TreeSet<>();
	
	public TreeSet<Genero> getCadastroGenero() {
		return cadastroGenero;
	}
	public void setCadastroGenero(Genero genero) {
		this.cadastroGenero.add(genero);
	}
	public TreeSet<Pessoa> getCadastroPessoa() {
		return cadastroPessoa;
	}
	public void setCadastroPessoa(Pessoa pessoa) {
		this.cadastroPessoa.add(pessoa);
	}
	public LinkedHashSet<Midia> getInventarioMidia() {
		return inventarioMidia;
	}
	public void adicionarMidia(Midia midia) {
		this.inventarioMidia.add(midia);
	}
	
	public TreeSet<Emprestimo> getControleEmprestimo() {
		return controleEmprestimo;
	}
	public void adicionaEmprestimo(Emprestimo controleEmprestimo) {
		this.controleEmprestimo.add(controleEmprestimo);
	}
	public Genero procuraGenero(String sigla){
		for (Genero genero : cadastroGenero) {
			if(genero.getSigla().equals(sigla)){
				return genero;
			}
		}
		return null; 
	}
	public Pessoa procuraPessoa(int codigo){
		for (Pessoa pessoa : cadastroPessoa) {
			if(pessoa.getCodigo() == codigo){
				return pessoa;
			}
		}
		return null;
	}
	
	public Midia procuraMidia(int codigo){
		for (Midia midia : inventarioMidia) {
			if(midia.getCodigo() == codigo){
				return midia;
			}
		}
		return null;
	}

}
