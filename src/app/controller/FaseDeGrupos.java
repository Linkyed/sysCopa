package app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import app.model.GrupoPrimeiraFase;
import app.model.Selecao;
import app.model.Teste;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import app.controller.JanelaJAVAFX;

public class FaseDeGrupos extends JanelaJAVAFX {

	@FXML
	private ListView<String> listaGrupoA;

	@FXML
	private ListView<Integer> listaGrupoApontos;

	@FXML
	private ListView<String> listaGrupoB;

	@FXML
	private ListView<Integer> listaGrupoBpontos;

	@FXML
	private ListView<String> listaGrupoC;

	@FXML
	private ListView<Integer> listaGrupoCpontos;

	@FXML
	private ListView<String> listaGrupoD;

	@FXML
	private ListView<Integer> listaGrupoDpontos;

	@FXML
	private ListView<String> listaGrupoE;

	@FXML
	private ListView<Integer> listaGrupoEpontos;

	@FXML
	private ListView<String> listaGrupoF;

	@FXML
	private ListView<Integer> listaGrupoFpontos;

	@FXML
	private ListView<String> listaGrupoG;

	@FXML
	private ListView<Integer> listaGrupoGpontos;

	@FXML
	private ListView<String> listaGrupoH;

	@FXML
	private ListView<Integer> listaGrupoHpontos;

	@FXML
	private Button cadastrarPartidas;

	@FXML
	private Button listarPartidas;

	@FXML
	private Button bntVoltarMenuPrincipal;

	private void atualizarGrupos() {

		List<ListView<String>> listaDeListas = new ArrayList<>();
		listaDeListas.add(listaGrupoA);
		listaDeListas.add(listaGrupoB);
		listaDeListas.add(listaGrupoC);
		listaDeListas.add(listaGrupoD);
		listaDeListas.add(listaGrupoE);
		listaDeListas.add(listaGrupoF);
		listaDeListas.add(listaGrupoG);
		listaDeListas.add(listaGrupoH);
		for (ListView<String> lista : listaDeListas) {
			lista.getItems().clear();
		}

		List<String> selecoeStrings = GrupoPrimeiraFase.selecoesClassificacaoNome("A");
		for (String selecao : selecoeStrings) {
			System.out.println(selecao);
			listaGrupoA.getItems().add(selecao);
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesClassificacaoNome("B");
		for (String selecao : selecoeStrings) {
			listaGrupoB.getItems().add(selecao);
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesClassificacaoNome("C");
		for (String selecao : selecoeStrings) {
			listaGrupoC.getItems().add(selecao);
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesClassificacaoNome("D");
		for (String selecao : selecoeStrings) {
			listaGrupoD.getItems().add(selecao);
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesClassificacaoNome("E");
		for (String selecao : selecoeStrings) {
			listaGrupoE.getItems().add(selecao);
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesClassificacaoNome("F");
		for (String selecao : selecoeStrings) {
			listaGrupoF.getItems().add(selecao);
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesClassificacaoNome("G");
		for (String selecao : selecoeStrings) {
			listaGrupoG.getItems().add(selecao);
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesClassificacaoNome("H");
		for (String selecao : selecoeStrings) {
			listaGrupoH.getItems().add(selecao);
		}

	}

	private void atualizarPontos() {

		List<ListView<Integer>> listaDeListas = new ArrayList<>();
		listaDeListas.add(listaGrupoApontos);
		listaDeListas.add(listaGrupoBpontos);
		listaDeListas.add(listaGrupoCpontos);
		listaDeListas.add(listaGrupoDpontos);
		listaDeListas.add(listaGrupoEpontos);
		listaDeListas.add(listaGrupoFpontos);
		listaDeListas.add(listaGrupoGpontos);
		listaDeListas.add(listaGrupoHpontos);
		for (ListView<Integer> lista : listaDeListas) {
			lista.getItems().clear();
		}

		List<Integer> selecoeStrings = GrupoPrimeiraFase.selecoesClassificacaoPontos("A");
		for (Integer selecao : selecoeStrings) {
			listaGrupoApontos.getItems().add(selecao);
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesClassificacaoPontos("B");
		for (Integer selecao : selecoeStrings) {
			listaGrupoBpontos.getItems().add(selecao);
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesClassificacaoPontos("C");
		for (Integer selecao : selecoeStrings) {
			listaGrupoCpontos.getItems().add(selecao);
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesClassificacaoPontos("D");
		for (Integer selecao : selecoeStrings) {
			listaGrupoDpontos.getItems().add(selecao);
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesClassificacaoPontos("E");
		for (Integer selecao : selecoeStrings) {
			listaGrupoEpontos.getItems().add(selecao);
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesClassificacaoPontos("F");
		for (Integer selecao : selecoeStrings) {
			listaGrupoFpontos.getItems().add(selecao);
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesClassificacaoPontos("G");
		for (Integer selecao : selecoeStrings) {
			listaGrupoGpontos.getItems().add(selecao);
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesClassificacaoPontos("H");
		for (Integer selecao : selecoeStrings) {
			listaGrupoHpontos.getItems().add(selecao);
		}

	}

	public void btnCadastrar(ActionEvent event) throws IOException {

		Stage window = (Stage) cadastrarPartidas.getScene().getWindow();

		trocarJanela("/app/viewFasedeGrupos/Etapa1Partida.fxml", 800, 500, window);
	}
	
	public void btnListar(ActionEvent event) throws IOException {

		Stage window = (Stage) listarPartidas.getScene().getWindow();

		trocarJanela("/app/viewFasedeGrupos/ListarPartidasFaseGrupo.fxml", 800, 500, window);
	}
	
	public void btnVoltarMenu(ActionEvent event) throws IOException {

		Stage window = (Stage) bntVoltarMenuPrincipal.getScene().getWindow();

		trocarJanela("/app/viewFasedeGrupos/MenuGeralPartida.fxml", 800, 500, window);
	}
	
	

	public void randPartidaMenuAction(ActionEvent event) {
		Teste.RandomPartida(1, true);
		atualizarGrupos();
		atualizarPontos();
	}

	@FXML
	void initialize() {
		atualizarGrupos();
		atualizarPontos();

	}
}
