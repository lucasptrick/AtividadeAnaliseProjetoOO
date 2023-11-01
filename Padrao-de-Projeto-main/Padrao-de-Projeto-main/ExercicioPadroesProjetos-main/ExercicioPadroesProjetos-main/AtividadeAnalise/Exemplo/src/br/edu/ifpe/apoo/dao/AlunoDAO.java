package br.edu.ifpe.apoo.dao;

import br.edu.ifpe.apoo.entidades.Aluno;

public interface AlunoDAO {
	
	public void inserir(Aluno aluno);
	public void atualizar(Aluno aluno);
	public boolean remover(long id);
	public Aluno get(long id);
}
