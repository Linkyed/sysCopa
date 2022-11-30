package app.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class EdicaoNaInsercao {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Label labelSelecao;

    @FXML
    private Button btnEditarJogador;

    @FXML
    private Button btnEditarSelecao;

    @FXML
    private Button btnEditarTecnico;

    @FXML
    private Button btnVoltar;

    @FXML
    void btnEditarJogadorAction(ActionEvent event) {
    	
    }

    @FXML
    void btnEditarSelecaoAction(ActionEvent event) {
    	
    }

    @FXML
    void btnEditarTecnicoAction(ActionEvent event) {

    }

    @FXML
    void btnVoltarAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnEditarJogador != null : "fx:id=\"btnEditarJogador\" was not injected: check your FXML file 'EdicaoNaInsercao.fxml'.";
        assert btnEditarSelecao != null : "fx:id=\"btnEditarSelecao\" was not injected: check your FXML file 'EdicaoNaInsercao.fxml'.";
        assert btnEditarTecnico != null : "fx:id=\"btnEditarTecnico\" was not injected: check your FXML file 'EdicaoNaInsercao.fxml'.";
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'EdicaoNaInsercao.fxml'.";
        labelSelecao.setText(labelSelecao.getText().formatted(InsercaoSelecao.selecaoComboBox.getNome()));
    }

}
