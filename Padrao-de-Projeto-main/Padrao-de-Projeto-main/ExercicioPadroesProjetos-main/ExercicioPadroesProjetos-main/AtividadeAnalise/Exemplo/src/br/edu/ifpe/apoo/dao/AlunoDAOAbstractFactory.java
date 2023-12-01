package br.edu.ifpe.apoo.dao;

public class AlunoDAOAbstractFactory {

	public static AlunoDAO getDAO() {
		return AlunoDAOList.getInstancia();
	}
}
