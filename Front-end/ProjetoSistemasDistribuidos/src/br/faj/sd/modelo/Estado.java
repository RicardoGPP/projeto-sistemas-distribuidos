package br.faj.sd.modelo;

import org.json.simple.JSONObject;

public class Estado extends Entidade
{
	private String nome;
	private Pais pais;
	
	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public Pais getPais()
	{
		return pais;
	}
	
	public void setPais(Pais pais)
	{
		this.pais = pais;
	}
	
	public Estado()
	{
		this.nome = "";
		this.pais = null;
	}
	
	public Estado(JSONObject jsonObject) throws ClassCastException
	{
		this.setCodigo(Integer.parseInt((String) jsonObject.get("codigo")));
		this.nome = (String) jsonObject.get("nome");
		this.pais = new Pais((JSONObject) jsonObject.get("pais"));
	}
}
