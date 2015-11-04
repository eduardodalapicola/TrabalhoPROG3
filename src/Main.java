import java.io.FileNotFoundException;
public class Main {

	public static void main(String[] args) throws FileNotFoundException{
		Sistema s = new Sistema();
		for (int i=0;i<args.length;i+=2) {
			if(args[i].equals("-g")){	
				Readfile.Read(s,args[i+1],'g');
				for (Genero gen : s.getCadastroGenero()) {
					System.out.println(gen.getSigla());
					System.out.println(gen.getNome());
				}
			}
			if(args[i].equals("-p")){
				String nome;
				int codigo;
				nome = "larila";
				codigo = 312;
				Pessoa u = new Pessoa(nome, codigo);
				s.setCadastroPessoa(u);
//				for (Usuario user : s.getCadastroUsuario()) {
//					//System.out.println(user.getNome());
//				}
			}
			if(args[i].equals("-m")){
				Readfile.Read(s, args[i+1], 'm');
			}
			if(args[i].equals("-e")){
				
			}
		}
		
	}

}

