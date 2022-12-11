package app.controller;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import app.model.GrupoPrimeiraFase;
import app.model.Partida;
import app.model.PartidaDAO;
import app.model.Teste;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


public class ListagemFaseGrupoController extends JanelaJAVAFX {
	
    @FXML
    private Button bntClassificacao;

	@FXML
	private ListView<Partida> listaGrupoA;

	@FXML
	private ListView<String> listaGrupoApontos;

	@FXML
	private ListView<Partida> listaGrupoB;

	@FXML
	private ListView<String> listaGrupoBpontos;

	@FXML
	private ListView<Partida> listaGrupoC;

	@FXML
	private ListView<String> listaGrupoCpontos;

	@FXML
	private ListView<Partida> listaGrupoD;

	@FXML
	private ListView<String> listaGrupoDpontos;

	@FXML
	private ListView<Partida> listaGrupoE;

	@FXML
	private ListView<String> listaGrupoEpontos;

	@FXML
	private ListView<Partida> listaGrupoF;

	@FXML
	private ListView<String> listaGrupoFpontos;

	@FXML
	private ListView<Partida> listaGrupoG;

	@FXML
	private ListView<String> listaGrupoGpontos;

	@FXML
	private ListView<Partida> listaGrupoH;

	@FXML
	private ListView<String> listaGrupoHpontos;

	@FXML
	private Button cadastrarPartidas;

	@FXML
	private Button listarPartidas;

	@FXML
	private Button bntVoltarMenuPrincipal;

	private void atualizarGrupos() {

		List<ListView<Partida>> listaDeListas = new ArrayList<>();
		listaDeListas.add(listaGrupoA);
		listaDeListas.add(listaGrupoB);
		listaDeListas.add(listaGrupoC);
		listaDeListas.add(listaGrupoD);
		listaDeListas.add(listaGrupoE);
		listaDeListas.add(listaGrupoF);
		listaDeListas.add(listaGrupoG);
		listaDeListas.add(listaGrupoH);
		for (ListView<Partida> lista : listaDeListas) {
			lista.getItems().clear();
		}

		List<Partida> partidasGrupo = PartidaDAO.listaDePartidasGrupo("A");
		for (Partida selecao : partidasGrupo) {
			System.out.println(selecao);
			listaGrupoA.getItems().add(selecao);
		}
		partidasGrupo = PartidaDAO.listaDePartidasGrupo("B");
		for (Partida selecao : partidasGrupo) {
			listaGrupoB.getItems().add(selecao);
		}
		partidasGrupo = PartidaDAO.listaDePartidasGrupo("C");
		for (Partida selecao : partidasGrupo) {
			listaGrupoC.getItems().add(selecao);
		}
		partidasGrupo = PartidaDAO.listaDePartidasGrupo("D");
		for (Partida selecao : partidasGrupo) {
			listaGrupoD.getItems().add(selecao);
		}
		partidasGrupo = PartidaDAO.listaDePartidasGrupo("E");
		for (Partida selecao : partidasGrupo) {
			listaGrupoE.getItems().add(selecao);
		}
		partidasGrupo = PartidaDAO.listaDePartidasGrupo("F");
		for (Partida selecao : partidasGrupo) {
			listaGrupoF.getItems().add(selecao);
		}
		partidasGrupo = PartidaDAO.listaDePartidasGrupo("G");
		for (Partida selecao : partidasGrupo) {
			listaGrupoG.getItems().add(selecao);
		}
		partidasGrupo = PartidaDAO.listaDePartidasGrupo("H");
		for (Partida selecao : partidasGrupo) {
			listaGrupoH.getItems().add(selecao);
		}

	}

