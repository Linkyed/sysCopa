package app.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import app.model.GrupoPrimeiraFase;
import app.model.Selecao;
import app.model.SelecaoDAO;
import app.model.exceptions.ObjetoNaoExisteException;
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
import javafx.stage.Window;
import javafx.stage.WindowEvent;

public class InsercaoSelecao extends JanelaJAVAFX{

	//Variaveis publicas para realizar controles logicos e de interface
	public static int quantidadeSelecoes = SelecaoDAO.quantidadeSelecoes();
	public static String selecaoComboBox;
	public static boolean alteracaoSelecao = false;
	
    @FXML
    private Button btnEditar;

    @FXML
    private Button btnEditarArbitro;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnExcluirArbitro;

    @FXML
    private Button btnFaseGrupos;

    @FXML
    private Button btnInserirSelecao;

    @FXML
    private Button btnListagem;

    @FXML
    private Button btnPesquisa;

    @FXML
    private Button btnVoltarMenu;
	  
	@FXML
	private ComboBox<String> comboBoxSelecoes;
	
    @FXML
    private Label labelErrorEditDel;
	
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
	/**Ação do botão de inserir seleção onde será criada tanto a seleção, tecnico, e os 11 jogadores de uma seleção
	 * e depois disso ocorrerá toda atualização das outras funcionalidades da janela**/
	void btnInserirSelecaoAction(ActionEvent event) throws IOException {
		//Iniciando o precesso de inserir uma seleção em uma tela separada
		
	 	abrirJanela("/app/view/criarCopa/CriarSelecao.fxml", 250, 150, true, false);

	 	//Iniciando o precesso de inserir um Tecnico em uma tela separada
	 	abrirJanela("/app/view/criarCopa/CriarTecnico.fxml", 250, 150, true, false);
	 	
	 	//Iniciando o processo de de inserir um jogador em uma tela separada
	 	for (int i = 0; i < 11; i++) {
	 		CriarSelecao.quantidadeJoadores = i;
	 		abrirJanela("/app/view/criarCopa/CriarJogador.fxml", 250, 250, true, false);
	 	}
	 	atualizarGrupos();
	 	atualizarComboBoxSelecao();
	 	atualizarBarraProgresso();
	 	atualizarBotoes();
	 	CriarSelecao.selecaoAtual = null;
	    }
   
	@FXML
	/**Ação do botão de editar, onde ele pega seleção escolhida pela ComboBox e pede ao usuario o que será alterado, podendo escolher
	 * entre mudar o nome da seleção ou do tecnico ou o nome e a posição de um jogador da seleção**/
    void btnEditarAction(ActionEvent event) throws IOException {
		try {
			//Iniciando o precesso de inserir uma seleção em uma tela separada
			abrirJanela("/app/view/criarCopa/EdicaoGeral.fxml", 250, 275, true, true);
			
			if(alteracaoSelecao) {		
				comboBoxSelecoes.getItems().add(EdicaoGeralCriarCopa.nomeSelecaoEditada);
                comboBoxSelecoes.setValue(EdicaoGeralCriarCopa.nomeSelecaoEditada);
                int x = comboBoxSelecoes.getItems().size()-2;
                for (int i = x; i >= 0; i--) {
                    comboBoxSelecoes.getItems().remove(i);
                }
				atualizarComboBoxSelecao();
				atualizarGrupos();
			}
			atualizarLabelsSelecaoEscolhida();
			atualizarBotoes();
			alteracaoSelecao = false;
		} catch (Exception e) {
			labelErrorEditDel.setText("Selecione uma seleção acima para ser editada!");
		}
		
	}
    
