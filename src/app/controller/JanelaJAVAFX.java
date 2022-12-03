package app.controller;

import java.io.IOException;
import java.net.URL;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public abstract class JanelaJAVAFX {

	void abrirJanela(String diretorioFXML, double largura, double altura, boolean travarJanelaPrincipal, boolean podeFechar) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		URL xmlURL = getClass().getResource(diretorioFXML);
		loader.setLocation(xmlURL);
		Parent root = loader.load();
		Stage window = new Stage();
		window.resizableProperty().setValue(false);
		window.setScene(new Scene(root, largura, altura));
		if (travarJanelaPrincipal) {
			window.initModality(Modality.APPLICATION_MODAL);
			if (!podeFechar) {
				impedirFechamento(window, "ERROR", "Termine a inserção para sair desta tela!");				
			}
			window.showAndWait();
		} else {
			if (!podeFechar) {
				impedirFechamento(window, "ERROR", "Termine a inserção para sair desta tela!");	
			}
			window.show();
		}
	}
	
	void trocarJanela(String diretorioFXML, double largura, double altura, Stage janelaAntiga) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		URL xmlURL = getClass().getResource(diretorioFXML);
		loader.setLocation(xmlURL);
		Parent root = loader.load();
		Stage window = janelaAntiga;
		window.setScene(new Scene(root, largura, altura));
	}
	
	private void impedirFechamento(Stage window, String titulo, String mensagem) {
	   	 window.setOnCloseRequest(new EventHandler<WindowEvent>() {
		        	@Override
		        	public void handle(WindowEvent event) {
		        		JanelaJAVAFX.alertBox(titulo, mensagem);
		        		event.consume();
		        	}
		        });
	   }
	
	public static void alertBox (String titulo, String mensagem) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(titulo);
		window.setMinWidth(250);
		window.setMinHeight(100);
		
		Label label = new Label();
		label.setText(mensagem);
		label.setFont(Font.font("System", FontWeight.BOLD, 12));
		if (mensagem.length() > 30) {
			label.setMinWidth(200);
			label.setMaxWidth(200);
			label.setPrefWidth(200);
			label.setTextAlignment(TextAlignment.CENTER);			
		}
		label.setWrapText(true);
		Button btnCloseAlertBox = new Button("Fechar alerta");
		btnCloseAlertBox.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, btnCloseAlertBox);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
	}
	
}
