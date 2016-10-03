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
	private FormPrincipal view;
	
	public ControllerCotacao(Model model) {		
		this.model = model;
	}

	//Carrega os dados do bd
	public void carregarBd() throws JSONException{
		model.getData("http://api.promasters.net.br/cotacao/v1/valores");		
	}
	
	//Busca os dados da moeda selecionada de acordo com a identificação do index
	public void pesquisar(int index){	

		Moeda mc = (Moeda) model.getMoeda(index);
		
		switch (index) {
		case 0: mc.setImg("/br/com/cotacaoDeMoedas/view/img/0-dolar.png"); break;			
		case 1: mc.setImg("/br/com/cotacaoDeMoedas/view/img/1-euro.png"); break;
		case 2: mc.setImg("/br/com/cotacaoDeMoedas/view/img/2-pesoArgentino.png"); break;
		case 3: mc.setImg("/br/com/cotacaoDeMoedas/view/img/3-libraEsterlina.png"); break;
		case 4: mc.setImg("/br/com/cotacaoDeMoedas/view/img/4-bitcoin.png"); break;
		default:
			break;
		}
		
		model.setValores(mc.getNome(), formataMoeda(mc.getValor()), mc.getFonte(), mc.getImg());
	
	}	
	
	//Formata a moeda para R$ (real)
	public String formataMoeda(double valor){

		BigDecimal val = new BigDecimal(String.valueOf(valor));
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String valorFormatado = nf.format(val);

		return valorFormatado;		
	}

}
