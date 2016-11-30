package ull.herramientas.opendatachartgenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;

public interface IReader {

	public ArrayList<Instancia> leerTodo(InputStream is);

	public ArrayList<Instancia> leerdeURL(String url) throws MalformedURLException, IOException;

	public ArrayList<Instancia> leerdeFichero(String string) throws MalformedURLException, IOException;

	public ArrayList<Instancia> leerDatos(String string) throws MalformedURLException, IOException;

	public String[] getNombres_atributos();

	

}
