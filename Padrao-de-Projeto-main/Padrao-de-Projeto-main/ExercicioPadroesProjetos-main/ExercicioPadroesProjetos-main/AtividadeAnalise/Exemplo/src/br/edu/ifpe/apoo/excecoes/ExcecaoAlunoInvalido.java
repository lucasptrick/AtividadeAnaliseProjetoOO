package br.edu.ifpe.apoo.excecoes;

public class ExcecaoAlunoInvalido extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcecaoAlunoInvalido() {
		super();
	}

	public ExcecaoAlunoInvalido(String message) {
		super(message);
	}
}
