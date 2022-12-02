package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.model.Jogador;
import app.model.Selecao;
import app.model.SelecaoDAO;
import app.model.exceptions.ObjetoNaoExisteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExclusaoGeralCriarCopa {

	public static boolean selecaoExcluida = false;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox VBox;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnVoltar;

    @FXML
    private ComboBox<String> cbEscolhaExclusao;

    @FXML
    private GridPane gridTela;

    @FXML
    private Label labelError;

    @FXML
    private Label labelSelecao;

    ComboBox<String> escolhaJogador = new ComboBox<String>();
    private boolean objetosJogadorCriado = false;
    @FXML
    void cbEscolhaExclusaoAction(ActionEvent event) {
    	if (cbEscolhaExclusao.getValue().toString().equals("Seleção")) {
    		if (objetosJogadorCriado) {
    			VBox.getChildren().removeAll(escolhaJogador); 
    			objetosJogadorCriado = false;
    		}
    	} else if (cbEscolhaExclusao.getValue().toString().equals("Tecnico")) {
    		if (objetosJogadorCriado) {
    			VBox.getChildren().removeAll(escolhaJogador); 
    			objetosJogadorCriado = false;
    		}
    	} else if (cbEscolhaExclusao.getValue().toString().equals("Jogador")) {
    		if (!objetosJogadorCriado) {
    			VBox.getChildren().removeAll(btnExcluir, btnVoltar);    			
    			VBox.getChildren().addAll(escolhaJogador, btnExcluir, btnVoltar);
    			escolhaJogador.setValue(escolhaJogador.getItems().get(0));
    			objetosJogadorCriado = true;
    		}
    	}
    }
    
    @FXML
    void btnExcluirAction(ActionEvent event) {
    	Stage window = (Stage)btnVoltar.getScene().getWindow();
    	if (cbEscolhaExclusao.getValue().toString().equals("Seleção")) {
    		try {
    			SelecaoDAO.excluir(new Selecao(InsercaoSelecao.selecaoComboBox));
    			SelecaoDAO.listar();
    			window.close();
    			selecaoExcluida = true;
    		} catch (ObjetoNaoExisteException e) {
    			labelError.setText("Seleção não pode ser excluida");
    		}
    	} else if (cbEscolhaExclusao.getValue().toString().equals("Tecnico")) {
    		//FALTA AQUI
    	} else if (cbEscolhaExclusao.getValue().toString().equals("Jogador")) {
    		//FALTA AQUI
    	}
    	
    }

    @FXML
    void btnVoltarAction(ActionEvent event) {
    	Stage window = (Stage)btnVoltar.getScene().getWindow();
    	window.close();
    }

   

    @FXML
    void initialize() {
    	cbEscolhaExclusao.getItems().addAll("Seleção", "Tecnico", "Jogador");
    	cbEscolhaExclusao.setMinWidth(150);
    	try {
			for (Jogador jogador: SelecaoDAO.getSelecaoPorSelecao(new Selecao(InsercaoSelecao.selecaoComboBox)).getJogadores()) {
				escolhaJogador.getItems().add(jogador.getNome());
			}
		} catch (ObjetoNaoExisteException e) {
			// TODO Auto-generated catch block
			labelError.setText("Seleção não encontrada!");
		}
    	
        assert VBox != null : "fx:id=\"VBox\" was not injected: check your FXML file 'ExclusaoGeral.fxml'.";
        assert btnExcluir != null : "fx:id=\"btnExcluir\" was not injected: check your FXML file 'ExclusaoGeral.fxml'.";
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'ExclusaoGeral.fxml'.";
        assert cbEscolhaExclusao != null : "fx:id=\"cbEscolhaExclusao\" was not injected: check your FXML file 'ExclusaoGeral.fxml'.";
        assert gridTela != null : "fx:id=\"gridTela\" was not injected: check your FXML file 'ExclusaoGeral.fxml'.";
        assert labelError != null : "fx:id=\"labelError\" was not injected: check your FXML file 'ExclusaoGeral.fxml'.";
        assert labelSelecao != null : "fx:id=\"labelSelecao\" was not injected: check your FXML file 'ExclusaoGeral.fxml'.";

    }

}
