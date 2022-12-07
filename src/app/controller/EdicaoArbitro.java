package app.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import app.model.Arbitro;
import app.model.ArbitroDAO;
import app.model.exceptions.CaracterInvalidoException;
import app.model.exceptions.ObjetoJaExisteException;
import app.model.exceptions.ObjetoNaoExisteException;
import app.model.exceptions.StringVaziaException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EdicaoArbitro {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEditar;


    @FXML
    private Label labelError;
    
    @FXML
    private ChoiceBox<String> escolhaArbitro;

    @FXML
    private TextField nomeArbitro;

    @FXML
    /**Ação do botão de ditar, onde com o arbitro escolhido na choicebox e o novo nome digitado pelo usuario, o arbitro escolhido será editado
     * e seu nome será alterado pelo novo que o usuario escolheu**/
    void btnEditarAction(ActionEvent event) {
    	Stage window = (Stage)btnEditar.getScene().getWindow();
    	try {
			Arbitro arbitroNomeAntigo = ArbitroDAO.getArbitroPorNome(escolhaArbitro.getValue().toString());
			String novoNome = nomeArbitro.getText().strip();
			ArbitroDAO.editar(arbitroNomeAntigo, novoNome);
			window.close();
		} catch (ObjetoNaoExisteException e) {
			labelError.setText(e.getMessage());
		} catch (ObjetoJaExisteException e) {
			labelError.setText(e.getMessage());
		} catch (StringVaziaException e) {
			labelError.setText(e.getMessage());
		} catch (CaracterInvalidoException e) {
			labelError.setText(e.getMessage());
		}
    }

    @FXML
    void initialize() {
    	//Adicionando todos os arbitros existentes na choicebox
    	List<String> arbitrosNomes = ArbitroDAO.todosNomesArbitros();
    	for(String nome: arbitrosNomes) {
    		escolhaArbitro.getItems().add(nome);
    	}
    	escolhaArbitro.setValue(escolhaArbitro.getItems().get(0));
        assert btnEditar != null : "fx:id=\"btnEditar\" was not injected: check your FXML file 'EdicaoArbitro.fxml'.";
        assert escolhaArbitro != null : "fx:id=\"escolhaArbitro\" was not injected: check your FXML file 'EdicaoArbitro.fxml'.";
        assert nomeArbitro != null : "fx:id=\"nomeArbitro\" was not injected: check your FXML file 'EdicaoArbitro.fxml'.";

    }

}
