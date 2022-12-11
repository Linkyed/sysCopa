package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import app.model.GrupoPrimeiraFase;
import app.model.Jogador;
import app.model.Partida;
import app.model.PartidaDAO;
import app.model.Selecao;
import app.model.SelecaoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Etapa4PartidaController extends JanelaJAVAFX {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnSalvar;

	@FXML
	private ComboBox<Integer> comboSele1J1;

	@FXML
	private ComboBox<Integer> comboSele1J10;

	@FXML
	private ComboBox<Integer> comboSele1J11;

	@FXML
	private ComboBox<Integer> comboSele1J2;

	@FXML
	private ComboBox<Integer> comboSele1J3;

	@FXML
	private ComboBox<Integer> comboSele1J4;

	@FXML
	private ComboBox<Integer> comboSele1J5;

	@FXML
	private ComboBox<Integer> comboSele1J6;

	@FXML
	private ComboBox<Integer> comboSele1J7;

	@FXML
	private ComboBox<Integer> comboSele1J8;

	@FXML
	private ComboBox<Integer> comboSele1J9;

	@FXML
	private ComboBox<Integer> comboSele2J1;

	@FXML
	private ComboBox<Integer> comboSele2J10;

	@FXML
	private ComboBox<Integer> comboSele2J11;

	@FXML
	private ComboBox<Integer> comboSele2J2;

	@FXML
	private ComboBox<Integer> comboSele2J3;

	@FXML
	private ComboBox<Integer> comboSele2J4;

	@FXML
	private ComboBox<Integer> comboSele2J5;

	@FXML
	private ComboBox<Integer> comboSele2J6;

	@FXML
	private ComboBox<Integer> comboSele2J7;

	@FXML
	private ComboBox<Integer> comboSele2J8;

	@FXML
	private ComboBox<Integer> comboSele2J9;

	@FXML
	private Label partida;

	@FXML
	private Label sele1J1;

	@FXML
	private Label sele1J10;

	@FXML
	private Label sele1J11;

	@FXML
	private Label sele1J2;

	@FXML
	private Label sele1J3;

	@FXML
	private Label sele1J4;

	@FXML
	private Label sele1J5;

	@FXML
	private Label sele1J6;

	@FXML
	private Label sele1J7;

	@FXML
	private Label sele1J8;

	@FXML
	private Label sele1J9;

	@FXML
	private Label sele2J1;

	@FXML
	private Label sele2J10;

	@FXML
	private Label sele2J11;

	@FXML
	private Label sele2J2;

	@FXML
	private Label sele2J3;

	@FXML
	private Label sele2J4;

	@FXML
	private Label sele2J5;

	@FXML
	private Label sele2J6;

	@FXML
	private Label sele2J7;

	@FXML
	private Label sele2J8;

	@FXML
	private Label sele2J9;

	private List<Integer> listaCartVermelho = new ArrayList<>();

	private ObservableList<Integer> cartVermelho;

	private void atualizarCartVermelho() {

		for (int i = 0; i <= 1; i++) {
			listaCartVermelho.add(i);
		}
		cartVermelho = FXCollections.observableArrayList(listaCartVermelho);
		comboSele1J1.setItems(cartVermelho);
		comboSele1J2.setItems(cartVermelho);
		comboSele1J3.setItems(cartVermelho);
		comboSele1J4.setItems(cartVermelho);
		comboSele1J5.setItems(cartVermelho);
		comboSele1J6.setItems(cartVermelho);
		comboSele1J7.setItems(cartVermelho);
		comboSele1J8.setItems(cartVermelho);
		comboSele1J9.setItems(cartVermelho);
		comboSele1J10.setItems(cartVermelho);
		comboSele1J11.setItems(cartVermelho);

		comboSele2J1.setItems(cartVermelho);
		comboSele2J2.setItems(cartVermelho);
		comboSele2J3.setItems(cartVermelho);
		comboSele2J4.setItems(cartVermelho);
		comboSele2J5.setItems(cartVermelho);
		comboSele2J6.setItems(cartVermelho);
		comboSele2J7.setItems(cartVermelho);
		comboSele2J8.setItems(cartVermelho);
		comboSele2J9.setItems(cartVermelho);
		comboSele2J10.setItems(cartVermelho);
		comboSele2J11.setItems(cartVermelho);

		comboSele1J1.setValue(0);
		comboSele1J2.setValue(0);
		comboSele1J3.setValue(0);
		comboSele1J4.setValue(0);
		comboSele1J5.setValue(0);
		comboSele1J6.setValue(0);
		comboSele1J7.setValue(0);
		comboSele1J8.setValue(0);
		comboSele1J9.setValue(0);
		comboSele1J10.setValue(0);
		comboSele1J11.setValue(0);

		comboSele2J1.setValue(0);
		comboSele2J2.setValue(0);
		comboSele2J3.setValue(0);
		comboSele2J4.setValue(0);
		comboSele2J5.setValue(0);
		comboSele2J6.setValue(0);
		comboSele2J7.setValue(0);
		comboSele2J8.setValue(0);
		comboSele2J9.setValue(0);
		comboSele2J10.setValue(0);
		comboSele2J11.setValue(0);

	}

	public void atualizarPartida() {
		Partida modeloPartida = PartidaDAO.partidaSemRealizar();
		partida.setText("" + modeloPartida);
	}

	private void atualizarJogadores() {
		Partida modeloPartida = PartidaDAO.partidaSemRealizar();
		List<Jogador> sele1jogadores = SelecaoDAO.jogadoresSele(modeloPartida.getSelecao1());
		sele1J1.setText("" + sele1jogadores.get(0));
		sele1J2.setText("" + sele1jogadores.get(1));
		sele1J3.setText("" + sele1jogadores.get(2));
		sele1J4.setText("" + sele1jogadores.get(3));
		sele1J5.setText("" + sele1jogadores.get(4));
		sele1J6.setText("" + sele1jogadores.get(5));
		sele1J7.setText("" + sele1jogadores.get(6));
		sele1J8.setText("" + sele1jogadores.get(7));
		sele1J9.setText("" + sele1jogadores.get(8));
		sele1J10.setText("" + sele1jogadores.get(9));
		sele1J11.setText("" + sele1jogadores.get(10));

		List<Jogador> sele2jogadores = SelecaoDAO.jogadoresSele(modeloPartida.getSelecao2());
		sele2J1.setText("" + sele2jogadores.get(0));
		sele2J2.setText("" + sele2jogadores.get(1));
		sele2J3.setText("" + sele2jogadores.get(2));
		sele2J4.setText("" + sele2jogadores.get(3));
		sele2J5.setText("" + sele2jogadores.get(4));
		sele2J6.setText("" + sele2jogadores.get(5));
		sele2J7.setText("" + sele2jogadores.get(6));
		sele2J8.setText("" + sele2jogadores.get(7));
		sele2J9.setText("" + sele2jogadores.get(8));
		sele2J10.setText("" + sele2jogadores.get(9));
		sele2J11.setText("" + sele2jogadores.get(10));

	}

	private void adicionarCartVermelho() {
		List<Integer> listaSeleCartvermelho1 = new ArrayList<>();
		List<Integer> listaSeleCartvermelho2 = new ArrayList<>();

		Partida modeloPartida = PartidaDAO.partidaSemRealizar();
		List<Jogador> sele1jogadores = SelecaoDAO.jogadoresSele(modeloPartida.getSelecao1());
		List<Jogador> sele2jogadores = SelecaoDAO.jogadoresSele(modeloPartida.getSelecao2());

		Map<Jogador, Integer> jogadorECartVermelhoSele1 = new HashMap<>();
		Map<Jogador, Integer> jogadorECartVermelhoSele2 = new HashMap<>();

		listaSeleCartvermelho1.add(comboSele1J1.getValue());
		listaSeleCartvermelho1.add(comboSele1J2.getValue());
		listaSeleCartvermelho1.add(comboSele1J3.getValue());
		listaSeleCartvermelho1.add(comboSele1J4.getValue());
		listaSeleCartvermelho1.add(comboSele1J5.getValue());
		listaSeleCartvermelho1.add(comboSele1J6.getValue());
		listaSeleCartvermelho1.add(comboSele1J7.getValue());
		listaSeleCartvermelho1.add(comboSele1J8.getValue());
		listaSeleCartvermelho1.add(comboSele1J9.getValue());
		listaSeleCartvermelho1.add(comboSele1J10.getValue());
		listaSeleCartvermelho1.add(comboSele1J11.getValue());

		listaSeleCartvermelho2.add(comboSele2J1.getValue());
		listaSeleCartvermelho2.add(comboSele2J2.getValue());
		listaSeleCartvermelho2.add(comboSele2J3.getValue());
		listaSeleCartvermelho2.add(comboSele2J4.getValue());
		listaSeleCartvermelho2.add(comboSele2J5.getValue());
		listaSeleCartvermelho2.add(comboSele2J6.getValue());
		listaSeleCartvermelho2.add(comboSele2J7.getValue());
		listaSeleCartvermelho2.add(comboSele2J8.getValue());
		listaSeleCartvermelho2.add(comboSele2J9.getValue());
		listaSeleCartvermelho2.add(comboSele2J10.getValue());
		listaSeleCartvermelho2.add(comboSele2J11.getValue());

		int contador = 0;
		for (Integer integer : listaSeleCartvermelho1) {
			if (integer != 0) {
				System.out.println(sele1jogadores.get(contador) + " " + integer);
				jogadorECartVermelhoSele1.put(sele1jogadores.get(contador), integer);
			}
			contador++;
		}
		contador = 0;
		for (Integer integer : listaSeleCartvermelho2) {
			if (integer != 0) {
				System.out.println(sele2jogadores.get(contador) + " " + integer);
				jogadorECartVermelhoSele2.put(sele2jogadores.get(contador), integer);
			}
			contador++;
		}

		PartidaDAO.editarCartVermelho(modeloPartida, jogadorECartVermelhoSele1, 1);
		PartidaDAO.editarCartVermelho(modeloPartida, jogadorECartVermelhoSele2, 2);
	}

	public void btnSalvaCartVermelho() throws IOException {
		adicionarCartVermelho();
		Partida modeloPartida = PartidaDAO.partidaSemRealizar();
		
		SelecaoDAO.atualizarCriterioDesempate(modeloPartida.getSelecao1());
		SelecaoDAO.atualizarCriterioDesempate(modeloPartida.getSelecao2());
		if (modeloPartida.getFasePartida().equalsIgnoreCase("FaseDeGrupo")) {
			PartidaDAO.alteracaoDeStatusPartida(true, modeloPartida);
			GrupoPrimeiraFase.definirPontos(modeloPartida, true);
			Stage window = (Stage) btnSalvar.getScene().getWindow();
			trocarJanela("/app/viewFasedeGrupos/FaseDeGrupos.fxml", 800, 600, window);
		} else if (modeloPartida.getFasePartida().equalsIgnoreCase("Oitavas")) {
			PartidaDAO.resultadoPartida(modeloPartida);
			Stage window = (Stage) btnSalvar.getScene().getWindow();
			if (modeloPartida.getResultadoSelecao() == null) {
				abrirJanela("/app/viewFasedeGrupos/Desempate.fxml", 300, 400, true, false);
			}
			PartidaDAO.alteracaoDeStatusPartida(true, modeloPartida);
			trocarJanela("/app/viewFasedeGrupos/OitavasDeFinal.fxml", 800, 600, window);
		}else if (modeloPartida.getFasePartida().equalsIgnoreCase("Quartas")) {
			PartidaDAO.resultadoPartida(modeloPartida);
			Stage window = (Stage) btnSalvar.getScene().getWindow();
			if (modeloPartida.getResultadoSelecao() == null) {
				abrirJanela("/app/viewFasedeGrupos/Desempate.fxml", 300, 400, true, false);
			}
			PartidaDAO.alteracaoDeStatusPartida(true, modeloPartida);
			trocarJanela("/app/viewFasedeGrupos/QuartasDeFinal.fxml", 800, 600, window);
		}else if (modeloPartida.getFasePartida().equalsIgnoreCase("Semi")) {
			PartidaDAO.resultadoPartida(modeloPartida);
			Stage window = (Stage) btnSalvar.getScene().getWindow();
			if (modeloPartida.getResultadoSelecao() == null) {
				abrirJanela("/app/viewFasedeGrupos/Desempate.fxml", 300, 400, true, false);
			}
			PartidaDAO.alteracaoDeStatusPartida(true, modeloPartida);
			trocarJanela("/app/viewFasedeGrupos/SemiFinal.fxml", 800, 600, window);}
	}

	@FXML
	void initialize() {
		atualizarJogadores();
		atualizarPartida();
		atualizarCartVermelho();

		assert btnSalvar != null : "fx:id=\"btnSalvar\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert comboSele1J1 != null
				: "fx:id=\"comboSele1J1\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert comboSele1J10 != null
				: "fx:id=\"comboSele1J10\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert comboSele1J11 != null
				: "fx:id=\"comboSele1J11\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert comboSele1J2 != null
				: "fx:id=\"comboSele1J2\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert comboSele1J3 != null
				: "fx:id=\"comboSele1J3\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert comboSele1J4 != null
				: "fx:id=\"comboSele1J4\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert comboSele1J5 != null
				: "fx:id=\"comboSele1J5\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert comboSele1J6 != null
				: "fx:id=\"comboSele1J6\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert comboSele1J7 != null
				: "fx:id=\"comboSele1J7\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert comboSele1J8 != null
				: "fx:id=\"comboSele1J8\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert comboSele1J9 != null
				: "fx:id=\"comboSele1J9\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert comboSele2J1 != null
				: "fx:id=\"comboSele2J1\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert comboSele2J10 != null
				: "fx:id=\"comboSele2J10\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert comboSele2J11 != null
				: "fx:id=\"comboSele2J11\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert comboSele2J2 != null
				: "fx:id=\"comboSele2J2\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert comboSele2J3 != null
				: "fx:id=\"comboSele2J3\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert comboSele2J4 != null
				: "fx:id=\"comboSele2J4\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert comboSele2J5 != null
				: "fx:id=\"comboSele2J5\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert comboSele2J6 != null
				: "fx:id=\"comboSele2J6\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert comboSele2J7 != null
				: "fx:id=\"comboSele2J7\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert comboSele2J8 != null
				: "fx:id=\"comboSele2J8\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert comboSele2J9 != null
				: "fx:id=\"comboSele2J9\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert partida != null : "fx:id=\"partida\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert sele1J1 != null : "fx:id=\"sele1J1\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert sele1J10 != null : "fx:id=\"sele1J10\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert sele1J11 != null : "fx:id=\"sele1J11\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert sele1J2 != null : "fx:id=\"sele1J2\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert sele1J3 != null : "fx:id=\"sele1J3\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert sele1J4 != null : "fx:id=\"sele1J4\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert sele1J5 != null : "fx:id=\"sele1J5\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert sele1J6 != null : "fx:id=\"sele1J6\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert sele1J7 != null : "fx:id=\"sele1J7\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert sele1J8 != null : "fx:id=\"sele1J8\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert sele1J9 != null : "fx:id=\"sele1J9\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert sele2J1 != null : "fx:id=\"sele2J1\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert sele2J10 != null : "fx:id=\"sele2J10\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert sele2J11 != null : "fx:id=\"sele2J11\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert sele2J2 != null : "fx:id=\"sele2J2\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert sele2J3 != null : "fx:id=\"sele2J3\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert sele2J4 != null : "fx:id=\"sele2J4\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert sele2J5 != null : "fx:id=\"sele2J5\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert sele2J6 != null : "fx:id=\"sele2J6\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert sele2J7 != null : "fx:id=\"sele2J7\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert sele2J8 != null : "fx:id=\"sele2J8\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";
		assert sele2J9 != null : "fx:id=\"sele2J9\" was not injected: check your FXML file 'Etapa4Partida.fxml'.";

	}

}