    @FXML
    /**Ação do botão de exlcuir que pega a seleção com base no que foi escolhido na ComboBox e pede ao usuario o que sera excluido
     * caso a seleção sejá excluida, o usuario deve criar uma nova seleção completa para ficar no lugar na excluida
     * caso o tecnico sejá excluido, o usuario deve criar um novo tecnico para substituir o antigo
     * caso um jogador sejá excluido o usuario deve criar uum novo jogador para susbtituir o antigo**/
    void btnExcluirAction(ActionEvent event) {
    	
    	try {
			comboBoxSelecoes.getValue();
			labelErrorEditDel.setText("");
			//Iniciando o precesso de inserir uma seleção em uma tela separada
			abrirJanela("/app/view/criarCopa/ExclusaoGeralCriarCopa.fxml", 250, 275, true, true);
			atualizarLabelsSelecaoEscolhida();
			atualizarBotoes();
			alteracaoSelecao = false;
		} catch (Exception e) {
			labelErrorEditDel.setText("Selecione uma seleção acima para ser editada!");
		}
    	
    	if (ExclusaoGeralCriarCopa.selecaoExcluida) {
    		try {
    			String nomeSelecaoExcluida = comboBoxSelecoes.getValue().toString();
    			comboBoxSelecoes.setValue("Vazio");
    			int x = comboBoxSelecoes.getItems().size()-1;
    			for (int i = x; i>= 0; i--) {
    				comboBoxSelecoes.getItems().remove(i);
    			}
    			atualizarComboBoxSelecao();
    			atualizarBarraProgresso();
    			atualizarGrupos();
    			atualizarBotoes();
    			if (comboBoxSelecoes.getItems().size() > 0) {
    				comboBoxSelecoes.setValue(comboBoxSelecoes.getItems().get(0));
    				//comboBoxSelecoes.getItems();
    			}
    			ExclusaoGeralCriarCopa.selecaoExcluida = false;
    		} catch (Exception e) {
    			labelErrorEditDel.setText("Seleção não pode ser excluida");
    		}	
    	}
    }
    
    @FXML
    /**Ação do botão de editar arbitro onde será aberto uma janela que o usuario decidira que arbitro deseja editar e dará o seu novo nome**/
    void btnEditarArbitroAction(ActionEvent event) throws IOException {
    	abrirJanela("/app/view/criarCopa/EdicaoArbitro.fxml", 250, 200, true, true);
    }
  
    @FXML
    /**Ação do botão de excluir arbitro onde será aberto uma janela onde o usuario poderá escolher que arbitro sera excluido e logo apos
     * terá que criar um novo arbitro para que a lista se mantenha do mesmo tamanho**/
    void btnExcluirArbitroAction(ActionEvent event) throws IOException {
    	abrirJanela("/app/view/criarCopa/ExclusaoArbitro.fxml", 250, 200, true, true);
    	abrirJanela("/app/view/criarCopa/CriarArbitro.fxml", 250, 200, true, false);
    }
    
    @FXML
    /**Ação do botão de pesquisar onde o usuario pooderá escolher se quer pesquisa uma Seleção, Tecnico, Jogador e arbitro a partir de uma
     * sequencia de caracters que não necesseriamente precisam formar uma palavra**/
    void btnPesquisaAction(ActionEvent event) throws IOException {
    	abrirJanela("/app/view/criarCopa/Pesquisa.fxml", 250, 200, true, true);
    }
    
    @FXML
    /**Ação do botão de listagem onde o usuario irá escolher entre Seleção, Tecnico, Jogador e Arbitro para que sejam listados todos os 
     * presentes no banco de dados do programa**/
    void btnListagemAction(ActionEvent event) throws IOException {
    	abrirJanela("/app/view/criarCopa/Listagem.fxml", 250, 200, true, true);
    }
    
    @FXML
    /**Ação do botão de ir para fase de grupos onde a tela será trocada para uma nova e o usuario poderá criar as partidas da copa do mundo**/
    void btnFaseGruposAction(ActionEvent event) throws IOException {
    	GrupoPrimeiraFase.organizadorTodasPartidas();
    	Stage window = (Stage)btnFaseGrupos.getScene().getWindow();
    	trocarJanela("/app/viewFasedeGrupos/FaseDeGrupos.fxml", 800, 500, window);
    }
    
    @FXML
    /**Ação do botão de voltar onde simplesmente a tela atual é trocada para a do menu principal e todo o progresso criado é perdido, tendo
     * que iniciar do 0 caso alguma seleção tenha sido criada no processo**/
    void btnVoltarMenuAction(ActionEvent event) throws IOException {
        Stage window = (Stage)btnVoltarMenu.getScene().getWindow();
        trocarJanela("/app/view/MenuPrincipal.fxml", 800, 500, window);
    }
    
    @FXML
    
