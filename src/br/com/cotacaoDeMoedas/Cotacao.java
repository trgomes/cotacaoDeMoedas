package br.com.cotacaoDeMoedas;

import java.util.List;

import org.json.JSONException;

import br.com.cotacaoDeMoedas.model.Model;
import br.com.cotacaoDeMoedas.model.Moeda;

public class Cotacao {

	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub		
		Model model = new Model();
		model.getData("http://api.promasters.net.br/cotacao/v1/valores");
		
		List<Moeda> result = model.getBD();
		
		//System.out.println(result);
		System.out.println(">>> Cotação de moedas <<<\n");
		
		for(Moeda m:result){
			
			System.out.println("1 " + m.getNome() + " = R$" + m.getValor());
			
		}	

	}

}
