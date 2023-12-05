package br.edu.ifpe.apoo.main;

import br.edu.ifpe.apoo.apresentacao.FachadaApresentacaoFactory;
import br.edu.ifpe.apoo.apresentacao.IFachadaApresentacao;

public class Main {

	public static void main(String[] args) {
		
		
		
		
		  IFachadaApresentacao fachada = FachadaApresentacaoFactory.getInstancia();
	        fachada.vaiExibirMenu();
	}
}