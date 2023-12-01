package br.edu.ifpe.apoo.negocio.validacao;


public class ValidadorEMAILAdapter {

	public ValidadorEMAILAdapter() {}
	
	public boolean isEMAIL(String email) {
		return ValidadorEMAIL.isEmail(email);
	}
	

}
