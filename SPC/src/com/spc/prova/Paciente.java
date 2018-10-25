package com.spc.prova;

public class Paciente {
	private String nome;
	private String sexo;
	private double peso;
	private int idade;
	private double altura;
	protected String getNome() {
		return nome;
	}
	protected void setNome(String nome) {
		this.nome = nome;
	}
	protected String getSexo() {
		return sexo;
	}
	protected void setSexo(String sexo) {
			this.sexo = sexo;
		
	}
	protected double getPeso() {
		return peso;
	}
	protected void setPeso(double peso) {
		this.peso = peso;
	}
	protected int getIdade() {
		return idade;
	}
	protected void setIdade(int idade) {
		this.idade = idade;
	}
	protected double getAltura() {
		return altura;
	}
	protected void setAltura(double altura) {
		this.altura = altura;
	}
	
	
	
}
