package br.faj.sd.visao;

import java.io.IOException;
import br.faj.sd.configuracao.Configuracao;
import br.faj.sd.controle.ConfiguracaoControle;
import br.faj.sd.util.Alerta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.WindowEvent;

public class ConfiguracaoVisao extends Visao<ConfiguracaoControle, BorderPane>
{
	private VBox vboxGeral;
	private Label labelAPI;
	private HBox hboxCampoBotoes;
	private TextField textfieldAPI;
	private Button buttonAdicionar;
	private Button buttonRemover;
	private ListView<String> listviewAPIs;
	private HBox hboxBotoes;
	private Button buttonOK;
	
	protected void instanciarComponentes()
	{
		this.vboxGeral = new VBox();
		this.labelAPI = new Label();
		this.hboxCampoBotoes = new HBox();
		this.textfieldAPI = new TextField();
		this.buttonAdicionar = new Button();
		this.buttonRemover = new Button();
		this.listviewAPIs = new ListView<>();
		this.hboxBotoes = new HBox();
		this.buttonOK = new Button();
	}

	protected void definirEstrutura()
	{
		this.setTitle("Configurações");
		this.setWidth(300);
		this.setHeight(400);
		this.setResizable(false);
		
		getPainel().setPadding(new Insets(10));
		
		getPainel().setCenter(this.vboxGeral);
		
		this.labelAPI.setText("URL da API:");
		this.labelAPI.setStyle("-fx-font-weight: bold");
		this.vboxGeral.getChildren().add(this.labelAPI);
		
		this.hboxCampoBotoes.setSpacing(2);
		this.hboxCampoBotoes.setPadding(new Insets(0, 0, 5, 0));
		this.vboxGeral.getChildren().add(this.hboxCampoBotoes);
		
		this.textfieldAPI.setPrefWidth(210);
		this.hboxCampoBotoes.getChildren().add(this.textfieldAPI);
		
		this.buttonAdicionar.setText("+");
		this.buttonAdicionar.setPrefWidth(25);
		this.hboxCampoBotoes.getChildren().add(this.buttonAdicionar);
		
		this.buttonRemover.setText("-");
		this.buttonRemover.setPrefWidth(25);
		this.hboxCampoBotoes.getChildren().add(this.buttonRemover);
		
		this.vboxGeral.getChildren().add(this.listviewAPIs);
		
		this.hboxBotoes.setPadding(new Insets(5, 0, 0, 0));
		this.hboxBotoes.setAlignment(Pos.CENTER_RIGHT);
		getPainel().setBottom(this.hboxBotoes);
		
		this.buttonOK.setText("OK");
		this.buttonOK.setPrefWidth(80);
		this.hboxBotoes.getChildren().add(this.buttonOK);
	}

	protected void definirEventos()
	{
		this.buttonAdicionar.setOnAction(this.aoClicarBotaoAdicionar());
		this.buttonRemover.setOnAction(this.aoClicarBotaoRemover());
		this.setOnShown(this.aoAbrirTela());
		this.buttonOK.setOnAction(this.aoClicarBotaoOK());
	}

	protected ConfiguracaoControle definirControle()
	{
		return new ConfiguracaoControle(this);
	}

	protected BorderPane definirPainel()
	{
		return new BorderPane();
	}
	
	private Configuracao ler() throws ClassNotFoundException, IOException
	{
		Configuracao configuracao = Configuracao.recuperar();
		configuracao.getApis().clear();
		for (String api : listviewAPIs.getItems())
			configuracao.getApis().add(api);
		return configuracao;	
	}
	
	private void escrever(Configuracao configuracao)
	{
		this.listviewAPIs.getItems().clear();
		for (String api : configuracao.getApis())
			this.listviewAPIs.getItems().add(api);
	}
	
	private EventHandler<ActionEvent> aoClicarBotaoAdicionar()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent arg0)
			{
				if (!textfieldAPI.getText().trim().equals(""))
				{
					listviewAPIs.getItems().add(textfieldAPI.getText().trim());
					textfieldAPI.clear();
				}
			}
		};
	}
	
	private EventHandler<ActionEvent> aoClicarBotaoRemover()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent arg0)
			{
				int index = listviewAPIs.getSelectionModel().getSelectedIndex();
				if (index != -1)
					listviewAPIs.getItems().remove(index);
			}
		};
	}
	
	private EventHandler<WindowEvent> aoAbrirTela()
	{
		return new EventHandler<WindowEvent>()
		{
			public void handle(WindowEvent arg0)
			{
				try
				{
					escrever(getControle().carregarConfiguracao());					
				} catch (ClassNotFoundException | IOException e)
				{
					Alerta.mostrar(AlertType.ERROR, "Ocorreu um erro no sistema.", "Erro: " + e.getMessage() + ".");
				}
			}
		};
	}
	
	private EventHandler<ActionEvent> aoClicarBotaoOK()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent arg0)
			{
				try
				{
					getControle().salvarConfiguracao(ler());
					close();
				} catch (ClassNotFoundException | IOException e)
				{
					Alerta.mostrar(AlertType.ERROR, "Ocorreu um erro no sistema.", "Erro: " + e.getMessage() + ".");
				}
			}
		};
	}
}