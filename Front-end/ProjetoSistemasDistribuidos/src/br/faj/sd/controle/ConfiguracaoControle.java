package br.faj.sd.controle;

import java.io.IOException;

import br.faj.sd.configuracao.Configuracao;
import br.faj.sd.visao.ConfiguracaoVisao;

public class ConfiguracaoControle extends Controle<ConfiguracaoVisao>
{
	public ConfiguracaoControle(ConfiguracaoVisao visao)
	{
		super(visao);
	}
	
	public Configuracao carregarConfiguracao() throws ClassNotFoundException, IOException
	{
		return Configuracao.recuperar();
	}
	
	public void salvarConfiguracao(Configuracao configuracao) throws IOException
	{
		configuracao.salvar();
	}
}