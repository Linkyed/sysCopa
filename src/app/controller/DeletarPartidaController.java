package app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.model.Partida;
import app.model.PartidaDAO;
import app.model.Selecao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DeletarPartidaController extends JanelaJAVAFX {

	@FXML
	private Button btnDeletar;

	@FXML
	private ComboBox<Partida> comboBoxPartida;

	void atualizarCombo() {
		List<Partida> listaSelecaos = new ArrayList<>();
		if (PartidaDAO.quantidaPartidas() == 48) {
			listaSelecaos = PartidaDAO.listaPartidasRealizadas(1);
		} else if (PartidaDAO.quantidaPartidas() == 56) {
			listaSelecaos = PartidaDAO.listaPartidasRealizadas(2);
		}else if (PartidaDAO.quantidaPartidas() == 60) {
			listaSelecaos = PartidaDAO.listaPartidasRealizadas(3);
		}else if (PartidaDAO.quantidaPartidas() == 62) {
			listaSelecaos = PartidaDAO.listaPartidasRealizadas(4);
		}else if (PartidaDAO.quantidaPartidas() == 63) {
			listaSelecaos = PartidaDAO.listaPartidasRealizadas(5);
		}
		ObservableList<Partida> partidas = FXCollections.observableArrayList(listaSelecaos);
		comboBoxPartida.setItems(partidas);

	}

	public void salvarGanhador() throws IOException {
		PartidaDAO.excluir(comboBoxPartida.getValue());
		Stage window = (Stage) btnDeletar.getScene().getWindow();
		if (PartidaDAO.quantidaPartidas() == 48) {
			trocarJanela("/app/viewFasedeGrupos/FaseDeGrupos.fxml", 800, 500, window);
		}else if (PartidaDAO.quantidaPartidas() == 56) {
			trocarJanela("/app/viewFasedeGrupos/OitavasDeFinal.fxml", 800, 600, window);
		}else if (PartidaDAO.quantidaPartidas() == 60) {
			trocarJanela("/app/viewFasedeGrupos/QuartasDeFinal.fxml", 800, 600, window);
		}else if (PartidaDAO.quantidaPartidas() == 62) {
			trocarJanela("/app/viewFasedeGrupos/SemiFinal.fxml", 800, 600, window);
		}else {
			trocarJanela("/app/viewFasedeGrupos/Terceiro_E_Final.fxml", 800, 600, window);
		}

	}

	public void verificarCombo(MouseEvent event) {
		if (comboBoxPartida.getValue() == null) {
			btnDeletar.setDisable(true);
		} else {
			btnDeletar.setDisable(false);
		}
	}

	@FXML
	void initialize() {
		atualizarCombo();
		btnDeletar.setDisable(true);
	}

}
