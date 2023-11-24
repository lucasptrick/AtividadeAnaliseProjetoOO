package br.edu.ifpe.apoo.negocio;

public class ValidadorCPFAdapter implements IValidadorCPFAdapter {
	private ValidadorCPF validadorCPF;
	
	public ValidadorCPFAdapter(ValidadorCPF validadorCPF) {
		this.validadorCPF = validadorCPF;
	}
	@Override
	public boolean isCPF(String cpf) {
		return ValidadorCPF.isCPF(cpf);
	}
	

}
