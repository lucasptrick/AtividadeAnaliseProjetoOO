package br.edu.ifpe.apoo.negocio;

public class FachadaNegocioFactory {

	private static FachadaNegocio instancia;
	
	public static FachadaNegocio getInstancia() {
		/*if (instancia == null) instancia = new FachadaNegocio();*/
	

		
		return (instancia == null ) ? new FachadaNegocio()  : instancia  ;
	}
}
