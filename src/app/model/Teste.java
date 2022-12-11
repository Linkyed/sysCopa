package app.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import app.model.exceptions.CaracterInvalidoException;
import app.model.exceptions.ListaCheiaException;
import app.model.exceptions.ObjetoJaExisteException;
import app.model.exceptions.StringVaziaException;

public class Teste {

	public static void RandomPartida(int numeroDePartidas,boolean grupoOUmata) {
		Random rand = new Random();

		for (int i = 0; i < numeroDePartidas; i++) {
			Partida partidaModelo = PartidaDAO.partidaSemRealizar();
			PartidaDAO.alteracaoDeStatusPartida(true, partidaModelo);
			Map<Jogador, Integer> jogadorMap = new HashMap<>();
			Map<Jogador, Integer> jogadorMap2 = new HashMap<>();
			List<Jogador> listaJogadores = partidaModelo.getSelecao1().getJogadores();
			List<Jogador> listaJogadores2 = partidaModelo.getSelecao2().getJogadores();
			int contador = rand.nextInt(10);
			int contador2 = rand.nextInt(10);
			for(int c = 0; c < contador; c ++) {
				int int_random = rand.nextInt(2);
				jogadorMap.put(listaJogadores.get(c), int_random);
			}
			for(int c = 0; c < contador2; c ++) {
				int int_random2 = rand.nextInt(2);
				jogadorMap2.put(listaJogadores2.get(c), int_random2);
			}
			PartidaDAO.editarGol(partidaModelo, jogadorMap, 1);
			PartidaDAO.editarGol(partidaModelo, jogadorMap2, 2);
			if (grupoOUmata) {
				GrupoPrimeiraFase.definirPontos(partidaModelo, true);
			}
			else {
				List<Selecao> desempateList = PartidaDAO.resultadoPartida(partidaModelo);
				if(desempateList.size() == 2) {
					int int_random = rand.nextInt(2);
					PartidaDAO.DefinirGanhador(desempateList.get(int_random), partidaModelo);
				}
			}
			SelecaoDAO.atualizarCriterioDesempate(partidaModelo.getSelecao1());
			SelecaoDAO.atualizarCriterioDesempate(partidaModelo.getSelecao2());
			
		}
	}
	
