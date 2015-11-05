import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Relatorio3 {
	@Override
	public String toString(){
		return "Data;Tomador;Atrasado?;Dias de Atraso";
		
			
	}
	
	public int getDiff(Emprestimo E,Date hoje){
		int diff = (int) ((hoje.getTime() - (E.getDevolucao().getTime()) ) / (1000 * 60 * 60 * 24) );
		return diff;
	}
	
	public void WriteFile(PrintWriter writer,Emprestimo E) throws FileNotFoundException, ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String atrasado;
		Date hoje = (Date) sdf.parse("06/11/2015");
		int dif = 0;
		
		if(hoje.after(E.getDevolucao())){
			atrasado = "Sim";
			dif = getDiff(E,hoje);
		}
		else{
			atrasado = "Nao";
		}
		writer.println(sdf.format(E.getEmprestimo())+ ";"+E.getNome()+";" + atrasado + ";"+ dif);
	}
}
