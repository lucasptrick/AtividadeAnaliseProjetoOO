package br.edu.ifpe.apoo.negocio;

import br.edu.ifpe.apoo.entidades.Aluno;
import br.edu.ifpe.apoo.excecoes.ExcecaoAlunoInvalido;

public class FachadaNegocio implements IFachadaNegocio {

	private FachadaNegocio() {
	}
	
	private static FachadaNegocio instancia;
	
	public static FachadaNegocio getInstancia() {
		if (instancia == null) {
			instancia = new FachadaNegocio();
			
		}
		return instancia;
		
	}
	
	
	@Override
	public void inserirAluno(Aluno aluno) throws ExcecaoAlunoInvalido {
		
	
		IControladorAluno controlador = ControladorFactory.getControladorAluno();
		controlador.inserir(aluno);
	}
	

	
	@Override
	public void atualizarAluno(Aluno aluno) throws ExcecaoAlunoInvalido {
		IControladorAluno controlador = ControladorFactory.getControladorAluno();
		controlador.atualizar(aluno);
	}

	@Override
	public boolean removerAluno(long id) throws ExcecaoAlunoInvalido {
		IControladorAluno controlador = ControladorFactory.getControladorAluno();
		
		return controlador.remover(id);
	}


	@Override
	public Aluno devolverGet(long id) throws ExcecaoAlunoInvalido {
		IControladorAluno controlador = ControladorFactory.getControladorAluno();
		
		return controlador.get(id);
	}


}
