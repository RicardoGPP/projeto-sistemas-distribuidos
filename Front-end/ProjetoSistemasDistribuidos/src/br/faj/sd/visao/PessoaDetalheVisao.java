package br.faj.sd.visao;

import java.text.SimpleDateFormat;

import br.faj.sd.controle.PessoaDetalheControle;
import br.faj.sd.modelo.Pessoa;
import br.faj.sd.util.Alerta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.WindowEvent;

public class PessoaDetalheVisao extends Visao<PessoaDetalheControle, BorderPane>
{
	private VBox vboxFoto;
	private ImageView imageviewFoto;
	private VBox vboxDados;
	private Label labelCpf;
	private TextField textfieldCpf;
	private Label labelRg;
	private TextField textfieldRg;
	private Label labelNome;
	private TextField textfieldNome;
	private Label labelDataNascimento;
	private TextField textfieldDataNascimento;
	private Label labelSexo;
	private TextField textfieldSexo;
	private Label labelFuma;
	private TextField textfieldFuma;
	private Label labelTemFilhos;
	private TextField textfieldTemFilhos;
	private Label labelEndereco;
	private TextField textfieldEndereco;
	private Label labelTelefone;
	private TextField textfieldTelefone;
	private Label labelEmail;
	private TextField textfieldEmail;
	private HBox hboxBotao;
	private Button buttonOK;
	
	public PessoaDetalheVisao(Pessoa pessoa)
	{
		getControle().setPessoa(pessoa);
	}
	
	protected void instanciarComponentes()
	{
		this.vboxFoto = new VBox();
		this.imageviewFoto = new ImageView();
		this.vboxDados = new VBox();
		this.labelCpf = new Label();
		this.textfieldCpf = new TextField();
		this.labelRg = new Label();
		this.textfieldRg = new TextField();
		this.labelNome = new Label();
		this.textfieldNome = new TextField();
		this.labelDataNascimento = new Label();
		this.textfieldDataNascimento = new TextField();
		this.labelSexo = new Label();
		this.textfieldSexo = new TextField();
		this.labelFuma = new Label();
		this.textfieldFuma = new TextField();
		this.labelTemFilhos = new Label();
		this.textfieldTemFilhos = new TextField();
		this.labelEndereco = new Label();
		this.textfieldEndereco = new TextField();
		this.labelTelefone = new Label();
		this.textfieldTelefone = new TextField();
		this.labelEmail = new Label();
		this.textfieldEmail = new TextField();
		this.hboxBotao = new HBox();
		this.buttonOK = new Button();
	}

