package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import app.model.Final;
import app.model.Partida;
import app.model.PartidaDAO;
import app.model.SemiFinal;
import app.model.Teste;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TerceiroController extends JanelaJAVAFX {

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
	private Label ganhador;

	@FXML
	private Label sele1;

	@FXML
	private Label sele2;

	@FXML
	private Label seleTerceiroGanhador;
	

    @FXML
    private Button excuirPartida;

	private List<Label> listaLabels = new ArrayList<>();

	@FXML
	 /**A��o do bot�o de cadastrar onde muda a tela para a cria��o de partida**/
	void btnCadastrar(ActionEvent event) throws IOException {
		Stage window = (Stage) btnCadastrarPartida.getScene().getWindow();

		trocarJanela("/app/viewFasedeGrupos/Etapa1Partida.fxml", 800, 600, window);
	}

	@FXML
	/**A��o do bot�o de voltar onde muda a tela para a fase de grupos**/
	void btnVoltarMenu(ActionEvent event) throws IOException {
		Stage window = (Stage) btnVoltarMenu.getScene().getWindow();

		trocarJanela("/app/viewFasedeGrupos/SemiFinal.fxml", 800, 600, window);
	}
	
	@FXML
	/**A��o do bot�o proximo onde muda a tela para a final da copa do mundo**/
	void btnProx(ActionEvent event) throws IOException {
		Final.partidaGrandeFinal();
		Stage window = (Stage) btnProxima.getScene().getWindow();

		trocarJanela("/app/viewFasedeGrupos/Final.fxml", 800, 600, window);
	}

	@FXML
	/**Metodo para randomizar o resultado das partidas**/
	void randPartidaMenuAction(ActionEvent event) {
		Teste.RandomPartida(PartidaDAO.quantidadePartidasNaoRealizada(), false);
		atualizarPartidas();
		atualizarBotoes();
		atualizarExcuir();
	}

	public void deletar() throws IOException {
		Stage window = (Stage) excuirPartida.getScene().getWindow();
		trocarJanela("/app/viewFasedeGrupos/DeletarPartida.fxml", 300, 400, window);
	}
	
	public void atualizarExcuir() {
		if(PartidaDAO.quantidadePartidasRealizada() == 62) {
			excuirPartida.setDisable(true);
		}else {
			excuirPartida.setDisable(false);
		}
	}

	void adicionar() {
		listaLabels.add(sele1);
		listaLabels.add(sele2);

	}

	void atualizarPartidas() {

		List<Partida> partidasSemiList = new ArrayList<Partida>();
		partidasSemiList.add(Final.partidaTerceiro());
		int contador = 0;
		for (Partida partida : partidasSemiList) {
			if (partida.getStatus() == false) {
				listaLabels.get(contador).setText("" + partida.getSelecao1());
				contador++;
				listaLabels.get(contador).setText("" + partida.getSelecao2());
				contador++;
			} else {
				if (partida.getSelecao1().equals(partida.getResultadoSelecao())) {
					listaLabels.get(contador).setText("" + partida.getSelecao1());
					contador++;
					listaLabels.get(contador).setText("" + partida.getSelecao2());
					contador++;
					seleTerceiroGanhador.setText("" + partida.getResultadoSelecao());
					ganhador.setText("Ganhador!!!");
				} else {
					listaLabels.get(contador).setText("" + partida.getSelecao1());
					contador++;
					listaLabels.get(contador).setText("" + partida.getSelecao2());
					contador++;
					seleTerceiroGanhador.setText("" + partida.getResultadoSelecao());
					ganhador.setText("Ganhador!!!");
				}
			}
		}
	}
	
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
		atualizarExcuir();
		assert btnCadastrarPartida != null
				: "fx:id=\"btnCadastrarPartida\" was not injected: check your FXML file 'Teceiro_E_Final.fxml'.";
		assert btnRandown != null
				: "fx:id=\"btnRandown\" was not injected: check your FXML file 'Teceiro_E_Final.fxml'.";
		assert btnVoltarMenu != null
				: "fx:id=\"btnVoltarMenu\" was not injected: check your FXML file 'Teceiro_E_Final.fxml'.";
		assert ganhador != null : "fx:id=\"ganhador\" was not injected: check your FXML file 'Teceiro_E_Final.fxml'.";
		assert sele1 != null : "fx:id=\"sele1\" was not injected: check your FXML file 'Teceiro_E_Final.fxml'.";
		assert sele2 != null : "fx:id=\"sele2\" was not injected: check your FXML file 'Teceiro_E_Final.fxml'.";
		assert seleTerceiroGanhador != null
				: "fx:id=\"seleTerceiroGanhador\" was not injected: check your FXML file 'Teceiro_E_Final.fxml'.";

	}

}
