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
		for (Aluno alunoAtualizar : alunos) {
			if (alunoAtualizar.getId() == aluno.getId()) {
				alunos.set((int)aluno.getId(), aluno.clone());
			}
		}
		
	}

	public boolean remover(long id) {
		for (Aluno alunoRemover : alunos) {
			if (alunoRemover.getId() == id) {
				alunos.remove((int)id);
				return true;
			}
		}
		throw new UnsupportedOperationException("Aluno não foi removido!\nCertifique-se de digitar o ID correto!");
	}

	public Aluno get(long id) {
		for (Aluno alunoConsulta : alunos) {
			if (alunoConsulta.getId() == id) {
				
				return alunos.get((int) id).clone();  
			}
		}
		throw new UnsupportedOperationException("Aluno não encontrado!\nCertifique-se de digitar o ID correto!");
	}
}
