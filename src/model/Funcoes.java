package model;

import java.util.Scanner;

public class Funcoes {
	public final static String entradaString (String texto) {
		String entradaUsuario = "";
		System.out.println(texto);
		Scanner entrada = new Scanner(System.in);
		entradaUsuario = entrada.nextLine();
		return entradaUsuario;
	}
	
	public final static int entradaInt(String texto) {
		int entradaUsuario = 0;
		Scanner entrada = new Scanner(System.in);
		System.out.print(texto);
		try {
			entradaUsuario = Integer.parseInt(entrada.nextLine());
		}
		catch (java.lang.NumberFormatException e) {
			System.out.println("\nSó digite numeros que sejam relacionados as opções!\n");
		}
		return entradaUsuario;
	}
	public final static void mostrarOpcoes() {
		
		System.out.println("[1] Seleção.\n"
				+ "[2] Arbitro.\n"
				+ "[3] Tecnico.\n"
				+ "[4] Jogador.\n");
	}
	public final static String captilizeString(String texto) {
		String[] c = texto.split(" ");
		String n = "";
		for (String p: c) {
			n += p.substring(0, 1).toUpperCase() + p.substring(1).toLowerCase() + " ";
		}
		return n.strip();
	}


	
}
