package br.edu.ifpe.apoo.negocio;

public class FachadaNegocioFactory {

	private static IFachadaNegocio instancia;
	
	public static IFachadaNegocio getInstancia() {
		return (instancia == null ) ? new FachadaNegocio() : instancia;
		
	}
}
