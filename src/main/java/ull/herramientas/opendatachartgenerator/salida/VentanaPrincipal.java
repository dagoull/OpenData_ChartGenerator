package ull.herramientas.opendatachartgenerator.salida;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import ull.herramientas.opendatachartgenerator.Dataset;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

/**
 * Ventana principal de la aplicación
 * @author Mauricio
 *
 */
public class VentanaPrincipal {

	private JFrame frame;
	private JTextField urlConjunto;

	/**
	 * Lanza la aplicación.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea la aplicación.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Inicializa los contenidos del frame.
	 */
	private void initialize() {
		//Creación de ventana
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
        //Creación de título de aplicación
		JLabel lblOpenDataChart = new JLabel("Open Data Chart Generator");
		lblOpenDataChart.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblOpenDataChart.setBounds(67, 55, 357, 28);
		frame.getContentPane().add(lblOpenDataChart);
        //Creación de campo de texto para URLs de conjuntos de datos
		urlConjunto = new JTextField();
		urlConjunto.setBounds(116, 139, 219, 20);
		frame.getContentPane().add(urlConjunto);
		urlConjunto.setColumns(10);
        //Creación de botón para procesar una url introducida
		JButton btnProcesarConjuntoDe = new JButton("Procesar conjunto de datos");
		btnProcesarConjuntoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dataset dataset;
				try {
					//Se extrae y almacenan los datos del conjunto del url en un objeto de clase Dataset
					dataset = new Dataset(urlConjunto.getText());
					//Se crea la ventana de selección de gráficos de la información del conjunto de datos
					SalidaGraficosFrame seleccion_graficos = new SalidaGraficosFrame(dataset);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnProcesarConjuntoDe.setBounds(132, 184, 193, 23);
		frame.getContentPane().add(btnProcesarConjuntoDe);

		//Creación de texto descriptivo de campo de introducción de URL de conjunto de datos
		JLabel lblUrlDeConjunto = new JLabel("URL de conjunto de datos");
		lblUrlDeConjunto.setBounds(156, 114, 149, 14);
		frame.getContentPane().add(lblUrlDeConjunto);
	}
}
