package br.edu.ifpe.apoo.negocio;

import br.edu.ifpe.apoo.dao.AlunoDAO;
import br.edu.ifpe.apoo.dao.AlunoDAOList;

public class AlunoControladorAbstractFactory {
	
	public static IControladorAluno getDAO() {
		return ControladorAluno.getInstancia();
	}
}
