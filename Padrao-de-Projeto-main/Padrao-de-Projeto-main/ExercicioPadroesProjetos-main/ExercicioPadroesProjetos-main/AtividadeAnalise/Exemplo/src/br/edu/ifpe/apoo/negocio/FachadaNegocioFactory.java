package br.edu.ifpe.apoo.negocio;

public class FachadaNegocioFactory {

	public static IFachadaNegocio getFachadaNegocio() {
		return FachadaNegocio.getInstancia();

	}

}
