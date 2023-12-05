package br.edu.ifpe.apoo.negocio.validacao;

public class ValidadorNOMEAdapter implements IValidadorNOMEAdapter {

	public ValidadorNOMEAdapter() {
	}

	@Override
	public boolean isNome(String nome) {

		return ValidadorNOME.isNome(nome);
	}

}
