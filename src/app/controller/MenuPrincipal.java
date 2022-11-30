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

public class MenuPrincipal {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCriarCopa;

    @FXML
    void btnCriarCopaAction(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
		URL xmlURL = getClass().getResource("/app/view/InsercaoSelecao.fxml");
		
		loader.setLocation(xmlURL);
		
		Parent root = loader.load();
		
		Stage window = (Stage)btnCriarCopa.getScene().getWindow();
		window.setScene(new Scene(root, 700, 500));
    }

    @FXML
    void initialize() {
        assert btnCriarCopa != null : "fx:id=\"btnCriarCopa\" was not injected: check your FXML file 'MenuPrincipal.fxml'.";

    }

}
