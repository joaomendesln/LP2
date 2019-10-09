package main;

public class Professor {
	private String nome;
	private String matricula;
	private int idade;
	private double salario;
	
	public Professor(String nome, String matricula, int idade, double salario) {
		this.nome = nome;
		this.matricula = matricula;
		this.idade = idade;
		this.salario = salario;
	}
	
	//Getters
	public String getNome() {
		return this.nome;
	}
	public String getMatricula() {
		return this.matricula;
	}
	public int getIdade() {
		return this.idade;
	}
	public double getSalario() {
		return this.salario;
	}
	
	//Setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
}
