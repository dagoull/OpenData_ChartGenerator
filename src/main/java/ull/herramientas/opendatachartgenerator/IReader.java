package ull.herramientas.opendatachartgenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;

public interface IReader {

	/**
	 * Lee, extrae y procesa la información guargada en un fichero para convertirlo en un
	 * vector de instancias de datos.
	 * @param is - Flujo de entrada de datos del fichero a procesar
	 * @return  Instancias de datos del fichero.
	 */
	public ArrayList<Instancia> leerTodo(InputStream is);

	/**
	 * Recibe una dirección URL de un fichero de datos abiertos y
	 * crea un flujo de entrada de datos a partir de él para extraer y retornar dichos datos
	 * como un vector de instancias.
	 * @param url - Dirección url del fichero a procesar
	 * @return - Instancias de datos del fichero
	 * @throws MalformedURLException
	 * @throws IOException
	 */

	public ArrayList<Instancia> leerdeURL(String url) throws MalformedURLException, IOException;

/**
 * Recibe la dirección de un fichero local y
 * crea un flujo de entrada de datos a partir de él para extraer y retornar dichos datos
 * como un vector de instancias.
 * @param direccion - Direccion del fichero local a procesar
 * @return  Instancias de datos del fichero
 * @throws MalformedURLException
 * @throws IOException
 */
	public ArrayList<Instancia> leerdeFichero(String direccion) throws MalformedURLException, IOException;

	/**
	 * Método que recibe una direccion de un fichero y determina si se trata de un fichero local o
	 * remoto (de una URL) para aplicar alguno de sus métodos respectivos y poder extraer y retornar
	 * las instancias de sus datos
	 * @param direccion
	 * @return Instancias de datos del fichero
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public ArrayList<Instancia> leerDatos(String direccion) throws MalformedURLException, IOException;

	/**
	 * Retorna la lista de nombres de los atributos presentes en la instancias de los datos leídos
	 * de un fichero de un conjunto de datos
	 * @return  Lista de nombres de los atributos de un fichero de un conjunto de datos
	 */
	public String[] getNombres_atributos();



}
