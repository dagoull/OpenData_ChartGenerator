package ull.herramientas.opendatachartgenerator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class App
{
	public static void main(String[] args) throws MalformedURLException, IOException
	{
	

		Dataset dataset = new Dataset(
				"http://www.santacruzdetenerife.es/opendata/dataset/8363b662-0bdc-47e1-b9f6-65b536714f29/resource/1f86d613-d406-418e-8757-46bea561d9ed/download/barrios.xls",1
		);

		for (int i = 0; i < dataset.numero_de_atributos(); i++){
			System.out.print(dataset.getNombreAtributo(i)+ "  ");
		}
		
		for (int i=1; i < dataset.numero_de_atributos(); i++){
			System.out.print(dataset.getColumna(i)+"  ");
		}
		

//	
//
//		BarriosTenerife b = new BarriosTenerife(
//				"http://www.santacruzdetenerife.es/opendata/dataset/8363b662-0bdc-47e1-b9f6-65b536714f29/resource/ee814891-ba52-4e7c-b9e6-017c1bc43b6b/download/barrios.csv"
//		);
//		ArrayList<String> aux = b.getBarrios();
//		for (int i = 0; i < aux.size(); i++)
//		{
//			System.out.println(aux.get(i));
//		}
//		
		
		
	}
}
