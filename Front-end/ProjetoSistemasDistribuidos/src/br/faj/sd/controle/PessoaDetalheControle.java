package br.faj.sd.controle;

import br.faj.sd.modelo.Pessoa;
import br.faj.sd.visao.PessoaDetalheVisao;

public class PessoaDetalheControle extends Controle<PessoaDetalheVisao>
{
	private Pessoa pessoa;
	
	public void setPessoa(Pessoa pessoa)
	{
		this.pessoa = pessoa;
	}
	
	public Pessoa getPessoa()
	{
		return this.pessoa;
	}
	
	public PessoaDetalheControle(PessoaDetalheVisao visao)
	{
		super(visao);
	}
}
