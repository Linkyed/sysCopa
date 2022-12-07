package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.model.Jogador;
import app.model.JogadorDAO;
import app.model.Selecao;
import app.model.SelecaoDAO;
import app.model.exceptions.CaracterInvalidoException;
import app.model.exceptions.ListaCheiaException;
import app.model.exceptions.ObjetoJaExisteException;
import app.model.exceptions.ObjetoNaoExisteException;
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
    /**Ação do botão de proximo onde com base no que foi digitado pelo usuario, o DAO do jogador ira fazer suas devidas verificações
     * e caso seja aceito o jogador sera criado, caso não sejá aceita o erro encontrado será reportado para o usuario para que ele
     * possa concertar**/
    void btnProximoAction(ActionEvent event) {
    	Selecao selecao = null;
    	try {
    		if (CriarSelecao.selecaoAtual != null) {
    			selecao = CriarSelecao.selecaoAtual;
    		} else {
    			selecao = SelecaoDAO.getSelecaoPorSelecao(new Selecao(InsercaoSelecao.selecaoComboBox));	
    		}
    		Jogador jogador = new Jogador(nomeJogador.getText().strip(), selecao, posicaoJogador.getValue().toString());
    		JogadorDAO.inserir(jogador, selecao, true);
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
		} catch (ObjetoNaoExisteException e) {
			errorShow.setText("A seleção nao existe!");
		}
    }

    @FXML
    /**Atalho ENTER para que não seja necessario o click no botão de proximo**/
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

        //Atualização da interface para caso a seleção precise dos 11 jogadores ou precise apenas de um jogador que ocorre nos casos de exclusão
        if (CriarSelecao.selecaoAtual != null) {
        	quantidadeJogadores.setProgress((1/11.0)*CriarSelecao.quantidadeJoadores);
        	labelQuantidadeJogadores.setText(labelQuantidadeJogadores.getText().formatted(11-CriarSelecao.quantidadeJoadores));
        } else {
        	labelQuantidadeJogadores.setText(labelQuantidadeJogadores.getText().formatted(1));
        	quantidadeJogadores.setProgress(0.90);
        }
        
        //Adicionando as possiveis posições que o jogador pode ter
        posicaoJogador.getItems().addAll("Goleiro", "Lateral direito", "Lateral esquerdo", "Zagueiro",
    			"Volante", "Meia Atacante" );
        posicaoJogador.setValue("Goleiro");
        labelNomeJogador.setText(labelNomeJogador.getText().formatted(CriarSelecao.quantidadeJoadores+1));
        labelPosicaoJogador.setText(labelPosicaoJogador.getText().formatted(CriarSelecao.quantidadeJoadores+1));
        
    }

}
