
import java.util.TreeSet;

public class Sistema {
	private TreeSet<Genero> cadastroGenero = new TreeSet<>();
	private TreeSet<Pessoa> cadastroPessoa = new TreeSet<>();
	private TreeSet<Livro> inventarioMidia = new TreeSet<Livro>();
	
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
	public TreeSet<Livro> getInventarioMidia() {
		return inventarioMidia;
	}
	public void adicionarLivro(Livro midia) {
		this.inventarioMidia.add(midia);
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

}
