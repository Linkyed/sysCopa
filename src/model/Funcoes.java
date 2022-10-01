package model;

import java.util.Scanner;

public class Funcoes {
	
	static final Scanner entrada = new Scanner(System.in);
	
	public final static String entradaString(String texto) {
		String entradaUsuario = "";
		System.out.println(texto);

		entradaUsuario = entrada.nextLine();
		
		return entradaUsuario;
	}

	public final static int entradaInt(String texto) {
		int entradaUsuario = 0;

		while (true) {
			try {
				System.out.print(texto);
				entradaUsuario = Integer.parseInt(entrada.nextLine());

				break;

			} catch (java.lang.NumberFormatException e) {
				System.out.println("\nSó digite numeros!\n");
			}

		}
		
		return entradaUsuario;
	}

	public final static int entradaIntRanger(String texto, int inicio, int fim) {
		int entradaUsuario = 0;
	
		while (true) {
			try {
				System.out.print(texto);
				entradaUsuario = Integer.parseInt(entrada.nextLine());
				if (inicio <= entradaUsuario && entradaUsuario <= fim) {
					break;
				} else {
					System.out.println("O número está fora do ranger! Digite novamente.");
				}
			} catch (java.lang.NumberFormatException e) {
				System.out.println("\nSó digite numeros!\n");
			}
		}
		
		return entradaUsuario;

	}

	public final static void mostrarOpcoes() {

		System.out.println("[1] Seleção.\n" + "[2] Arbitro.\n" + "[3] Tecnico.\n" + "[4] Jogador.\n");
	}

	public final static String captilizeString(String texto) {
		String[] c = texto.split(" ");
		String n = "";
		for (String p : c) {
			n += p.substring(0, 1).toUpperCase() + p.substring(1).toLowerCase() + " ";
		}
		return n.strip();
	}

}
