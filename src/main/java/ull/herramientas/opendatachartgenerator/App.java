package ull.herramientas.opendatachartgenerator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class App {
	public static void main(String[] args) throws MalformedURLException, IOException {
		Atributo A = new Atributo("Joel", "Nombre");
		Atributo B = new Atributo("24", "Edad");
		Atributo C = new Atributo("Tlf");

		IReader reader = new Reader();

		ArrayList<Instancia> dataset = new ArrayList<Instancia>();

		dataset = reader.leerDatos("http://www.santacruzdetenerife.es/opendata/dataset/8363b662-0bdc-47e1-b9f6-65b536714f29/resource/ee814891-ba52-4e7c-b9e6-017c1bc43b6b/download/barrios.csv");

		for (int i = 0; i<dataset.size(); i++)
		{
			for (int j = 0; j<dataset.get(i).size(); j++)
				System.out.print(dataset.get(i).getIdItem(j)+ ", ");
		}


		System.out.println(dataset.size());
		Instancia I = new Instancia();
		I.addAtributo(A);
		I.addAtributo(B);
		I.addAtributo(C);

		for (int i = 0; i < I.size(); i++) {
			System.out.print(I.getIdItem(i) + "\t");
		}

		System.out.println();
		for (int i = 0; i < I.size(); i++) {
			System.out.print(I.getValorItem(i) + "\t");
		}
	}
}

