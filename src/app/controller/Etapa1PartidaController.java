package app.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.model.ArbitroDAO;

import app.model.Partida;
import app.model.PartidaDAO;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Etapa1PartidaController extends JanelaJAVAFX{

	 @FXML
	    private ProgressBar barraProgressoPartidas;

	    @FXML
	    private Button bntClassificacao;


	    @FXML
	    private Button btnProximaEtapa;

	    @FXML
	    private ComboBox<String> comboArbitro;
	    
	    private List<String> listaArbitros = new ArrayList<>();
	    
	    private ObservableList<String> arbitros;

	    @FXML
	    private ComboBox<Integer> comboDia;
	    
	    private List<Integer> listaDias = new ArrayList<>();
	    
	    private ObservableList<Integer> dias;


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
	    
	    
	    /**Ação do botão Mostrar classificicação para mostrar como estão os grupos da fase atual**/
	    public void bntClassificacaoMostrar(ActionEvent event) throws IOException {
	    	Stage window = (Stage)bntClassificacao.getScene().getWindow();
	        trocarJanela("/app/viewFasedeGrupos/FaseDeGrupos.fxml", 800, 500, window);
	    }
	    
	    /**Metodo para atualizar a barra de progresso das partidas**/
	    private void atualizarBarraProgresso() {
	    	double num = PartidaDAO.quantidaPartidas();
	    	quantidadePartidasCriadas.setText("Quantidade de Partidas criadas: %d".formatted(PartidaDAO.quantidadePartidasRealizada()));
	    	barraProgressoPartidas.setProgress((1/num)*PartidaDAO.quantidadePartidasRealizada());
	    }
	    
	    
	    /**Metodo para atualizar as partidas**/
	    private void atualizarPartida() {
	    	Partida modeloPartida = PartidaDAO.partidaSemRealizar();
	    	nomeDaPartida.setText(modeloPartida+" - "+modeloPartida.getFasePartida());
	    }
	    
	    
	    /**Metodo para atualizar a lista de arbitros disponiveis**/
	    private void AtualizarListaArbitros() {
	    	listaArbitros = ArbitroDAO.todosNomesArbitros();
	    	arbitros = FXCollections.observableArrayList(listaArbitros);
	    	comboArbitro.setItems(arbitros);
	    }

	    /**Metodo para atualizar os dias disponiveis para realizar as partidas**/
	    private void atualizarDias() {
	    	for(int i = 1; i <= 31;i++) {
	    		listaDias.add(i);
	    	}
	    	dias = FXCollections.observableArrayList(listaDias);
	    	comboDia.setItems(dias);
	    }
	    
	    /**Metodo para atualizar os meses disponiveis para realizar as partidas**/
	    private void atualizarMes() {
	    	for(int i = 1; i <= 12;i++) {
	    		listaMes.add(i);
	    	}
	    	mes = FXCollections.observableArrayList(listaMes);
	    	comboMes.setItems(mes);
	    }
	    
	    /**Metodo para atualizar as horas disponiveis para realizar as partidas**/
	    private void atualizarHora() {
	    	for(int i = 0; i <= 23;i++) {
	    		listaHoras.add(i);
	    	}
	    	horas = FXCollections.observableArrayList(listaHoras);
	    	comboHora.setItems(horas);
	    }
	    
	    /**Metodo para atualizar os minutos disponiveis para realizar as partidas**/
	    private void atualizarMinuto() {
	    	for(int i = 0; i <= 59;i++) {
	    		listaMinuto.add(i);
	    	}
	    	minuto = FXCollections.observableArrayList(listaMinuto);
	    	comboMinuto.setItems(minuto);
	    }
	    
	    /**Ação do botão proximo para salvar a partida e mudar a tela para a proxima etapa**/
	    public void btnProximo(ActionEvent event) throws IOException, ObjetoNaoExisteException{
	    	Partida modeloPartida = PartidaDAO.partidaSemRealizar();
	    	PartidaDAO.editarLocal(localPartida.getText(), modeloPartida);
	    	PartidaDAO.editarMes(comboMes.getValue(), modeloPartida);
	    	PartidaDAO.editarDia(comboDia.getValue(), modeloPartida);
	    	PartidaDAO.editarArbitros(ArbitroDAO.getArbitroPorNome(comboArbitro.getValue()), modeloPartida);
	    	PartidaDAO.editarHorario(comboHora.getValue(), comboMinuto.getValue(), modeloPartida);
	    	Stage window = (Stage)btnProximaEtapa.getScene().getWindow();
	        trocarJanela("/app/viewFasedeGrupos/Etapa2Partida.fxml", 800, 600, window);
	    }
	    
	    /**Metodo para atualizar a disponibilidade do botão de proxima etapa**/
	    public void atualizarBotao(MouseEvent event) {
	    	if(localPartida.getText().isEmpty() || comboArbitro.getValue() == null || comboDia.getValue() == null || comboMinuto.getValue() == null || comboHora.getValue() == null || comboMes.getValue() == null) {
	    		btnProximaEtapa.setDisable(true);
	    	}else {
	    		btnProximaEtapa.setDisable(false);
			}
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
			btnProximaEtapa.setDisable(true);
	    }


}
