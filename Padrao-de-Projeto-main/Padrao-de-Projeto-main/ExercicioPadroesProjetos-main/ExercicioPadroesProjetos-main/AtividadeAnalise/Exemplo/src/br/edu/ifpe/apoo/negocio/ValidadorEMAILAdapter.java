package br.edu.ifpe.apoo.negocio;


public class ValidadorEMAILAdapter {
	private ValidadorEMAIL validadorEMAIL;

	public ValidadorEMAILAdapter(ValidadorEMAIL validadorEMAIL) {
		this.validadorEMAIL = validadorEMAIL;
	}
	
	public boolean isEMAIL(String email) {
		return ValidadorEMAIL.isEmail(email);
	}
	

}
