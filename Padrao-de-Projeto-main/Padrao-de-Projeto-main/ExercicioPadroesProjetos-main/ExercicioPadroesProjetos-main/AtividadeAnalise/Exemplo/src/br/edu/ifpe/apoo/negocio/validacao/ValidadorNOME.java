package br.edu.ifpe.apoo.negocio.validacao;

import java.util.regex.*;

public class ValidadorNOME {
	public static boolean isNome(String nome) {
		String regex = "^[A-Za-z]\\w{4,101}$"; //Expressão regular para validar a string
		
		Pattern p = Pattern.compile(regex); //Compilando o ReGex
		
		if (nome == null) {
			return false;
		}
		
		Matcher m = p.matcher(nome); //A classe Pattern contém matcher() para encontrar uma combinação entre o nome do usuario e a expressão regular
		
	return m.matches(); //Retorna o nome do usuario 
	}
}
