package br.com.cotacaoDeMoedas.controller;

import org.json.JSONException;

import br.com.cotacaoDeMoedas.model.Model;
import br.com.cotacaoDeMoedas.view.FormPrincipal;

public class ControllerCotacao {
	
	private FormPrincipal frmPrincipal = new FormPrincipal();
	
	private Model model = new Model();	
	
	public void carregarModelo() throws JSONException{
		model.getData("http://api.promasters.net.br/cotacao/v1/valores");		
	}
		
	public void pesquisar(int valor) throws JSONException{		
		model.getMoeda(valor).getNome();
		model.getMoeda(valor).getValor();
		model.getMoeda(valor).getFonte();
		
	}
	
	

	
	
	
}
