package ull.herramientas.opendatachartgenerator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

/**
 * Clase que representa a los conjuntos de datos abiertos o "datasets", incluyendo operaciones para
 * la carga, el acceso y manipulación de su contenido.
 * @author Mauricio
 *
 */

public class Dataset {
	private IReader reader;
	private ArrayList<Instancia> rows;
	private String[] columnas;

	/**
	 * Constructor del dataset
	 * @param url - Dirección del fichero con el conjunto de datos a cargar
	 * @throws MalformedURLException
	 * @throws IOException
	 */

	public Dataset(String url) throws MalformedURLException, IOException
	{
		this.reader =  new Reader();
		this.rows = new ArrayList<Instancia>();
		this.rows = reader.leerdeURL(url);
		this.columnas = reader.getNombres_atributos();
	}

	/**
	 * Retorna el lector/cargador de datos
	 * @return lector/cargador de datos.
	 */
	public IReader getReader() {
		return reader;
	}

	/**
	 * Asigna un lector/cargador de datos
	 * @param reader - Lector/cargador de datos a asignar.
	 */
	public void setReader(IReader reader) {
		this.reader = reader;
	}

	/**
	 * Retorna las filas del conjunto de datos cargado
	 * @return filas de conjunto de datos cargado
	 */
	public ArrayList<Instancia> getRows() {
		return rows;
	}

	/**
	 * Asigna las filas de un conjunto de datos
	 * @param rows - Las filas del conjunto de datos a asignar
	 */
	public void setRows(ArrayList<Instancia> rows) {
		this.rows = rows;
	}

	/**
	 * Retorna los nombres de las columnas del conjunto de datos cargado
	 * @return - Los nombres de las columnas del conjunto de datos cargado
	 */
	public String[] getColumnas() {
		return columnas;
	}

	/**
	 * Asigna los nombres de las columnas de un conjunto de datos
	 * @param columnas - Los nombres de las columnas de un conjunto de datos a asignar
	 */
	public void setColumnas(String[] columnas) {
		this.columnas = columnas;
	}

	/**
	 * Retorna el número de filas del conjunto de datos cargado
	 * @return - Número de filas del conjunto de datos cargado
	 */

	public int size()
	{
		return rows.size();
	}

	/**
	 * Retorna la instancia del conjunto de datos correspondiente a su fila de índice i
	 * @param i - Índice de fila del conjunto de datos.
	 * @return - Instancia de fila de índice i del conjunto de datos cargado
	 */
	public ArrayList<Atributo> getInstancia(int i)
	{
		return rows.get(i).getInst_();
	}

	/**
	 * Retorna el número de atributos del conjunto de datos cargado
	 * @return - número de atributos del conjunto de datos cargado
	 */
	public int numero_de_atributos()
	{
		return columnas.length;
	}

	/**
	 * Retorna el nombre del atributo de la columna i del conjunto de datos
	 * @param i - Índice de columna del conjunto de datos.
	 * @return - Nombre de atributo de la columna i del conjunto de datos cargado
	 */

	public String getNombreAtributo(int i)
	{
		return columnas[i];
	}

	/**
	 * Retorna una columna y sus datos guardados del conjunto de datos cargado
	 * @param index - Índice de columna a retornar
	 * @return - Columna de índice i y sus datos
	 */

	public ArrayList<String> getColumna(int index){
		ArrayList<String> aux=new ArrayList<String>();
		for(int i=0; i<rows.size(); i++){
			aux.add(rows.get(i).getValorItem(index));
		}
		return aux;
	}

}
