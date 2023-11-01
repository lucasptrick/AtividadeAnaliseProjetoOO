package br.edu.ifpe.apoo.apresentacao;

public class FachadaApresentacao implements IFachadaApresentacao{
	

	protected FachadaApresentacao() {}
	
	@Override
	public void vaiExibirMenu() {
		AlunoApresentacao apresentacao = new AlunoApresentacao();
		
		try {
			apresentacao.exibirMenu();
	
		} catch (Exception ex) {
			
			System.out.println(ex.getMessage());
	

		}}
}
