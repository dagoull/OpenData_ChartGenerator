package ull.herramientas.opendatachartgenerator;

public class App {
	public static void main(String[] args) {
		Atributo A = new Atributo("Joel", "Nombre");
		Atributo B = new Atributo("24", "Edad");
		Atributo C = new Atributo("Tlf");

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

