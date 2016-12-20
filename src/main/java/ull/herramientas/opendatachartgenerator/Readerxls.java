package ull.herramientas.opendatachartgenerator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * \class Clase Readerxls que lee ficheros de formato xls (Excel hasta la version 2007)
 * @author Ángel
 *
 */
public class Readerxls implements IReader {
	private ArrayList<Instancia> instancias;
	private String[] nombres_atributos;

	public Readerxls() {
		this.instancias = new ArrayList<Instancia>();
	}

	@Override
	public ArrayList<Instancia> leerTodo(InputStream is) {

		/**
		 * \brief Inicializamos dos arraylists que nos serviran para almacenar la informacion del dataset
		 */
		ArrayList<String> names=new ArrayList<String>();
		ArrayList<String> values=new ArrayList<String>();
		
		/**
		 * \brief Ademas de una variable que indicara si la columna que estamos recorriendo es la primera o no
		 */
		int i = 0;

		/**
		 * \brief Utilizaremos una variable workbook especial para leer el fichero excel
		 */
		HSSFWorkbook workbook=null;
		try {
			workbook = new HSSFWorkbook(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		HSSFSheet sheet = workbook.getSheetAt(0);
		/**
		 * \brief Comenzamos a recorrer el fichero por filas (instancias)
		 */
		Iterator<Row> rowIterator = sheet.iterator();
		String[]valores=null;
		Row row;

		while (rowIterator.hasNext()) {

			row = rowIterator.next();

			/**
			 * \brief Y dentro de cada fila recorremos cada celda, la cual almacena un atributo de la instancia
			 */
			Iterator<Cell> cellIterator = row.cellIterator();

			Cell celda;
			
			/**
			 * \brief Si la fila que recorremos es la primera, almacenaremos los nombres de los atributos en el arraylist names
			 */
			if (i == 0) {
				while (cellIterator.hasNext()) {
					celda = cellIterator.next();
					names.add(celda.getStringCellValue());
				}
				i++;
				/**
				 * \brief Pasamos los datos almacenados a un array de string para utilizarlo posteriormente
				 */
				nombres_atributos= new String[names.size()];
				for(int index=0;index<names.size();index++){
					nombres_atributos[index]=names.get(index);
				}
				
			/**
			 * \brief En caso contrario se almacenaran los atributos en el arraylist values
			 */
			}else{
				while (cellIterator.hasNext()) {
					celda=cellIterator.next();
					if(celda.getCellType()==Cell.CELL_TYPE_NUMERIC){
						values.add(String.valueOf(celda.getNumericCellValue()));
					}else
						values.add(celda.getStringCellValue());	
				}
				
				/**
				 * \brief Pasamos los datos almacenados a un array de string para utilizarlo posteriormente
				 */
				valores=new String[values.size()];
				
				for(int index3=0;index3<values.size();index3++){
					valores[index3]=values.get(index3);
				}
				
				/**
				 *  Los arrays de strings se utilizan entonces para generar los vectores de atributos que crearan las instancias del dataset
				 */
				Atributo[] atr = new Atributo[nombres_atributos.length];
				for (int k = 0; k < nombres_atributos.length; k++) {
					atr[k] = new Atributo(valores[k], nombres_atributos[k]);
			}
				instancias.add(new Instancia(atr));
				values.clear();
			}
		}
		
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
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

	public ArrayList<Instancia> leerDatos(String direccion) throws MalformedURLException, IOException {
		if (isValidURL(direccion)) {
			return leerdeURL(direccion);
		} else {
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

	/**
	 * @return the nombres_atributos
	 */
	public String[] getNombres_atributos() {
		return nombres_atributos;
	}

	/**
	 * @param nombres_atributos
	 *            the nombres_atributos to set
	 */
	public void setNombres_atributos(String[] nombres_atributos) {
		this.nombres_atributos = nombres_atributos;
	}
}
