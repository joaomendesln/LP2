package main;

public class SistemaEscolar {
	public static void main(String[] args) {
		Prova prova11 = new Prova(4.0, 2.5);
		Prova prova12 = new Prova(1.0, 7.0);
		Prova prova21 = new Prova(6.5, 3.5);
		Prova prova22 = new Prova(0.0, 3.0);
		Prova prova31 = new Prova(5.0, 4.0);
		Prova prova32 = new Prova(6.0, 1.5);
		
		Aluno aluno1 = new Aluno(prova11, prova12);
		Aluno aluno2 = new Aluno(prova21, prova22);
		Aluno aluno3 = new Aluno(prova31, prova32);
		
		Turma lp2 = new Turma(aluno1, aluno2, aluno3);
		
		System.out.println(lp2.calcularMedia());
	}
}
