package br.com.cotacaoDeMoedas.controller;

import javax.swing.JOptionPane;

import org.json.JSONException;

import br.com.cotacaoDeMoedas.Cotacao;
import br.com.cotacaoDeMoedas.model.Model;
import br.com.cotacaoDeMoedas.model.Moeda;
import br.com.cotacaoDeMoedas.view.FormPrincipal;

public class ControllerCotacao {
	
//	public static FormPrincipal frmPrincipal = new FormPrincipal();	
	private Model model = new Model();
	

	
	public void carregarBd() throws JSONException{
		model.getData("http://api.promasters.net.br/cotacao/v1/valores");		
	}
		
	public Moeda pesquisar(int indexMoeda) throws JSONException{		
		Moeda mc = (Moeda) model.getMoeda(indexMoeda);
		
		mc.getNome();
		mc.getValor();
		mc.getFonte();
		
		return mc;		
		
	}
	
	
	

	
	
	
}
