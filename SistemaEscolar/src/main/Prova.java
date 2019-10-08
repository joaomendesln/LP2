package main;

public class Prova {
	private double notaParte1;
	private double notaParte2;
	
	public Prova(double nota1, double nota2) {
		this.notaParte1 = nota1;
		this.notaParte2 = nota2;
	}
	
	public double calcularNotaTotal() {
		return this.notaParte1 + this.notaParte2;
	}
}
