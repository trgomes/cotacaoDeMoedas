package br.com.cotacaoDeMoedas.model;
import java.util.List;

import org.json.JSONException;

public class Model {
	private List<Moeda> bd;
	
	private Conenection con = new Conenection();
	
	
	public List<Moeda> getBD(){
		return bd;
	}
	
	public void getData(String url) throws JSONException{
		bd = con.getData(url);
	}
}