	public static void preDefinicao() {
		
		Arbitro arbitro1 = new Arbitro("João Ernesto");
		Arbitro arbitro2 = new Arbitro("Mauricio de Santos");
		Arbitro arbitro3 = new Arbitro("Josivaldo Almeida");
		Arbitro arbitro4 = new Arbitro("Pedro Henrique");
		Arbitro arbitro5 = new Arbitro("Nalbert Santos");
		Arbitro arbitro6 = new Arbitro("Guilherme Lucas");
		Arbitro arbitro7 = new Arbitro("Matias Binnoto");
		Arbitro arbitro8 = new Arbitro("Max Verstappen");
		Arbitro arbitro9 = new Arbitro("Thiago Mendes");
		Arbitro arbitro10 = new Arbitro("Lucas Araujo");
		Arbitro arbitro11 = new Arbitro("Marcos Costa");
		Arbitro arbitro12 = new Arbitro("Ernesto Junior");
		Arbitro arbitro13 = new Arbitro("Rafael Leitão");
		Arbitro arbitro14 = new Arbitro("Gabriel Jesus");
		Arbitro arbitro15 = new Arbitro("Pedro Lucas Santos");
		Arbitro arbitro16 = new Arbitro("Luciano de Almeida");
		Arbitro arbitro17 = new Arbitro("Harry Kany");
		Arbitro arbitro18 = new Arbitro("David Mota");
		Arbitro arbitro19 = new Arbitro("Matheus Henrique");
		Arbitro arbitro20 = new Arbitro("Jose Henrique Almeida");
		
		ArbitroDAO.inserirConsole(arbitro1);
		ArbitroDAO.inserirConsole(arbitro2);
		ArbitroDAO.inserirConsole(arbitro3);
		ArbitroDAO.inserirConsole(arbitro4);
		ArbitroDAO.inserirConsole(arbitro5);
		ArbitroDAO.inserirConsole(arbitro6);
		ArbitroDAO.inserirConsole(arbitro7);
		ArbitroDAO.inserirConsole(arbitro8);
		ArbitroDAO.inserirConsole(arbitro9);
		ArbitroDAO.inserirConsole(arbitro10);
		ArbitroDAO.inserirConsole(arbitro11);
		ArbitroDAO.inserirConsole(arbitro12);
		ArbitroDAO.inserirConsole(arbitro13);
		ArbitroDAO.inserirConsole(arbitro14);
		ArbitroDAO.inserirConsole(arbitro15);
		ArbitroDAO.inserirConsole(arbitro16);
		ArbitroDAO.inserirConsole(arbitro17);
		ArbitroDAO.inserirConsole(arbitro18);
		ArbitroDAO.inserirConsole(arbitro19);
		ArbitroDAO.inserirConsole(arbitro20);
		
		
		
		Selecao selecao1 = new Selecao("Qatar");
		SelecaoDAO.inserirConsole(selecao1);
		Jogador Q1Jogador = new Jogador("Saad Al-Sheeb", selecao1, 0);
		Jogador Q2Jogador = new Jogador("Pedro Miguel", selecao1, 3);
		Jogador Q3Jogador = new Jogador("Abdelkarim Hassan", selecao1, 3);
		Jogador Q4Jogador = new Jogador("Homam Ahmed", selecao1, 1);
		Jogador Q5Jogador = new Jogador("Bassam Al-Rawi", selecao1, 1);
		Jogador Q6Jogador = new Jogador("Boualem Khoukhi", selecao1, 2);
		Jogador Q7Jogador = new Jogador("Mohammed Waad", selecao1, 2);
		Jogador Q8Jogador = new Jogador("Abdulaziz Hatem", selecao1, 5);
		Jogador Q9Jogador = new Jogador("Karim Boudiaf", selecao1, 5);
		Jogador Q10Jogador = new Jogador("Mohammed Muntari", selecao1, 5);
		Jogador Q11Jogador = new Jogador("Hassan Al-Haydos", selecao1, 4);

		JogadorDAO.inserirConsole(Q1Jogador, selecao1, false);
		JogadorDAO.inserirConsole(Q2Jogador, selecao1, false);
		JogadorDAO.inserirConsole(Q3Jogador, selecao1, false);
		JogadorDAO.inserirConsole(Q4Jogador, selecao1, false);
		JogadorDAO.inserirConsole(Q5Jogador, selecao1, false);
		JogadorDAO.inserirConsole(Q6Jogador, selecao1, false);
		JogadorDAO.inserirConsole(Q7Jogador, selecao1, false);
		JogadorDAO.inserirConsole(Q8Jogador, selecao1, false);
		JogadorDAO.inserirConsole(Q9Jogador, selecao1, false);
		JogadorDAO.inserirConsole(Q10Jogador, selecao1, false);
		JogadorDAO.inserirConsole(Q11Jogador, selecao1, false);

		Selecao selecao2 = new Selecao("Ecuador");
		SelecaoDAO.inserirConsole(selecao2);
		Jogador E1Jogador = new Jogador("Alexander Dominguez", selecao2, 0);
		Jogador E2Jogador = new Jogador("Pervis Estupinan", selecao2, 3);
		Jogador E3Jogador = new Jogador("Angelo Preciado", selecao2, 3);
		Jogador E4Jogador = new Jogador("Piero Hincapie", selecao2, 1);
		Jogador E5Jogador = new Jogador("Xavier Arreaga", selecao2, 1);
		Jogador E6Jogador = new Jogador("Diego Palacios", selecao2, 2);
		Jogador E7Jogador = new Jogador("Jackson Porozo", selecao2, 2);
		Jogador E8Jogador = new Jogador("Gonzalo Plata", selecao2, 5);
		Jogador E9Jogador = new Jogador("Moises Caicedo", selecao2, 5);
		Jogador E10Jogador = new Jogador("Michael Estrada", selecao2, 5);
		Jogador E11Jogador = new Jogador("Djorkaeff Reasco", selecao2, 4);

		JogadorDAO.inserirConsole(E1Jogador, selecao2, false);
		JogadorDAO.inserirConsole(E2Jogador, selecao2, false);
		JogadorDAO.inserirConsole(E3Jogador, selecao2, false);
		JogadorDAO.inserirConsole(E4Jogador, selecao2, false);
		JogadorDAO.inserirConsole(E5Jogador, selecao2, false);
		JogadorDAO.inserirConsole(E6Jogador, selecao2, false);
		JogadorDAO.inserirConsole(E7Jogador, selecao2, false);
		JogadorDAO.inserirConsole(E8Jogador, selecao2, false);
		JogadorDAO.inserirConsole(E9Jogador, selecao2, false);
		JogadorDAO.inserirConsole(E10Jogador, selecao2, false);
		JogadorDAO.inserirConsole(E11Jogador, selecao2, false);

		Selecao selecao3 = new Selecao("Senegal");
		SelecaoDAO.inserirConsole(selecao3);

		Jogador S1Jogador = new Jogador("Seny Dieng", selecao3, 0);
		Jogador S2Jogador = new Jogador("Formose Mendy", selecao3, 3);
		Jogador S3Jogador = new Jogador("Kalidou Koulibaly", selecao3, 3);
		Jogador S4Jogador = new Jogador("Papa Abou Cisse", selecao3, 1);
		Jogador S5Jogador = new Jogador("Fode Ballo-Toure", selecao3, 1);
		Jogador S6Jogador = new Jogador("Abdou Diallo", selecao3, 2);
		Jogador S7Jogador = new Jogador("Pape Matar Sarr", selecao3, 2);
		Jogador S8Jogador = new Jogador("Nampalys Mendy", selecao3, 5);
		Jogador S9Jogador = new Jogador("Cheikhou Kouyate", selecao3, 5);
		Jogador S10Jogador = new Jogador("Nicolas Jackson", selecao3, 5);
		Jogador S11Jogador = new Jogador("Krepin Diatta", selecao3, 4);

		JogadorDAO.inserirConsole(S1Jogador, selecao3, false);
		JogadorDAO.inserirConsole(S2Jogador, selecao3, false);
		JogadorDAO.inserirConsole(S3Jogador, selecao3, false);
		JogadorDAO.inserirConsole(S4Jogador, selecao3, false);
		JogadorDAO.inserirConsole(S5Jogador, selecao3, false);
		JogadorDAO.inserirConsole(S6Jogador, selecao3, false);
		JogadorDAO.inserirConsole(S7Jogador, selecao3, false);
		JogadorDAO.inserirConsole(S8Jogador, selecao3, false);
		JogadorDAO.inserirConsole(S9Jogador, selecao3, false);
		JogadorDAO.inserirConsole(S10Jogador, selecao3, false);
		JogadorDAO.inserirConsole(S11Jogador, selecao3, false);

		Selecao selecao4 = new Selecao("Holanda");
		SelecaoDAO.inserirConsole(selecao4);
		Jogador H1Jogador = new Jogador("Justin Bijlow", selecao4, 0);
		Jogador H2Jogador = new Jogador("Steven Bergwijn", selecao4, 1);
		Jogador H3Jogador = new Jogador("Cody Gakpo", selecao4, 1);
		Jogador H4Jogador = new Jogador("Luuk de Jong", selecao4, 2);
		Jogador H5Jogador = new Jogador("Memphis Depay", selecao4, 2);
		Jogador H6Jogador = new Jogador("Steven Berghuis", selecao4, 3);
		Jogador H7Jogador = new Jogador("Vincent Janssen", selecao4, 3);
		Jogador H8Jogador = new Jogador("Teun Koopmeiners", selecao4, 4);
		Jogador H9Jogador = new Jogador("Frenkie de Jong", selecao4, 4);
		Jogador H10Jogador = new Jogador("Kenneth Taylor", selecao4, 5);
		Jogador H11Jogador = new Jogador("Daley Blind", selecao4, 5);

		JogadorDAO.inserirConsole(H1Jogador, selecao4, false);
		JogadorDAO.inserirConsole(H2Jogador, selecao4, false);
		JogadorDAO.inserirConsole(H3Jogador, selecao4, false);
		JogadorDAO.inserirConsole(H4Jogador, selecao4, false);
		JogadorDAO.inserirConsole(H5Jogador, selecao4, false);
		JogadorDAO.inserirConsole(H6Jogador, selecao4, false);
		JogadorDAO.inserirConsole(H7Jogador, selecao4, false);
		JogadorDAO.inserirConsole(H8Jogador, selecao4, false);
		JogadorDAO.inserirConsole(H9Jogador, selecao4, false);
		JogadorDAO.inserirConsole(H10Jogador, selecao4, false);
		JogadorDAO.inserirConsole(H11Jogador, selecao4, false);

		Selecao selecao5 = new Selecao("Inglaterra");
		SelecaoDAO.inserirConsole(selecao5);
		Jogador I1Jogador = new Jogador("Nick Pope", selecao5, 0);
		Jogador I2Jogador = new Jogador("Harry Maguire", selecao5, 1);
		Jogador I3Jogador = new Jogador("Kyle Walker", selecao5, 1);
		Jogador I4Jogador = new Jogador("Look de Mains", selecao5, 2);
		Jogador I5Jogador = new Jogador("John Stones", selecao5, 2);
		Jogador I6Jogador = new Jogador("Jordan Henderson", selecao5, 3);
		Jogador I7Jogador = new Jogador("Declan Rice", selecao5, 3);
		Jogador I8Jogador = new Jogador("Jude Belliingham", selecao5, 4);
		Jogador I9Jogador = new Jogador("Harry Kane", selecao5, 4);
		Jogador I10Jogador = new Jogador("Jack Grealish", selecao5, 5);
		Jogador I11Jogador = new Jogador("Callum Wilson", selecao5, 5);

		JogadorDAO.inserirConsole(I1Jogador, selecao5, false);
		JogadorDAO.inserirConsole(I2Jogador, selecao5, false);
		JogadorDAO.inserirConsole(I3Jogador, selecao5, false);
		JogadorDAO.inserirConsole(I4Jogador, selecao5, false);
		JogadorDAO.inserirConsole(I5Jogador, selecao5, false);
		JogadorDAO.inserirConsole(I6Jogador, selecao5, false);
		JogadorDAO.inserirConsole(I7Jogador, selecao5, false);
		JogadorDAO.inserirConsole(I8Jogador, selecao5, false);
		JogadorDAO.inserirConsole(I9Jogador, selecao5, false);
		JogadorDAO.inserirConsole(I10Jogador, selecao5, false);
		JogadorDAO.inserirConsole(I11Jogador, selecao5, false);

		Selecao selecao6 = new Selecao("Irã");
		SelecaoDAO.inserirConsole(selecao6);
		Jogador IR1Jogador = new Jogador("Payam Niazmand", selecao6, 0);
		Jogador IR2Jogador = new Jogador("Sadegh Moharrami", selecao6, 1);
		Jogador IR3Jogador = new Jogador("Ehsan Hajsafi", selecao6, 1);
		Jogador IR4Jogador = new Jogador("Shojae Khalilzadeh", selecao6, 2);
		Jogador IR5Jogador = new Jogador("Milad Mohammadi", selecao6, 2);
		Jogador IR6Jogador = new Jogador("Saeid Ezatolahi", selecao6, 3);
		Jogador IR7Jogador = new Jogador("Vahid Amiri", selecao6, 3);
		Jogador IR8Jogador = new Jogador("Saman Ghoddos", selecao6, 4);
		Jogador IR9Jogador = new Jogador("Alireza Jahanbakhsh", selecao6, 4);
		Jogador IR10Jogador = new Jogador("Mehdi Taremi", selecao6, 5);
		Jogador IR11Jogador = new Jogador("Karim Ansarifard", selecao6, 5);

		JogadorDAO.inserirConsole(IR1Jogador, selecao6, false);
		JogadorDAO.inserirConsole(IR2Jogador, selecao6, false);
		JogadorDAO.inserirConsole(IR3Jogador, selecao6, false);
		JogadorDAO.inserirConsole(IR4Jogador, selecao6, false);
		JogadorDAO.inserirConsole(IR5Jogador, selecao6, false);
		JogadorDAO.inserirConsole(IR6Jogador, selecao6, false);
		JogadorDAO.inserirConsole(IR7Jogador, selecao6, false);
		JogadorDAO.inserirConsole(IR8Jogador, selecao6, false);
		JogadorDAO.inserirConsole(IR9Jogador, selecao6, false);
		JogadorDAO.inserirConsole(IR10Jogador, selecao6, false);
		JogadorDAO.inserirConsole(IR11Jogador, selecao6, false);

		Selecao selecao7 = new Selecao("Estados Unidos");
		SelecaoDAO.inserirConsole(selecao7);
		Jogador EU1Jogador = new Jogador("Matt Turner", selecao7, 0);
		Jogador EU2Jogador = new Jogador("DeAndre Yedlin", selecao7, 3);
		Jogador EU3Jogador = new Jogador("Walker Zimmerman", selecao7, 3);
		Jogador EU4Jogador = new Jogador("Aaron Long", selecao7, 1);
		Jogador EU5Jogador = new Jogador("Sergiño Dest", selecao7, 1);
		Jogador EU6Jogador = new Jogador("Yunus Musah", selecao7, 2);
		Jogador EU7Jogador = new Jogador("Cristian Roldan", selecao7, 2);
		Jogador EU8Jogador = new Jogador("Kellyn Acosta", selecao7, 5);
		Jogador EU9Jogador = new Jogador("Josh Sargent", selecao7, 5);
		Jogador EU10Jogador = new Jogador("Jesus Ferreira", selecao7, 5);
		Jogador EU11Jogador = new Jogador("Timothy Weah", selecao7, 4);

		JogadorDAO.inserirConsole(EU1Jogador, selecao7, false);
		JogadorDAO.inserirConsole(EU2Jogador, selecao7, false);
		JogadorDAO.inserirConsole(EU3Jogador, selecao7, false);
		JogadorDAO.inserirConsole(EU4Jogador, selecao7, false);
		JogadorDAO.inserirConsole(EU5Jogador, selecao7, false);
		JogadorDAO.inserirConsole(EU6Jogador, selecao7, false);
		JogadorDAO.inserirConsole(EU7Jogador, selecao7, false);
		JogadorDAO.inserirConsole(EU8Jogador, selecao7, false);
		JogadorDAO.inserirConsole(EU9Jogador, selecao7, false);
		JogadorDAO.inserirConsole(EU10Jogador, selecao7, false);
		JogadorDAO.inserirConsole(EU11Jogador, selecao7, false);

		Selecao selecao8 = new Selecao("Pais de Gales");
		SelecaoDAO.inserirConsole(selecao8);
		Jogador PG1Jogador = new Jogador("Wayne Hennessey", selecao8, 0);
		Jogador PG2Jogador = new Jogador("Chris Gunter", selecao8, 3);
		Jogador PG3Jogador = new Jogador("Walker Dead", selecao8, 3);
		Jogador PG4Jogador = new Jogador("Neco Williams", selecao8, 1);
		Jogador PG5Jogador = new Jogador("Ben Cabango", selecao8, 1);
		Jogador PG6Jogador = new Jogador("Joe Morrell", selecao8, 2);
		Jogador PG7Jogador = new Jogador("Jonny Williams", selecao8, 2);
		Jogador PG8Jogador = new Jogador("Gareth Bale", selecao8, 5);
		Jogador PG9Jogador = new Jogador("Kieffer Moore", selecao8, 5);
		Jogador PG10Jogador = new Jogador("Mark Harris", selecao8, 5);
		Jogador PG11Jogador = new Jogador("Dan James", selecao8, 4);

		JogadorDAO.inserirConsole(PG1Jogador, selecao8, false);
		JogadorDAO.inserirConsole(PG2Jogador, selecao8, false);
		JogadorDAO.inserirConsole(PG3Jogador, selecao8, false);
		JogadorDAO.inserirConsole(PG4Jogador, selecao8, false);
		JogadorDAO.inserirConsole(PG5Jogador, selecao8, false);
		JogadorDAO.inserirConsole(PG6Jogador, selecao8, false);
		JogadorDAO.inserirConsole(PG7Jogador, selecao8, false);
		JogadorDAO.inserirConsole(PG8Jogador, selecao8, false);
		JogadorDAO.inserirConsole(PG9Jogador, selecao8, false);
		JogadorDAO.inserirConsole(PG10Jogador, selecao8, false);
		JogadorDAO.inserirConsole(PG11Jogador, selecao8, false);

		Selecao selecao9 = new Selecao("Argentina");
		SelecaoDAO.inserirConsole(selecao9);
		Jogador AG1Jogador = new Jogador("Geronimo Rulli", selecao9, 0);
		Jogador AG2Jogador = new Jogador("Gonzalo Montiel", selecao9, 3);
		Jogador AG3Jogador = new Jogador("German Pezzella", selecao9, 3);
		Jogador AG4Jogador = new Jogador("Alanzoka From Brazil", selecao9, 1);
		Jogador AG5Jogador = new Jogador("Nicolás Otamendi", selecao9, 1);
		Jogador AG6Jogador = new Jogador("Cristian Romero", selecao9, 2);
		Jogador AG7Jogador = new Jogador("Guido Rodríguez", selecao9, 2);
		Jogador AG8Jogador = new Jogador("Rodrigo De Paul", selecao9, 5);
		Jogador AG9Jogador = new Jogador("Ángel Di María", selecao9, 5);
		Jogador AG10Jogador = new Jogador("Lionel Messi", selecao9, 5);
		Jogador AG11Jogador = new Jogador("Julián Álvarez", selecao9, 4);

		JogadorDAO.inserirConsole(AG1Jogador, selecao9, false);
		JogadorDAO.inserirConsole(AG2Jogador, selecao9, false);
		JogadorDAO.inserirConsole(AG3Jogador, selecao9, false);
		JogadorDAO.inserirConsole(AG4Jogador, selecao9, false);
		JogadorDAO.inserirConsole(AG5Jogador, selecao9, false);
		JogadorDAO.inserirConsole(AG6Jogador, selecao9, false);
		JogadorDAO.inserirConsole(AG7Jogador, selecao9, false);
		JogadorDAO.inserirConsole(AG8Jogador, selecao9, false);
		JogadorDAO.inserirConsole(AG9Jogador, selecao9, false);
		JogadorDAO.inserirConsole(AG10Jogador, selecao9, false);
		JogadorDAO.inserirConsole(AG11Jogador, selecao9, false);

		Selecao selecao10 = new Selecao("Árabia Saudita");
		SelecaoDAO.inserirConsole(selecao10);
		Jogador AS1Jogador = new Jogador("Mohammed Al Rubaie", selecao10, 0);
		Jogador AS2Jogador = new Jogador("Abdullah Madu", selecao10, 3);
		Jogador AS3Jogador = new Jogador("Saud Abdulhamid", selecao10, 3);
		Jogador AS4Jogador = new Jogador("Hassan Tambakti", selecao10, 1);
		Jogador AS5Jogador = new Jogador("Riyadh Sharahili", selecao10, 1);
		Jogador AS6Jogador = new Jogador("Hattan Bahebri", selecao10, 2);
		Jogador AS7Jogador = new Jogador("Mohamed Kanno", selecao10, 2);
		Jogador AS8Jogador = new Jogador("Abdullah Otayf", selecao10, 5);
		Jogador AS9Jogador = new Jogador("Haitham Asiri", selecao10, 5);
		Jogador AS10Jogador = new Jogador("Firas Al Buraikan", selecao10, 5);
		Jogador AS11Jogador = new Jogador("Saleh Al Shehri", selecao10, 4);

		JogadorDAO.inserirConsole(AS1Jogador, selecao10, false);
		JogadorDAO.inserirConsole(AS2Jogador, selecao10, false);
		JogadorDAO.inserirConsole(AS3Jogador, selecao10, false);
		JogadorDAO.inserirConsole(AS4Jogador, selecao10, false);
		JogadorDAO.inserirConsole(AS5Jogador, selecao10, false);
		JogadorDAO.inserirConsole(AS6Jogador, selecao10, false);
		JogadorDAO.inserirConsole(AS7Jogador, selecao10, false);
		JogadorDAO.inserirConsole(AS8Jogador, selecao10, false);
		JogadorDAO.inserirConsole(AS9Jogador, selecao10, false);
		JogadorDAO.inserirConsole(AS10Jogador, selecao10, false);
		JogadorDAO.inserirConsole(AS11Jogador, selecao10, false);

		Selecao selecao11 = new Selecao("México");
		SelecaoDAO.inserirConsole(selecao11);
		Jogador M1Jogador = new Jogador("Guillermo Ochoa", selecao11, 0);
		Jogador M2Jogador = new Jogador("Jorge Sánchez", selecao11, 3);
		Jogador M3Jogador = new Jogador("Kevin Álvarez", selecao11, 3);
		Jogador M4Jogador = new Jogador("Néstor Araujo", selecao11, 1);
		Jogador M5Jogador = new Jogador("Johan Vásquez", selecao11, 1);
		Jogador M6Jogador = new Jogador("Gerardo Arteaga", selecao11, 2);
		Jogador M7Jogador = new Jogador("Héctor Moreno", selecao11, 2);
		Jogador M8Jogador = new Jogador("Carlos Rodríguez", selecao11, 5);
		Jogador M9Jogador = new Jogador("Luis Chávez", selecao11, 5);
		Jogador M10Jogador = new Jogador("Uriel Antuna ", selecao11, 5);
		Jogador M11Jogador = new Jogador("Henry Martín", selecao11, 4);

		JogadorDAO.inserirConsole(M1Jogador, selecao11, false);
		JogadorDAO.inserirConsole(M2Jogador, selecao11, false);
		JogadorDAO.inserirConsole(M3Jogador, selecao11, false);
		JogadorDAO.inserirConsole(M4Jogador, selecao11, false);
		JogadorDAO.inserirConsole(M5Jogador, selecao11, false);
		JogadorDAO.inserirConsole(M6Jogador, selecao11, false);
		JogadorDAO.inserirConsole(M7Jogador, selecao11, false);
		JogadorDAO.inserirConsole(M8Jogador, selecao11, false);
		JogadorDAO.inserirConsole(M9Jogador, selecao11, false);
		JogadorDAO.inserirConsole(M10Jogador, selecao11, false);
		JogadorDAO.inserirConsole(M11Jogador, selecao11, false);

		Selecao selecao12 = new Selecao("Polônia");
		SelecaoDAO.inserirConsole(selecao12);
		Jogador P1Jogador = new Jogador("Bart Dragowski", selecao12, 0);
		Jogador P2Jogador = new Jogador("Jan Bednarek", selecao12, 3);
		Jogador P3Jogador = new Jogador("Bartosz Bereszynski", selecao12, 3);
		Jogador P4Jogador = new Jogador("Matty Cash", selecao12, 1);
		Jogador P5Jogador = new Jogador("Kamil Glik", selecao12, 1);
		Jogador P6Jogador = new Jogador("Robert Gumny", selecao12, 2);
		Jogador P7Jogador = new Jogador("Artur Jedrzejczyk", selecao12, 2);
		Jogador P8Jogador = new Jogador("Krystian Bielik", selecao12, 5);
		Jogador P9Jogador = new Jogador("Kamil Grosicki", selecao12, 5);
		Jogador P10Jogador = new Jogador("Robert Lewandowski", selecao12, 5);
		Jogador P11Jogador = new Jogador("Karol Swiderski", selecao12, 4);

		JogadorDAO.inserirConsole(P1Jogador, selecao12, false);
		JogadorDAO.inserirConsole(P2Jogador, selecao12, false);
		JogadorDAO.inserirConsole(P3Jogador, selecao12, false);
		JogadorDAO.inserirConsole(P4Jogador, selecao12, false);
		JogadorDAO.inserirConsole(P5Jogador, selecao12, false);
		JogadorDAO.inserirConsole(P6Jogador, selecao12, false);
		JogadorDAO.inserirConsole(P7Jogador, selecao12, false);
		JogadorDAO.inserirConsole(P8Jogador, selecao12, false);
		JogadorDAO.inserirConsole(P9Jogador, selecao12, false);
		JogadorDAO.inserirConsole(P10Jogador, selecao12, false);
		JogadorDAO.inserirConsole(P11Jogador, selecao12, false);

		Selecao selecao13 = new Selecao("França");
		SelecaoDAO.inserirConsole(selecao13);
		Jogador F1Jogador = new Jogador("Hugo Lloris", selecao13, 0);
		Jogador F2Jogador = new Jogador("Benjamin Pavard", selecao13, 3);
		Jogador F3Jogador = new Jogador("Jules Koundé", selecao13, 3);
		Jogador F4Jogador = new Jogador("Presnel Kimpembe", selecao13, 1);
		Jogador F5Jogador = new Jogador("William Saliba", selecao13, 1);
		Jogador F6Jogador = new Jogador("Adrien Rabiot", selecao13, 2);
		Jogador F7Jogador = new Jogador("Aurélien Tchouaméni", selecao13, 2);
		Jogador F8Jogador = new Jogador("Youssouf Fofana", selecao13, 5);
		Jogador F9Jogador = new Jogador("Mattéo Guendouzi", selecao13, 5);
		Jogador F10Jogador = new Jogador("Kingsley Coman", selecao13, 5);
		Jogador F11Jogador = new Jogador("Kylian Mbappé", selecao13, 4);

		JogadorDAO.inserirConsole(F1Jogador, selecao13, false);
		JogadorDAO.inserirConsole(F2Jogador, selecao13, false);
		JogadorDAO.inserirConsole(F3Jogador, selecao13, false);
		JogadorDAO.inserirConsole(F4Jogador, selecao13, false);
		JogadorDAO.inserirConsole(F5Jogador, selecao13, false);
		JogadorDAO.inserirConsole(F6Jogador, selecao13, false);
		JogadorDAO.inserirConsole(F7Jogador, selecao13, false);
		JogadorDAO.inserirConsole(F8Jogador, selecao13, false);
		JogadorDAO.inserirConsole(F9Jogador, selecao13, false);
		JogadorDAO.inserirConsole(F10Jogador, selecao13, false);
		JogadorDAO.inserirConsole(F11Jogador, selecao13, false);

		Selecao selecao14 = new Selecao("Australia");
		SelecaoDAO.inserirConsole(selecao14);
		Jogador A1Jogador = new Jogador("Mathew Ryan", selecao14, 0);
		Jogador A2Jogador = new Jogador("Aziz Behich", selecao14, 3);
		Jogador A3Jogador = new Jogador("Bailey Wright", selecao14, 3);
		Jogador A4Jogador = new Jogador("Harry Souttar", selecao14, 1);
		Jogador A5Jogador = new Jogador("Nathaniel Atkinson", selecao14, 1);
		Jogador A6Jogador = new Jogador("Joel King", selecao14, 2);
		Jogador A7Jogador = new Jogador("Thomas Deng", selecao14, 2);
		Jogador A8Jogador = new Jogador("Aaron Mooy", selecao14, 5);
		Jogador A9Jogador = new Jogador("Jackson Irvine", selecao14, 5);
		Jogador A10Jogador = new Jogador("Mitchell Duke", selecao14, 5);
		Jogador A11Jogador = new Jogador("Martin Boyle", selecao14, 4);

		JogadorDAO.inserirConsole(A1Jogador, selecao14, false);
		JogadorDAO.inserirConsole(A2Jogador, selecao14, false);
		JogadorDAO.inserirConsole(A3Jogador, selecao14, false);
		JogadorDAO.inserirConsole(A4Jogador, selecao14, false);
		JogadorDAO.inserirConsole(A5Jogador, selecao14, false);
		JogadorDAO.inserirConsole(A6Jogador, selecao14, false);
		JogadorDAO.inserirConsole(A7Jogador, selecao14, false);
		JogadorDAO.inserirConsole(A8Jogador, selecao14, false);
		JogadorDAO.inserirConsole(A9Jogador, selecao14, false);
		JogadorDAO.inserirConsole(A10Jogador, selecao14, false);
		JogadorDAO.inserirConsole(A11Jogador, selecao14, false);

		Selecao selecao15 = new Selecao("Dinamarca");
		SelecaoDAO.inserirConsole(selecao15);
		Jogador D1Jogador = new Jogador("Kasper Schmeichel", selecao15, 0);
		Jogador D2Jogador = new Jogador("Simon Kjaer", selecao15, 3);
		Jogador D3Jogador = new Jogador("Joachim Andersen", selecao15, 3);
		Jogador D4Jogador = new Jogador("Joakim Maehle", selecao15, 1);
		Jogador D5Jogador = new Jogador("Andreas Christensen", selecao15, 1);
		Jogador D6Jogador = new Jogador("Thomas Delaney", selecao15, 2);
		Jogador D7Jogador = new Jogador("Mathias Jensen", selecao15, 2);
		Jogador D8Jogador = new Jogador("Christian Eriksen", selecao15, 5);
		Jogador D9Jogador = new Jogador("Pierre-Emile Hojbjerg", selecao15, 5);
		Jogador D10Jogador = new Jogador("Andreas Skov Olsen", selecao15, 5);
		Jogador D11Jogador = new Jogador("Jesper Lindstrom", selecao15, 4);

		JogadorDAO.inserirConsole(D1Jogador, selecao15, false);
		JogadorDAO.inserirConsole(D2Jogador, selecao15, false);
		JogadorDAO.inserirConsole(D3Jogador, selecao15, false);
		JogadorDAO.inserirConsole(D4Jogador, selecao15, false);
		JogadorDAO.inserirConsole(D5Jogador, selecao15, false);
		JogadorDAO.inserirConsole(D6Jogador, selecao15, false);
		JogadorDAO.inserirConsole(D7Jogador, selecao15, false);
		JogadorDAO.inserirConsole(D8Jogador, selecao15, false);
		JogadorDAO.inserirConsole(D9Jogador, selecao15, false);
		JogadorDAO.inserirConsole(D10Jogador, selecao15, false);
		JogadorDAO.inserirConsole(D11Jogador, selecao15, false);

		Selecao selecao16 = new Selecao("Tunísia");
		SelecaoDAO.inserirConsole(selecao16);
		Jogador T1Jogador = new Jogador("Aymen Dahmen", selecao16, 0);
		Jogador T2Jogador = new Jogador("Mouez Hassen", selecao16, 3);
		Jogador T3Jogador = new Jogador("Mohamed Drager ", selecao16, 3);
		Jogador T4Jogador = new Jogador("Wajdi Kechrida", selecao16, 1);
		Jogador T5Jogador = new Jogador("Montassar Talbi", selecao16, 1);
		Jogador T6Jogador = new Jogador("Dylan Bronn", selecao16, 2);
		Jogador T7Jogador = new Jogador("Ellyes Skhiri", selecao16, 2);
		Jogador T8Jogador = new Jogador("Aissa Laidouni", selecao16, 5);
		Jogador T9Jogador = new Jogador("Hannibal Mejbri", selecao16, 5);
		Jogador T10Jogador = new Jogador("Naim Sliti", selecao16, 5);
		Jogador T11Jogador = new Jogador("Anis Ben Slimane", selecao16, 4);

		JogadorDAO.inserirConsole(T1Jogador, selecao16, false);
		JogadorDAO.inserirConsole(T2Jogador, selecao16, false);
		JogadorDAO.inserirConsole(T3Jogador, selecao16, false);
		JogadorDAO.inserirConsole(T4Jogador, selecao16, false);
		JogadorDAO.inserirConsole(T5Jogador, selecao16, false);
		JogadorDAO.inserirConsole(T6Jogador, selecao16, false);
		JogadorDAO.inserirConsole(T7Jogador, selecao16, false);
		JogadorDAO.inserirConsole(T8Jogador, selecao16, false);
		JogadorDAO.inserirConsole(T9Jogador, selecao16, false);
		JogadorDAO.inserirConsole(T10Jogador, selecao16, false);
		JogadorDAO.inserirConsole(T11Jogador, selecao16, false);

		Selecao selecao17 = new Selecao("Espanha");
		SelecaoDAO.inserirConsole(selecao17);
		Jogador ES1Jogador = new Jogador("Unai Simón", selecao17, 0);
		Jogador ES2Jogador = new Jogador("Dani Carvajal", selecao17, 3);
		Jogador ES3Jogador = new Jogador("César Azpilicueta", selecao17, 3);
		Jogador ES4Jogador = new Jogador("Eric García", selecao17, 1);
		Jogador ES5Jogador = new Jogador("Hugo Guillamón", selecao17, 1);
		Jogador ES6Jogador = new Jogador("Sergio Busquets", selecao17, 2);
		Jogador ES7Jogador = new Jogador("Rodrigo Moreno", selecao17, 2);
		Jogador ES8Jogador = new Jogador("Pablo Gavi ", selecao17, 5);
		Jogador ES9Jogador = new Jogador("Carlos Soler", selecao17, 5);
		Jogador ES10Jogador = new Jogador("Nico Williams", selecao17, 5);
		Jogador ES11Jogador = new Jogador("Dani Olmo", selecao17, 4);

		JogadorDAO.inserirConsole(ES1Jogador, selecao17, false);
		JogadorDAO.inserirConsole(ES2Jogador, selecao17, false);
		JogadorDAO.inserirConsole(ES3Jogador, selecao17, false);
		JogadorDAO.inserirConsole(ES4Jogador, selecao17, false);
		JogadorDAO.inserirConsole(ES5Jogador, selecao17, false);
		JogadorDAO.inserirConsole(ES6Jogador, selecao17, false);
		JogadorDAO.inserirConsole(ES7Jogador, selecao17, false);
		JogadorDAO.inserirConsole(ES8Jogador, selecao17, false);
		JogadorDAO.inserirConsole(ES9Jogador, selecao17, false);
		JogadorDAO.inserirConsole(ES10Jogador, selecao17, false);
		JogadorDAO.inserirConsole(ES11Jogador, selecao17, false);

		Selecao selecao18 = new Selecao("Costa Rica");
		SelecaoDAO.inserirConsole(selecao18);
		Jogador CR1Jogador = new Jogador("Keylor Navas", selecao18, 0);
		Jogador CR2Jogador = new Jogador("Francisco Calvo", selecao18, 3);
		Jogador CR3Jogador = new Jogador("Framengo Calvo", selecao18, 3);
		Jogador CR4Jogador = new Jogador("Erico Gartia", selecao18, 1);
		Jogador CR5Jogador = new Jogador("Óscar Duarte ", selecao18, 1);
		Jogador CR6Jogador = new Jogador("Juan Pablo Vargas", selecao18, 2);
		Jogador CR7Jogador = new Jogador("Celso Borges", selecao18, 2);
		Jogador CR8Jogador = new Jogador("Bryan Ruiz", selecao18, 5);
		Jogador CR9Jogador = new Jogador("Gerson Torres", selecao18, 5);
		Jogador CR10Jogador = new Jogador("Brandon Aguilera", selecao18, 5);
		Jogador CR11Jogador = new Jogador("Douglas López", selecao18, 4);

		JogadorDAO.inserirConsole(CR1Jogador, selecao18, false);
		JogadorDAO.inserirConsole(CR2Jogador, selecao18, false);
		JogadorDAO.inserirConsole(CR3Jogador, selecao18, false);
		JogadorDAO.inserirConsole(CR4Jogador, selecao18, false);
		JogadorDAO.inserirConsole(CR5Jogador, selecao18, false);
		JogadorDAO.inserirConsole(CR6Jogador, selecao18, false);
		JogadorDAO.inserirConsole(CR7Jogador, selecao18, false);
		JogadorDAO.inserirConsole(CR8Jogador, selecao18, false);
		JogadorDAO.inserirConsole(CR9Jogador, selecao18, false);
		JogadorDAO.inserirConsole(CR10Jogador, selecao18, false);
		JogadorDAO.inserirConsole(CR11Jogador, selecao18, false);

		Selecao selecao19 = new Selecao("Alemanha");
		SelecaoDAO.inserirConsole(selecao19);
		Jogador AM1Jogador = new Jogador("Manuel Neuer", selecao19, 0);
		Jogador AM2Jogador = new Jogador("Matthias Ginter", selecao19, 3);
		Jogador AM3Jogador = new Jogador("Niklas Suele", selecao19, 3);
		Jogador AM4Jogador = new Jogador("Thilo Kehrer", selecao19, 1);
		Jogador AM5Jogador = new Jogador("Lukas Klostermann", selecao19, 1);
		Jogador AM6Jogador = new Jogador("Ilkay Gundongan", selecao19, 2);
		Jogador AM7Jogador = new Jogador("Jonas Hofmann", selecao19, 2);
		Jogador AM8Jogador = new Jogador("Leon Goretzka", selecao19, 5);
		Jogador AM9Jogador = new Jogador("Joshua Kimmich", selecao19, 5);
		Jogador AM10Jogador = new Jogador("Karim Ademeyi", selecao19, 5);
		Jogador AM11Jogador = new Jogador("Niklas Fuellkrug", selecao19, 4);

		JogadorDAO.inserirConsole(AM1Jogador, selecao19, false);
		JogadorDAO.inserirConsole(AM2Jogador, selecao19, false);
		JogadorDAO.inserirConsole(AM3Jogador, selecao19, false);
		JogadorDAO.inserirConsole(AM4Jogador, selecao19, false);
		JogadorDAO.inserirConsole(AM5Jogador, selecao19, false);
		JogadorDAO.inserirConsole(AM6Jogador, selecao19, false);
		JogadorDAO.inserirConsole(AM7Jogador, selecao19, false);
		JogadorDAO.inserirConsole(AM8Jogador, selecao19, false);
		JogadorDAO.inserirConsole(AM9Jogador, selecao19, false);
		JogadorDAO.inserirConsole(AM10Jogador, selecao19, false);
		JogadorDAO.inserirConsole(AM11Jogador, selecao19, false);

		Selecao selecao20 = new Selecao("Japão");
		SelecaoDAO.inserirConsole(selecao20);
		Jogador JP1Jogador = new Jogador("Eiji Kawashima", selecao20, 0);
		Jogador JP2Jogador = new Jogador("Miki Yamane", selecao20, 3);
		Jogador JP3Jogador = new Jogador("Takehiro Tomiyasu", selecao20, 3);
		Jogador JP4Jogador = new Jogador("Hiroki Sakai ", selecao20, 1);
		Jogador JP5Jogador = new Jogador("Maya Yoshida", selecao20, 1);
		Jogador JP6Jogador = new Jogador("Wataru Endo", selecao20, 2);
		Jogador JP7Jogador = new Jogador("Gaku Shibasaki", selecao20, 2);
		Jogador JP8Jogador = new Jogador("Kaoru Mitoma", selecao20, 5);
		Jogador JP9Jogador = new Jogador("Takumi Minamino", selecao20, 5);
		Jogador JP10Jogador = new Jogador("Takuma Asano", selecao20, 5);
		Jogador JP11Jogador = new Jogador("Daizen Maeda", selecao20, 4);

		JogadorDAO.inserirConsole(JP1Jogador, selecao20, false);
		JogadorDAO.inserirConsole(JP2Jogador, selecao20, false);
		JogadorDAO.inserirConsole(JP3Jogador, selecao20, false);
		JogadorDAO.inserirConsole(JP4Jogador, selecao20, false);
		JogadorDAO.inserirConsole(JP5Jogador, selecao20, false);
		JogadorDAO.inserirConsole(JP6Jogador, selecao20, false);
		JogadorDAO.inserirConsole(JP7Jogador, selecao20, false);
		JogadorDAO.inserirConsole(JP8Jogador, selecao20, false);
		JogadorDAO.inserirConsole(JP9Jogador, selecao20, false);
		JogadorDAO.inserirConsole(JP10Jogador, selecao20, false);
		JogadorDAO.inserirConsole(JP11Jogador, selecao20, false);

		Selecao selecao21 = new Selecao("Bélgica");
		SelecaoDAO.inserirConsole(selecao21);
		Jogador BG1Jogador = new Jogador("Thibaut Courtois", selecao21, 0);
		Jogador BG2Jogador = new Jogador("Jan Vertonghen", selecao21, 3);
		Jogador BG3Jogador = new Jogador("Toby Alderweireld", selecao21, 3);
		Jogador BG4Jogador = new Jogador("Zeno Debast", selecao21, 1);
		Jogador BG5Jogador = new Jogador("Hans Vanaken", selecao21, 1);
		Jogador BG6Jogador = new Jogador("Amadou Onana", selecao21, 2);
		Jogador BG7Jogador = new Jogador("Kevin De Bruyne", selecao21, 2);
		Jogador BG8Jogador = new Jogador("Yannick Carrasco", selecao21, 5);
		Jogador BG9Jogador = new Jogador("Romelu Lukaku", selecao21, 5);
		Jogador BG10Jogador = new Jogador("Michy Batshuayi", selecao21, 5);
		Jogador BG11Jogador = new Jogador("Eden Hazard", selecao21, 4);

		JogadorDAO.inserirConsole(BG1Jogador, selecao21, false);
		JogadorDAO.inserirConsole(BG2Jogador, selecao21, false);
		JogadorDAO.inserirConsole(BG3Jogador, selecao21, false);
		JogadorDAO.inserirConsole(BG4Jogador, selecao21, false);
		JogadorDAO.inserirConsole(BG5Jogador, selecao21, false);
		JogadorDAO.inserirConsole(BG6Jogador, selecao21, false);
		JogadorDAO.inserirConsole(BG7Jogador, selecao21, false);
		JogadorDAO.inserirConsole(BG8Jogador, selecao21, false);
		JogadorDAO.inserirConsole(BG9Jogador, selecao21, false);
		JogadorDAO.inserirConsole(BG10Jogador, selecao21, false);
		JogadorDAO.inserirConsole(BG11Jogador, selecao21, false);

		Selecao selecao22 = new Selecao("Canadá");
		SelecaoDAO.inserirConsole(selecao22);
		Jogador CA1Jogador = new Jogador("James Pantemis", selecao22, 0);
		Jogador CA2Jogador = new Jogador("Samuel Adekugbe", selecao22, 3);
		Jogador CA3Jogador = new Jogador("Joel Waterman", selecao22, 3);
		Jogador CA4Jogador = new Jogador("Alistair Johnston", selecao22, 1);
		Jogador CA5Jogador = new Jogador("Richie Laryea", selecao22, 1);
		Jogador CA6Jogador = new Jogador("Liam Fraser", selecao22, 2);
		Jogador CA7Jogador = new Jogador("Ismael Koné", selecao22, 2);
		Jogador CA8Jogador = new Jogador("Samuel Piette", selecao22, 5);
		Jogador CA9Jogador = new Jogador("Lucas Cavallini", selecao22, 5);
		Jogador CA10Jogador = new Jogador("Jonathan Fagos", selecao22, 5);
		Jogador CA11Jogador = new Jogador("Jonathan David", selecao22, 4);

		JogadorDAO.inserirConsole(CA1Jogador, selecao22, false);
		JogadorDAO.inserirConsole(CA2Jogador, selecao22, false);
		JogadorDAO.inserirConsole(CA3Jogador, selecao22, false);
		JogadorDAO.inserirConsole(CA4Jogador, selecao22, false);
		JogadorDAO.inserirConsole(CA5Jogador, selecao22, false);
		JogadorDAO.inserirConsole(CA6Jogador, selecao22, false);
		JogadorDAO.inserirConsole(CA7Jogador, selecao22, false);
		JogadorDAO.inserirConsole(CA8Jogador, selecao22, false);
		JogadorDAO.inserirConsole(CA9Jogador, selecao22, false);
		JogadorDAO.inserirConsole(CA10Jogador, selecao22, false);
		JogadorDAO.inserirConsole(CA11Jogador, selecao22, false);

		Selecao selecao23 = new Selecao("Marrocos");
		SelecaoDAO.inserirConsole(selecao23);
		Jogador MA1Jogador = new Jogador("Yassine Bono", selecao23, 0);
		Jogador MA2Jogador = new Jogador("Achraf Hakimi", selecao23, 3);
		Jogador MA3Jogador = new Jogador("Noussair Mazraoui", selecao23, 3);
		Jogador MA4Jogador = new Jogador("Nayef Aguerd", selecao23, 1);
		Jogador MA5Jogador = new Jogador("Ghanem Saiss", selecao23, 1);
		Jogador MA6Jogador = new Jogador("Achraf Dari", selecao23, 2);
		Jogador MA7Jogador = new Jogador("Badr Benoun", selecao23, 2);
		Jogador MA8Jogador = new Jogador("Sofyan Amrabat", selecao23, 5);
		Jogador MA9Jogador = new Jogador("Sofy Bat", selecao23, 5);
		Jogador MA10Jogador = new Jogador("Sofiane Boufal", selecao23, 5);
		Jogador MA11Jogador = new Jogador("Walid Cheddira", selecao23, 4);

		JogadorDAO.inserirConsole(MA1Jogador, selecao23, false);
		JogadorDAO.inserirConsole(MA2Jogador, selecao23, false);
		JogadorDAO.inserirConsole(MA3Jogador, selecao23, false);
		JogadorDAO.inserirConsole(MA4Jogador, selecao23, false);
		JogadorDAO.inserirConsole(MA5Jogador, selecao23, false);
		JogadorDAO.inserirConsole(MA6Jogador, selecao23, false);
		JogadorDAO.inserirConsole(MA7Jogador, selecao23, false);
		JogadorDAO.inserirConsole(MA8Jogador, selecao23, false);
		JogadorDAO.inserirConsole(MA9Jogador, selecao23, false);
		JogadorDAO.inserirConsole(MA10Jogador, selecao23, false);
		JogadorDAO.inserirConsole(MA11Jogador, selecao23, false);

		Selecao selecao24 = new Selecao("Croácia");
		SelecaoDAO.inserirConsole(selecao24);
		Jogador CC1Jogador = new Jogador("Ivo Grbic", selecao24, 0);
		Jogador CC2Jogador = new Jogador("Domagoj Vida", selecao24, 3);
		Jogador CC3Jogador = new Jogador("Dejan Lovren", selecao24, 3);
		Jogador CC4Jogador = new Jogador("Josip Juranovic", selecao24, 1);
		Jogador CC5Jogador = new Jogador("Borna Sosa", selecao24, 1);
		Jogador CC6Jogador = new Jogador("Martin Erlic", selecao24, 2);
		Jogador CC7Jogador = new Jogador("Luka Modric", selecao24, 2);
		Jogador CC8Jogador = new Jogador("Mateo Kovacic", selecao24, 5);
		Jogador CC9Jogador = new Jogador("Marcelo Brozovic", selecao24, 5);
		Jogador CC10Jogador = new Jogador("Kristijan Jakic", selecao24, 5);
		Jogador CC11Jogador = new Jogador("Ante Budimir", selecao24, 4);

		JogadorDAO.inserirConsole(CC1Jogador, selecao24, false);
		JogadorDAO.inserirConsole(CC2Jogador, selecao24, false);
		JogadorDAO.inserirConsole(CC3Jogador, selecao24, false);
		JogadorDAO.inserirConsole(CC4Jogador, selecao24, false);
		JogadorDAO.inserirConsole(CC5Jogador, selecao24, false);
		JogadorDAO.inserirConsole(CC6Jogador, selecao24, false);
		JogadorDAO.inserirConsole(CC7Jogador, selecao24, false);
		JogadorDAO.inserirConsole(CC8Jogador, selecao24, false);
		JogadorDAO.inserirConsole(CC9Jogador, selecao24, false);
		JogadorDAO.inserirConsole(CC10Jogador, selecao24, false);
		JogadorDAO.inserirConsole(CC11Jogador, selecao24, false);

		Selecao selecao25 = new Selecao("Brasil");
		SelecaoDAO.inserirConsole(selecao25);
		Jogador BR1Jogador = new Jogador("Alisson", selecao25, 0);
		Jogador BR2Jogador = new Jogador("Danilo", selecao25, 3);
		Jogador BR3Jogador = new Jogador("Alex Sandro", selecao25, 3);
		Jogador BR4Jogador = new Jogador("Marquinhos", selecao25, 1);
		Jogador BR5Jogador = new Jogador("Thiago Silva", selecao25, 1);
		Jogador BR6Jogador = new Jogador("Casemiro", selecao25, 2);
		Jogador BR7Jogador = new Jogador("Paquetá", selecao25, 2);
		Jogador BR8Jogador = new Jogador("Vinicius Júnior", selecao25, 5);
		Jogador BR9Jogador = new Jogador("Raphinha", selecao25, 5);
		Jogador BR10Jogador = new Jogador("Richarlison", selecao25, 5);
		Jogador BR11Jogador = new Jogador("Neymar", selecao25, 4);

		JogadorDAO.inserirConsole(BR1Jogador, selecao25, false);
		JogadorDAO.inserirConsole(BR2Jogador, selecao25, false);
		JogadorDAO.inserirConsole(BR3Jogador, selecao25, false);
		JogadorDAO.inserirConsole(BR4Jogador, selecao25, false);
		JogadorDAO.inserirConsole(BR5Jogador, selecao25, false);
		JogadorDAO.inserirConsole(BR6Jogador, selecao25, false);
		JogadorDAO.inserirConsole(BR7Jogador, selecao25, false);
		JogadorDAO.inserirConsole(BR8Jogador, selecao25, false);
		JogadorDAO.inserirConsole(BR9Jogador, selecao25, false);
		JogadorDAO.inserirConsole(BR10Jogador, selecao25, false);
		JogadorDAO.inserirConsole(BR11Jogador, selecao25, false);

		Selecao selecao26 = new Selecao("Sérvia");
		SelecaoDAO.inserirConsole(selecao26);
		Jogador SE1Jogador = new Jogador("Marko Dmitrovic", selecao26, 0);
		Jogador SE2Jogador = new Jogador("Stefan Mitrovic", selecao26, 3);
		Jogador SE3Jogador = new Jogador("Nikola Milenkovic", selecao26, 3);
		Jogador SE4Jogador = new Jogador("Strahinja Pavlovic", selecao26, 1);
		Jogador SE5Jogador = new Jogador("Milos Veljkovic", selecao26, 1);
		Jogador SE6Jogador = new Jogador("Filip Mladenovic", selecao26, 2);
		Jogador SE7Jogador = new Jogador("Nemanja Gudelj", selecao26, 2);
		Jogador SE8Jogador = new Jogador("Filip Kostic", selecao26, 5);
		Jogador SE9Jogador = new Jogador("Ivan Ilic", selecao26, 5);
		Jogador SE10Jogador = new Jogador("Andriza Zivkovic", selecao26, 5);
		Jogador SE11Jogador = new Jogador("Dusan Vlahovic", selecao26, 4);

		JogadorDAO.inserirConsole(SE1Jogador, selecao26, false);
		JogadorDAO.inserirConsole(SE2Jogador, selecao26, false);
		JogadorDAO.inserirConsole(SE3Jogador, selecao26, false);
		JogadorDAO.inserirConsole(SE4Jogador, selecao26, false);
		JogadorDAO.inserirConsole(SE5Jogador, selecao26, false);
		JogadorDAO.inserirConsole(SE6Jogador, selecao26, false);
		JogadorDAO.inserirConsole(SE7Jogador, selecao26, false);
		JogadorDAO.inserirConsole(SE8Jogador, selecao26, false);
		JogadorDAO.inserirConsole(SE9Jogador, selecao26, false);
		JogadorDAO.inserirConsole(SE10Jogador, selecao26, false);
		JogadorDAO.inserirConsole(SE11Jogador, selecao26, false);

		Selecao selecao27 = new Selecao("Suíça");
		SelecaoDAO.inserirConsole(selecao27);
		Jogador SU1Jogador = new Jogador("Gregor Kobel", selecao27, 0);
		Jogador SU2Jogador = new Jogador("Manuel Akanji ", selecao27, 3);
		Jogador SU3Jogador = new Jogador("Nico Elvedi ", selecao27, 3);
		Jogador SU4Jogador = new Jogador("Eray Comert", selecao27, 1);
		Jogador SU5Jogador = new Jogador("Silvan Widmer", selecao27, 1);
		Jogador SU6Jogador = new Jogador("Michel Aebischer", selecao27, 2);
		Jogador SU7Jogador = new Jogador("Fabian Frei", selecao27, 2);
		Jogador SU8Jogador = new Jogador("Remo Freuler", selecao27, 5);
		Jogador SU9Jogador = new Jogador("Ardon Jashari", selecao27, 5);
		Jogador SU10Jogador = new Jogador("Fabian Rieder", selecao27, 5);
		Jogador SU11Jogador = new Jogador("Noah Okafor", selecao27, 4);

		JogadorDAO.inserirConsole(SU1Jogador, selecao27, false);
		JogadorDAO.inserirConsole(SU2Jogador, selecao27, false);
		JogadorDAO.inserirConsole(SU3Jogador, selecao27, false);
		JogadorDAO.inserirConsole(SU4Jogador, selecao27, false);
		JogadorDAO.inserirConsole(SU5Jogador, selecao27, false);
		JogadorDAO.inserirConsole(SU6Jogador, selecao27, false);
		JogadorDAO.inserirConsole(SU7Jogador, selecao27, false);
		JogadorDAO.inserirConsole(SU8Jogador, selecao27, false);
		JogadorDAO.inserirConsole(SU9Jogador, selecao27, false);
		JogadorDAO.inserirConsole(SU10Jogador, selecao27, false);
		JogadorDAO.inserirConsole(SU11Jogador, selecao27, false);

		Selecao selecao28 = new Selecao("Camarões");
		SelecaoDAO.inserirConsole(selecao28);
		Jogador CM1Jogador = new Jogador("Andre Onana", selecao28, 0);
		Jogador CM2Jogador = new Jogador("Enzo Ebosse", selecao28, 3);
		Jogador CM3Jogador = new Jogador("Collins Fai", selecao28, 3);
		Jogador CM4Jogador = new Jogador("Olivier Mbaizo", selecao28, 1);
		Jogador CM5Jogador = new Jogador("Nicolas Nkoulou", selecao28, 1);
		Jogador CM6Jogador = new Jogador("Tolo Nouhou", selecao28, 2);
		Jogador CM7Jogador = new Jogador("Christopher Wooh", selecao28, 2);
		Jogador CM8Jogador = new Jogador("Olivier Ntcham", selecao28, 5);
		Jogador CM9Jogador = new Jogador("Gael Ondoua", selecao28, 5);
		Jogador CM10Jogador = new Jogador("Samuel Oum Gouet", selecao28, 5);
		Jogador CM11Jogador = new Jogador("Vicent Aboubakar", selecao28, 4);

		JogadorDAO.inserirConsole(CM1Jogador, selecao28, false);
		JogadorDAO.inserirConsole(CM2Jogador, selecao28, false);
		JogadorDAO.inserirConsole(CM3Jogador, selecao28, false);
		JogadorDAO.inserirConsole(CM4Jogador, selecao28, false);
		JogadorDAO.inserirConsole(CM5Jogador, selecao28, false);
		JogadorDAO.inserirConsole(CM6Jogador, selecao28, false);
		JogadorDAO.inserirConsole(CM7Jogador, selecao28, false);
		JogadorDAO.inserirConsole(CM8Jogador, selecao28, false);
		JogadorDAO.inserirConsole(CM9Jogador, selecao28, false);
		JogadorDAO.inserirConsole(CM10Jogador, selecao28, false);
		JogadorDAO.inserirConsole(CM11Jogador, selecao28, false);

		Selecao selecao29 = new Selecao("Portugal");
		SelecaoDAO.inserirConsole(selecao29);
		Jogador PO1Jogador = new Jogador("Rui Patrício", selecao29, 0);
		Jogador PO2Jogador = new Jogador("Diogo Dalot", selecao29, 3);
		Jogador PO3Jogador = new Jogador("João Cancelo", selecao29, 3);
		Jogador PO4Jogador = new Jogador("Danilo Pereira", selecao29, 1);
		Jogador PO5Jogador = new Jogador("Pepe", selecao29, 1);
		Jogador PO6Jogador = new Jogador("Nuno Mendes", selecao29, 2);
		Jogador PO7Jogador = new Jogador("Bernardo Silva", selecao29, 2);
		Jogador PO8Jogador = new Jogador("Matheus Nunes", selecao29, 5);
		Jogador PO9Jogador = new Jogador("Vitinha", selecao29, 5);
		Jogador PO10Jogador = new Jogador("João Félix", selecao29, 5);
		Jogador PO11Jogador = new Jogador("Cristiano Ronaldo", selecao29, 4);

		JogadorDAO.inserirConsole(PO1Jogador, selecao29, false);
		JogadorDAO.inserirConsole(PO2Jogador, selecao29, false);
		JogadorDAO.inserirConsole(PO3Jogador, selecao29, false);
		JogadorDAO.inserirConsole(PO4Jogador, selecao29, false);
		JogadorDAO.inserirConsole(PO5Jogador, selecao29, false);
		JogadorDAO.inserirConsole(PO6Jogador, selecao29, false);
		JogadorDAO.inserirConsole(PO7Jogador, selecao29, false);
		JogadorDAO.inserirConsole(PO8Jogador, selecao29, false);
		JogadorDAO.inserirConsole(PO9Jogador, selecao29, false);
		JogadorDAO.inserirConsole(PO10Jogador, selecao29, false);
		JogadorDAO.inserirConsole(PO11Jogador, selecao29, false);

		Selecao selecao30 = new Selecao("Gana");
		SelecaoDAO.inserirConsole(selecao30);
		Jogador GA1Jogador = new Jogador("Manaf Nurudeen", selecao30, 0);
		Jogador GA2Jogador = new Jogador("Denis Odoi", selecao30, 3);
		Jogador GA3Jogador = new Jogador("Tariq Lamptey", selecao30, 3);
		Jogador GA4Jogador = new Jogador("Alidu Seidu", selecao30, 1);
		Jogador GA5Jogador = new Jogador("Daniel Amartey", selecao30, 1);
		Jogador GA6Jogador = new Jogador("Alexander Djiku", selecao30, 2);
		Jogador GA7Jogador = new Jogador("Jali Habbei", selecao30, 2);
		Jogador GA8Jogador = new Jogador("Gideon Ganwa", selecao30, 5);
		Jogador GA9Jogador = new Jogador("Gideon Mensah", selecao30, 5);
		Jogador GA10Jogador = new Jogador("Thomas Partey", selecao30, 5);
		Jogador GA11Jogador = new Jogador("Jordan Ayew", selecao30, 4);

		JogadorDAO.inserirConsole(GA1Jogador, selecao30, false);
		JogadorDAO.inserirConsole(GA2Jogador, selecao30, false);
		JogadorDAO.inserirConsole(GA3Jogador, selecao30, false);
		JogadorDAO.inserirConsole(GA4Jogador, selecao30, false);
		JogadorDAO.inserirConsole(GA5Jogador, selecao30, false);
		JogadorDAO.inserirConsole(GA6Jogador, selecao30, false);
		JogadorDAO.inserirConsole(GA7Jogador, selecao30, false);
		JogadorDAO.inserirConsole(GA8Jogador, selecao30, false);
		JogadorDAO.inserirConsole(GA9Jogador, selecao30, false);
		JogadorDAO.inserirConsole(GA10Jogador, selecao30, false);
		JogadorDAO.inserirConsole(GA11Jogador, selecao30, false);

		Selecao selecao31 = new Selecao("Uruguai");
		SelecaoDAO.inserirConsole(selecao31);
		Jogador UR1Jogador = new Jogador("Fernando Muslera", selecao31, 0);
		Jogador UR2Jogador = new Jogador("Ronald Araújo", selecao31, 3);
		Jogador UR3Jogador = new Jogador("Martín Cáceres", selecao31, 3);
		Jogador UR4Jogador = new Jogador("Diego Godín", selecao31, 1);
		Jogador UR5Jogador = new Jogador("Mathías Olivera", selecao31, 1);
		Jogador UR6Jogador = new Jogador("Guillermo Varela", selecao31, 2);
		Jogador UR7Jogador = new Jogador("Rodrigo Bentancur", selecao31, 2);
		Jogador UR8Jogador = new Jogador("Giorgian de Arrascaeta", selecao31, 5);
		Jogador UR9Jogador = new Jogador("Nicolás de la Cruz", selecao31, 5);
		Jogador UR10Jogador = new Jogador("Lucas Torreira", selecao31, 5);
		Jogador UR11Jogador = new Jogador("Edinson Cavani", selecao31, 4);

		JogadorDAO.inserirConsole(UR1Jogador, selecao31, false);
		JogadorDAO.inserirConsole(UR2Jogador, selecao31, false);
		JogadorDAO.inserirConsole(UR3Jogador, selecao31, false);
		JogadorDAO.inserirConsole(UR4Jogador, selecao31, false);
		JogadorDAO.inserirConsole(UR5Jogador, selecao31, false);
		JogadorDAO.inserirConsole(UR6Jogador, selecao31, false);
		JogadorDAO.inserirConsole(UR7Jogador, selecao31, false);
		JogadorDAO.inserirConsole(UR8Jogador, selecao31, false);
		JogadorDAO.inserirConsole(UR9Jogador, selecao31, false);
		JogadorDAO.inserirConsole(UR10Jogador, selecao31, false);
		JogadorDAO.inserirConsole(UR11Jogador, selecao31, false);

		Selecao selecao32 = new Selecao("Coreia do Sul");
		SelecaoDAO.inserirConsole(selecao32);
		Jogador KR1Jogador = new Jogador("Kim Seung Gyu", selecao32, 0);
		Jogador KR2Jogador = new Jogador("Hong Chul", selecao32, 3);
		Jogador KR3Jogador = new Jogador("Kim Moon hwan", selecao32, 3);
		Jogador KR4Jogador = new Jogador("Yoon Jong gyu", selecao32, 1);
		Jogador KR5Jogador = new Jogador("Kim Young gwon", selecao32, 1);
		Jogador KR6Jogador = new Jogador("Kim Tae hwan", selecao32, 2);
		Jogador KR7Jogador = new Jogador("Kwon Kyung won", selecao32, 2);
		Jogador KR8Jogador = new Jogador("Na Sang ho", selecao32, 5);
		Jogador KR9Jogador = new Jogador("Paik Seung ho", selecao32, 5);
		Jogador KR10Jogador = new Jogador("Kwon Chang hoon", selecao32, 5);
		Jogador KR11Jogador = new Jogador("Hwang Ui jo", selecao32, 4);

		JogadorDAO.inserirConsole(KR1Jogador, selecao32, false);
		JogadorDAO.inserirConsole(KR2Jogador, selecao32, false);
		JogadorDAO.inserirConsole(KR3Jogador, selecao32, false);
		JogadorDAO.inserirConsole(KR4Jogador, selecao32, false);
		JogadorDAO.inserirConsole(KR5Jogador, selecao32, false);
		JogadorDAO.inserirConsole(KR6Jogador, selecao32, false);
		JogadorDAO.inserirConsole(KR7Jogador, selecao32, false);
		JogadorDAO.inserirConsole(KR8Jogador, selecao32, false);
		JogadorDAO.inserirConsole(KR9Jogador, selecao32, false);
		JogadorDAO.inserirConsole(KR10Jogador, selecao32, false);
		JogadorDAO.inserirConsole(KR11Jogador, selecao32, false);
		

		try {
			TecnicoDAO.inserir(new Tecnico("Félix Sánchez", selecao1), selecao1);
			TecnicoDAO.inserir(new Tecnico("Gustavo Alfaro", selecao2), selecao2);
			TecnicoDAO.inserir(new Tecnico("Aliou Cissé", selecao3), selecao3);
			TecnicoDAO.inserir(new Tecnico("Louis Van Gaal", selecao4), selecao4);
			TecnicoDAO.inserir(new Tecnico("Gareth Southgate", selecao5), selecao5);
			TecnicoDAO.inserir(new Tecnico("Carlos Queiroz", selecao6), selecao6);
			TecnicoDAO.inserir(new Tecnico("Gregg Berhalter", selecao7), selecao7);
			TecnicoDAO.inserir(new Tecnico("Robert Page", selecao8), selecao8);
			TecnicoDAO.inserir(new Tecnico("Lionel Scaloni", selecao9), selecao9);
			TecnicoDAO.inserir(new Tecnico("Herve Renard", selecao10), selecao10);
			TecnicoDAO.inserir(new Tecnico("Gerardo Martino", selecao11), selecao11);
			TecnicoDAO.inserir(new Tecnico("Czeslaw Michniewicz", selecao12), selecao12);
			TecnicoDAO.inserir(new Tecnico("Didier Deschamps", selecao13), selecao13);
			TecnicoDAO.inserir(new Tecnico("Graham Arnold", selecao14), selecao14);
			TecnicoDAO.inserir(new Tecnico("Kasper Hjulmand", selecao15), selecao15);
			TecnicoDAO.inserir(new Tecnico("Jalel Kadri", selecao16), selecao16);
			TecnicoDAO.inserir(new Tecnico("Luis Enrique", selecao17), selecao17);
			TecnicoDAO.inserir(new Tecnico("Luis Fernando", selecao18), selecao18);
			TecnicoDAO.inserir(new Tecnico("Hansi Flick", selecao19), selecao19);
			TecnicoDAO.inserir(new Tecnico("Hajime Moriyasu", selecao20), selecao20);
			TecnicoDAO.inserir(new Tecnico("Roberto Martínez", selecao21), selecao21);
			TecnicoDAO.inserir(new Tecnico("John Herdman", selecao22), selecao22);
			TecnicoDAO.inserir(new Tecnico("Walid Regragui", selecao23), selecao23);
			TecnicoDAO.inserir(new Tecnico("Zlatko Dalic", selecao24), selecao24);
			TecnicoDAO.inserir(new Tecnico("Tite", selecao25), selecao25);
			TecnicoDAO.inserir(new Tecnico("Dragan Stojkovic", selecao26), selecao26);
			TecnicoDAO.inserir(new Tecnico("Murat Yakin", selecao27), selecao27);
			TecnicoDAO.inserir(new Tecnico("Rigobert Song", selecao28), selecao28);
			TecnicoDAO.inserir(new Tecnico("Fernando Santos", selecao29), selecao29);
			TecnicoDAO.inserir(new Tecnico("Otto Addo", selecao30), selecao30);
			TecnicoDAO.inserir(new Tecnico("Diego Alonso", selecao31), selecao31);
			TecnicoDAO.inserir(new Tecnico("Paulo Bento", selecao32), selecao32);
		} catch (ListaCheiaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ObjetoJaExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CaracterInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StringVaziaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		GrupoPrimeiraFase.adicionarSelecao("A", selecao1);
		GrupoPrimeiraFase.adicionarSelecao("A", selecao2);
		GrupoPrimeiraFase.adicionarSelecao("A", selecao3);
		GrupoPrimeiraFase.adicionarSelecao("A", selecao4);

		GrupoPrimeiraFase.adicionarSelecao("B", selecao5);
		GrupoPrimeiraFase.adicionarSelecao("B", selecao6);
		GrupoPrimeiraFase.adicionarSelecao("B", selecao7);
		GrupoPrimeiraFase.adicionarSelecao("B", selecao8);

		GrupoPrimeiraFase.adicionarSelecao("C", selecao9);
		GrupoPrimeiraFase.adicionarSelecao("C", selecao10);
		GrupoPrimeiraFase.adicionarSelecao("C", selecao11);
		GrupoPrimeiraFase.adicionarSelecao("C", selecao12);

		GrupoPrimeiraFase.adicionarSelecao("D", selecao13);
		GrupoPrimeiraFase.adicionarSelecao("D", selecao14);
		GrupoPrimeiraFase.adicionarSelecao("D", selecao15);
		GrupoPrimeiraFase.adicionarSelecao("D", selecao16);

		GrupoPrimeiraFase.adicionarSelecao("E", selecao17);
		GrupoPrimeiraFase.adicionarSelecao("E", selecao18);
		GrupoPrimeiraFase.adicionarSelecao("E", selecao19);
		GrupoPrimeiraFase.adicionarSelecao("E", selecao20);

		GrupoPrimeiraFase.adicionarSelecao("F", selecao21);
		GrupoPrimeiraFase.adicionarSelecao("F", selecao22);
		GrupoPrimeiraFase.adicionarSelecao("F", selecao23);
		GrupoPrimeiraFase.adicionarSelecao("F", selecao24);

		GrupoPrimeiraFase.adicionarSelecao("G", selecao25);
		GrupoPrimeiraFase.adicionarSelecao("G", selecao26);
		GrupoPrimeiraFase.adicionarSelecao("G", selecao27);
		GrupoPrimeiraFase.adicionarSelecao("G", selecao28);

		GrupoPrimeiraFase.adicionarSelecao("H", selecao29);
		GrupoPrimeiraFase.adicionarSelecao("H", selecao30);
		GrupoPrimeiraFase.adicionarSelecao("H", selecao31);
		GrupoPrimeiraFase.adicionarSelecao("H", selecao32);
	}

	public static void main(String[] args) {

		preDefinicao();

		GrupoPrimeiraFase.organizadorTodasPartidas();

		RandomPartida(48, true);
		GrupoPrimeiraFase.listarTodosGrupos();
		OitavasDeFinal.OrganizarPartidasOitavas();
		
		RandomPartida(8, false);
	
		QuartasDeFinal.organizarPartidasQuartas();
		System.out.println("====================================");
		
		RandomPartida(4, false);
		QuartasDeFinal.listarPartidasQuartas();
		System.out.println("====================================");
		SemiFinal.organizarPartidasSemi();
		
		RandomPartida(2, false);
		SemiFinal.listarPartidasSemi();
		System.out.println("====================================");
		Final.partidaGrandeFinal();
		
		RandomPartida(1, false);
		Final.partidaFinal();
		Final.campeaoDelMundo();
		System.out.println("====================================");
		for(Partida partida:SelecaoDAO.listaPartidas(Final.CampeaoMundo())) {
			System.out.println(partida);
		}
		System.out.println("====================================");
		Final.CampeaoMundo().listarJogadores();
		
		
	}

}
