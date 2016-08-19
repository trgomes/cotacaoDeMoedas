package br.com.cotacaoDeMoedas.model;

public class Moeda {

	private String nome;
	private double valor;
	private String ultimaConsulta;
	private String fonte;
	
	
//	public Moeda(String nome, double valor, String ultimaConsulta, String fonte) {
//		this.nome = nome;
//		this.valor = valor;
//		this.ultimaConsulta = ultimaConsulta;
//		this.fonte = fonte;
//	}
	
	
	//Construtor para teste
	public Moeda(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}

	//Setters e Getters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public String getUltimaConsulta() {
		return ultimaConsulta;
	}


	public void setUltimaConsulta(String ultimaConsulta) {
		this.ultimaConsulta = ultimaConsulta;
	}


	public String getFonte() {
		return fonte;
	}


	public void setFonte(String fonte) {
		this.fonte = fonte;
	}
	
	
}
