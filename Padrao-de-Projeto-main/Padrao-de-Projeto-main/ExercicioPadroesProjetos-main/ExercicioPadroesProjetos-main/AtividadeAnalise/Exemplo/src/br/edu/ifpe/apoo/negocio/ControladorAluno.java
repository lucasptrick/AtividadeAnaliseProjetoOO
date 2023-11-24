package br.edu.ifpe.apoo.negocio;

import java.util.ArrayList;

import br.edu.ifpe.apoo.dao.AlunoDAO;
import br.edu.ifpe.apoo.dao.AlunoDAOAbstractFactory;
import br.edu.ifpe.apoo.dao.AlunoDAOArquivos;
import br.edu.ifpe.apoo.dao.AlunoDAOList;
import br.edu.ifpe.apoo.entidades.Aluno;
import br.edu.ifpe.apoo.excecoes.ExcecaoAlunoInvalido;

public class ControladorAluno implements IControladorAluno {
	
	private static ControladorAluno instancia;
	

	protected static ControladorAluno getInstancia() {
		if (instancia == null) {
			instancia = new ControladorAluno();
		}

		return instancia;
	}
	
	private ControladorAluno() {}
	
	public void inserir(Aluno aluno) throws ExcecaoAlunoInvalido {
		if (!this.isValido(aluno)) {
			
		}

		AlunoDAO dao = AlunoDAOAbstractFactory.getDAO();
		dao.inserir(aluno);
	}
	
	public void atualizar(Aluno aluno) throws ExcecaoAlunoInvalido {
		if (!this.isValido(aluno)) {
			
		}
		
		AlunoDAO dao = AlunoDAOAbstractFactory.getDAO();
		dao.atualizar(aluno);
	}
	
	@Override
	public boolean remover(long id) {
		AlunoDAO dao = AlunoDAOAbstractFactory.getDAO();
		dao.remover(id);
		
		return false; 
	}
	
	@Override
	public Aluno get(long id) {
		AlunoDAO dao = AlunoDAOAbstractFactory.getDAO();
		
		return dao.get(id);
	}
	
	private boolean isValido(Aluno aluno) throws ExcecaoAlunoInvalido  {
		return isNomeValido(aluno) && isCPFValido(aluno) && isEmailValido(aluno);
		
	}

	private boolean isCPFValido(Aluno aluno) throws ExcecaoAlunoInvalido {
		ValidadorCPF validadorCPF = new ValidadorCPF();
		ValidadorCPFAdapter adaptador = new ValidadorCPFAdapter(validadorCPF);
		
		
		if (adaptador.isCPF(aluno.getCpf()) == true) return true; 
		throw new ExcecaoAlunoInvalido();
	}

	private boolean isNomeValido(Aluno aluno) throws ExcecaoAlunoInvalido{
		ValidadorNOME validadorNOME = new ValidadorNOME();
		ValidadorNOMEAdapter adaptador = new ValidadorNOMEAdapter(validadorNOME);
		
		if (adaptador.isNome(aluno.getNome()) == true) return true;
		throw new ExcecaoAlunoInvalido();
		
	}
	
	private boolean isEmailValido(Aluno aluno) throws ExcecaoAlunoInvalido{
		ValidadorEMAIL validadorEMAIL= new ValidadorEMAIL();
		ValidadorEMAILAdapter adaptador = new ValidadorEMAILAdapter(validadorEMAIL);
		
		if (adaptador.isEMAIL(aluno.getEmail())==true) return true;
		throw new ExcecaoAlunoInvalido();
		
	}
}
