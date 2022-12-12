package app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import app.model.GrupoPrimeiraFase;
import app.model.OitavasDeFinal;
import app.model.PartidaDAO;
import app.model.Selecao;
import app.model.SelecaoDAO;
import app.model.Teste;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import app.controller.JanelaJAVAFX;

public class FaseDeGrupos extends JanelaJAVAFX {

	@FXML
	private ListView<Selecao> listaGrupoA;

	@FXML
	private ListView<Integer> listaGrupoApontos;

	@FXML
	private ListView<Selecao> listaGrupoB;

	@FXML
	private ListView<Integer> listaGrupoBpontos;

	@FXML
	private ListView<Selecao>listaGrupoC;

	@FXML
	private ListView<Integer> listaGrupoCpontos;

	@FXML
	private ListView<Selecao> listaGrupoD;

	@FXML
	private ListView<Integer> listaGrupoDpontos;

	@FXML
	private ListView<Selecao> listaGrupoE;

	@FXML
	private ListView<Integer> listaGrupoEpontos;

	@FXML
	private ListView<Selecao> listaGrupoF;

	@FXML
	private ListView<Integer> listaGrupoFpontos;

	@FXML
	private ListView<Selecao> listaGrupoG;

	@FXML
	private ListView<Integer> listaGrupoGpontos;

	@FXML
	private ListView<Selecao> listaGrupoH;

	@FXML
	private ListView<Integer> listaGrupoHpontos;

	@FXML
	private Button cadastrarPartidas;

	@FXML
	private Button listarPartidas;

	@FXML
	private Button bntVoltarMenuPrincipal;
	
	@FXML
	private Button randButton;
	
	@FXML
	private Button oitavasButton;
	
	@FXML
    private Button excuirPartida;

