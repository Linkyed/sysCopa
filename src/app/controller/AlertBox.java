package app.controller;



import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
	public static void display (String titulo, String mensagem) {
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
