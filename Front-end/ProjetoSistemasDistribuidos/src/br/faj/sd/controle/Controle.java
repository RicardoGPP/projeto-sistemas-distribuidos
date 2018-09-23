package br.faj.sd.controle;

import br.faj.sd.visao.Visao;

public abstract class Controle<T extends Visao<? extends Controle<T>, ?>>
{
	private T visao;
	
	protected T getVisao()
	{
		return visao;
	}

	public Controle(T visao)
	{
		this.visao = visao;
	}
}