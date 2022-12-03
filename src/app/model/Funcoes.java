package app.model;

import java.util.Scanner;

import app.model.exceptions.CaracterInvalidoException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
/**
 * Classe de Funções para ajudar na contrução do codígo.
 * 
 * @author Nalbert Santos Araujo
 * @author Pedro Henrique
 *
 */
public class Funcoes {

	static final Scanner entrada = new Scanner(System.in);
	
	/**Metodo para mostrar um texto para o usuario e salvar a sua resposta em string**/
	public final static String entradaString(String texto, boolean verificacao) {
		boolean condicao = true;
		String entradaUsuario = "";
		while (condicao) {
			System.out.print(texto);

			entradaUsuario = entrada.nextLine().strip();
			if (verificacao == true) {
				if (entradaUsuario.matches("[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ\s]+")) {
					entradaUsuario = Funcoes.captilizeString(entradaUsuario).strip();
					condicao = false;
				} else {
					System.out.println("Erro! Não digite números ou caracteres.");
				}
			}
			else {
				condicao = false;
			}
			
		}
		System.out.println();
		return entradaUsuario;
	}
	
	/**Metodo para mostrar um texto para o usuario e salvar a sua resposta em string com 1 caracter**/
	public final static String entradaLetraGrupo(String texto, boolean verificacao) {
		boolean condicao = true;
		String entradaUsuario = "";
		while (condicao) {
			System.out.print(texto);

			entradaUsuario = entrada.nextLine().strip();
			if (verificacao == true) {
				if(entradaUsuario.length() != 1) {
					System.out.println("Digite Apenas 1 caracter!");
				}
				else if (entradaUsuario.matches("[a-hA-H]")) {
					entradaUsuario = Funcoes.captilizeString(entradaUsuario).strip();
					condicao = false;
				} else {
					System.out.println("Erro! digite caracteres dentro de [A-H] e  não digite números.");
				}
			}
			else {
				condicao = false;
			}
			
		}
		System.out.println();
		return entradaUsuario;
	}
	
	
	/**Metodo para mostrar um texto para o usuario e salvar a sua resposta em int, aceitando apenas inteiros**/
	public final static int entradaInt(String texto) {
		int entradaUsuario = 0;
		boolean condicao = true;
		while (condicao) {
			try {
				System.out.print(texto);
				entradaUsuario = Integer.parseInt(entrada.nextLine());
				condicao = false;

			} catch (java.lang.NumberFormatException e) {
				System.out.println("\nSó digite numeros!\n");
			}

		}

		return entradaUsuario;
	}
	
	/**Metodo para mostrar um texto para o usuario e salvar a sua resposta em int, aceitando apenas inteiros em um certo intervalo**/
	public final static int entradaIntRanger(String texto, int inicio, int fim) {
		int entradaUsuario = 0;
		boolean condicao = true;
		while (condicao) {
			try {
				System.out.print(texto);
				entradaUsuario = Integer.parseInt(entrada.nextLine());
				if (inicio <= entradaUsuario && entradaUsuario <= fim) {
					condicao = false;
					;
				} else {
					System.out.println(
							"O número está fora do ranger[" + inicio + "-" + fim + "]" + " ! Digite novamente.");
				}
			} catch (java.lang.NumberFormatException e) {
				System.out.println("\nSó digite numeros!\n");
			}
		}

		return entradaUsuario;

	}
	
	/**Metodo para mostrar um texto para o usuario e salvar a sua resposta em int, aceitando apenas inteiros em um certo intervalo inicial**/
	public final static int entradaIntRanger(String texto, int inicio) {
		int entradaUsuario = 0;
		boolean condicao = true;
		while (condicao) {
			try {
				System.out.print(texto);
				entradaUsuario = Integer.parseInt(entrada.nextLine());
				if (inicio <= entradaUsuario) {
					condicao = false;
					;
				} else {
					System.out.println(
							"O número está fora do ranger[" + inicio + " até infinito]" + " ! Digite novamente.");
				}
			} catch (java.lang.NumberFormatException e) {
				System.out.println("\nSó digite numeros!\n");
			}
		}

		return entradaUsuario;

	}
	
	public final static int entradaIntList(String text, List<Integer> numerosPossiveis) {
		boolean condicao = true;
		Integer entradaUsuario = 0;
		while (condicao) {
			try {
				System.out.println(text);
				entradaUsuario = Integer.parseInt(entrada.nextLine());
				if(numerosPossiveis.contains(entradaUsuario)) {
					condicao = false;
				} else {
					System.out.println("\nO numero digitado não esta ligado a nenhuma opção, tenta novamente!\n");
				}
			} catch (Exception e) {
				System.out.println("\nDigite apenas numeros!\n");
			}
		}
		return entradaUsuario;
	}

	/**Metodo para mostrar as opções de jogador, tecnico, seleção e arbitro para o usuario**/
	public final static void mostrarOpcoes() {

		System.out.println("[1] Seleção.\n" + "[2] Arbitro.\n" + "[3] Tecnico.\n" + "[4] Jogador.\n" + "[5] Voltar.\n");
	}

	/**Metodo para fazer com que todas as letras inicias comecem com letra maiuscula**/
	public final static String captilizeString(String texto) {
		String[] c = texto.split(" ");
		String n = "";
		for (String p : c) {
			n += p.substring(0, 1).toUpperCase() + p.substring(1).toLowerCase() + " ";
		}
		return n.strip();
	}
	
	/**Metodo para fechar o scanner**/
	public static void fechar() {
		entrada.close();
	}

	public static String verificarString(String nome, String mensagem) throws CaracterInvalidoException{
	    if (!nome.matches("[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ\s]+")) {
	    	throw new CaracterInvalidoException(mensagem);
	    }
	    return nome;
	}
	
	
}
