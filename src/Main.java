import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
public class Main {

	public static void main(String[] args) throws ParseException, IOException{
		Sistema s = new Sistema();
		int gposfile = 0,pposfile = 0,mposfile = 0,eposfile = 0;
		boolean readonly = false,writeonly = false,writeandread = false;
		for (int i=0;i<args.length;i+=2) {
			if(args[i].equals("-g"))
				gposfile = i+1;
			else if(args[i].equals("-p"))
				pposfile = i+1;
			else if(args[i].equals("-m"))
				mposfile = i+1;
			else if(args[i].equals("-e"))
				eposfile = i+1;
			else if(args[i].equals("--read-only")){
				readonly = true;
				i--;
			}
			else if(args[i].equals("--write-only")){
					writeonly = true;
					i--;
			}
			else
				writeandread = true;
		}
			
		
			if(readonly){

				
				FileWriter dat = new FileWriter("inventario.dat");
				PrintWriter gravarArq = new PrintWriter(dat);
				Readfile.Read(s,args[gposfile],'g',true,gravarArq);
//				for (Genero gen : s.getCadastroGenero()) {
//					System.out.println(gen.toString());
//				}

				Readfile.Read(s, args[pposfile], 'p',true,gravarArq);
//				for (Pessoa p : s.getCadastroPessoa()) {
//					System.out.println(p.toString());
//				}
			
				Readfile.Read(s, args[mposfile], 'm',true,gravarArq);
//				for (Midia m : s.getInventarioMidia()) {
//					System.out.println(m.toString());
//				}

				Readfile.Read(s, args[eposfile], 'e',true,gravarArq);
//				for (Emprestimo e : s.getControleEmprestimo()) {
//					System.out.println(e.toString());
//				}
				PrintWriter writer;
				writer = new PrintWriter("3-emprestimos.csv", "UTF-8");
				Relatorio3 relat3 = new Relatorio3();
				writer.println(relat3.toString());
				for (Emprestimo e : s.getControleEmprestimo()) {
					System.out.println(e.toString());
					relat3.WriteFile(writer,e);
				}
				writer.close();
				dat.close();
			}
			if(writeonly){
				
			}
	}

}

