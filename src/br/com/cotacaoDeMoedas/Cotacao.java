package br.com.cotacaoDeMoedas;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

import org.json.JSONException;
import org.omg.CORBA.PUBLIC_MEMBER;

import br.com.cotacaoDeMoedas.model.Model;
import br.com.cotacaoDeMoedas.model.Moeda;

public class Cotacao {

	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub		
		Model model = new Model();
		model.getData("http://api.promasters.net.br/cotacao/v1/valores");
		
		List<Moeda> result = model.getBD();
		
		//System.out.println(result);
		System.out.println(">>> Cota��o de moedas <<<\n");
								
		for(Moeda moeda:result){
			
			System.out.println("1 " + moeda.getNome() + " = " + 
					           Cotacao.formataMoeda(moeda.getValor())+
					           "\nUltima consulta: " + moeda.getUltimaConsulta() + 
					           "\nFonte" + moeda.getFonte() + "\n" );
			
		}		

	}
	
	
	public static String formataMoeda(double valor){
		
		BigDecimal val = new BigDecimal(String.valueOf(valor));
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String valorFormatado = nf.format(val);
		
		return valorFormatado;		
	}
	
	

}
