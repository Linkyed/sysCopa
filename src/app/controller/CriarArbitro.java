package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.model.Arbitro;
import app.model.ArbitroDAO;
import app.model.exceptions.CaracterInvalidoException;
import app.model.exceptions.ObjetoJaExisteException;
import app.model.exceptions.StringVaziaException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class CriarArbitro extends JanelaJAVAFX{

	public static boolean continuar = true;
	public static int arbitrosCriados = 0;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnProximo;

    @FXML
    private Label errorShow;

    @FXML
    private Label labelNomeJogador;

    @FXML
    private Label labelQuantidadeArbitros;

    @FXML
    private TextField nomeArbitro;

    @FXML
    private ProgressBar quantidadeArbitros;

    @FXML
    void btnProximoAction(ActionEvent event) {
    	String nome = nomeArbitro.getText();
    	try {
    		ArbitroDAO.inserir(new Arbitro(nome));
    		Stage window = (Stage)btnProximo.getScene().getWindow();
    		arbitrosCriados++;
    		window.close();
    	} catch (ObjetoJaExisteException e) {
    		errorShow.setText(e.getMessage());
    	} catch (StringVaziaException e) {
    		errorShow.setText(e.getMessage());
    	} catch (CaracterInvalidoException e) {
    		errorShow.setText(e.getMessage());
    	}
    }

    @FXML
    void enterPressionado(KeyEvent event) {
    	if (event.getCode().toString().equals("ENTER")) {
    		btnProximoAction(new ActionEvent());
    	}
    }
   
    @FXML
    void initialize() {
    	
    	atualizarObejtos();
    	
        assert btnProximo != null : "fx:id=\"btnProximo\" was not injected: check your FXML file 'CriarArbitro.fxml'.";
        assert errorShow != null : "fx:id=\"errorShow\" was not injected: check your FXML file 'CriarArbitro.fxml'.";
        assert labelNomeJogador != null : "fx:id=\"labelNomeJogador\" was not injected: check your FXML file 'CriarArbitro.fxml'.";
        assert labelQuantidadeArbitros != null : "fx:id=\"labelQuantidadeArbitros\" was not injected: check your FXML file 'CriarArbitro.fxml'.";
        assert nomeArbitro != null : "fx:id=\"nomeArbitro\" was not injected: check your FXML file 'CriarArbitro.fxml'.";
        assert quantidadeArbitros != null : "fx:id=\"quantidadeArbitros\" was not injected: check your FXML file 'CriarArbitro.fxml'.";

    }

    void atualizarObejtos() {
    	labelQuantidadeArbitros.setText(labelQuantidadeArbitros.getText().formatted(20-arbitrosCriados));
    	quantidadeArbitros.setProgress((1/20.0)*arbitrosCriados);
    }
    
    
}
