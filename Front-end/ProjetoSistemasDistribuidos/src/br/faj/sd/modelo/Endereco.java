package br.faj.sd.modelo;

import org.json.simple.JSONObject;

public class Endereco
{
	private String logradouro;
	private String numero;
	private String bairro;
	private Cidade cidade;
	private String cep;
	
	public String getLogradouro()
	{
		return logradouro;
	}
	
	public void setLogradouro(String logradouro)
	{
		this.logradouro = logradouro;
	}
	
	public String getNumero()
	{
		return numero;
	}
	
	public void setNumero(String numero)
	{
		this.numero = numero;
	}
	
	public String getBairro() 
	{
		return bairro;
	}
	
	public void setBairro(String bairro)
	{
		this.bairro = bairro;
	}
	
	public Cidade getCidade()
	{
		return cidade;
	}
	
	public void setCidade(Cidade cidade)
	{
		this.cidade = cidade;
	}
	
	public String getCep()
	{
		return cep;
	}
	
	public void setCep(String cep)
	{
		this.cep = cep;
	}
	
	public Endereco()
	{
		this.logradouro = "";
		this.numero = "";
		this.bairro = "";
		this.cidade = null;
		this.cep = "";
	}
	
	public Endereco(JSONObject jsonObject) throws ClassCastException
	{
		this.logradouro = (String) jsonObject.get("logradouro");
		this.numero = (String) jsonObject.get("numero");
		this.bairro = (String) jsonObject.get("bairro");
		this.cidade = new Cidade((JSONObject) jsonObject.get("cidade"));
		this.cep = (String) jsonObject.get("cep");
	}
}
