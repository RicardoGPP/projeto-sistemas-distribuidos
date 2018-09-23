package br.faj.sd.inicio;

import br.faj.sd.visao.PessoaListaVisao;
import javafx.application.Application;
import javafx.stage.Stage;

public class Inicio extends Application
{
	public static void main(String[] args) 
	{		
		launch();
	}

	public void start(Stage inicio) throws Exception
	{
		PessoaListaVisao tela = new PessoaListaVisao();
		tela.show();
	}
}
