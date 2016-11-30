package ull.herramientas.opendatachartgenerator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class Dataset {
	private IReader reader;
	private ArrayList<Instancia> rows;
	private String[] columnas;

	public Dataset(String url) throws MalformedURLException, IOException
	{
		this.reader =  new Reader();
		this.rows = new ArrayList<Instancia>();
		this.rows = reader.leerdeURL(url);
		this.columnas = reader.getNombres_atributos();
	}

	/**
	 * @return the reader
	 */
	public IReader getReader() {
		return reader;
	}

	/**
	 * @param reader the reader to set
	 */
	public void setReader(IReader reader) {
		this.reader = reader;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<Instancia> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Instancia> rows) {
		this.rows = rows;
	}

	/**
	 * @return the columnas
	 */
	public String[] getColumnas() {
		return columnas;
	}

	/**
	 * @param columnas the columnas to set
	 */
	public void setColumnas(String[] columnas) {
		this.columnas = columnas;
	}

	public int size()
	{
		return rows.size();
	}

	public ArrayList<Atributo> getInstancia(int i)
	{
		return rows.get(i).getInst_();
	}

	public int numero_de_atributos()
	{
		return columnas.length;
	}

	public String getNombreAtributo(int i)
	{
		return columnas[i];
	}
	
	public ArrayList<String> getColumna(int index){
		ArrayList<String> aux=new ArrayList<String>();
		for(int i=0; i<rows.size(); i++){
			aux.add(rows.get(i).getValorItem(index));
		}
		return aux;
	}

}
