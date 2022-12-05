package app.controller;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.model.Arbitro;
import app.model.ArbitroDAO;
import app.model.GrupoPrimeiraFase;
import app.model.Partida;
import app.model.PartidaDAO;
import app.model.SelecaoDAO;
import app.model.exceptions.ObjetoNaoExisteException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MenuDePartidas extends JanelaJAVAFX{

    @FXML
    private ProgressBar barraProgressoPartidas;

    @FXML
    private Button bntClassificacao;

    @FXML
    private Button btnOitavas;

    @FXML
    private Button btnSalvarPartida;

    @FXML
    private ComboBox<String> comboArbitro;
    
    private List<String> listaArbitros = new ArrayList<>();
    
    private ObservableList<String> arbitros;

    @FXML
    private ComboBox<Integer> comboDia;
    
    private List<Integer> listaDias = new ArrayList<>();
    
    private ObservableList<Integer> dias;

    @FXML
    private ComboBox<Integer> comboGolSelecao1;
    
    private List<Integer> listaGols = new ArrayList<>();
    
    private ObservableList<Integer> gols;

    @FXML
    private ComboBox<Integer> comboGolSelecao2;

    @FXML
    private ComboBox<Integer> comboHora;
    
    private List<Integer> listaHoras = new ArrayList<>();
    
    private ObservableList<Integer> horas;

    @FXML
    private ComboBox<Integer> comboMes;
    
    private List<Integer> listaMes = new ArrayList<>();
    
    private ObservableList<Integer> mes;

    @FXML
    private ComboBox<Integer> comboMinuto;
    
    private List<Integer> listaMinuto = new ArrayList<>();
    
    private ObservableList<Integer> minuto;

    @FXML
    private TextField localPartida;

    @FXML
    private Label nomeDaPartida;

    @FXML
    private Label quantidadePartidasCriadas;
    
    @FXML
    private Label selecao1;

    @FXML
    private Label selecao2;
    
    public void bntClassificacaoMostrar(ActionEvent event) throws IOException {
    	Stage window = (Stage)bntClassificacao.getScene().getWindow();
        trocarJanela("/app/viewFasedeGrupos/FaseDeGrupos.fxml", 800, 500, window);
    }
    
    private void atualizarBarraProgresso() {
    	quantidadePartidasCriadas.setText("Quantidade de Partidas criadas: %d".formatted(PartidaDAO.quantidadePartidasRealizada()));
    	barraProgressoPartidas.setProgress((1/48.0)*PartidaDAO.quantidadePartidasRealizada());
    }
    
    private void atualizarPartida() {
    	Partida modeloPartida = PartidaDAO.partidaSemRealizar();
    	nomeDaPartida.setText(""+modeloPartida);
    	selecao1.setText("%s".formatted(modeloPartida.getSelecao1().getNome()));
    	selecao2.setText("%s".formatted(modeloPartida.getSelecao2().getNome()));
    }
    
    private void AtualizarListaArbitros() {
    	listaArbitros = ArbitroDAO.todosNomesArbitros();
    	arbitros = FXCollections.observableArrayList(listaArbitros);
    	comboArbitro.setItems(arbitros);
    }
    
    private void atualizarDias() {
    	for(int i = 1; i <= 31;i++) {
    		listaDias.add(i);
    	}
    	dias = FXCollections.observableArrayList(listaDias);
    	comboDia.setItems(dias);
    }
    
    private void atualizarMes() {
    	for(int i = 1; i <= 12;i++) {
    		listaMes.add(i);
    	}
    	mes = FXCollections.observableArrayList(listaMes);
    	comboMes.setItems(mes);
    }
    
    private void atualizarHora() {
    	for(int i = 0; i <= 23;i++) {
    		listaHoras.add(i);
    	}
    	horas = FXCollections.observableArrayList(listaHoras);
    	comboHora.setItems(horas);
    }
    
    private void atualizarMinuto() {
    	for(int i = 0; i <= 59;i++) {
    		listaMinuto.add(i);
    	}
    	minuto = FXCollections.observableArrayList(listaMinuto);
    	comboMinuto.setItems(minuto);
    }
    
    private void atualizarGols() {
    	for(int i = 0; i <= 20;i++) {
    		listaGols.add(i);
    	}
    	gols = FXCollections.observableArrayList(listaGols);
    	comboGolSelecao1.setItems(gols);
    	comboGolSelecao2.setItems(gols);
    }
    
    public void btnSalvar(ActionEvent event) throws IOException, ObjetoNaoExisteException{
    	Partida modeloPartida = PartidaDAO.partidaSemRealizar();
    	PartidaDAO.editarLocal(localPartida.getText(), modeloPartida);
    	PartidaDAO.alteracaoDeStatusPartida(true,modeloPartida);
    	PartidaDAO.editarMes(comboMes.getValue(), modeloPartida);
    	PartidaDAO.editarDia(comboDia.getValue(), modeloPartida);
    	PartidaDAO.editarArbitros(ArbitroDAO.getArbitroPorNome(comboArbitro.getValue()), modeloPartida);
    	PartidaDAO.editarHorario(comboHora.getValue(), comboMinuto.getValue(), modeloPartida);
    	PartidaDAO.editorGols(modeloPartida, comboGolSelecao1.getValue(), comboGolSelecao2.getValue());
    	GrupoPrimeiraFase.definirPontos(modeloPartida, true);
    	Stage window = (Stage)btnSalvarPartida.getScene().getWindow();
        trocarJanela("/app/viewFasedeGrupos/menuDePartidas.fxml", 800, 500, window);
    }
    
    @FXML
    void initialize() {
		atualizarBarraProgresso();
		atualizarPartida();
		AtualizarListaArbitros();
		atualizarDias();
		atualizarMes();
		atualizarHora();
		atualizarMinuto();
		atualizarGols();
    }

}

 