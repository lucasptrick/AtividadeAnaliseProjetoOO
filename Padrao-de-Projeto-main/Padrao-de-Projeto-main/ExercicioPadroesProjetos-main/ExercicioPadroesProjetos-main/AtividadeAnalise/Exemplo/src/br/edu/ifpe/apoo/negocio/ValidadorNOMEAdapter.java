package br.edu.ifpe.apoo.negocio;

public class ValidadorNOMEAdapter {
	private ValidadorNOME validadorNOME;

	public ValidadorNOMEAdapter(ValidadorNOME validadorNOME) {
		this.validadorNOME = validadorNOME;
	}
	
	public boolean isNome(String nome) {
		return ValidadorNOME.isNome(nome);
	}
	

}