	protected void definirEstrutura()
	{
		this.setTitle("Detalhes da pessoa");
		this.setWidth(650);
		this.setHeight(515);
		this.setResizable(false);
		
		getPainel().setPadding(new Insets(10));
		
		this.vboxFoto.setPadding(new Insets(0, 10, 0, 0));
		getPainel().setLeft(this.vboxFoto);
		
		this.imageviewFoto.setFitWidth(100);
		this.imageviewFoto.setFitHeight(100);
		this.vboxFoto.getChildren().add(this.imageviewFoto);
		
		getPainel().setCenter(this.vboxDados);
		
		this.labelCpf.setText("CPF:");
		this.labelCpf.setStyle("-fx-font-weight: bold");
		this.vboxDados.getChildren().add(this.labelCpf);
		
		this.textfieldCpf.setEditable(false);
		this.vboxDados.getChildren().add(this.textfieldCpf);
		
		this.labelRg.setText("RG:");
		this.labelRg.setStyle("-fx-font-weight: bold");
		this.vboxDados.getChildren().add(this.labelRg);
		
		this.textfieldRg.setEditable(false);
		this.vboxDados.getChildren().add(this.textfieldRg);
		
		this.labelNome.setText("Nome:");
		this.labelNome.setStyle("-fx-font-weight: bold");
		this.vboxDados.getChildren().add(this.labelNome);
		
		this.textfieldNome.setEditable(false);
		this.vboxDados.getChildren().add(this.textfieldNome);
		
		this.labelDataNascimento.setText("Data de nascimento:");
		this.labelDataNascimento.setStyle("-fx-font-weight: bold");
		this.vboxDados.getChildren().add(this.labelDataNascimento);
		
		this.textfieldDataNascimento.setEditable(false);
		this.vboxDados.getChildren().add(this.textfieldDataNascimento);
		
		this.labelSexo.setText("Sexo:");
		this.labelSexo.setStyle("-fx-font-weight: bold");
		this.vboxDados.getChildren().add(this.labelSexo);
		
		this.textfieldSexo.setEditable(false);
		this.vboxDados.getChildren().add(this.textfieldSexo);
		
		this.labelFuma.setText("Fuma?");
		this.labelFuma.setStyle("-fx-font-weight: bold");
		this.vboxDados.getChildren().add(this.labelFuma);
		
		this.textfieldFuma.setEditable(false);
		this.vboxDados.getChildren().add(this.textfieldFuma);
		
		this.labelTemFilhos.setText("Tem filhos?");
		this.labelTemFilhos.setStyle("-fx-font-weight: bold");
		this.vboxDados.getChildren().add(this.labelTemFilhos);
		
		this.textfieldTemFilhos.setEditable(false);
		this.vboxDados.getChildren().add(this.textfieldTemFilhos);
		
		this.labelEndereco.setText("Endereço:");
		this.labelEndereco.setStyle("-fx-font-weight: bold");
		this.vboxDados.getChildren().add(this.labelEndereco);
		
		this.textfieldEndereco.setEditable(false);
		this.vboxDados.getChildren().add(this.textfieldEndereco);
		
		this.labelTelefone.setText("Telefone:");
		this.labelTelefone.setStyle("-fx-font-weight: bold");
		this.vboxDados.getChildren().add(this.labelTelefone);
		
		this.textfieldTelefone.setEditable(false);
		this.vboxDados.getChildren().add(this.textfieldTelefone);
		
		this.labelEmail.setText("E-mail:");
		this.labelEmail.setStyle("-fx-font-weight: bold");
		this.vboxDados.getChildren().add(this.labelEmail);
		
		this.textfieldEmail.setEditable(false);
		this.vboxDados.getChildren().add(this.textfieldEmail);
		
		this.hboxBotao.setPadding(new Insets(10, 0, 0, 0));
		this.hboxBotao.setAlignment(Pos.CENTER_RIGHT);
		getPainel().setBottom(this.hboxBotao);
		
		this.buttonOK.setText("OK");
		this.buttonOK.setPrefWidth(80);
		this.hboxBotao.getChildren().add(this.buttonOK);
	}

	protected void definirEventos()
	{
		this.setOnShown(this.aoAbrirTela());
		this.buttonOK.setOnAction(this.aoClicarBotaoOK());
	}

	protected PessoaDetalheControle definirControle()
	{
		return new PessoaDetalheControle(this);
	}

	protected BorderPane definirPainel()
	{
		return new BorderPane();
	}
	
	private void escrever(Pessoa pessoa)
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");			
		this.textfieldCpf.setText(pessoa.getCpf());
		this.textfieldRg.setText(pessoa.getRg());
		this.textfieldNome.setText(pessoa.getNome());
		this.textfieldDataNascimento.setText(simpleDateFormat.format(pessoa.getDataNascimento()));
		this.textfieldSexo.setText(pessoa.getSexo().getDescricao());
		this.textfieldFuma.setText((pessoa.isFuma()) ? "Sim" : "Não");
		this.textfieldTemFilhos.setText((pessoa.isTemFilhos()) ? "Sim" : "Não");
		this.textfieldEndereco.setText
		(
				pessoa.getEndereco().getLogradouro() + ", " +
				pessoa.getEndereco().getNumero() + ", " +
				pessoa.getEndereco().getBairro() + ", " +
				pessoa.getEndereco().getCidade().getNome() + ", " +
				pessoa.getEndereco().getCidade().getEstado().getNome() + ", " +
				pessoa.getEndereco().getCidade().getEstado().getPais().getNome() + ", " +
				pessoa.getEndereco().getCep()					
		);
		this.textfieldTelefone.setText(pessoa.getTelefone());
		this.textfieldEmail.setText(pessoa.getEmail());		
		try
		{
			Image image = new Image(pessoa.getFoto());
			this.imageviewFoto.setImage(image);
		} catch (Exception e)
		{
			Alerta.mostrar(AlertType.ERROR, "Falha no processamento.", "Não foi possível carregar a foto.");
		}
	}
	
	private EventHandler<WindowEvent> aoAbrirTela()
	{
		return new EventHandler<WindowEvent>()
		{
			public void handle(WindowEvent arg0)
			{
				escrever(getControle().getPessoa());
			}
		};
	}
	
	private EventHandler<ActionEvent> aoClicarBotaoOK()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent arg0)
			{
				close();
			}
		};
	}
}
