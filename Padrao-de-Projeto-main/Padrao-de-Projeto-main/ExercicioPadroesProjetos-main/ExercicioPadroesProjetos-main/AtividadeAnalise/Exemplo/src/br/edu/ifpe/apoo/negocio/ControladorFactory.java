package br.edu.ifpe.apoo.negocio;


public class ControladorFactory {

	public static IControladorAluno getControladorAluno() {
		return ControladorAluno.getInstancia();
		
	}
}
