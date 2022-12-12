package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import app.model.OitavasDeFinal;
import app.model.Partida;
import app.model.PartidaDAO;
import app.model.QuartasDeFinal;
import app.model.Teste;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class OitavasDeFinalController extends JanelaJAVAFX {

	@FXML
	private Button btnQuartasDeFinal;

	@FXML
	private Button btnRand;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnCadastrarPartida;

	@FXML
	private Button btnVoltarMenu;

	@FXML
	private Label oitava1Sele1;

	@FXML
	private Label oitava1Sele2;

	@FXML
	private Label oitava2Sele1;

	@FXML
	private Label oitava2Sele2;

	@FXML
	private Label oitava3Sele1;

	@FXML
	private Label oitava3Sele2;

	@FXML
	private Label oitava4Sele1;

	@FXML
	private Label oitava4Sele2;

	@FXML
	private Label oitava5Sele1;

	@FXML
	private Label oitava5Sele2;

	@FXML
	private Label oitava6Sele1;

	@FXML
	private Label oitava6Sele2;

	@FXML
	private Label oitava7Sele1;

	@FXML
	private Label oitava7Sele2;

	@FXML
	private Label oitava8Sele1;

	@FXML
	private Label oitava8Sele2;
	
	@FXML
    private Button excuirPartida;

	private List<Label> listaLabels = new ArrayList<>();

	/**Ação do botão de cadastrar onde muda a tela para a criação de partida**/
	public void btnCadastrar(ActionEvent event) throws IOException {

		Stage window = (Stage) btnCadastrarPartida.getScene().getWindow();

		trocarJanela("/app/viewFasedeGrupos/Etapa1Partida.fxml", 800, 600, window);
	}

	/**Ação do botão de voltar onde muda a tela para a fase de grupos**/
	public void btnVoltarMenu(ActionEvent event) throws IOException {
		OitavasDeFinal.voltarGrupo();
		Stage window = (Stage) btnVoltarMenu.getScene().getWindow();

		trocarJanela("/app/viewFasedeGrupos/FaseDeGrupos.fxml", 800, 500, window);
	}

	/**Ação do botão de quartas de final onde muda a tela para as quartas de final**/
	public void btnQuartas(ActionEvent event) throws IOException {
		
		QuartasDeFinal.organizarPartidasQuartas();
		Stage window = (Stage) btnQuartasDeFinal.getScene().getWindow();

		trocarJanela("/app/viewFasedeGrupos/QuartasDeFinal.fxml", 800, 600, window);
	}

	/**Metodo para adicionar na lista de labels os label com as seleções**/
	void adicionar() {
		listaLabels.add(oitava1Sele1);
		listaLabels.add(oitava1Sele2);
		listaLabels.add(oitava2Sele1);
		listaLabels.add(oitava2Sele2);
		listaLabels.add(oitava3Sele1);
		listaLabels.add(oitava3Sele2);
		listaLabels.add(oitava4Sele1);
		listaLabels.add(oitava4Sele2);
		listaLabels.add(oitava5Sele1);
		listaLabels.add(oitava5Sele2);
		listaLabels.add(oitava6Sele1);
		listaLabels.add(oitava6Sele2);
		listaLabels.add(oitava7Sele1);
		listaLabels.add(oitava7Sele2);
		listaLabels.add(oitava8Sele1);
		listaLabels.add(oitava8Sele2);
	}

	/**Metodo para atualizar as partidas das oitavas de final**/
	void atualizarPartidas() {
		List<Partida> partidasOitavasList = OitavasDeFinal.listaPartidasOitavas();
		int contador = 0;
		for (Partida partida : partidasOitavasList) {
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

	/**Metodo para randomizar o resultado das partidas**/
	public void randPartidaMenuAction(ActionEvent event) {
		Teste.RandomPartida(PartidaDAO.quantidadePartidasNaoRealizada(), false);
		atualizarPartidas();
		atualizarBotoes();
		atualizarExcuir();
	}
	

	/**metodo para atualizar a disponibilidade dos botões**/
	void atualizarBotoes() {
		if(PartidaDAO.quantidadePartidasNaoRealizada() == 0) {
			btnCadastrarPartida.setDisable(true);
			btnRand.setDisable(true);
			btnQuartasDeFinal.setDisable(false);
		}else {
			btnCadastrarPartida.setDisable(false);
			btnRand.setDisable(false);
			btnQuartasDeFinal.setDisable(true);
		}
	}
	
	public void deletar() throws IOException {
		Stage window = (Stage) excuirPartida.getScene().getWindow();
		trocarJanela("/app/viewFasedeGrupos/DeletarPartida.fxml", 300, 400, window);
	}
	
	public void atualizarExcuir() {
		if(PartidaDAO.quantidadePartidasRealizada() == 48) {
			excuirPartida.setDisable(true);
		}else {
			excuirPartida.setDisable(false);
		}
	}

	@FXML
	void initialize() {
		adicionar();
		atualizarPartidas();
		atualizarBotoes();
		atualizarExcuir();
		assert btnCadastrarPartida != null
				: "fx:id=\"btnCadastrarPartida\" was not injected: check your FXML file 'OitavasDeFinal.fxml'.";
		assert btnVoltarMenu != null
				: "fx:id=\"btnVoltarMenu\" was not injected: check your FXML file 'OitavasDeFinal.fxml'.";
		assert oitava1Sele1 != null
				: "fx:id=\"oitava1Sele1\" was not injected: check your FXML file 'OitavasDeFinal.fxml'.";
		assert oitava1Sele2 != null
				: "fx:id=\"oitava1Sele2\" was not injected: check your FXML file 'OitavasDeFinal.fxml'.";
		assert oitava2Sele1 != null
				: "fx:id=\"oitava2Sele1\" was not injected: check your FXML file 'OitavasDeFinal.fxml'.";
		assert oitava2Sele2 != null
				: "fx:id=\"oitava2Sele2\" was not injected: check your FXML file 'OitavasDeFinal.fxml'.";
		assert oitava3Sele1 != null
				: "fx:id=\"oitava3Sele1\" was not injected: check your FXML file 'OitavasDeFinal.fxml'.";
		assert oitava3Sele2 != null
				: "fx:id=\"oitava3Sele2\" was not injected: check your FXML file 'OitavasDeFinal.fxml'.";
		assert oitava4Sele1 != null
				: "fx:id=\"oitava4Sele1\" was not injected: check your FXML file 'OitavasDeFinal.fxml'.";
		assert oitava4Sele2 != null
				: "fx:id=\"oitava4Sele2\" was not injected: check your FXML file 'OitavasDeFinal.fxml'.";
		assert oitava5Sele1 != null
				: "fx:id=\"oitava5Sele1\" was not injected: check your FXML file 'OitavasDeFinal.fxml'.";
		assert oitava5Sele2 != null
				: "fx:id=\"oitava5Sele2\" was not injected: check your FXML file 'OitavasDeFinal.fxml'.";
		assert oitava6Sele1 != null
				: "fx:id=\"oitava6Sele1\" was not injected: check your FXML file 'OitavasDeFinal.fxml'.";
		assert oitava6Sele2 != null
				: "fx:id=\"oitava6Sele2\" was not injected: check your FXML file 'OitavasDeFinal.fxml'.";
		assert oitava7Sele1 != null
				: "fx:id=\"oitava7Sele1\" was not injected: check your FXML file 'OitavasDeFinal.fxml'.";
		assert oitava7Sele2 != null
				: "fx:id=\"oitava7Sele2\" was not injected: check your FXML file 'OitavasDeFinal.fxml'.";
		assert oitava8Sele1 != null
				: "fx:id=\"oitava8Sele1\" was not injected: check your FXML file 'OitavasDeFinal.fxml'.";
		assert oitava8Sele2 != null
				: "fx:id=\"oitava8Sele2\" was not injected: check your FXML file 'OitavasDeFinal.fxml'.";

	}

}
