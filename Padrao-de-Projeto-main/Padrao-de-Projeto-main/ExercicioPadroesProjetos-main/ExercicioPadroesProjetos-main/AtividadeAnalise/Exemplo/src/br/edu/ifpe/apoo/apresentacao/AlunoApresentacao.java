package br.edu.ifpe.apoo.apresentacao;

import java.util.Scanner;

import br.edu.ifpe.apoo.entidades.Aluno;
import br.edu.ifpe.apoo.excecoes.ExcecaoAlunoInvalido;
import br.edu.ifpe.apoo.negocio.FachadaNegocioFactory;
import br.edu.ifpe.apoo.negocio.IFachadaNegocio;
import br.edu.ifpe.apoo.negocio.ValidadorCPF;


public class AlunoApresentacao {

	
	public int verifica;
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
			}
		}
	}
	private void inserir() throws ExcecaoAlunoInvalido {
		Aluno aluno = new Aluno.AlunoBuilder()
		.id(verifica)
		.nome(null)
		.cpf(null)
		.email(null)
		.build();
		
		boolean cpf_OK = false;
		while (!cpf_OK) {
			System.out.println("Digite apenas os números do seu CPF: ");
			String cpf = entradaUser.nextLine();
			
			if (ValidadorCPF.isCPF(cpf)) {
				aluno.setCpf(cpf);
				cpf_OK = true;
			}else {
				System.out.println("Erro, CPF Inválido insira um CPF válido!");
			}
		}
		
		System.out.println("Digite seu nome:");
		String nome = entradaUser.nextLine();
		aluno.setNome(nome);
		
		System.out.println("Digite seu e-mail:");
		String email = entradaUser.nextLine();
		aluno.setEmail(email);
		
		aluno.setId(verifica);
		verifica++;

		IFachadaNegocio fachada = FachadaNegocioFactory.getInstancia();
		fachada.inserirAluno(aluno);
	}
	
	private void consultar() throws ExcecaoAlunoInvalido {
		System.out.println("Digite o ID do aluno a ser consultado: ");
		long idConsulta = entradaUser.nextLong();

		Aluno alunoConsulta;
		
		IFachadaNegocio fachada = FachadaNegocioFactory.getInstancia();
		alunoConsulta = fachada.devolverGet(idConsulta);
		
		System.out.println(alunoConsulta.getNome()+"\n"+alunoConsulta.getCpf()+"\n"+alunoConsulta.getEmail());
		
	}
	
	private void remover() throws ExcecaoAlunoInvalido {
		System.out.println("Digite o ID do aluno a ser removido: ");
		long idRemove = entradaUser.nextLong();
		
		Aluno alunoRemove;
		
		
		IFachadaNegocio fachada = FachadaNegocioFactory.getInstancia();
		alunoRemove = fachada.devolverGet(idRemove);
		fachada.removerAluno(idRemove);
		System.out.println("Aluno removido!");
		

	}

	



	
	private void atualizar() throws ExcecaoAlunoInvalido {
		System.out.println("Digite o ID do aluno a ser atualizado: ");
		long idAtualizar = entradaUser.nextLong();
		
		Aluno alunoUpdate = new Aluno.AlunoBuilder()
				.id(idAtualizar)
				.nome(null)
				.cpf(null)
				.email(null)
				.build();
		
		boolean cpfValido = false;
		while (!cpfValido) {
			System.out.println("Digite apenas os números do seu CPF: ");
			String cpf = entradaUser.nextLine();
			
			if (ValidadorCPF.isCPF(cpf)) {
				alunoUpdate.setCpf(cpf);
				cpfValido = true;
			}else {
				System.out.println("Erro, CPF Inválido insira um CPF válido!");
			}
		}
		
		System.out.println("Digite o novo nome:");
		String nome = entradaUser.next();
		alunoUpdate.setNome(nome);
		
		System.out.println("Digite o novo e-mail:");
		String email = entradaUser.next();
		alunoUpdate.setEmail(email);

	
		
		
		IFachadaNegocio fachada = FachadaNegocioFactory.getInstancia();
		fachada.atualizarAluno(alunoUpdate);
		
		
		
	}
}