import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class Readfile {
	public static void Read(Sistema s,String path,char document) throws FileNotFoundException, ParseException {
		Locale.setDefault(new Locale("pt", "BR"));
		Scanner scanner = null;
		String nome = null;
		String siglaGenero = null;
		String linha = null;
		String parametros[] = null;
		String tomador = null;
		int diretor = 0;
		String autores[] = null;
		String nomeSerie = null;
		int temporada = 0;
		int tamanho = 0;
		char tipo = 0;
		char possui = 0;
		char consumiu = 0;
		char deseja = 0;
		double preco = 0;
		Genero g = null;
		Pessoa p = null;
		int codigo = 0;
		try{
			scanner = new Scanner(new FileReader(path))
					.useDelimiter("\n");
		    }
		    catch(FileNotFoundException exception){
		      System.out.println("File does Not Exist Please Try Again: ");
		    }
			
		if(scanner.hasNext())
			scanner.next();
		
			if(document == 'g'){
				while(scanner.hasNext()){
					linha = scanner.next();
					parametros = linha.split(";");
				
					siglaGenero = parametros[0];
					nome = parametros[1];
					g = new Genero(siglaGenero, nome);
					s.setCadastroGenero(g);
				}
			}
			if(document == 'p'){
				while(scanner.hasNext()){
					linha = scanner.next();
					parametros = linha.split(";");
					codigo = Integer.parseInt(parametros[0]);
					nome = parametros[1];
					p = new Pessoa(nome, codigo);
					s.setCadastroPessoa(p);
				}
			}
			if(document == 'e'){
				while(scanner.hasNext()){
					linha = scanner.next();
					parametros = linha.split(";");
					codigo = Integer.parseInt(parametros[0]);
					tomador = parametros[1];
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					Date emprestimo = (Date) format.parse(parametros[2]);
					Date devolucao = (Date) format.parse(parametros[3]);
					Emprestimo e = new Emprestimo(codigo, emprestimo, devolucao);
					s.adicionaEmprestimo(e);
				}
					
				}
			if(document == 'm'){
				while(scanner.hasNext()){
					linha = scanner.next();
					parametros = linha.split(";");
//					for (String string : parametros) {
//						System.out.print(string+" ");
//					}System.out.print("\n");
					codigo = Integer.parseInt(parametros[0]);
					nome = parametros[1];
					tipo = parametros[2].charAt(0);
					autores = parametros[4].split(",");
					tamanho = Integer.parseInt(parametros[5]);
					siglaGenero = parametros[6];
					g = s.procuraGenero(siglaGenero);
					if(parametros[9].length()!=0)	possui = parametros[9].charAt(0);
					if(parametros[10].length()!=0)	consumiu = parametros[10].charAt(0);
					if(parametros[11].length()!=0)	deseja = parametros[11].charAt(0);
					parametros[12] = parametros[12].replace(',','.');
					preco = Double.parseDouble(parametros[12]);

					
					if(tipo == 'L'){
						Livro l = new Livro(codigo, nome, g, preco, possui, consumiu, deseja, tamanho);
						int autor;
						for (String string : autores) {
							if(string.length()!=0){
								autor = Integer.parseInt(string);
								Pessoa p1 = s.procuraPessoa(autor);
								l.setAutores(p1);
							}
						}
						s.adicionarMidia(l);
					}
					
					if(tipo == 'F'){
						diretor = Integer.parseInt(parametros[3]);
						Filme f = new Filme(codigo, nome, g, preco, possui, consumiu, deseja, diretor, tamanho);
						int ator;
						for (String string : autores) {
							if(string.length()!=0){
								ator = Integer.parseInt(string);
								Pessoa p1 = s.procuraPessoa(ator);
								f.adicionaAtor(p1);
							}
						}
						s.adicionarMidia(f);
					}
					if(tipo == 'S'){
						nomeSerie = parametros[7];
						temporada = Integer.parseInt(parametros[8]);
						Serie serie = new Serie(codigo, nome, g, preco, possui, consumiu, deseja, temporada, nomeSerie, tamanho);
						int ator;
						for (String string : autores) {
							if(string.length()!=0){
								ator = Integer.parseInt(string);
								Pessoa p1 = s.procuraPessoa(ator);
								serie.adicionaActors(p1);
							}
						}
						s.adicionarMidia(serie);
							
					}
				}
				for (Midia m : s.getInventarioMidia()) {
					System.out.println(m.toString());
				}
			}
		}
		    
	}
