package br.edu.ifpe.apoo.apresentacao;

public class FachadaApresentacaoFactory {
	private static FachadaApresentacao instancia;
	
	public static FachadaApresentacao getInstancia() {
		if (instancia == null ) instancia = new
				FachadaApresentacao();
		return instancia;
	}

}
