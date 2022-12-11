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
import app.model.SemiFinal;
import app.model.Teste;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class QuartasDeFinalController extends JanelaJAVAFX{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCadastrarPartida;
    
    @FXML
    private Button btnVoltarMenu;

    @FXML
    private Button btnRandown;
    
    @FXML
    private Button btnSemiDeFinal;

    @FXML
    private Label quarta1sele1;

    @FXML
    private Label quarta1sele2;

    @FXML
    private Label quarta2sele1;

    @FXML
    private Label quarta2sele2;

    @FXML
    private Label quarta3sele1;

    @FXML
    private Label quarta3sele2;

    @FXML
    private Label quarta4sele1;

    @FXML
    private Label quarta4sele2;
    
    private List<Label> listaLabels = new ArrayList<>();

	public void btnCadastrar(ActionEvent event) throws IOException {

		Stage window = (Stage) btnCadastrarPartida.getScene().getWindow();

		trocarJanela("/app/viewFasedeGrupos/Etapa1Partida.fxml", 800, 600, window);
	}

	public void btnVoltar(ActionEvent event) throws IOException {

		Stage window = (Stage) btnVoltarMenu.getScene().getWindow();

		trocarJanela("/app/viewFasedeGrupos/OitavasDeFinal.fxml", 800, 600, window);
	}

	public void btnSemiFinal(ActionEvent event) throws IOException {
		
		SemiFinal.organizarPartidasSemi();
		Stage window = (Stage) btnSemiDeFinal.getScene().getWindow();

		trocarJanela("/app/viewFasedeGrupos/SemiFinal.fxml", 800, 600, window);
	}

	void adicionar() {
		listaLabels.add(quarta1sele1);
		listaLabels.add(quarta1sele2);
		listaLabels.add(quarta2sele1);
		listaLabels.add(quarta2sele2);
		listaLabels.add(quarta3sele1);
		listaLabels.add(quarta3sele2);
		listaLabels.add(quarta4sele1);
		listaLabels.add(quarta4sele2);
		
	}

	void atualizarPartidas() {
		List<Partida> partidasQuartasList = QuartasDeFinal.listaQuartas();
		int contador = 0;
		for (Partida partida : partidasQuartasList) {
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

	public void randPartidaMenuAction(ActionEvent event) {
		Teste.RandomPartida(PartidaDAO.quantidadePartidasNaoRealizada(), false);
		atualizarPartidas();
		atualizarBotoes();
	}
	
	void atualizarBotoes() {
		if(PartidaDAO.quantidadePartidasNaoRealizada() == 0) {
			btnCadastrarPartida.setDisable(true);
			btnRandown.setDisable(true);
			btnSemiDeFinal.setDisable(false);
		}else {
			btnCadastrarPartida.setDisable(false);
			btnRandown.setDisable(false);
			btnSemiDeFinal.setDisable(true);
		}
	}

    @FXML
    void initialize() {
    	adicionar();
    	atualizarPartidas();
    	atualizarBotoes();
        assert btnCadastrarPartida != null : "fx:id=\"btnCadastrar\" was not injected: check your FXML file 'QuartasDeFinal.fxml'.";
        assert btnRandown != null : "fx:id=\"btnRandown\" was not injected: check your FXML file 'QuartasDeFinal.fxml'.";
        assert quarta1sele1 != null : "fx:id=\"quarta1sele1\" was not injected: check your FXML file 'QuartasDeFinal.fxml'.";
        assert quarta1sele2 != null : "fx:id=\"quarta1sele2\" was not injected: check your FXML file 'QuartasDeFinal.fxml'.";
        assert quarta2sele1 != null : "fx:id=\"quarta2sele1\" was not injected: check your FXML file 'QuartasDeFinal.fxml'.";
        assert quarta2sele2 != null : "fx:id=\"quarta2sele2\" was not injected: check your FXML file 'QuartasDeFinal.fxml'.";
        assert quarta3sele1 != null : "fx:id=\"quarta3sele1\" was not injected: check your FXML file 'QuartasDeFinal.fxml'.";
        assert quarta3sele2 != null : "fx:id=\"quarta3sele2\" was not injected: check your FXML file 'QuartasDeFinal.fxml'.";
        assert quarta4sele1 != null : "fx:id=\"quarta4sele1\" was not injected: check your FXML file 'QuartasDeFinal.fxml'.";
        assert quarta4sele2 != null : "fx:id=\"quarta4sele2\" was not injected: check your FXML file 'QuartasDeFinal.fxml'.";

    }

}
