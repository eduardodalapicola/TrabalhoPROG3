import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Readfile {
	public static void Read(Sistema s,String path,char document,boolean readonly,PrintWriter gravarArq) throws ParseException, IOException {
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
		Livro l = null;
		Filme f = null;
		Serie serie = null;
		Emprestimo e = null;
		int codigo = 0;
		try{
			scanner = new Scanner(new FileReader(path))
					.useDelimiter("\n");
		    }
		    catch(FileNotFoundException exception){
		      System.out.println("Erro de I/O");
		    }
			
		if(scanner.hasNext())
			scanner.next();
		
		while(scanner.hasNext()){
			try{
			linha = scanner.next();
			parametros = linha.split(";");
			if(document == 'g'){
					siglaGenero = parametros[0];
					nome = parametros[1];
					g = new Genero(siglaGenero, nome);
				}
			if(document == 'p'){
					codigo = Integer.parseInt(parametros[0]);
					nome = parametros[1];
					p = new Pessoa(nome, codigo);
				}

			if(document == 'm'){
					codigo = Integer.parseInt(parametros[0]);
					tamanho = Integer.parseInt(parametros[5]);
					nome = parametros[1];
					tipo = parametros[2].charAt(0);
					autores = parametros[4].split(",");
					siglaGenero = parametros[6];
					g = s.procuraGenero(siglaGenero);
					
					if(g == null){
						System.out.println("Inconsistências na entrada");
						continue;
					}
					
					if(parametros[9].length()!=0)	possui = parametros[9].charAt(0);
					else possui = ' ';
					if(parametros[10].length()!=0)	consumiu = parametros[10].charAt(0);
					else consumiu = ' ';
					if(parametros[11].length()!=0)	deseja = parametros[11].charAt(0);
					else deseja = ' ';
					parametros[12] = parametros[12].replace(',','.');
					preco = Double.parseDouble(parametros[12]);
					
					if(tipo == 'L'){
						l = new Livro(codigo, nome, g, preco, possui, consumiu, deseja, tamanho);
						int autor;
						for (String string : autores) {
							if(string.length()!=0){
								autor = Integer.parseInt(string);
								Pessoa p1 = s.procuraPessoa(autor);
								if(p1 == null){
									System.out.println("Inconsistências na entrada");
									continue;
								}
								l.setAutores(p1);
							}
						}
					}
					
					if(tipo == 'F'){
						diretor = Integer.parseInt(parametros[3]);
						f = new Filme(codigo, nome, g, preco, possui, consumiu, deseja, diretor, tamanho);
						int ator;
						for (String string : autores) {
							if(string.length()!=0){
								ator = Integer.parseInt(string);
								Pessoa p1 = s.procuraPessoa(ator);
								if(p1 == null){
									System.out.println("Inconsistências na entrada");
									continue;
								}
								f.adicionaAtor(p1);
							}
						}
					}
					if(tipo == 'S'){
						nomeSerie = parametros[7];
						temporada = Integer.parseInt(parametros[8]);
						serie = new Serie(codigo, nome, g, preco, possui, consumiu, deseja, temporada, nomeSerie, tamanho);
						int ator;
						for (String string : autores) {
							if(string.length()!=0){
								ator = Integer.parseInt(string);
								Pessoa p1 = s.procuraPessoa(ator);
								if(p1 == null){
									System.out.println("Inconsistências na entrada");
									continue;
								}
								serie.adicionaActors(p1);
							}
						}
					}
					possui = 0;
					consumiu = 0;
					deseja = 0;
			}

			
			if(document == 'e'){
					codigo = Integer.parseInt(parametros[0]);
					tomador = parametros[1];
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					Date emprestimo = (Date) format.parse(parametros[2]);
					Date devolucao = (Date) format.parse(parametros[3]);
					Midia m = s.procuraMidia(codigo);
					if(m == null){
						System.out.println("Inconsistências na entrada");
						continue;
					}
					e = new Emprestimo(m,tomador, emprestimo, devolucao);
			}
		}catch(ParseException parse){
			System.out.println("Erro de Formatação");
		}
		
			if(document == 'g')
				s.setCadastroGenero(g);
			if(document == 'p')
				s.setCadastroPessoa(p);
			if(document == 'm')
				if(tipo == 'L')
					s.adicionarMidia(l);
				if(tipo == 'F')
					s.adicionarMidia(f);
				if(tipo == 'S')
					s.adicionarMidia(serie);
			if(document == 'e')
				s.adicionaEmprestimo(e);				
		}
		if(readonly){
			gravarArq.print(linha);	
		}
	}
}

