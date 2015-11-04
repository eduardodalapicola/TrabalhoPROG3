import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.xml.bind.ParseConversionEvent;


public class Readfile {
	public static void Read(Sistema s,String path,char document) throws FileNotFoundException {
		Locale.setDefault(new Locale("pt", "BR"));
		Scanner scanner = null;
		String nome = null;
		String siglaGenero = null;
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
					siglaGenero = scanner.next();
					if(scanner.hasNext()){
						nome = scanner.next();
						g = new Genero(siglaGenero, nome);
					}
					s.setCadastroGenero(g);
				}
			}
			if(document == 'p'){
				while(scanner.hasNextInt()){
					codigo = scanner.nextInt();
					if(scanner.hasNext()){
						nome = scanner.next();
						p = new Pessoa(nome, codigo);
					}
					s.setCadastroPessoa(p);
				}
			}
			if(document == 'e'){
					
					
				}
			if(document == 'm'){
				while(scanner.hasNext()){
					String linha = scanner.next();
					String parametros[] = linha.split(";");
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
					Livro l =new Livro(codigo, nome, g, preco, possui, consumiu, deseja, tamanho);
					
					int autor,ator;
					for (String string : autores) {
						if(string.length()!=0){
						autor = Integer.parseInt(string);
						ator = Integer.parseInt(string);
						Pessoa p1 = s.procuraPessoa(autor);
						l.setAutores(p1);
						}
					}
					//System.out.println(l.toString());
					
					s.adicionarLivro(l);
					
					if(tipo == 'F'){
						diretor = Integer.parseInt(parametros[3]);
					}
					if(tipo == 'S'){
						nomeSerie = parametros[7];
						temporada = Integer.parseInt(parametros[8]);
					}
				}
				for (Livro livro : s.getInventarioMidia()) {
					livro.toString();
				}
			}
		}
		    
	}
