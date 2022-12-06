package app.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import app.model.Arbitro;
import app.model.ArbitroDAO;
import app.model.Jogador;
import app.model.JogadorDAO;
import app.model.Selecao;
import app.model.SelecaoDAO;
import app.model.Tecnico;
import app.model.TecnicoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Listagem extends JanelaJAVAFX{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnListar;

    @FXML
    private ChoiceBox<String> escolhaListagem;

    @FXML
    void btnListarAction(ActionEvent event) {
    	Stage window = new Stage();
    	window.initModality(Modality.APPLICATION_MODAL);
    	
    	VBox layout = new VBox();
    	layout.setAlignment(Pos.CENTER);
    	
    	Label label = new Label();
    	label.setText("Esses são os(as) '%s' presentes na copa até agora".formatted(escolhaListagem.getValue().toString()));
    	
    	ListView<String> listagemView = new ListView<>();
    	layout.getChildren().addAll(label, listagemView);
    	
    	Scene scene = new Scene(layout);

    	if (escolhaListagem.getValue().toString().equals("Seleção")) {
    		List<String> lista = SelecaoDAO.selecoesExistentes();
    		
    		if (lista.size() > 0) {
    			for (String selecao: lista) {
    				listagemView.getItems().add(selecao);
    			}    			
    			window.setScene(scene);
    			window.showAndWait();
    		} else {
    			alertBox("Listagem", "Não existe nenhuma seleção registrada!");
    		}
    		  		
    	} else if (escolhaListagem.getValue().toString().equals("Tecnico")) {
    		List<String> lista = TecnicoDAO.tecnicosExistentes();
    		
    		if (lista.size() > 0) {
    			for (String tecnico: lista) {
    				listagemView.getItems().add(tecnico);
    			}    			
    			window.setScene(scene);
    			window.showAndWait();
    		} else {
    			alertBox("Listagem", "Não existe nenhum tecnico registrado!");
    		}
    		
    	} else if (escolhaListagem.getValue().toString().equals("Jogador")) {
    		List<String> lista = JogadorDAO.jogadoresExistentes();
    		
    		if (lista.size() > 0) {
    			for (String jogador: lista) {
    				listagemView.getItems().add(jogador);
    			}    			
    			window.setScene(scene);
    			window.showAndWait();
    		} else {
    			alertBox("Listagem", "Não existe nenhum jogador registrado!");
    		}
    		
    	} else if (escolhaListagem.getValue().toString().equals("Arbitro")) {
    		List<String> lista = ArbitroDAO.arbitrosExistentes();
    		
    		if (lista.size() > 0) {
    			for (String arbitro: lista) {
    				listagemView.getItems().add(arbitro);
    			}    			
    			window.setScene(scene);
    			window.showAndWait();
    		} else {
    			alertBox("Listagem", "Não existe nenhum arbitro registrado!");
    		}
    		
    	}
    }

    @FXML
    void initialize() {
    	escolhaListagem.getItems().addAll("Seleção", "Tecnico", "Jogador", "Arbitro");
    	escolhaListagem.setValue("Seleção");
    	
    	
        assert btnListar != null : "fx:id=\"btnListar\" was not injected: check your FXML file 'Listagem.fxml'.";
        assert escolhaListagem != null : "fx:id=\"escolhaListagem\" was not injected: check your FXML file 'Listagem.fxml'.";

    }

}
