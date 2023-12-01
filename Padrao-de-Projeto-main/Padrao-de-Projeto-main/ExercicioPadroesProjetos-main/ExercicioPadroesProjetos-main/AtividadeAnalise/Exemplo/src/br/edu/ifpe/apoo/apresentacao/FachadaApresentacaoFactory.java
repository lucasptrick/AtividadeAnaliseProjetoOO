package br.edu.ifpe.apoo.apresentacao;

public class FachadaApresentacaoFactory {
	private static IFachadaApresentacao instancia;
	
	public static IFachadaApresentacao getInstancia() {
		if (instancia == null ) instancia = new
				FachadaApresentacao();
		return instancia;
	}

}
