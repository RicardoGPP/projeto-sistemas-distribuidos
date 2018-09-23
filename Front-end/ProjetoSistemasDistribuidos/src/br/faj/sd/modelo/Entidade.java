package br.faj.sd.modelo;

public abstract class Entidade
{
	private int codigo;

	public int getCodigo()
	{
		return codigo;
	}

	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}
	
	public Entidade()
	{
		this.codigo = -1;
	}
}