package br.edu.ifpe.apoo.main;

import br.edu.ifpe.apoo.apresentacao.AlunoApresentacao;
import br.edu.ifpe.apoo.excecoes.ExcecaoAlunoInvalido;

public class Main {

	public static void main(String[] args) {
		AlunoApresentacao apresentacao = new AlunoApresentacao();
		
		try {
			apresentacao.exibirMenu();
		} catch (ExcecaoAlunoInvalido ex) {
			System.out.println(ex.getMessage());
		}
	}
}
