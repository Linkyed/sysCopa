package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import app.model.Final;
import app.model.Partida;
import app.model.PartidaDAO;
import app.model.QuartasDeFinal;
import app.model.SemiFinal;
import app.model.Teste;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SemiFinalController extends JanelaJAVAFX {

	@FXML
	private Button btnProxima;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnCadastrarPartida;

	@FXML
	private Button btnRandown;

	@FXML
	private Button btnVoltarMenu;

	@FXML
	private Label semi1sele1;

	@FXML
	private Label semi1sele2;

	@FXML
	private Label semi2sele1;

	@FXML
	private Label semi2sele2;

	private List<Label> listaLabels = new ArrayList<>();

	@FXML
	 /**Ação do botão de cadastrar onde muda a tela para a criação de partida**/
	void btnCadastrar(ActionEvent event) throws IOException {
		Stage window = (Stage) btnCadastrarPartida.getScene().getWindow();

		trocarJanela("/app/viewFasedeGrupos/Etapa1Partida.fxml", 800, 600, window);
	}

	@FXML
	/**Ação do botão de voltar onde muda a tela para a fase de grupos**/
	void btnVoltarMenu(ActionEvent event) throws IOException {
		Stage window = (Stage) btnVoltarMenu.getScene().getWindow();

		trocarJanela("/app/viewFasedeGrupos/QuartasDeFinal.fxml", 800, 600, window);
	}

	@FXML
	/**Metodo para randomizar o resultado das partidas**/
	void randPartidaMenuAction(ActionEvent event) {
		Teste.RandomPartida(PartidaDAO.quantidadePartidasNaoRealizada(), false);
		atualizarPartidas();
		atualizarBotoes();
	}
	
	/**Ação d obotão de terceiro lugar onde muda a tela para a disputa de terceiro lugar da copa**/
	public void btnTerceiro(ActionEvent event) throws IOException {

		Final.partidaTerceiroLugar();
		Stage window = (Stage) btnProxima.getScene().getWindow();

		trocarJanela("/app/viewFasedeGrupos/Terceiro_E_Final.fxml", 800, 600, window);
	}

	void adicionar() {
		listaLabels.add(semi1sele1);
		listaLabels.add(semi1sele2);
		listaLabels.add(semi2sele1);
		listaLabels.add(semi2sele2);

	}

	/**Metodo para atualizar as partidas das quartas de final**/
	void atualizarPartidas() {
		List<Partida> partidasSemiList = SemiFinal.listaPartidasSeimiFinal();
		int contador = 0;
		for (Partida partida : partidasSemiList) {
			if (partida.getStatus() == false) {
				listaLabels.get(contador).setText("" + partida.getSelecao1());
				contador++;
				listaLabels.get(contador).setText("" + partida.getSelecao2());
				contador++;
			} else {
				if (partida.getSelecao1().equals(partida.getResultadoSelecao())) {
					listaLabels.get(contador).setText("" + partida.getSelecao1() + " - Ganhador!");
					contador++;
					listaLabels.get(contador).setText("" + partida.getSelecao2());
					contador++;
				} else {
					listaLabels.get(contador).setText("" + partida.getSelecao1());
					contador++;
					listaLabels.get(contador).setText("" + partida.getSelecao2() + " - Ganhador!");
					contador++;
				}
			}
		}
	}
	
	/**metodo para atualizar a disponibilidade dos botões**/
	void atualizarBotoes() {
		if(PartidaDAO.quantidadePartidasNaoRealizada() == 0) {
			btnCadastrarPartida.setDisable(true);
			btnRandown.setDisable(true);
			btnProxima.setDisable(false);
		}else {
			btnCadastrarPartida.setDisable(false);
			btnRandown.setDisable(false);
			btnProxima.setDisable(true);
		}
	}

	@FXML
	void initialize() {
		adicionar();
		atualizarPartidas();
		atualizarBotoes();
		assert btnCadastrarPartida != null
				: "fx:id=\"btnCadastrarPartida\" was not injected: check your FXML file 'SemiFinal.fxml'.";
		assert btnRandown != null : "fx:id=\"btnRandown\" was not injected: check your FXML file 'SemiFinal.fxml'.";
		assert btnVoltarMenu != null
				: "fx:id=\"btnVoltarMenu\" was not injected: check your FXML file 'SemiFinal.fxml'.";
		assert semi1sele1 != null : "fx:id=\"semi1sele1\" was not injected: check your FXML file 'SemiFinal.fxml'.";
		assert semi1sele2 != null : "fx:id=\"semi1sele2\" was not injected: check your FXML file 'SemiFinal.fxml'.";
		assert semi2sele1 != null : "fx:id=\"semi2sele1\" was not injected: check your FXML file 'SemiFinal.fxml'.";
		assert semi2sele2 != null : "fx:id=\"semi2sele2\" was not injected: check your FXML file 'SemiFinal.fxml'.";

	}

}
