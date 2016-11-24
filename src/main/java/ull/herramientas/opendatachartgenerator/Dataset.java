package ull.herramientas.opendatachartgenerator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class Dataset {
	private IReader reader;
	private ArrayList<Instancia> rows;
	private String columnas;

	public Dataset(String url) throws MalformedURLException, IOException
	{
		this.reader =  new Reader();
		this.rows = new ArrayList<Instancia>();
		this.rows = reader.leerdeURL(url);
	}

}
