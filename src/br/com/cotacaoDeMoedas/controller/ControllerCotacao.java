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
import br.com.cotacaoDeMoedas.view.FormPrincipal;

public class ControllerCotacao implements ActionListener{
	
	private Model model;	
	private FormPrincipal view;
	
	public ControllerCotacao(Model model, FormPrincipal view) {		
		this.model = model;
		this.view = view;
		this.view.btnPesquisar.addActionListener(this);
	}

	public void carregarBd() throws JSONException{
		model.getData("http://api.promasters.net.br/cotacao/v1/valores");		
	}
		
	public void pesquisar(){		
		Moeda mc = (Moeda) model.getMoeda(view.getIndexMoeda());
		
//		String[] dados = new String[3];
		 
		String nomeMoeda = mc.getNome();
		String valorMoeda = formataMoeda(mc.getValor());
		String fonteMoeda = mc.getFonte();		
		
		view.update(nomeMoeda, valorMoeda, fonteMoeda);
	
	}	
	
	public static String formataMoeda(double valor){

		BigDecimal val = new BigDecimal(String.valueOf(valor));
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String valorFormatado = nf.format(val);

		return valorFormatado;		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub		
		
		view.setIndexMoeda(view.cbxMoeda.getSelectedIndex());
		
		pesquisar();
		
	}
}
