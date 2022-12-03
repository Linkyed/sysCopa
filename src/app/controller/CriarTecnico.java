package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.model.Selecao;
import app.model.SelecaoDAO;
import app.model.Tecnico;
import app.model.TecnicoDAO;
import app.model.exceptions.CaracterInvalidoException;
import app.model.exceptions.ListaCheiaException;
import app.model.exceptions.ObjetoJaExisteException;
import app.model.exceptions.ObjetoNaoExisteException;
import app.model.exceptions.StringVaziaException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class CriarTecnico {

	@FXML
	private Label labelMensagem;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnProximo;

    @FXML
    private Label errorShow;

    @FXML
    private TextField nomeTecnico;

    @FXML
    void btnProximoAction(ActionEvent event) throws ObjetoNaoExisteException {
    	Selecao selecao = null;
    	if (CriarSelecao.selecaoAtual != null) {
    		selecao = CriarSelecao.selecaoAtual;
    	} else {
			selecao = SelecaoDAO.getSelecaoPorSelecao(new Selecao(InsercaoSelecao.selecaoComboBox));
    	}
    	try {
    		Tecnico tecnico = new Tecnico(nomeTecnico.getText().strip(), selecao);
    		TecnicoDAO.inserir(tecnico, selecao);
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
		} catch (StringIndexOutOfBoundsException e) {
			errorShow.setText("O Nome esta vazio!");
		}
    	TecnicoDAO.listar();
    }

    @FXML
    void enterPressionado(KeyEvent event) throws IOException, ObjetoNaoExisteException {
    	if (event.getCode().toString().equals("ENTER")) {
    		btnProximoAction(new ActionEvent());
    	}
    }
    
    @FXML
    void initialize() {
        assert btnProximo != null : "fx:id=\"btnProximo\" was not injected: check your FXML file 'CriarTecnico.fxml'.";
        assert errorShow != null : "fx:id=\"errorShow\" was not injected: check your FXML file 'CriarTecnico.fxml'.";
        assert nomeTecnico != null : "fx:id=\"nomeTecnico\" was not injected: check your FXML file 'CriarTecnico.fxml'.";

    }

}
