package app.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MenuPrincipalPartidas extends JanelaJAVAFX {
	
	@FXML
    private Button faseDeGrupos;
	
	/**Ação do botão de mostra classificação onde muda a tela para a fase de grupos**/
	public void bntClassificacaoMostrar(ActionEvent event) throws IOException {
	    	Stage window = (Stage)faseDeGrupos.getScene().getWindow();
	        trocarJanela("/app/viewFasedeGrupos/FaseDeGrupos.fxml", 800, 500, window);
	    }
	
	@FXML
	void initialize() {


	}
}
