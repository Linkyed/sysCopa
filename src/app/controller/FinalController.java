package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import app.model.Final;
import app.model.Partida;
import app.model.PartidaDAO;
import app.model.Teste;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FinalController extends JanelaJAVAFX{

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
    private Label sele1;

    @FXML
    private Label sele2;
    
    private List<Label> listaLabels = new ArrayList<>();

    @FXML
    /**A��o do bot�o cadastrar onde muda a tela para a primeira etapa da cria��o de partida**/
	void btnCadastrar(ActionEvent event) throws IOException {
		Stage window = (Stage) btnCadastrarPartida.getScene().getWindow();

		trocarJanela("/app/viewFasedeGrupos/Etapa1Partida.fxml", 800, 600, window);
	}

	@FXML
	/**A��o do bot�o de voltar onde volta para o terceiro menu**/
	void btnVoltarMenu(ActionEvent event) throws IOException {
		Stage window = (Stage) btnVoltarMenu.getScene().getWindow();

		trocarJanela("/app/viewFasedeGrupos/Terceiro_E_Final.fxml", 800, 600, window);
	}

	@FXML
	/**A��o do bot�o para randomizar o resultado da partida**/
	void randPartidaMenuAction(ActionEvent event) throws IOException {
		Teste.RandomPartida(PartidaDAO.quantidadePartidasNaoRealizada(), false);
		atualizarPartidas();
		Stage window = (Stage) btnRandown.getScene().getWindow();
		trocarJanela("/app/viewFasedeGrupos/GanhadorFinal.fxml", 800, 600, window);
	}

	
	void adicionar() {
		listaLabels.add(sele1);
		listaLabels.add(sele2);

	}

	/**metodo para atualizar as partidas**/
	void atualizarPartidas() {

		List<Partida> partidasSemiList = new ArrayList<Partida>();
		partidasSemiList.add(Final.partidaFinal());
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
				} else {
					listaLabels.get(contador).setText("" + partida.getSelecao1());
					contador++;
					listaLabels.get(contador).setText("" + partida.getSelecao2());
					contador++;

				}
			}
		}
	}

    @FXML
    void initialize() {
    	adicionar();
    	atualizarPartidas();
        assert btnCadastrarPartida != null : "fx:id=\"btnCadastrarPartida\" was not injected: check your FXML file 'Final.fxml'.";
        assert btnRandown != null : "fx:id=\"btnRandown\" was not injected: check your FXML file 'Final.fxml'.";
        assert btnVoltarMenu != null : "fx:id=\"btnVoltarMenu\" was not injected: check your FXML file 'Final.fxml'.";
        assert sele1 != null : "fx:id=\"sele1\" was not injected: check your FXML file 'Final.fxml'.";
        assert sele2 != null : "fx:id=\"sele2\" was not injected: check your FXML file 'Final.fxml'.";

    }

}
