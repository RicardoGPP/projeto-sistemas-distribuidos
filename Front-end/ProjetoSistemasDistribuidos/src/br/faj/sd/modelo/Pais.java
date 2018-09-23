package br.faj.sd.modelo;

import org.json.simple.JSONObject;

public class Pais extends Entidade
{
	private String nome;

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public Pais()
	{
		this.nome = "";
	}
	
	public Pais(JSONObject jsonObject) throws ClassCastException
	{
		this.setCodigo(Integer.parseInt((String) jsonObject.get("codigo")));
		this.nome = (String) jsonObject.get("nome");
	}
}
