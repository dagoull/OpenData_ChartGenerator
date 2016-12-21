package ull.herramientas.opendatachartgenerator;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Lector de ficheros de conjuntos de datos de formato .csv
 * @author Mauricio
 *
 */
public class Readercsv extends IReader{

	public Readercsv() {
		super();
	}

	@Override
	public ArrayList<Instancia> leerTodo(InputStream is) {
		Scanner rd = new Scanner(is);
		nombres_atributos = null;
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
}
