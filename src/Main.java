import java.io.FileNotFoundException;
import java.text.ParseException;
public class Main {

	public static void main(String[] args) throws FileNotFoundException, ParseException{
		Sistema s = new Sistema();
		for (int i=0;i<args.length;i+=2) {
			if(args[i].equals("-g")){	
				Readfile.Read(s,args[i+1],'g');
//				for (Genero gen : s.getCadastroGenero()) {
//					System.out.println(gen.toString());
//				}
			}
			if(args[i].equals("-p")){
				Readfile.Read(s, args[i+1], 'p');
//				for (Pessoa p : s.getCadastroPessoa()) {
//					System.out.println(p.toString());
//				}
			}
			if(args[i].equals("-m")){
				//Readfile.Read(s, args[i+1], 'm');
			}
			if(args[i].equals("-e")){
				Readfile.Read(s, args[i+1], 'e');
				for (Emprestimo e : s.getControleEmprestimo()) {
					System.out.println(e.toString());
				}
			}
		}
		
	}

}

