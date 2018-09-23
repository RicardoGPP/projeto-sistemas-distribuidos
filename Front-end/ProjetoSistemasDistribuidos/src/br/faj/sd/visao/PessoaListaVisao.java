package br.faj.sd.visao;

import br.faj.sd.controle.PessoaListaControle;
import br.faj.sd.modelo.Pessoa;
import br.faj.sd.servico.API;
import br.faj.sd.util.Alerta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class PessoaListaVisao extends Visao<PessoaListaControle, BorderPane>
{
	private HBox hboxBotoesTopo;
	private Button buttonBuscar;
	private Button buttonConfiguracao;
	private ListView<Pessoa> listviewPessoas;
	private HBox hboxBotoesRodape;
	private Button buttonVerDetalhes;
	
	protected void instanciarComponentes()
	{
		this.hboxBotoesTopo = new HBox();
		this.buttonBuscar = new Button();
		this.buttonConfiguracao = new Button();
		this.listviewPessoas = new ListView<>();
		this.hboxBotoesRodape = new HBox();
		this.buttonVerDetalhes = new Button();
	}

	protected void definirEstrutura()
	{
		this.setTitle("Lista de pessoas");
		this.setWidth(350);
		this.setHeight(400);
		this.setResizable(false);
		
		getPainel().setPadding(new Insets(10));
		
		this.hboxBotoesTopo.setSpacing(2);
		this.hboxBotoesTopo.setPadding(new Insets(0, 0, 5, 0));
		this.hboxBotoesTopo.setAlignment(Pos.CENTER_RIGHT);
		getPainel().setTop(this.hboxBotoesTopo);
		
		this.buttonBuscar.setText("Buscar");
		this.hboxBotoesTopo.getChildren().add(this.buttonBuscar);
		
		this.buttonConfiguracao.setText("Configurações");
		this.hboxBotoesTopo.getChildren().add(this.buttonConfiguracao);
		
		getPainel().setCenter(this.listviewPessoas);
		
		this.hboxBotoesRodape.setPadding(new Insets(5, 0, 0, 0));
		this.hboxBotoesRodape.setAlignment(Pos.CENTER_RIGHT);
		getPainel().setBottom(this.hboxBotoesRodape);
		
		this.buttonVerDetalhes.setText("Ver detalhes");
		this.hboxBotoesRodape.getChildren().add(this.buttonVerDetalhes);
	}

	protected void definirEventos()
	{
		this.buttonBuscar.setOnAction(this.aoClicarBotaoBuscar());
		this.buttonConfiguracao.setOnAction(this.aoClicarBotaoConfiguracao());
		this.buttonVerDetalhes.setOnAction(this.aoClicarBotaoVerDetalhes());
	}

	protected PessoaListaControle definirControle()
	{
		return new PessoaListaControle(this);
	}

	protected BorderPane definirPainel()
	{
		return new BorderPane();
	}
	
	private EventHandler<ActionEvent> aoClicarBotaoBuscar()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent arg0)
			{
				listviewPessoas.getItems().clear();
				for (Pessoa pessoa : getControle().obterPessoas())
					listviewPessoas.getItems().add(pessoa);
			}
		};
	}
	
	private EventHandler<ActionEvent> aoClicarBotaoConfiguracao()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent arg0)
			{
				ConfiguracaoVisao configuracaoVisao = new ConfiguracaoVisao();
				configuracaoVisao.showAndWait();
			}
		};
	}
	
	private EventHandler<ActionEvent> aoClicarBotaoVerDetalhes()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent arg0)
			{				
				Pessoa selecionado = listviewPessoas.getSelectionModel().getSelectedItem();
				if (selecionado == null)
					Alerta.mostrar(AlertType.INFORMATION, "Ausência de seleção.", "Selecione uma pessoa para detalhar.");
				{
					Pessoa pessoa = API.obterPessoa(selecionado.getCodigo());
					if (pessoa == null)
						Alerta.mostrar(AlertType.ERROR, "Falha no processo.", "Não foi possível recuperar os detalhes da pessoa selecionada.");
					else
					{					
						PessoaDetalheVisao pessoaDetalheVisao = new PessoaDetalheVisao(pessoa);
						pessoaDetalheVisao.showAndWait();
					}
				}
			}
		};
	}
}
