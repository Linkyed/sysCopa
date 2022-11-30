package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuCriarCopa {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnInserirSelecao;

    @FXML
    private Button btnVoltarMenu;

    @FXML
    void btnInserirSelecaoAction(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
		URL xmlURL = getClass().getResource("/app/view/InsercaoSelecao.fxml");
		
		loader.setLocation(xmlURL);
		
		Parent root = loader.load();
		
		Stage window = (Stage)btnVoltarMenu.getScene().getWindow();
		window.setScene(new Scene(root, 800, 600));
    }
    
    @FXML
    void btnVoltarMenuAction(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
		URL xmlURL = getClass().getResource("/app/view/MenuPrincipal.fxml");
		
		loader.setLocation(xmlURL);
		
		Parent root = loader.load();
		
		Stage window = (Stage)btnVoltarMenu.getScene().getWindow();
		window.setScene(new Scene(root, 600, 400));
    }	
    
    @FXML
    void initialize() {
        assert btnInserirSelecao != null : "fx:id=\"btnInserirSelecao\" was not injected: check your FXML file 'MenuCriarCopa.fxml'.";
        assert btnVoltarMenu != null : "fx:id=\"btnVoltarMenu\" was not injected: check your FXML file 'MenuCriarCopa.fxml'.";

    }

}
