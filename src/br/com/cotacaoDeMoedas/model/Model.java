package br.com.cotacaoDeMoedas.model;
import java.util.List;

import org.json.JSONException;

public class Model {
	private List<Moeda> bd;
	
	private Conenection con = new Conenection();
	
	//Retorna a lista de moedas
	public List<Moeda> getBD(){
		return bd;
	}
	
	//Salva todos os dados no bd
	public void getData(String url) throws JSONException{
		bd = con.getData(url);
	}
	
	//Retorna o objeto referenta a moedas especifica
	public Object getMoeda(int index){
		return bd.get(index);
	}
	
	
}