    /**Ação da comboBox onde cada vez que é trocada de seleção os labels que mostram as informações da mesma são atualizados**/
    void comboBoxTrocarLabelsAction(ActionEvent event) {
    	atualizarLabelsSelecaoEscolhida();
		selecaoComboBox = comboBoxSelecoes.getValue();
		
    }
    
    
    @FXML
    void initialize() {
		atualizarGrupos();
    	atualizarComboBoxSelecao();
    	atualizarLabelsSelecaoEscolhida();
		atualizarBarraProgresso();
		atualizarBotoes();
    }

    /**Função que atualiza todos os grupos mostrados na interface, atualizando as seleções existentes em grupo por grupo**/
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
    
    /**Função que atualiza as seleções que podem ser escolhidas na comboBox com base na lista de seleções salvas no programa**/
    private void atualizarComboBoxSelecao() {

    	List<String> listaSelecoes = SelecaoDAO.selecoesExistentes();
    	if(listaSelecoes.size() == 0) {
    		comboBoxSelecoes.setValue("Nenhuma");
    	} else {
    		//comboBoxSelecoes.setValue(listaSelecoes.get(0));    
    		if (listaSelecoes.size() > 0) {
    			for(String selecao: listaSelecoes) {
    				if (!comboBoxSelecoes.getItems().contains(selecao)) {
    					comboBoxSelecoes.getItems().add(selecao);    					
    				}
    				comboBoxSelecoes.setValue(listaSelecoes.get(listaSelecoes.size()-1));
    				selecaoComboBox = listaSelecoes.get(listaSelecoes.size()-1);
    			}    			
    		}
    	}
    }
    
    /**Função que atualiza os labels de informçãoes de uma seleção que possuem ligação direta com a seleção escolhiga pela comboBox**/
    private void atualizarLabelsSelecaoEscolhida() {
    	try {
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
    	} catch (ObjetoNaoExisteException e) {
    		labelNomeSelecao.setText("Vazio");
    		labelNomeTecnico.setText("Vazio");
    		labelNomeJogador1.setText("Vazio");
    		labelNomeJogador2.setText("Vazio");
    		labelNomeJogador3.setText("Vazio");
    		labelNomeJogador4.setText("Vazio");
    		labelNomeJogador5.setText("Vazio");
    		labelNomeJogador6.setText("Vazio");
    		labelNomeJogador7.setText("Vazio");
    		labelNomeJogador8.setText("Vazio");
    		labelNomeJogador9.setText("Vazio");
    		labelNomeJogador10.setText("Vazio");
    		labelNomeJogador11.setText("Vazio"); 
    	} 
    	catch(Exception e) {
    		labelNomeSelecao.setText("Vazio");
    		labelNomeTecnico.setText("Vazio");
    		labelNomeJogador1.setText("Vazio");
    		labelNomeJogador2.setText("Vazio");
    		labelNomeJogador3.setText("Vazio");
    		labelNomeJogador4.setText("Vazio");
    		labelNomeJogador5.setText("Vazio");
    		labelNomeJogador6.setText("Vazio");
    		labelNomeJogador7.setText("Vazio");
    		labelNomeJogador8.setText("Vazio");
    		labelNomeJogador9.setText("Vazio");
    		labelNomeJogador10.setText("Vazio");
    		labelNomeJogador11.setText("Vazio"); 
    	}
    }
    
    /**Função que atualiza a barra de prorgasso de seleções criadas com base na quantidade de seleções já existentes e as que faltam
     * serem criadas para que o programa possa ir para a proxima fase**/
    private void atualizarBarraProgresso() {
    	quantidadeSelecoesCriadas.setText("Quantidade de Seleções criadas: %d".formatted(SelecaoDAO.quantidadeSelecoes()));
    	progressoSelecoesCriadas.setProgress((1/32.0)*SelecaoDAO.quantidadeSelecoes());
    }
    
    /**Função que atualiza o estado de disponiblidade dos botões, onde alguns que precisam e alguns prerequisitos para estarem disponivels
     * terão que ser atualizados e verificados para que possam estar disponiveis para o usuario**/
    private void atualizarBotoes() {
    	if (comboBoxSelecoes.getItems().size() > 0) {
    		btnEditar.setDisable(false);
    		btnExcluir.setDisable(false);
    	} else {
    		btnEditar.setDisable(true);
    		btnExcluir.setDisable(true);
    	}
    	if (SelecaoDAO.quantidadeSelecoes() == 32) {
    		btnFaseGrupos.setDisable(false);
    	} else {
    		btnFaseGrupos.setDisable(true);
    	}
    }

}
