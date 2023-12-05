package br.edu.ifpe.apoo.negocio;

import br.edu.ifpe.apoo.entidades.Aluno;
import br.edu.ifpe.apoo.excecoes.ExcecaoAlunoInvalido;

public interface IControladorAluno {
	
	public void inserir(Aluno aluno)throws ExcecaoAlunoInvalido;
	public void atualizar(Aluno aluno) throws ExcecaoAlunoInvalido ;
	public boolean remover(long id);
	public Aluno get(long id);

}
