package br.edu.ifpe.apoo.negocio.validacao;

public class ValidadorEMAILAdapter implements IValidadorEMAILAdapter {
	public ValidadorEMAILAdapter() {
	}

	@Override
	public boolean isEMAIL(String email) {

		return ValidadorEMAIL.isEmail(email);
	}

	

}
