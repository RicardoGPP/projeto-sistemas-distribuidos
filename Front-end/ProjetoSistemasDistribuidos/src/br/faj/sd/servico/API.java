package br.faj.sd.servico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import br.faj.sd.configuracao.Configuracao;
import br.faj.sd.modelo.Pessoa;

public class API
{
	public static Pessoa obterPessoa(int codigo)
	{
		Pessoa pessoa = null;
		try
		{
			for (String api : Configuracao.recuperar().getApis())
			{
				try
				{
					String conteudo = API.recuperarConteudo(api + "/api/pessoa/buscar/" + codigo);
					pessoa = new Pessoa((JSONObject) (new JSONParser()).parse(conteudo));
					break;
				} catch (IOException e)
				{
					continue;
				}				
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			pessoa = null;
		}					
		return pessoa;
	}
	
	public static List<Pessoa> obterPessoas()
	{
		List<Pessoa> pessoas = new ArrayList<>();		
		try
		{
			for (String api : Configuracao.recuperar().getApis())
			{
				try
				{
					String conteudo = API.recuperarConteudo(api + "/api/pessoa/listar");					
					JSONArray jsonArray = new JSONArray();
					JSONParser jsonParser = new JSONParser();					
					jsonArray = (JSONArray) jsonParser.parse(conteudo);					
					for (Object object : jsonArray)
					{
						JSONObject jsonObject = (JSONObject) object;
						pessoas.add(new Pessoa(jsonObject));
					}
					break;
				} catch (IOException e)
				{
					continue;
				}
			}			
		} catch (Exception e)
		{
			e.printStackTrace();
			pessoas.clear();
		}		
		return pessoas;
	}
	
	private static String recuperarConteudo(String sUrl) throws IOException 
	{
		String conteudo = "";
		URL url = new URL(sUrl);
		URLConnection urlConnection = url.openConnection();
		InputStreamReader stream = new InputStreamReader(urlConnection.getInputStream());
		BufferedReader leitor = new BufferedReader(stream);
		try
		{
			String linha = "";
			while ((linha = leitor.readLine()) != null)
				conteudo += linha;
			conteudo = conteudo.replace("&quot;", "\"");
		} finally
		{
			if (leitor != null)
				leitor.close();
			if (stream != null)
				stream.close();
		}
		return conteudo;
	}
}
