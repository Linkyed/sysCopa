package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import app.model.GrupoPrimeiraFase;
import app.model.Jogador;
import app.model.Partida;
import app.model.PartidaDAO;
import app.model.SelecaoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Etapa2PartidaController extends JanelaJAVAFX {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSalvar;

    @FXML
    private ComboBox<Integer> comboSele1J1;

    @FXML
    private ComboBox<Integer> comboSele1J10;

    @FXML
    private ComboBox<Integer> comboSele1J11;

    @FXML
    private ComboBox<Integer> comboSele1J2;

    @FXML
    private ComboBox<Integer> comboSele1J3;

    @FXML
    private ComboBox<Integer> comboSele1J4;

    @FXML
    private ComboBox<Integer> comboSele1J5;

    @FXML
    private ComboBox<Integer> comboSele1J6;

    @FXML
    private ComboBox<Integer> comboSele1J7;

    @FXML
    private ComboBox<Integer> comboSele1J8;

    @FXML
    private ComboBox<Integer> comboSele1J9;

    @FXML
    private ComboBox<Integer> comboSele2J1;

    @FXML
    private ComboBox<Integer> comboSele2J10;

    @FXML
    private ComboBox<Integer> comboSele2J11;

    @FXML
    private ComboBox<Integer> comboSele2J2;

    @FXML
    private ComboBox<Integer> comboSele2J3;

    @FXML
    private ComboBox<Integer> comboSele2J4;

    @FXML
    private ComboBox<Integer> comboSele2J5;

    @FXML
    private ComboBox<Integer> comboSele2J6;

    @FXML
    private ComboBox<Integer> comboSele2J7;

    @FXML
    private ComboBox<Integer> comboSele2J8;

    @FXML
    private ComboBox<Integer> comboSele2J9;

    @FXML
    private Label partida;

    @FXML
    private Label sele1J1;

    @FXML
    private Label sele1J10;

    @FXML
    private Label sele1J11;

    @FXML
    private Label sele1J2;

    @FXML
    private Label sele1J3;

    @FXML
    private Label sele1J4;

    @FXML
    private Label sele1J5;

    @FXML
    private Label sele1J6;

    @FXML
    private Label sele1J7;

    @FXML
    private Label sele1J8;

    @FXML
    private Label sele1J9;

    @FXML
    private Label sele2J1;

    @FXML
    private Label sele2J10;

    @FXML
    private Label sele2J11;

    @FXML
    private Label sele2J2;

    @FXML
    private Label sele2J3;

    @FXML
    private Label sele2J4;

    @FXML
    private Label sele2J5;

    @FXML
    private Label sele2J6;

    @FXML
    private Label sele2J7;

    @FXML
    private Label sele2J8;

    @FXML
    private Label sele2J9;
    


    private List<Integer> listaGols = new ArrayList<>();
    
    private ObservableList<Integer> gols;
    
    private void atualizarGols() {
    	for(int i = 0; i <= 10;i++) {
    		listaGols.add(i);
    	}
    	gols = FXCollections.observableArrayList(listaGols);
    	comboSele1J1.setItems(gols);
    	comboSele1J2.setItems(gols);
    	comboSele1J3.setItems(gols);
    	comboSele1J4.setItems(gols);
    	comboSele1J5.setItems(gols);
    	comboSele1J6.setItems(gols);
    	comboSele1J7.setItems(gols);
    	comboSele1J8.setItems(gols);
    	comboSele1J9.setItems(gols);
    	comboSele1J10.setItems(gols);
    	comboSele1J11.setItems(gols);
    	
    	comboSele2J1.setItems(gols);
    	comboSele2J2.setItems(gols);
    	comboSele2J3.setItems(gols);
    	comboSele2J4.setItems(gols);
    	comboSele2J5.setItems(gols);
    	comboSele2J6.setItems(gols);
    	comboSele2J7.setItems(gols);
    	comboSele2J8.setItems(gols);
    	comboSele2J9.setItems(gols);
    	comboSele2J10.setItems(gols);
    	comboSele2J11.setItems(gols);
    	
    	comboSele1J1.setValue(0);
    	comboSele1J2.setValue(0);
    	comboSele1J3.setValue(0);
    	comboSele1J4.setValue(0);
    	comboSele1J5.setValue(0);
    	comboSele1J6.setValue(0);
    	comboSele1J7.setValue(0);
    	comboSele1J8.setValue(0);
    	comboSele1J9.setValue(0);
    	comboSele1J10.setValue(0);
    	comboSele1J11.setValue(0);
    	
    	comboSele2J1.setValue(0);
    	comboSele2J2.setValue(0);
    	comboSele2J3.setValue(0);
    	comboSele2J4.setValue(0);
    	comboSele2J5.setValue(0);
    	comboSele2J6.setValue(0);
    	comboSele2J7.setValue(0);
    	comboSele2J8.setValue(0);
    	comboSele2J9.setValue(0);
    	comboSele2J10.setValue(0);
    	comboSele2J11.setValue(0);
    	

    }
    
    public void atualizarPartida() {
    	Partida modeloPartida = PartidaDAO.partidaSemRealizar();
    	partida.setText(""+modeloPartida);
    }
    
    private void atualizarJogadores() {
    	Partida modeloPartida = PartidaDAO.partidaSemRealizar();
    	List<Jogador> sele1jogadores = SelecaoDAO.jogadoresSele(modeloPartida.getSelecao1());
    	sele1J1.setText(""+sele1jogadores.get(0));
    	sele1J2.setText(""+sele1jogadores.get(1));
    	sele1J3.setText(""+sele1jogadores.get(2));
    	sele1J4.setText(""+sele1jogadores.get(3));
    	sele1J5.setText(""+sele1jogadores.get(4));
    	sele1J6.setText(""+sele1jogadores.get(5));
    	sele1J7.setText(""+sele1jogadores.get(6));
    	sele1J8.setText(""+sele1jogadores.get(7));
    	sele1J9.setText(""+sele1jogadores.get(8));
    	sele1J10.setText(""+sele1jogadores.get(9));
    	sele1J11.setText(""+sele1jogadores.get(10));
    	
    	List<Jogador> sele2jogadores = SelecaoDAO.jogadoresSele(modeloPartida.getSelecao2());
    	sele2J1.setText(""+sele2jogadores.get(0));
    	sele2J2.setText(""+sele2jogadores.get(1));
    	sele2J3.setText(""+sele2jogadores.get(2));
    	sele2J4.setText(""+sele2jogadores.get(3));
    	sele2J5.setText(""+sele2jogadores.get(4));
    	sele2J6.setText(""+sele2jogadores.get(5));
    	sele2J7.setText(""+sele2jogadores.get(6));
    	sele2J8.setText(""+sele2jogadores.get(7));
    	sele2J9.setText(""+sele2jogadores.get(8));
    	sele2J10.setText(""+sele2jogadores.get(9));
    	sele2J11.setText(""+sele2jogadores.get(10));
    	
    }
    
    private void adicionarGols() {
        List<Integer> listaSeleGol1 = new ArrayList<>(); 
        List<Integer> listaSeleGol2 = new ArrayList<>(); 
        
        Partida modeloPartida = PartidaDAO.partidaSemRealizar();
    	List<Jogador> sele1jogadores = SelecaoDAO.jogadoresSele(modeloPartida.getSelecao1());
    	List<Jogador> sele2jogadores = SelecaoDAO.jogadoresSele(modeloPartida.getSelecao2());
    	
    	Map<Jogador, Integer> jogadorEgolSele1 = new HashMap<>();
    	Map<Jogador, Integer> jogadorEgolSele2 = new HashMap<>();
    	
		listaSeleGol1.add(comboSele1J1.getValue());
		listaSeleGol1.add(comboSele1J2.getValue());
		listaSeleGol1.add(comboSele1J3.getValue());
		listaSeleGol1.add(comboSele1J4.getValue());
		listaSeleGol1.add(comboSele1J5.getValue());
		listaSeleGol1.add(comboSele1J6.getValue());
		listaSeleGol1.add(comboSele1J7.getValue());
		listaSeleGol1.add(comboSele1J8.getValue());
		listaSeleGol1.add(comboSele1J9.getValue());
		listaSeleGol1.add(comboSele1J10.getValue());
		listaSeleGol1.add(comboSele1J11.getValue());
		
		listaSeleGol2.add(comboSele2J1.getValue());
		listaSeleGol2.add(comboSele2J2.getValue());
		listaSeleGol2.add(comboSele2J3.getValue());
		listaSeleGol2.add(comboSele2J4.getValue());
		listaSeleGol2.add(comboSele2J5.getValue());
		listaSeleGol2.add(comboSele2J6.getValue());
		listaSeleGol2.add(comboSele2J7.getValue());
		listaSeleGol2.add(comboSele2J8.getValue());
		listaSeleGol2.add(comboSele2J9.getValue());
		listaSeleGol2.add(comboSele2J10.getValue());
		listaSeleGol2.add(comboSele2J11.getValue());
		
		int contador = 0;
		for (Integer integer : listaSeleGol1) {
			if(integer != 0) {
				System.out.println(sele1jogadores.get(contador)+" "+integer);
				jogadorEgolSele1.put(sele1jogadores.get(contador), integer);
			}
			contador++;
		}
		contador = 0;
		for (Integer integer : listaSeleGol2) {
			if(integer != 0) {
				System.out.println(sele2jogadores.get(contador)+" "+integer);
				jogadorEgolSele2.put(sele2jogadores.get(contador), integer);
			}
			contador++;
		}
		PartidaDAO.editarGol(modeloPartida, jogadorEgolSele1, 1);
		PartidaDAO.editarGol(modeloPartida, jogadorEgolSele2, 2);
		

	}
    
    public void btnSalvaGol() throws IOException {
		adicionarGols();
		Stage window = (Stage)btnSalvar.getScene().getWindow();
        trocarJanela("/app/viewFasedeGrupos/Etapa3Partida.fxml", 800, 500, window);
	}
    

    @FXML
    void initialize() {
    	
    	atualizarGols();
    	atualizarJogadores();
    	atualizarPartida();
        assert btnSalvar != null : "fx:id=\"btnSalvar\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert comboSele1J1 != null : "fx:id=\"comboSele1J1\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert comboSele1J10 != null : "fx:id=\"comboSele1J10\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert comboSele1J11 != null : "fx:id=\"comboSele1J11\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert comboSele1J2 != null : "fx:id=\"comboSele1J2\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert comboSele1J3 != null : "fx:id=\"comboSele1J3\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert comboSele1J4 != null : "fx:id=\"comboSele1J4\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert comboSele1J5 != null : "fx:id=\"comboSele1J5\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert comboSele1J6 != null : "fx:id=\"comboSele1J6\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert comboSele1J7 != null : "fx:id=\"comboSele1J7\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert comboSele1J8 != null : "fx:id=\"comboSele1J8\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert comboSele1J9 != null : "fx:id=\"comboSele1J9\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert comboSele2J1 != null : "fx:id=\"comboSele2J1\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert comboSele2J10 != null : "fx:id=\"comboSele2J10\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert comboSele2J11 != null : "fx:id=\"comboSele2J11\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert comboSele2J2 != null : "fx:id=\"comboSele2J2\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert comboSele2J3 != null : "fx:id=\"comboSele2J3\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert comboSele2J4 != null : "fx:id=\"comboSele2J4\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert comboSele2J5 != null : "fx:id=\"comboSele2J5\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert comboSele2J6 != null : "fx:id=\"comboSele2J6\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert comboSele2J7 != null : "fx:id=\"comboSele2J7\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert comboSele2J8 != null : "fx:id=\"comboSele2J8\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert comboSele2J9 != null : "fx:id=\"comboSele2J9\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert partida != null : "fx:id=\"partida\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert sele1J1 != null : "fx:id=\"sele1J1\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert sele1J10 != null : "fx:id=\"sele1J10\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert sele1J11 != null : "fx:id=\"sele1J11\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert sele1J2 != null : "fx:id=\"sele1J2\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert sele1J3 != null : "fx:id=\"sele1J3\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert sele1J4 != null : "fx:id=\"sele1J4\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert sele1J5 != null : "fx:id=\"sele1J5\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert sele1J6 != null : "fx:id=\"sele1J6\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert sele1J7 != null : "fx:id=\"sele1J7\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert sele1J8 != null : "fx:id=\"sele1J8\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert sele1J9 != null : "fx:id=\"sele1J9\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert sele2J1 != null : "fx:id=\"sele2J1\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert sele2J10 != null : "fx:id=\"sele2J10\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert sele2J11 != null : "fx:id=\"sele2J11\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert sele2J2 != null : "fx:id=\"sele2J2\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert sele2J3 != null : "fx:id=\"sele2J3\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert sele2J4 != null : "fx:id=\"sele2J4\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert sele2J5 != null : "fx:id=\"sele2J5\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert sele2J6 != null : "fx:id=\"sele2J6\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert sele2J7 != null : "fx:id=\"sele2J7\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert sele2J8 != null : "fx:id=\"sele2J8\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";
        assert sele2J9 != null : "fx:id=\"sele2J9\" was not injected: check your FXML file 'Etapa2Partida.fxml'.";

    }

}
