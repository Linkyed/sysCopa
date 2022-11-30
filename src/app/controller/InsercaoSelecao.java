package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import app.model.GrupoPrimeiraFase;
import app.model.Selecao;
import app.model.SelecaoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class InsercaoSelecao {

	public static int quantidadeSelecoes = SelecaoDAO.quantidadeSelecoes();
	public static Selecao selecaoComboBox;
	@FXML
	private Button btnEditarSelecao;

		
	@FXML
	private Button btnInserirSelecao;
	   
	
	@FXML
	private Button btnVoltarMenu;
	  
	@FXML
	private ComboBox<String> comboBoxSelecoes;
	
	@FXML
	private Label labelNomeJogador1;

	@FXML
	private Label labelNomeJogador10;

	@FXML
	private Label labelNomeJogador11;

	@FXML
	private Label labelNomeJogador2;

	@FXML
	private Label labelNomeJogador3;

	@FXML
	private Label labelNomeJogador4;

	@FXML
	private Label labelNomeJogador5;

	@FXML
	private Label labelNomeJogador6;

	@FXML
	private Label labelNomeJogador7;

	@FXML
	private Label labelNomeJogador8;

	@FXML
	private Label labelNomeJogador9;

	@FXML
	private Label labelNomeSelecao;

	@FXML
	private Label labelNomeTecnico;

	@FXML
	private ProgressBar progressoSelecoesCriadas;

	@FXML
	private Label quantidadeSelecoesCriadas;

	@FXML
	private ListView<String> listaGrupoA;

	@FXML
	private ListView<String> listaGrupoB;

	@FXML
	private ListView<String> listaGrupoC;

	@FXML
	private ListView<String> listaGrupoD;

	@FXML
	private ListView<String> listaGrupoE;

	@FXML
	private ListView<String> listaGrupoF;

	@FXML
	private ListView<String> listaGrupoG;

	@FXML
	private ListView<String> listaGrupoH;
	    
	@FXML
	void btnInserirSelecaoAction(ActionEvent event) throws IOException {
		//Iniciando o precesso de inserir uma seleção em uma tela separada
		FXMLLoader loaderSelecao = new FXMLLoader();
		URL xmlURLSelecao = getClass().getResource("/app/view/criarCopa/CriarSelecao.fxml");
		loaderSelecao.setLocation(xmlURLSelecao);
	 	Parent rootSelecao = loaderSelecao.load();
	 	Stage windowSelecao = new Stage();
	 	windowSelecao.resizableProperty().setValue(false);
	 	windowSelecao.initModality(Modality.APPLICATION_MODAL);
	 	windowSelecao.setScene(new Scene(rootSelecao, 250, 150));
	 	impedirFechamento(windowSelecao, "ERROR", "Termine a inserção para sair desta tela!");
	 	windowSelecao.showAndWait();

	 	//Iniciando o precesso de inserir um Tecnico em uma tela separada
	 	FXMLLoader loaderTecnico = new FXMLLoader();
	 	URL xmlURLTecnico = getClass().getResource("/app/view/criarCopa/CriarTecnico.fxml");
	 	loaderTecnico.setLocation(xmlURLTecnico);
	 	Parent rootTecnico = loaderTecnico.load();
	 	Stage windowTecnico = new Stage();
	 	windowTecnico.initModality(Modality.APPLICATION_MODAL);
	 	windowTecnico.setScene(new Scene(rootTecnico, 250, 150));
	 	impedirFechamento(windowTecnico, "ERROR", "Termine a inserção para sair desta tela!");
	 	windowTecnico.showAndWait();

	 	//Iniciando o processo de de inserir um jogador em uma tela separada
	 	for (int i = 0; i < 11; i++) {
	 		CriarSelecao.quantidadeJoadores = i;
	 		FXMLLoader loaderJogador = new FXMLLoader();
	 		URL xmlURLJogador = getClass().getResource("/app/view/criarCopa/CriarJogador.fxml");
	 		loaderJogador.setLocation(xmlURLJogador);
	 		Parent rootJogador = loaderJogador.load();
	 		Stage windowJogador = new Stage();
	 		windowJogador.initModality(Modality.APPLICATION_MODAL);
	 		windowJogador.setScene(new Scene(rootJogador, 250, 210));
	 		impedirFechamento(windowJogador, "ERROR", "Termine a inserção para sair desta tela!");
	 		windowJogador.showAndWait();
	 	}
	 	atualizarGrupos();
	 	atualizarComboBoxSelecao();
	 	atualizarBarraProgresso();
	    }
   
	@FXML
    void btnEditarSelecaoAction(ActionEvent event) throws IOException {
		//Iniciando o precesso de inserir uma seleção em uma tela separada
		FXMLLoader loaderSelecao = new FXMLLoader();
		URL xmlURLSelecao = getClass().getResource("/app/view/criarCopa/EdicaoGeral.fxml");
		loaderSelecao.setLocation(xmlURLSelecao);
		Parent rootSelecao = loaderSelecao.load();
		Stage windowSelecao = new Stage();
		windowSelecao.resizableProperty().setValue(false);
		windowSelecao.initModality(Modality.APPLICATION_MODAL);
		windowSelecao.setScene(new Scene(rootSelecao, 250, 200));
		//impedirFechamento(windowSelecao, "ERROR", "Termine a inserção para sair desta tela!");
		windowSelecao.showAndWait();
	}
	
	
    @FXML
    void btnVoltarMenuAction(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        URL xmlURL = getClass().getResource("/app/view/MenuPrincipal.fxml");

        loader.setLocation(xmlURL);

        Parent root = loader.load();

        Stage window = (Stage)btnVoltarMenu.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }


    @FXML
    void comboBoxTrocarLabelsAction(ActionEvent event) {
    	atualizarLabelsSelecaoEscolhida();
    	selecaoComboBox = SelecaoDAO.getSelecaoPorSelecao(new Selecao(comboBoxSelecoes.getValue().toString()));
    }
    
    
    @FXML
    void initialize() {
		atualizarGrupos();
    	atualizarComboBoxSelecao();
		atualizarBarraProgresso();
		
	   	//this.tabelaGruposAD.getColumns().addAll(colunaA, colunaB, colunaC, colunaD);
	   	//this.tabelaGruposAD.setItems(selecoesGruposAD);
		//this.tabelaGruposEH.getColumns().addAll(colunaE, colunaF, colunaG, colunaH);
    }

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
    	for(ListView<String> lista: listaDeListas) {
    		lista.getItems().clear();
    	}
	
		List<String> listaSelecoesGrupos = GrupoPrimeiraFase.selecoesTodosGrupos();
		int salvarNumero = 0;
		int numeroDeRepeticoes = 4;
		for (ListView<String> lista: listaDeListas) {
			for (int i = salvarNumero; i < numeroDeRepeticoes; i++) {
				lista.getItems().add(listaSelecoesGrupos.get(i));
				salvarNumero = i;
			}
			salvarNumero++;
			numeroDeRepeticoes += 4;
		}
    }
    
    private void atualizarComboBoxSelecao() {
    	List<String> listaSelecoes = SelecaoDAO.selecoesExistentes();
    	if(listaSelecoes.size() == 0) {
    		comboBoxSelecoes.setValue("Nenhuma");
    	} else {
    		comboBoxSelecoes.setValue(listaSelecoes.get(0));    
    		if (listaSelecoes.size() > 1) {
    			for(String selecao: listaSelecoes) {
    				comboBoxSelecoes.getItems().add(selecao);
    			}    			
    		}
    		
    	}
    	
    }
    
    private void atualizarLabelsSelecaoEscolhida() {
    	String nome = comboBoxSelecoes.getValue().toString();
    	Selecao selecao = SelecaoDAO.getSelecaoPorSelecao(new Selecao(nome));
    	//labelNomeSelecao.textProperty().bind(comboBoxSelecoes.getSelectionModel().selectedItemProperty());
    	labelNomeSelecao.setText(selecao.getNome());
    	labelNomeTecnico.setText(selecao.getTecnico().getNome());
    	labelNomeJogador1.setText(selecao.getJogadores().get(0).getNome());
    	labelNomeJogador2.setText(selecao.getJogadores().get(1).getNome());
    	labelNomeJogador3.setText(selecao.getJogadores().get(2).getNome());
    	labelNomeJogador4.setText(selecao.getJogadores().get(3).getNome());
    	labelNomeJogador5.setText(selecao.getJogadores().get(4).getNome());
    	labelNomeJogador6.setText(selecao.getJogadores().get(5).getNome());
    	labelNomeJogador7.setText(selecao.getJogadores().get(6).getNome());
    	labelNomeJogador8.setText(selecao.getJogadores().get(7).getNome());
    	labelNomeJogador9.setText(selecao.getJogadores().get(8).getNome());
    	labelNomeJogador10.setText(selecao.getJogadores().get(9).getNome());
    	labelNomeJogador11.setText(selecao.getJogadores().get(10).getNome());
    }
    
    private void atualizarBarraProgresso() {
    	quantidadeSelecoesCriadas.setText("Quantidade de Seleções criadas: %d".formatted(quantidadeSelecoes));
    	progressoSelecoesCriadas.setProgress((1/32.0)*quantidadeSelecoes);
    }
    
    private void impedirFechamento(Stage window, String titulo, String mensagem) {
    	 window.setOnCloseRequest(new EventHandler<WindowEvent>() {
	        	@Override
	        	public void handle(WindowEvent event) {
	        		AlertBox.display(titulo, mensagem);
	        		event.consume();
	        	}
	        });
    }
}
