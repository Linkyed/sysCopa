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
import javafx.stage.Stage;

public class ExclusaoArbitro extends JanelaJAVAFX{

	public static boolean excluido = false;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnExcluir;

    @FXML
    private ChoiceBox<String> escolhaArbitro;

    @FXML
    private Label labelError;

    @FXML
    /**Ação do botão de excluir onde a partir do arbitro selecionado na choice box, ele será excluido e logo após um novo arbitro será
     * criado e inserido pelo usuario**/
    void btnExcluirAction(ActionEvent event) {
    	Stage window = (Stage)btnExcluir.getScene().getWindow();
    	try {
			ArbitroDAO.excluir(escolhaArbitro.getValue().toString());
			CriarArbitro.arbitrosCriados--;
			excluido = true;
			window.close();
			alertBox("Resultado", "O arbitro foi excluido com sucesso! Agora crie o novo que ira ficar no local do excluido!");
		} catch (ObjetoNaoExisteException e) {
			labelError.setText(e.getMessage());
		}
    }

    @FXML
    void initialize() {
    	
    	//Acessando todos os arbitros e colocando seus nomes na choice box para o usuario poder escolher
    	List<String> arbitrosNomes = ArbitroDAO.todosNomesArbitros();
    	for(String nome: arbitrosNomes) {
    		escolhaArbitro.getItems().add(nome);
    	}
    	escolhaArbitro.setValue(escolhaArbitro.getItems().get(0));
        assert btnExcluir != null : "fx:id=\"btnExcluir\" was not injected: check your FXML file 'ExclusaoArbitro.fxml'.";
        assert escolhaArbitro != null : "fx:id=\"escolhaArbitro\" was not injected: check your FXML file 'ExclusaoArbitro.fxml'.";
        assert labelError != null : "fx:id=\"labelError\" was not injected: check your FXML file 'ExclusaoArbitro.fxml'.";

    }

}
