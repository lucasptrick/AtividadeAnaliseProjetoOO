package br.edu.ifpe.apoo.apresentacao;

import java.util.Scanner;
import java.util.function.Predicate;

import br.edu.ifpe.apoo.entidades.Aluno;
import br.edu.ifpe.apoo.excecoes.ExcecaoAlunoInvalido;
import br.edu.ifpe.apoo.negocio.FachadaNegocioFactory;
import br.edu.ifpe.apoo.negocio.IFachadaNegocio;
import br.edu.ifpe.apoo.negocio.validacao.ValidadorCPFAdapter;
import br.edu.ifpe.apoo.negocio.validacao.ValidadorEMAILAdapter;
import br.edu.ifpe.apoo.negocio.validacao.ValidadorNOMEAdapter;


public class AlunoApresentacao {
	public int verifica;

	Scanner entradaUser = new Scanner(System.in);

	public void exibirMenu() throws ExcecaoAlunoInvalido {

		boolean continuar = true;
		while (continuar) { 
			System.out.println("Digite a opção desejada:");
			System.out.println("1 para inserir um aluno");
			System.out.println("2 para consultar um aluno");
			System.out.println("3 para remover um aluno");
			System.out.println("4 para atualizar um aluno");

			int opcao = Integer.parseInt(entradaUser.nextLine());
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

			System.out.println(); System.out.print("Deseja continuar(s/n): "); 
			String sair = entradaUser.nextLine(); 
			if (sair.equalsIgnoreCase("n")) {
				continuar = false; 
				System.out.println("Operação finalizada!");
			}
		}
	}


	private void inserir() throws ExcecaoAlunoInvalido {
		ValidadorCPFAdapter adaptadorCPF = new ValidadorCPFAdapter();
		ValidadorNOMEAdapter adaptadorNome = new ValidadorNOMEAdapter();
		ValidadorEMAILAdapter adaptadorEmail = new ValidadorEMAILAdapter();

		String cpf = lerCampo("Digite seu CPF: ", xCPF -> adaptadorCPF.isCPF(xCPF), "Insira um CPF válido!");
		String nome = lerCampo("Digite seu nome: ", xNOME -> adaptadorNome.isNome(xNOME), "Insira um NOME válido!");
		String email = lerCampo("Digite seu email: ", xEMAIL -> adaptadorEmail.isEMAIL(xEMAIL), "Insira um EMAIL válido!");
		
		Aluno aluno = new Aluno.AlunoBuilder()
				.id(verifica)
				.cpf(cpf)
				.nome(nome)
				.email(email)
				.build();
		
		verifica++;
		IFachadaNegocio fachada = FachadaNegocioFactory.getInstancia();
		fachada.inserirAluno(aluno);
		System.out.println(">> O aluno, "+aluno.getNome()+" foi inserido com sucesso.\n");
	}


	private void consultar() throws ExcecaoAlunoInvalido {
		System.out.println("Digite o ID do aluno a ser consultado: ");
		long idConsulta = entradaUser.nextLong();

		Aluno alunoConsulta;

		IFachadaNegocio fachada = FachadaNegocioFactory.getInstancia();
		alunoConsulta = fachada.devolverGet(idConsulta);
		System.out.println(">> O aluno encontrado!");
		System.out.println("Nome: "+alunoConsulta.getNome()+"\nCPF: "+imprimirCPF(alunoConsulta.getCpf())+"\nEmail: "+alunoConsulta.getEmail()+"\n");
	}


	private void remover() throws ExcecaoAlunoInvalido {
		System.out.println("Digite o ID do aluno a ser removido: ");
		long idRemove = entradaUser.nextLong();

		IFachadaNegocio fachada = FachadaNegocioFactory.getInstancia();
		System.out.println(">> Aluno-ID:"+fachada.devolverGet(idRemove).getId()+" foi removido com sucesso.\n");
		fachada.removerAluno(idRemove);
	}


	private void atualizar() throws ExcecaoAlunoInvalido {
		ValidadorCPFAdapter adaptadorCPF = new ValidadorCPFAdapter();
		ValidadorNOMEAdapter adaptadorNome = new ValidadorNOMEAdapter();
		ValidadorEMAILAdapter adaptadorEmail = new ValidadorEMAILAdapter();

		System.out.println("Digite o ID do aluno a ser atualizado: ");
		long idAtualizar = entradaUser.nextLong();
		
		String cpf = lerCampo("Digite seu CPF: ", xCPF -> adaptadorCPF.isCPF(xCPF), "Insira um CPF válido!");
		String nome = lerCampo("Digite seu nome: ", xNOME -> adaptadorNome.isNome(xNOME), "Insira um NOME válido!");
		String email = lerCampo("Digite seu email: ", xEMAIL -> adaptadorEmail.isEMAIL(xEMAIL), "Insira um EMAIL válido!");
		
		Aluno alunoUpdate = new Aluno.AlunoBuilder()
				.id(idAtualizar)
				.cpf(cpf)
				.nome(nome)
				.email(email)
				.build();
		
		IFachadaNegocio fachada = FachadaNegocioFactory.getInstancia();
		System.out.println(">> Aluno-ID:"+fachada.devolverGet(idAtualizar).getId()+" foi atualizado com sucesso.\n");
		fachada.atualizarAluno(alunoUpdate);
	}
	
	private String lerCampo(String mensagemInput, Predicate<String> predicate, String mensagemERRO) {
		String campo;
		boolean isValido;
		do {
			System.out.println(mensagemInput);
			campo = entradaUser.nextLine();
			
			isValido = predicate.test(campo);
			
			if (!isValido) {
				System.out.println(mensagemERRO);
			}

		} while (!isValido);
	
		return campo;
	}
	
	private static String imprimirCPF(String CPF) {
		ValidadorCPFAdapter adaptadorCPF = new ValidadorCPFAdapter();
		CPF = adaptadorCPF.formatarCPF(CPF);
		return CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-" + CPF.substring(9, 11);
	}
}
