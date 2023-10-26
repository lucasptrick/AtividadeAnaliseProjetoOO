package br.edu.ifpe.apoo.negocio;

import br.edu.ifpe.apoo.dao.AlunoDAO;
import br.edu.ifpe.apoo.dao.AlunoDAOAbstractFactory;
import br.edu.ifpe.apoo.dao.AlunoDAOArquivos;
import br.edu.ifpe.apoo.entidades.Aluno;
import br.edu.ifpe.apoo.excecoes.ExcecaoAlunoInvalido;

public interface IControladorAluno {
	public void inserir(Aluno aluno);
	public void atualizar(Aluno aluno);
	public boolean remover(long id);
	public Aluno get(long id);

}
