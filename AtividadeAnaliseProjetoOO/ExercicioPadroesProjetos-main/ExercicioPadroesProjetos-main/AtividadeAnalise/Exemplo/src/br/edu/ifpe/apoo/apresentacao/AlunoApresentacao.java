package br.edu.ifpe.apoo.apresentacao;

import java.util.Scanner;
import br.edu.ifpe.apoo.entidades.Aluno;
import br.edu.ifpe.apoo.excecoes.ExcecaoAlunoInvalido;
import br.edu.ifpe.apoo.negocio.AlunoControladorAbstractFactory;
import br.edu.ifpe.apoo.negocio.ControladorAluno;
import br.edu.ifpe.apoo.negocio.IControladorAluno;

public class AlunoApresentacao {
	int verifica;
	Scanner entradaUser = new Scanner(System.in);

	public void exibirMenu() throws ExcecaoAlunoInvalido {
		boolean continuar = true;
		while (continuar) { 
			System.out.println("Digite a opção desejada");
			System.out.println("1 para inserir um aluno;");
			System.out.println("2 para consultar um aluno;");
			System.out.println("3 para remover um aluno;");
			System.out.println("4 para atualizar um aluno;");

			Scanner scanner = new Scanner(System.in);
			int opcao = Integer.parseInt(scanner.nextLine());
			if (opcao == 1) {
				this.inserir();
			}
			if (opcao == 2) {
				this.consultar();
			}
			if (opcao == 3) {
				this.remover();
			}
			if (opcao == 4) {
				this.atualizar();
			}

			System.out.println(); System.out.print("Deseja continuar (s/n): "); 
			String sair = entradaUser.nextLine(); 
			if (sair.equalsIgnoreCase("n")) 
			{continuar = false; 
			}}
	}

	private void inserir() throws ExcecaoAlunoInvalido {
		Aluno aluno = new Aluno();
		
		System.out.println("Digite apenas os números do seu CPF: ");
		String cpf = entradaUser.nextLine();
		aluno.setCpf(cpf); 
		
		System.out.println("Digite seu nome:");
		String nome = entradaUser.nextLine();
		aluno.setNome(nome);
		
		System.out.println("Digite seu e-mail:");
		String email = entradaUser.nextLine();
		aluno.setEmail(email);
		
		aluno.setId(verifica);
		verifica++;

		IControladorAluno controlador = AlunoControladorAbstractFactory.getDAO();
		controlador.inserir(aluno);
	}

	private void consultar() {
		System.out.println("Digite o ID do aluno a ser consultado: ");
		long idConsulta = entradaUser.nextLong();

		Aluno alunoConsulta;
		IControladorAluno controlador = AlunoControladorAbstractFactory.getDAO();
		alunoConsulta = controlador.get(idConsulta);
		System.out.println(alunoConsulta.getNome()+"\n"+alunoConsulta.getCpf()+"\n"+alunoConsulta.getEmail());
	}

	private void remover() {
		System.out.println("Digite o ID do aluno a ser removido: ");
		long idRemove = entradaUser.nextLong();
		
		Aluno alunoRemove;
		IControladorAluno controlador = AlunoControladorAbstractFactory.getDAO();
		alunoRemove = controlador.get(idRemove);
		controlador.remover(idRemove);
		System.out.println("Aluno removido!");

	}

	private void atualizar() {
		System.out.println("Digite o ID do aluno a ser atualizado: ");
		long idAtualizar = entradaUser.nextLong();
		Aluno alunoUpdate = new Aluno();
		
		System.out.println("Digite apenas os números do novo CPF: ");
		String cpf = entradaUser.next();
		alunoUpdate.setCpf(cpf); 
		
		System.out.println("Digite o novo nome:");
		String nome = entradaUser.next();
		alunoUpdate.setNome(nome);
		
		System.out.println("Digite o novo e-mail:");
		String email = entradaUser.next();
		alunoUpdate.setEmail(email);

		
	//	Aluno alunoAtualizado;
		IControladorAluno controlador = AlunoControladorAbstractFactory.getDAO();
		//alunoUpdate = controlador.get(idAtualizar);
		controlador.atualizar(alunoUpdate);
		
		
	}
}
