package br.faj.sd.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;

public class Pessoa extends Entidade
{
	private String cpf;
	private String rg;
	private String nome;
	private Date dataNascimento;
	private Sexo sexo;
	private boolean fuma;
	private boolean temFilhos;
	private Endereco endereco;
	private String telefone;
	private String email;
	private String foto;
	
	public enum Sexo
	{
		MASCULINO("Masculino"),
		FEMININO("Feminino");
		
		private String descricao;
		
		public String getDescricao()
		{
			return this.descricao;
		}
		
		private Sexo(String descricao)
		{
			this.descricao = descricao;
		}
	}

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public String getRg()
	{
		return rg;
	}

	public void setRg(String rg)
	{
		this.rg = rg;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public Date getDataNascimento()
	{
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento)
	{
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo()
	{
		return sexo;
	}

	public void setSexo(Sexo sexo)
	{
		this.sexo = sexo;
	}

	public boolean isFuma()
	{
		return fuma;
	}

	public void setFuma(boolean fuma)
	{
		this.fuma = fuma;
	}

	public boolean isTemFilhos()
	{
		return temFilhos;
	}

	public void setTemFilhos(boolean temFilhos)
	{
		this.temFilhos = temFilhos;
	}

	public Endereco getEndereco()
	{
		return endereco;
	}

	public String getTelefone()
	{
		return telefone;
	}

	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getFoto()
	{
		return foto;
	}

	public void setFoto(String foto)
	{
		this.foto = foto;
	}
	
	public Pessoa()
	{
		this.cpf = "";
		this.rg = "";
		this.nome = "";
		this.dataNascimento = null;
		this.sexo = null;
		this.fuma = false;
		this.temFilhos = false;
		this.endereco = new Endereco();
		this.telefone = "";
		this.email = "";
		this.foto = "";
	}
	
	public Pessoa(JSONObject jsonObject) throws ClassCastException, ParseException
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.setCodigo(Integer.parseInt((String) jsonObject.get("codigo")));
		this.cpf = (String) jsonObject.get("cpf");
		this.rg = (String) jsonObject.get("rg");
		this.nome = (String) jsonObject.get("nome");
		this.dataNascimento = simpleDateFormat.parse((String) jsonObject.get("dataNascimento"));
		this.sexo = ((String) jsonObject.get("sexo")).equals("M") ? Sexo.MASCULINO : Sexo.FEMININO;
		this.fuma = ((String) jsonObject.get("fuma")).equals("S");
		this.temFilhos = ((String) jsonObject.get("temFilhos")).equals("S");
		this.endereco = new Endereco((JSONObject) jsonObject.get("endereco"));
		this.telefone = (String) jsonObject.get("telefone");
		this.email = (String) jsonObject.get("email");
		this.foto = (String) jsonObject.get("foto");
	}
	
	public String toString()
	{
		return this.nome;
	}
}
