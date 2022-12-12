package app.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import app.model.Partida;
import app.model.PartidaDAO;
import app.model.Selecao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DesempateController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSalvar;

    @FXML
    private ComboBox<Selecao> comboBoxSele;
    
    
    /**Metodo para atualizar a combobox com as seleções que empataram**/
    void atualizarCombo() {
    	List< Selecao> listaSelecaos = new ArrayList<>();
    	Partida modelo = PartidaDAO.partidaSemRealizar();
    	
    	listaSelecaos.add(modelo.getSelecao1());
    	listaSelecaos.add(modelo.getSelecao2());
    	
    	ObservableList<Selecao> selecoes = FXCollections.observableArrayList(listaSelecaos);
    	comboBoxSele.setItems(selecoes);
    }
    
    /**Metodo para salvar o ganhador e fechar a janela atual**/
    public void salvarGanhador() {
    	Partida modelo = PartidaDAO.partidaSemRealizar();
    	PartidaDAO.DefinirGanhador(comboBoxSele.getValue(), modelo);
    	Stage window = (Stage)btnSalvar.getScene().getWindow();
    	window.close();
    	
    }
    
    /**Metodo para verificar se a combo box possui algum valor escolhido**/
    public void verificarCombo(MouseEvent event) {
    	if(comboBoxSele.getValue() == null ) {
    		btnSalvar.setDisable(true);
    	}else {
    		btnSalvar.setDisable(false);
    	}
    }
    

    @FXML
    void initialize() {
    	atualizarCombo();
    	btnSalvar.setDisable(true);
        assert btnSalvar != null : "fx:id=\"btnSalvar\" was not injected: check your FXML file 'Desempate.fxml'.";
        assert comboBoxSele != null : "fx:id=\"comboBoxSele\" was not injected: check your FXML file 'Desempate.fxml'.";

    }

}
