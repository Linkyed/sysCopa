package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.model.Jogador;
import app.model.JogadorDAO;
import app.model.exceptions.CaracterInvalidoException;
import app.model.exceptions.ListaCheiaException;
import app.model.exceptions.ObjetoJaExisteException;
import app.model.exceptions.StringVaziaException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class CriarJogador {

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
    private Label labelPosicaoJogador;

    @FXML
    private Label labelQuantidadeJogadores;

    @FXML
    private TextField nomeJogador;

    @FXML
    private ChoiceBox<String> posicaoJogador;

    @FXML
    private ProgressBar quantidadeJogadores;

    
    @FXML
    void btnProximoAction(ActionEvent event) {
    	Jogador jogador = new Jogador(nomeJogador.getText(), CriarSelecao.selecaoAtual, posicaoJogador.getValue().toString());
    	
    	try {
    		JogadorDAO.inserir(jogador, CriarSelecao.selecaoAtual, true);
    		System.out.println("Aceito!");
    		
    		
    		Stage window = (Stage)btnProximo.getScene().getWindow();
    		window.close();
    	} catch (CaracterInvalidoException e) {
			System.out.println(e.getMessage());
			errorShow.setText(e.getMessage());
		} catch (ObjetoJaExisteException e) {
			System.out.println(e.getMessage());
			errorShow.setText(e.getMessage());
		} catch (ListaCheiaException e) {
			System.out.println(e.getMessage());
			errorShow.setText(e.getMessage());
		} catch (StringVaziaException e) {
			System.out.println(e.getMessage());
			errorShow.setText(e.getMessage());
		}
    	JogadorDAO.listar();
    }

    @FXML
    void enterPressionado(KeyEvent event) {
    	if (event.getCode().toString().equals("ENTER")) {
    		btnProximoAction(new ActionEvent());
    	}
    }

    @FXML
    void initialize() {
        assert btnProximo != null : "fx:id=\"btnProximo\" was not injected: check your FXML file 'CriarJogador.fxml'.";
        assert errorShow != null : "fx:id=\"errorShow\" was not injected: check your FXML file 'CriarJogador.fxml'.";
        assert nomeJogador != null : "fx:id=\"nomeTecnico\" was not injected: check your FXML file 'CriarJogador.fxml'.";
        assert posicaoJogador != null : "fx:id=\"posicaoJogador\" was not injected: check your FXML file 'CriarJogador.fxml'.";

        posicaoJogador.getItems().addAll("Goleiro", "Lateral direito", "Lateral esquerdo", "Zagueiro",
    			"Volante", "Meia Atacante" );
        posicaoJogador.setValue("Goleiro");
        quantidadeJogadores.setProgress((1/11.0)*CriarSelecao.quantidadeJoadores);
        labelNomeJogador.setText(labelNomeJogador.getText().formatted(CriarSelecao.quantidadeJoadores+1));
        labelPosicaoJogador.setText(labelPosicaoJogador.getText().formatted(CriarSelecao.quantidadeJoadores+1));
        labelQuantidadeJogadores.setText(labelQuantidadeJogadores.getText().formatted(11-CriarSelecao.quantidadeJoadores));
        
    }

}