	private void atualizarPontos() {

		List<ListView<String>> listaDeListas = new ArrayList<>();
		listaDeListas.add(listaGrupoApontos);
		listaDeListas.add(listaGrupoBpontos);
		listaDeListas.add(listaGrupoCpontos);
		listaDeListas.add(listaGrupoDpontos);
		listaDeListas.add(listaGrupoEpontos);
		listaDeListas.add(listaGrupoFpontos);
		listaDeListas.add(listaGrupoGpontos);
		listaDeListas.add(listaGrupoHpontos);
		for (ListView<String> lista : listaDeListas) {
			lista.getItems().clear();
		}

		for (Partida partida : PartidaDAO.listaDePartidasGrupo("A")) {
			if(PartidaDAO.statusAtuaisPartidas(partida))
				listaGrupoApontos.getItems().add("Feita");
			else 
				listaGrupoApontos.getItems().add("N/Feita");
			
		}
		for (Partida partida : PartidaDAO.listaDePartidasGrupo("B")) {
			if(PartidaDAO.statusAtuaisPartidas(partida))
				listaGrupoBpontos.getItems().add("Feita");
			else 
				listaGrupoBpontos.getItems().add("N/Feita");
			
		}
		for (Partida partida : PartidaDAO.listaDePartidasGrupo("C")) {
			if(PartidaDAO.statusAtuaisPartidas(partida))
				listaGrupoCpontos.getItems().add("Feita");
			else 
				listaGrupoCpontos.getItems().add("N/Feita");
			
		}
		for (Partida partida : PartidaDAO.listaDePartidasGrupo("D")) {
			if(PartidaDAO.statusAtuaisPartidas(partida))
				listaGrupoDpontos.getItems().add("Feita");
			else 
				listaGrupoDpontos.getItems().add("N/Feita");
			
		}
		for (Partida partida : PartidaDAO.listaDePartidasGrupo("E")) {
			if(PartidaDAO.statusAtuaisPartidas(partida))
				listaGrupoEpontos.getItems().add("Feita");
			else 
				listaGrupoEpontos.getItems().add("N/Feita");
			
		}
		for (Partida partida : PartidaDAO.listaDePartidasGrupo("F")) {
			if(PartidaDAO.statusAtuaisPartidas(partida))
				listaGrupoFpontos.getItems().add("Feita");
			else 
				listaGrupoFpontos.getItems().add("N/Feita");
			
		}
		for (Partida partida : PartidaDAO.listaDePartidasGrupo("G")) {
			if(PartidaDAO.statusAtuaisPartidas(partida))
				listaGrupoGpontos.getItems().add("Feita");
			else 
				listaGrupoGpontos.getItems().add("N/Feita");
			
		}
		for (Partida partida : PartidaDAO.listaDePartidasGrupo("H")) {
			if(PartidaDAO.statusAtuaisPartidas(partida))
				listaGrupoHpontos.getItems().add("Feita");
			else 
				listaGrupoHpontos.getItems().add("N/Feita");
			
		}
		

	}
	
	void atualizarBotoes() {
		if(PartidaDAO.quantidadePartidasNaoRealizada() == 0) {
			cadastrarPartidas.setDisable(true);
		}else {
			cadastrarPartidas.setDisable(false);
		}
	}

	public void btnCadastrar(ActionEvent event) throws IOException {

		Stage window = (Stage) cadastrarPartidas.getScene().getWindow();

		trocarJanela("/app/viewFasedeGrupos/Etapa1Partida.fxml", 800, 600, window);
	}
	
	public void btnVoltarMenu(ActionEvent event) throws IOException {

		Stage window = (Stage) bntVoltarMenuPrincipal.getScene().getWindow();

		trocarJanela("/app/viewFasedeGrupos/MenuGeralPartida.fxml", 800, 600, window);
	}
	
	 public void bntClassificacaoMostrar(ActionEvent event) throws IOException {
	    	Stage window = (Stage)bntClassificacao.getScene().getWindow();
	        trocarJanela("/app/viewFasedeGrupos/FaseDeGrupos.fxml", 800, 600, window);
	    }


	@FXML
	void initialize() {
		atualizarGrupos();
		atualizarPontos();
		atualizarBotoes();

	}
}
