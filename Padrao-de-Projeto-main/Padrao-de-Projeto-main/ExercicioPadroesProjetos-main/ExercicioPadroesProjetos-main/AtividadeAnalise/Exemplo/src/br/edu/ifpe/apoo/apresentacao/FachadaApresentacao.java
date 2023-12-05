package br.edu.ifpe.apoo.apresentacao;

public class FachadaApresentacao implements IFachadaApresentacao{
	
	private static FachadaApresentacao instancia;

	protected static FachadaApresentacao getInstancia() {

		if (instancia == null) {
			instancia = new FachadaApresentacao();
		}
		return instancia;
	}

	private FachadaApresentacao() {}
	
	@Override
	public void vaiExibirMenu() {
		AlunoApresentacao apresentacao = new AlunoApresentacao();
		
		try {
			apresentacao.exibirMenu();
	
		} catch (Exception ex) {
			
			System.out.println(ex.getMessage());
	

		}}
}
