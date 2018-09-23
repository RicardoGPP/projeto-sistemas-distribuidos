package br.faj.sd.modelo;

import org.json.simple.JSONObject;

public class Cidade extends Entidade
{
	private String nome;
	private Estado estado;
	
	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public Estado getEstado()
	{
		return estado;
	}
	
	public void setEstado(Estado estado)
	{
		this.estado = estado;
	}
	
	public Cidade()
	{
		this.nome = "";
		this.estado = null;
	}
	
	public Cidade(JSONObject jsonObject) throws ClassCastException
	{
		this.setCodigo(Integer.parseInt((String) jsonObject.get("codigo")));
		this.nome = (String) jsonObject.get("nome");
		this.estado = new Estado((JSONObject) jsonObject.get("estado"));
	}
}
