package br.com.cotacaoDeMoedas;

import java.awt.Frame;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.JOptionPane;

import org.json.JSONException;
import org.omg.CORBA.PUBLIC_MEMBER;

import br.com.cotacaoDeMoedas.controller.ControllerCotacao;
import br.com.cotacaoDeMoedas.model.Model;
import br.com.cotacaoDeMoedas.model.Moeda;
import br.com.cotacaoDeMoedas.view.FormPrincipal;

public class Cotacao {

	// http://www.leepoint.net/GUI/structure/40mvc.html

	static FormPrincipal frmPrincipal;
	
	public static void main(String[] args) throws JSONException {	
				
		frmPrincipal = new FormPrincipal();
		frmPrincipal.setVisible(true);	
		

		
//		Object teste = cc.pesquisar(0);
//		
//		System.out.println("Classe Principal "+teste);
		
	
		

		
		
//		
//		// TODO Auto-generated method stub		
//		Model model = new Model();
//		model.getData("http://api.promasters.net.br/cotacao/v1/valores");
//		
//		System.out.println("Moeda especifica => "+model.getMoeda(0).getNome()+" \n");
//		
//		List<Moeda> result = model.getBD();
//		
//		//System.out.println(result);
//		System.out.println(">>> Cotação de moedas <<<\n");
//								
//		for(Moeda moeda:result){
//			
//			System.out.println("1 " + moeda.getNome() + " = " + 
//					           Cotacao.formataMoeda(moeda.getValor())+
//					           "\nUltima consulta: " + moeda.getUltimaConsulta() + 
//					           "\nFonte" + moeda.getFonte() + "\n" );			
//		}		
//
//	}
//	
//	
//	public static String formataMoeda(double valor){
//		
//		BigDecimal val = new BigDecimal(String.valueOf(valor));
//		NumberFormat nf = NumberFormat.getCurrencyInstance();
//		String valorFormatado = nf.format(val);
//		
//		return valorFormatado;		
	}
	
}
