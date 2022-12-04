package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.net.URL;

public class Main extends Application{
	
	@Override
	public void start(Stage primaryState) throws Exception {
		FXMLLoader loader = new FXMLLoader(); 
		URL xmlURL = getClass().getResource("/app/view/MenuPrincipal.fxml");
		loader.setLocation(xmlURL);	
		Parent parent = loader.load();
		Scene scene = new Scene(parent);
		primaryState.setTitle("Syscopa 3.0V");
		primaryState.setScene(scene);
		primaryState.show();
	}
	  
	
	public static void main(String[] args) {
		System.out.println("é");
		launch(args);
	}
	
}
