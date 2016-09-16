package br.com.cotacaoDeMoedas.controller;

import java.awt.List;
import java.math.BigDecimal;
import java.text.NumberFormat;

import javax.swing.JOptionPane;

import org.json.JSONException;

import br.com.cotacaoDeMoedas.Cotacao;
import br.com.cotacaoDeMoedas.model.Model;
import br.com.cotacaoDeMoedas.model.Moeda;
import br.com.cotacaoDeMoedas.view.FormPrincipal;

public class ControllerCotacao {
	private Model model = new Model();	

	
	public void carregarBd() throws JSONException{
		model.getData("http://api.promasters.net.br/cotacao/v1/valores");		
	}
		
	public String[] pesquisar(int indexMoeda) throws JSONException{		
		Moeda mc = (Moeda) model.getMoeda(indexMoeda);
		
		String[] dados = new String[3];
		 
		dados[0] = mc.getNome();
		dados[1] = formataMoeda(mc.getValor());
		dados[2] = mc.getFonte();		

		return dados;			
	}	
	
	public static String formataMoeda(double valor){

		BigDecimal val = new BigDecimal(String.valueOf(valor));
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String valorFormatado = nf.format(val);

		return valorFormatado;		
	}
}
