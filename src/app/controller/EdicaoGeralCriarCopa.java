package app.controller;


import java.net.URL;
import java.util.ResourceBundle;

import app.model.Jogador;
import app.model.Selecao;
import app.model.SelecaoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EdicaoGeralCriarCopa {

	private boolean objetosJaCriados= false;
	private boolean textoPosicaoCriado = false;
	
	@FXML
	private VBox VBox;
	  
	@FXML
	private GridPane gridTela;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Label labelSelecao;

    @FXML
    private ComboBox<String> cbEscolhaEdicao;
    
    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnEditar;
    
    @FXML
    void btnVoltarAction(ActionEvent event) {

    }
    
    @FXML
    void btnEditarAction(ActionEvent event) {

    }

    
    //Objetos usados na hora da escolha do que será editado
    TextField novoNome = new TextField();
    Label labelNovoNome =  new Label();
    Label labelPosicao =  new Label();
    Label labelJogador =  new Label();
    ChoiceBox<String> escolhaPosicao = new ChoiceBox<String>();
    ComboBox<String> escolhaJogador = new ComboBox<String>();
    @FXML
    void cbEscolhaEdicaoAction(ActionEvent event) {
    	Stage window = (Stage)btnVoltar.getScene().getWindow();
    	Selecao selecao = SelecaoDAO.getSelecaoPorSelecao(InsercaoSelecao.selecaoComboBox);
    	String escolha = cbEscolhaEdicao.getValue().toString();
    	if (!objetosJaCriados) {
    		for (Jogador jogador: selecao.getJogadores()) {
    			escolhaJogador.getItems().add(jogador.getNome());
    		}
    		labelPosicao.setText("Escolha a nova posição do Jogador");  	
    		escolhaPosicao.getItems().addAll("Goleiro", "Lateral direito", "Lateral esquerdo", "Zagueiro",
    					"Volante", "Meia Atacante" );
    		
    		labelJogador.setText("Escolha um dos jogadores da seleção");
    		escolhaPosicao.setMinWidth(150);
    		VBox.getChildren().add(labelNovoNome);
    		VBox.getChildren().add(novoNome);
    		novoNome.setMaxWidth(150);
    		VBox.getChildren().remove(btnVoltar);
    		VBox.getChildren().remove(btnEditar);
    		VBox.getChildren().addAll(btnEditar, btnVoltar); 
    		objetosJaCriados = true;
    	}
    	if (escolha.equals("Seleção")) {
    		if (textoPosicaoCriado == true) {
    			VBox.getChildren().remove(labelPosicao);
    			VBox.getChildren().remove(escolhaPosicao);
    			VBox.getChildren().remove(labelJogador);
    			VBox.getChildren().remove(escolhaJogador);
    			window.setHeight(250);
    			textoPosicaoCriado = false;
    		}
    		
    		labelNovoNome.setText("Digite o novo nome da Seleção");
  		} else if (escolha.equals("Tecnico")) {
  			if (textoPosicaoCriado == true) {
    			VBox.getChildren().remove(labelPosicao);
    			VBox.getChildren().remove(escolhaPosicao);
    			VBox.getChildren().remove(labelJogador);
    			VBox.getChildren().remove(escolhaJogador);
    			window.setHeight(250);
    			textoPosicaoCriado = false;
    		}
  			labelNovoNome.setText("Digite o novo nome do Tecnico");
    	} else if (escolha.equals("Jogador")) {
    		labelNovoNome.setText("Digite o novo nome do Jogador");    		
			if(!textoPosicaoCriado) {
				window.setHeight(375);
				VBox.getChildren().remove(labelNovoNome);
				VBox.getChildren().remove(novoNome);
				VBox.getChildren().remove(btnVoltar);
				VBox.getChildren().remove(btnEditar);
				
				VBox.getChildren().addAll(labelJogador, escolhaJogador, labelNovoNome, novoNome ,labelPosicao, escolhaPosicao, btnEditar, btnVoltar);
				textoPosicaoCriado = true;			    			
			}
    		
    	}
    }

    @FXML
    void initialize() {
       
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'EdicaoNaInsercao.fxml'.";
        labelSelecao.setText(labelSelecao.getText().formatted(InsercaoSelecao.selecaoComboBox.getNome()));
        cbEscolhaEdicao.getItems().addAll("Seleção", "Tecnico", "Jogador");
    }

}