	/**Metodo para atualizar os grupos da copa com as seleções**/
	private void atualizarGrupos() {

		List<ListView<Selecao>> listaDeListas = new ArrayList<>();
		listaDeListas.add(listaGrupoA);
		listaDeListas.add(listaGrupoB);
		listaDeListas.add(listaGrupoC);
		listaDeListas.add(listaGrupoD);
		listaDeListas.add(listaGrupoE);
		listaDeListas.add(listaGrupoF);
		listaDeListas.add(listaGrupoG);
		listaDeListas.add(listaGrupoH);
		for (ListView<Selecao> lista : listaDeListas) {
			lista.getItems().clear();
		}

		List<Selecao> selecoeStrings = GrupoPrimeiraFase.selecoesGrupo("A");
		for (Selecao selecao : selecoeStrings) {
			System.out.println(selecao);
			listaGrupoA.getItems().add(selecao);
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesGrupo("B");
		for (Selecao selecao : selecoeStrings) {
			listaGrupoB.getItems().add(selecao);
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesGrupo("C");
		for (Selecao selecao : selecoeStrings) {
			listaGrupoC.getItems().add(selecao);
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesGrupo("D");
		for (Selecao selecao : selecoeStrings) {
			listaGrupoD.getItems().add(selecao);
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesGrupo("E");
		for (Selecao selecao : selecoeStrings) {
			listaGrupoE.getItems().add(selecao);
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesGrupo("F");
		for (Selecao selecao : selecoeStrings) {
			listaGrupoF.getItems().add(selecao);
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesGrupo("G");
		for (Selecao selecao : selecoeStrings) {
			listaGrupoG.getItems().add(selecao);
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesGrupo("H");
		for (Selecao selecao : selecoeStrings) {
			listaGrupoH.getItems().add(selecao);
		}

	}

	/**Metodo para atualizar os pontos de cada seleção da copa**/
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

		List<Selecao> selecoeStrings = GrupoPrimeiraFase.selecoesGrupo("A");
		for (Selecao selecao : selecoeStrings) {
			listaGrupoApontos.getItems().add(selecao.getPontos());
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesGrupo("B");
		for (Selecao selecao : selecoeStrings) {
			listaGrupoBpontos.getItems().add(selecao.getPontos());
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesGrupo("C");
		for (Selecao selecao : selecoeStrings) {
			listaGrupoCpontos.getItems().add(selecao.getPontos());
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesGrupo("D");
		for (Selecao selecao : selecoeStrings) {
			listaGrupoDpontos.getItems().add(selecao.getPontos());
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesGrupo("E");
		for (Selecao selecao : selecoeStrings) {
			listaGrupoEpontos.getItems().add(selecao.getPontos());
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesGrupo("F");
		for (Selecao selecao : selecoeStrings) {
			listaGrupoFpontos.getItems().add(selecao.getPontos());
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesGrupo("G");
		for (Selecao selecao : selecoeStrings) {
			listaGrupoGpontos.getItems().add(selecao.getPontos());
		}
		selecoeStrings = GrupoPrimeiraFase.selecoesGrupo("H");
		for (Selecao selecao : selecoeStrings) {
			listaGrupoHpontos.getItems().add(selecao.getPontos());
		}
		

	}
	
	/**Metodo para atualizar a disponibilidade do botão de excluir**/
	public void atualizarExcuir() {
		if(PartidaDAO.quantidadePartidasRealizada() == 0) {
			excuirPartida.setDisable(true);
		}else {
			excuirPartida.setDisable(false);
		}
	}
	
	/**Metodo para atualizar a disponibilidade de certos botões**/
	public void atualizarBotoes() {
		if(PartidaDAO.quantidadePartidasNaoRealizada() == 0) {
			cadastrarPartidas.setDisable(true);
			randButton.setDisable(true);
			oitavasButton.setDisable(false);
		}else {
			oitavasButton.setDisable(true);
			cadastrarPartidas.setDisable(false);
			randButton.setDisable(false);
		}
	}

	/**Ação do botão de cadastrar onde troca a tela para a criação das partidas**/
	public void btnCadastrar(ActionEvent event) throws IOException {

		Stage window = (Stage) cadastrarPartidas.getScene().getWindow();

		trocarJanela("/app/viewFasedeGrupos/Etapa1Partida.fxml", 800, 600, window);
	}
	
	/**Ação do botão de listar onde troca a tela para a listagem de partidas**/
	public void btnListar(ActionEvent event) throws IOException {

		Stage window = (Stage) listarPartidas.getScene().getWindow();

		trocarJanela("/app/viewFasedeGrupos/ListarPartidasFaseGrupo.fxml", 800, 600, window);
	}
	
	/**Ação do botão voltar onde volta para o menu geral da partida**/
	public void btnVoltarMenu(ActionEvent event) throws IOException {

		Stage window = (Stage) bntVoltarMenuPrincipal.getScene().getWindow();

		trocarJanela("/app/viewFasedeGrupos/MenuGeralPartida.fxml", 800, 600, window);
	}
	
	/**Ação do botão de oitavas onde o programa ira para a proxima fase da copa**/
	public void btnOitavas(ActionEvent event) throws IOException {
		OitavasDeFinal.OrganizarPartidasOitavas();
		Stage window = (Stage) oitavasButton.getScene().getWindow();
		trocarJanela("/app/viewFasedeGrupos/OitavasDeFinal.fxml", 800, 600, window);
	}
	
	/**Metodo para trocar a tela de deltar**/
	public void deletar() throws IOException {
		Stage window = (Stage) excuirPartida.getScene().getWindow();
		trocarJanela("/app/viewFasedeGrupos/DeletarPartida.fxml", 300, 400, window);
	}
	

	/**Metodo para randomizar as partidas**/
	public void randPartidaMenuAction(ActionEvent event) {
		Teste.RandomPartida(PartidaDAO.quantidadePartidasNaoRealizada(), true);
		atualizarGrupos();
		atualizarPontos();
		atualizarBotoes();
		atualizarExcuir();
	}

	@FXML
	void initialize() {
		atualizarGrupos();
		atualizarPontos();
		atualizarBotoes();
		atualizarExcuir();

	}
}
