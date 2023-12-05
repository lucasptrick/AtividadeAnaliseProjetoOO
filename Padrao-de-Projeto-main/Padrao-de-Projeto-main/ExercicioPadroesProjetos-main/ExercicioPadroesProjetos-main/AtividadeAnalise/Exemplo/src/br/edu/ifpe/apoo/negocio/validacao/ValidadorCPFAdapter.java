package br.edu.ifpe.apoo.negocio.validacao;

public class ValidadorCPFAdapter implements IValidadorCPFAdapter {

	public ValidadorCPFAdapter() {
	}
	
	public String formatarCPF(String cpf) {
		return ValidadorCPF.formatarCPF(cpf);
	}

	@Override
	public boolean isCPF(String cpf) {
		return ValidadorCPF.isCPF(cpf);
	}
}
