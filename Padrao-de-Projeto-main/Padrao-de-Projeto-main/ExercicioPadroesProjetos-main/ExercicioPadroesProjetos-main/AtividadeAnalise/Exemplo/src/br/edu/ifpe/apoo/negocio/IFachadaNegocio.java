package br.edu.ifpe.apoo.negocio;

import br.edu.ifpe.apoo.entidades.Aluno;
import br.edu.ifpe.apoo.excecoes.ExcecaoAlunoInvalido;

public interface IFachadaNegocio {
	
	void inserirAluno(Aluno aluno) throws ExcecaoAlunoInvalido;
	void atualizarAluno(Aluno aluno)throws ExcecaoAlunoInvalido;
	boolean removerAluno(long id)throws ExcecaoAlunoInvalido;	
	Aluno devolverGet(long id)throws ExcecaoAlunoInvalido;
	

}
