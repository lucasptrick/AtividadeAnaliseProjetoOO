package br.edu.ifpe.apoo.negocio;

import br.edu.ifpe.apoo.dao.AlunoDAO;
import br.edu.ifpe.apoo.dao.AlunoDAOList;

public class ControladorFactory {

	public static ControladorAluno getControladorAluno() {
		return ControladorAluno.getInstancia();
		
	}
}
