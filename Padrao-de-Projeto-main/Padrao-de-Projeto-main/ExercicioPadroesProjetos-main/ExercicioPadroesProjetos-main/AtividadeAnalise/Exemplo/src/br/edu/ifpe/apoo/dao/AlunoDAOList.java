package br.edu.ifpe.apoo.dao;

import java.util.ArrayList;

import br.edu.ifpe.apoo.entidades.Aluno;

public class AlunoDAOList implements AlunoDAO{

	private static AlunoDAOList instancia;
	
	ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	protected static AlunoDAOList getInstancia() {
		if (instancia == null) {
			instancia = new AlunoDAOList();
		}

		return instancia;
	}

	private AlunoDAOList() {}

	public void inserir(Aluno aluno) {
		alunos.add(aluno);
	}

	public void atualizar(Aluno aluno) {
			if (alunoEncontrado(aluno.getId())) {
				alunos.set((int)aluno.getId(), aluno.clone());
			}	
	}

	public boolean remover(long id) {
			if (alunoEncontrado(id)) {
				alunos.remove((int)id);
				return true;
			}
		throw new RuntimeException("Aluno não foi removido!\nCertifique-se de digitar o ID correto!");
	}

	public Aluno get(long id) {
			if (alunoEncontrado(id)) {
				
				return alunos.get((int) id).clone();  
			}
		throw new RuntimeException("Aluno não encontrado!\nCertifique-se de digitar o ID correto!");
	}
	
	private boolean alunoEncontrado(long idSupostoAluno) {
		for (Aluno alunoEncontrado : alunos) {
			if ((alunoEncontrado.getId() == idSupostoAluno)) {
				return true;
			}
		}
		return false;
	}
}
