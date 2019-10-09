package main;
import java.util.*;

public class Escola {
	private ArrayList<Professor> listaProfessor;
	
	public Escola(ArrayList<Professor> listaProfessor) {
		this.listaProfessor = listaProfessor;
	}
	
	public void adicionarProfessor(Professor professor) {
		this.listaProfessor.add(professor);
	}
	public void removerProfessor(String matriculaRemover) {
		this.listaProfessor.forEach(professor -> {if(professor.getMatricula() == matriculaRemover) this.listaProfessor.remove(professor);} );
	}
	public int quantidadeProfessores() {
		return this.listaProfessor.size();
	}
	public Professor maiorSalario() {
		Professor professorMaiorSalario = new Professor("", "", 0, 0.0);
		for (Professor professor: this.listaProfessor) {
			if (professor.getSalario() > professorMaiorSalario.getSalario()) {
				professorMaiorSalario = professor;
			}
		}
		return professorMaiorSalario;
	}
	
	public static void main(String[] args) {
		
	}
}
