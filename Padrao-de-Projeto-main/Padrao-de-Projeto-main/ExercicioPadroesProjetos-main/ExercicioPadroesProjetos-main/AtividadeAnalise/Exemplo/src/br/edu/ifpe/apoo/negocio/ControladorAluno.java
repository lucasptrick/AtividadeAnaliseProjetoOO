package br.edu.ifpe.apoo.negocio;

import br.edu.ifpe.apoo.dao.AlunoDAO;
import br.edu.ifpe.apoo.dao.AlunoDAOAbstractFactory;
import br.edu.ifpe.apoo.entidades.Aluno;
import br.edu.ifpe.apoo.excecoes.ExcecaoAlunoInvalido;
import br.edu.ifpe.apoo.negocio.validacao.ValidadorCPFAdapter;
import br.edu.ifpe.apoo.negocio.validacao.ValidadorEMAILAdapter;
import br.edu.ifpe.apoo.negocio.validacao.ValidadorNOMEAdapter;

public class ControladorAluno implements IControladorAluno {

	private static ControladorAluno instancia;

	protected static ControladorAluno getInstancia() {
		if (instancia == null) {
			instancia = new ControladorAluno();
		}
		return instancia;
	}

	private ControladorAluno() {
	}

	@Override
	public void inserir(Aluno aluno) throws ExcecaoAlunoInvalido {
		if (this.isValido(aluno)) {

			AlunoDAO dao = AlunoDAOAbstractFactory.getDAO();
			dao.inserir(aluno);
		} else
			throw new ExcecaoAlunoInvalido("Aluno inválido!\nCertifique-se de preencher corretamente os campos");
	}

	@Override
	public void atualizar(Aluno aluno) throws ExcecaoAlunoInvalido {
		if (this.isValido(aluno)) {
			AlunoDAO dao = AlunoDAOAbstractFactory.getDAO();
			dao.atualizar(aluno);
		} else
			throw new ExcecaoAlunoInvalido("Aluno inválido!\nCertifique-se de preencher corretamente os campos");
	}

	@Override
	public boolean remover(long id) {
		AlunoDAO dao = AlunoDAOAbstractFactory.getDAO();
		dao.remover(id);
		return true;
	}

	@Override
	public Aluno get(long id) {
		AlunoDAO dao = AlunoDAOAbstractFactory.getDAO();
		return dao.get(id);
	}

	private boolean isValido(Aluno aluno) throws ExcecaoAlunoInvalido {
		return isNomeValido(aluno) && isCPFValido(aluno) && isEmailValido(aluno);
	}

	private boolean isCPFValido(Aluno aluno) throws ExcecaoAlunoInvalido {
		ValidadorCPFAdapter adaptador = new ValidadorCPFAdapter();
		if (adaptador.isCPF(aluno.getCpf()) == true)
			return true;
		throw new ExcecaoAlunoInvalido();
	}

	private boolean isNomeValido(Aluno aluno) throws ExcecaoAlunoInvalido {
		ValidadorNOMEAdapter adaptador = new ValidadorNOMEAdapter();
		if (adaptador.isNome(aluno.getNome()) == true)
			return true;
		throw new ExcecaoAlunoInvalido();
	}

	private boolean isEmailValido(Aluno aluno) throws ExcecaoAlunoInvalido {
		ValidadorEMAILAdapter adaptador = new ValidadorEMAILAdapter();
		if (adaptador.isEMAIL(aluno.getEmail()) == true)
			return true;
		throw new ExcecaoAlunoInvalido();
	}
}
