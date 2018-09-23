package br.faj.sd.controle;

import java.util.List;

import br.faj.sd.modelo.Pessoa;
import br.faj.sd.servico.API;
import br.faj.sd.visao.PessoaListaVisao;

public class PessoaListaControle extends Controle<PessoaListaVisao>
{
	public PessoaListaControle(PessoaListaVisao visao)
	{
		super(visao);
	}
	
	public List<Pessoa> obterPessoas()
	{
		return API.obterPessoas();
	}
}