package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.model.Final;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GanhadorFinalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label campeao;
    
    void atualizarCampeao() {
    	campeao.setText(Final.CampeaoMundo()+"");
    }

    @FXML
    void initialize() {
    	atualizarCampeao();
        assert campeao != null : "fx:id=\"campeao\" was not injected: check your FXML file 'GanhadorFinal.fxml'.";

    }

}
