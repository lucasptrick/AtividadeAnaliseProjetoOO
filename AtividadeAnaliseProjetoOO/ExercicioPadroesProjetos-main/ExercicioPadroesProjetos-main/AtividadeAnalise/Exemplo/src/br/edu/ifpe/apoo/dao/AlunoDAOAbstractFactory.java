package br.edu.ifpe.apoo.dao;

public class AlunoDAOAbstractFactory {

	public static AlunoDAO getDAO() {
		//return AlunoDAOMySQL.getInstancia();
		return AlunoDAOList.getInstancia();
	}
}
