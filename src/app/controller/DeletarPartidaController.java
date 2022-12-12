package app.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import app.model.Partida;
import app.model.PartidaDAO;
import app.model.Selecao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DeletarPartidaController extends JanelaJAVAFX{

    @FXML
    private Button btnDeletar;

    @FXML
    private ComboBox<Partida> comboBoxPartida;
    
    /**Metodo para atualizar a combo box com as partidas**/
    void atualizarCombo() {
    	List< Partida> listaSelecaos = PartidaDAO.listaPartidasRealizadas(1);
    	
    	ObservableList<Partida> partidas = FXCollections.observableArrayList(listaSelecaos);
    	comboBoxPartida.setItems(partidas);
    	
    }
    
    /**Metodo para salvar o ganhador e trocar a janela atual pela de fase de grupos**/
    public void salvarGanhador() throws IOException {
    	PartidaDAO.excluir(comboBoxPartida.getValue());
    	Stage window = (Stage)btnDeletar.getScene().getWindow();
    	trocarJanela("/app/viewFasedeGrupos/FaseDeGrupos.fxml", 800, 500, window);
    	
    }
    
    /**Metodo para verificar se a combo box possui algum valor escolhido**/
    public void verificarCombo(MouseEvent event) {
    	if(comboBoxPartida.getValue() == null ) {
    		btnDeletar.setDisable(true);
    	}else {
    		btnDeletar.setDisable(false);
    	}
    }
    

    @FXML
    void initialize() {
    	atualizarCombo();
    	btnDeletar.setDisable(true);}
    


}
