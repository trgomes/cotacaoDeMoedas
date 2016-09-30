package br.com.cotacaoDeMoedas.controller;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.NumberFormat;

import javax.swing.JOptionPane;

import org.json.JSONException;

import br.com.cotacaoDeMoedas.Cotacao;
import br.com.cotacaoDeMoedas.model.Model;
import br.com.cotacaoDeMoedas.model.Moeda;
import br.com.cotacaoDeMoedas.model.Subject;
import br.com.cotacaoDeMoedas.view.FormPrincipal;

public class ControllerCotacao implements AcessoController{
	
	private Model model;	
//	private Subject model;
	private FormPrincipal view;
	
	public ControllerCotacao(Model model) {		
		this.model = model;
//		this.view = new FormPrincipal(this);
//		this.view.btnPesquisar.addActionListener(this);
	}

	public void carregarBd() throws JSONException{
		model.getData("http://api.promasters.net.br/cotacao/v1/valores");		
	}
		
	public void pesquisar(int index){	

		Moeda mc = (Moeda) model.getMoeda(index);
		
		model.setValores(mc.getNome(), formataMoeda(mc.getValor()), mc.getFonte());
	
	}	
	
	public String formataMoeda(double valor){

		BigDecimal val = new BigDecimal(String.valueOf(valor));
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String valorFormatado = nf.format(val);

		return valorFormatado;		
	}

}
