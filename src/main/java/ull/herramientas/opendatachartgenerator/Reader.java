package ull.herramientas.opendatachartgenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader implements IReader{
	private ArrayList<Instancia> instancias;

	public Reader()
	{
		this.instancias = new ArrayList<Instancia>();
	}



	@Override
	public ArrayList<Instancia> leerTodo(InputStream is) {
		Scanner rd = new Scanner(is);
		String[] nombres_atributos = null;
		int i = 0;
		while (rd.hasNextLine())
		{
			if (i==0)
			{
				String cadena = rd.nextLine();
				nombres_atributos = cadena.split(",");
			}
			else
			{
			String cadena = rd.nextLine();
			String[] valores = cadena.split(",");
			Atributo[] atr = new Atributo[nombres_atributos.length];
			for (int j = 0; j < nombres_atributos.length; j++) {
				atr[j] = new Atributo(valores[j], nombres_atributos[j]);
			}
			instancias.add(new Instancia(atr));
			}
			i++;
		}
		return instancias;

	}

	@Override
	public ArrayList<Instancia> leerdeURL(String url) throws MalformedURLException, IOException {
		InputStream is = new URL(url).openStream();
		return leerTodo(is);
	}

	public ArrayList<Instancia> leerdeFichero(String file) throws MalformedURLException, IOException {
		String url = new File(file).toURI().toURL().toString();
		return leerdeURL(url);
	}

	public ArrayList<Instancia> leerDatos(String direccion) throws MalformedURLException, IOException
	{
		if (isValidURL(direccion))
		{
			return leerdeURL(direccion);
		}
		else
		{
			return leerdeFichero(direccion);
		}


	}

	public boolean isValidURL(String url) {

	    URL u = null;

	    try {
	        u = new URL(url);
	    } catch (MalformedURLException e) {
	        return false;
	    }

	    try {
	        u.toURI();
	    } catch (URISyntaxException e) {
	        return false;
	    }

	    return true;
	}

}
