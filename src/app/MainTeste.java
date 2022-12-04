package app;

import java.net.URL;

import app.model.GrupoPrimeiraFase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTeste extends Application{
	@Override
	public void start(Stage primaryState) throws Exception {
		FXMLLoader loader = new FXMLLoader(); 
		URL xmlURL = getClass().getResource("/app/viewFasedeGrupos/fasedegrupos.fxml");
		
		loader.setLocation(xmlURL);
		
		Parent parent = loader.load();
	
		 
		Scene scene = new Scene(parent);
		primaryState.setTitle("Syscopa 3.0V");
		primaryState.setScene(scene);
		primaryState.show();
	}
	  
	
	public static void main(String[] args) {
		app.model.Teste.preDefinicao();
		GrupoPrimeiraFase.organizadorTodasPartidas();
		launch(args);
	}
}
