package ull.herramientas.opendatachartgenerator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public abstract class IReader {
	
	protected ArrayList<Instancia> instancias;
	protected String[] nombres_atributos;
	
	public IReader() {
		this.instancias = new ArrayList<Instancia>();
	}

	public abstract ArrayList<Instancia> leerTodo(InputStream is);

	/**
	 * \brief Metodo para leer por url
	 * \param url
	 * \return
	 * \throws MalformedURLException
	 * \throws IOException
	 */
	public ArrayList<Instancia> leerdeURL(String url) throws MalformedURLException, IOException {
		InputStream is = new URL(url).openStream();
		return leerTodo(is);
	}

	/**
	 * \brief Metodo para leer por fichero
	 * \param file
	 * \return
	 * \throws MalformedURLException
	 * \throws IOException
	 */
	public ArrayList<Instancia> leerdeFichero(String file) throws MalformedURLException, IOException {
		String url = new File(file).toURI().toURL().toString();
		return leerdeURL(url);
	}
	
	/**
	 * \brief Metodo para leer los datos desde una url
	 * \param direccion
	 * \return
	 * \throws MalformedURLException
	 * \throws IOException
	 */
	public ArrayList<Instancia> leerDatos(String direccion) throws MalformedURLException, IOException {
		if (isValidURL(direccion)) {
			return leerdeURL(direccion);
		} else {
			return leerdeFichero(direccion);
		}

	}
	
	
	/**
	 * \brief Metodo booleano que nos dice si la url esta correcta
	 * \param url
	 * \return
	 */
	public boolean isValidURL(String url) {
		URL u = null;
		try {
			u = new URL(url);
		}
		catch (MalformedURLException e) {
			return false;
		}
		
		try {
			u.toURI();
		} catch (URISyntaxException e) {
			return false;
		}
		
		return true;
	}

	/**
	 * \return the nombres_atributos;
	 */
	public String[] getNombres_atributos() {
		return nombres_atributos;
	}
	
	/**
	 * \param nombres_atributos the nombres_atributos to set
	 */
	public void setNombres_atributos(String[] nombres_atributos) {
		this.nombres_atributos = nombres_atributos;
	}

}
