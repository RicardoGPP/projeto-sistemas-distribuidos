package br.faj.sd.configuracao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Configuracao implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private static final String NOME_ARQUIVO = "api.cfg";
	
	private static Configuracao instancia = null;
	private List<String> apis;
	
	public List<String> getApis()
	{
		return apis;
	}

	private Configuracao()
	{
		this.apis = new ArrayList<>();
	}
	
	public void salvar() throws IOException
	{
		this.serializar();
	}
	
	public static Configuracao recuperar() throws IOException, ClassNotFoundException
	{
		if (instancia == null)
		{
			File arquivo = new File(NOME_ARQUIVO);
			if (arquivo.exists())
				instancia = deserializar(arquivo);
			else
				instancia = new Configuracao();
		}
		return instancia;
	}
	
	private void serializar() throws IOException
	{
		try (FileOutputStream stream = new FileOutputStream(new File(NOME_ARQUIVO));
			 ObjectOutputStream serializador = new ObjectOutputStream(stream))
		{
			serializador.writeObject(this);
		}
	}
	
	private static Configuracao deserializar(File arquivo) throws IOException, ClassNotFoundException
	{
		try (FileInputStream stream = new FileInputStream(arquivo);
			 ObjectInputStream deserializador = new ObjectInputStream(stream))
		{
			return (Configuracao) deserializador.readObject();
		}
	}
}