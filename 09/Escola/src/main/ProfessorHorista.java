package main;

public class ProfessorHorista extends Professor {
	private int horasTrabalhadas;
	private double valorHora;
	
	public ProfessorHorista(String nome, String matricula, int idade, int horasTrabalhadas, double valorHora, double salario) {
		super(nome, matricula, idade, salario);
		this.horasTrabalhadas = horasTrabalhadas;
		this.valorHora = 25.00;
	}
	
	public void calcularSalario() {
		setSalario(this.horasTrabalhadas * this.valorHora);
	}
	
//	Getters
	public int getHorasTrabalhadas() {
		return this.horasTrabalhadas;
	}
	public double getValorHora() {
		return this.valorHora;
	}
	
//	Setters
	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
}
