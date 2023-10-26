package br.edu.ifpe.apoo.negocio;

import java.util.ArrayList;

import br.edu.ifpe.apoo.dao.AlunoDAO;
import br.edu.ifpe.apoo.dao.AlunoDAOAbstractFactory;
import br.edu.ifpe.apoo.dao.AlunoDAOArquivos;
import br.edu.ifpe.apoo.dao.AlunoDAOList;
import br.edu.ifpe.apoo.entidades.Aluno;
import br.edu.ifpe.apoo.excecoes.ExcecaoAlunoInvalido;

public class ControladorAluno implements IControladorAluno {
	private static final int caracterNomeMin = 5;
	private static final int caracterNomeMax = 100;
	private static final int comprimentoCPF = 11;
	
private static ControladorAluno instancia;
	
	
	protected static ControladorAluno getInstancia() {
		if (instancia == null) {
			instancia = new ControladorAluno();
		}

		return instancia;
	}
	
	private ControladorAluno() {}
	
	public void inserir(Aluno aluno) {
		if (!this.isValido(aluno)) {
			
		}

		AlunoDAO dao = AlunoDAOAbstractFactory.getDAO();
		dao.inserir(aluno);
	}
	
	public void atualizar(Aluno aluno) {
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
	
	private boolean isValido(Aluno aluno) {
		return isNomeValido(aluno) && isCPFValido(aluno);
		
	}

	private boolean isCPFValido(Aluno aluno) {
		return aluno.getCpf().length() == comprimentoCPF; //Usar API - Exmeplo validação de hash... validar CPF JAVA
	}

	private boolean isNomeValido(Aluno aluno) {
		return aluno.getNome().length() >= caracterNomeMin && aluno.getNome().length() <= caracterNomeMax; //Resolver os numeros magicos!
	}


}
