package br.edu.ifpe.apoo.dao;

import br.edu.ifpe.apoo.entidades.Aluno;

public class AlunoDAOMySQL implements AlunoDAO {
	
	private static AlunoDAOMySQL instancia;
	
	protected static AlunoDAOMySQL getInstancia() {
		if (instancia == null) {
			instancia = new AlunoDAOMySQL();
		}
		
		return instancia;
	}
	
	private AlunoDAOMySQL() {}

	public void inserir(Aluno aluno) {
		//inserir alunos na tabela mysql
	}
	
	public void atualizar(Aluno aluno) {
		
	}
	
	public boolean remover(long id) {
		throw new UnsupportedOperationException("not implemented");
	}
	
	public Aluno get(long id) {
		throw new UnsupportedOperationException("not implemented");
	}
}
