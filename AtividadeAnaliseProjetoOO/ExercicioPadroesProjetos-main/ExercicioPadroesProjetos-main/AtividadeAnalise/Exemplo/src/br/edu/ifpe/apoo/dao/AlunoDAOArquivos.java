package br.edu.ifpe.apoo.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.stream.Stream;

import br.edu.ifpe.apoo.entidades.Aluno;

public class AlunoDAOArquivos  implements AlunoDAO {

	public boolean verificarPermissaoEscritaArquivos() {
		throw new UnsupportedOperationException("not implemented!");
	}
	
	public void inserir(Aluno aluno) {
		ObjectOutputStream stream = null;
		try {
			File file = new File("alunos.data");
			FileOutputStream out = new FileOutputStream(file);
			stream = new ObjectOutputStream(out);
			stream.writeObject(aluno);
		} catch (Exception eX) {
		//...
		} finally {
			if (stream != null) {
				try {
				stream.close();
				} catch (Exception ex) {
					//do nothing!
				}
			}
		}
	}
	
	public void atualizar(Aluno aluno) {
		
	}
	
	public boolean remover(long id) {
		throw new UnsupportedOperationException("not implemented");
	}
	
	public Aluno get(long id) {
		throw new UnsupportedOperationException("not implemented");
	}
}
