package br.edu.ifpe.apoo.negocio;


public class AlunoControladorAbstractFactory {
	
	public static IControladorAluno getDAO() {
		return ControladorAluno.getInstancia();
	}
}
