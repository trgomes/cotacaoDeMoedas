package br.com.cotacaoDeMoedas.model;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import br.com.cotacaoDeMoedas.view.Observer;

public class Model implements Subject {
	private List<Moeda> bd;
	
	private ArrayList observers;
	private String nomeMoeda;
	private String valorMoeda;
	private String fonteMoeda;
	private String imgMoeda;
	
	private Conenection con;
	
	public Model(){
		observers = new ArrayList();
		con = new Conenection();
	}
		
	//Retorna a lista de moedas
	public List<Moeda> getBD(){
		return bd;
	}
	
	//Salva todos os dados no bd
	public void getData(String url){
		try {
			bd = con.getData(url);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Retorna o objeto referenta a moedas especifica
	public Object getMoeda(int index){
		return bd.get(index);
	}

	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);		
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}		
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.update(nomeMoeda, valorMoeda, fonteMoeda,imgMoeda);
		}
		
	}
	
	public void setValores(String nomeMoeda, String valorMoeda, String fonteMoeda, String imgMoeda) {
		this.nomeMoeda = nomeMoeda;
		this.valorMoeda = valorMoeda;
		this.fonteMoeda = fonteMoeda;
		this.imgMoeda = imgMoeda;
		notifyObservers();
	}
	
}
