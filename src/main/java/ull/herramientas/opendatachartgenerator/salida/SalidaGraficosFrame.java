package ull.herramientas.opendatachartgenerator.salida;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import ull.herramientas.opendatachartgenerator.Dataset;

/**
 * \class SalidaGraficosFrame
 * \brief ventana para generar salidas La clase genera la salida
 * dependiendo de la opción elegida por el usuario \author Orlandy Ariel Sánchez A.
 *
 */
public class SalidaGraficosFrame
{// ATRIBUTOS
	private JRadioButton m_RBtnGraficoBarra;
	private JRadioButton m_RBtnGraficoPastel;
	private JRadioButton m_RBtnConsola;
	private ButtonGroup m_BGrupoRadio;
	private JButton m_BtnGenerar;
	private IGenerarSalida m_salida;

	private Dataset m_dataset;
	private JFrame m_Ventana;

	// CONSTRUCTOR/ES Y MÉTODOS
	public SalidaGraficosFrame(Dataset a_dataset)
	{
		m_dataset = a_dataset;
		initComponet();
	}

	public static void main(String[] args) throws MalformedURLException, IOException
	{
		new SalidaGraficosFrame(new Dataset("http://www.santacruzdetenerife.es/opendata/dataset/8363b662-0bdc-47e1-b9f6-65b536714f29/resource/ee814891-ba52-4e7c-b9e6-017c1bc43b6b/download/barrios.csv"));
	}

	private void initComponet()
	{
		initRadioButton();
		configBoton();
		initVentana();
	}

	/**
	 * \brief Método para configurar y añadir los componentes a la ventana
	 */
	private void initVentana()
	{
		m_Ventana = new JFrame("Salida");
		m_Ventana.getContentPane().setLayout(new BoxLayout(m_Ventana.getContentPane(), BoxLayout.Y_AXIS));
		m_Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_Ventana.setLocationRelativeTo(null);
		m_Ventana.setSize(300, 200);
		m_Ventana.setVisible(true);
		m_Ventana.add(m_RBtnGraficoBarra);
		m_Ventana.add(m_RBtnGraficoPastel);
		m_Ventana.add(m_RBtnConsola);
		
		m_Ventana.add(m_BtnGenerar);
	}

	/**
	 * \brief Método para configurar botón de generar
	 */
	private void configBoton()
	{
		m_BtnGenerar = new JButton("Generar");
		m_BtnGenerar.setVisible(true);
		m_BtnGenerar.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						generarPDFPerformedJFreeChart(new GenerarSalidaGraficoBarras(m_dataset));
					}
				}
		);
	}
	/**
	 * \brief Método para inicializar y configurar los radios.
	 */
	private void initRadioButton()
	{
		m_RBtnGraficoBarra = new JRadioButton("Gráfico de Barra");
		m_RBtnGraficoBarra.setVisible(true);
		
		m_RBtnGraficoBarra.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						actionPerformedJFreeChart(new GenerarSalidaGraficoBarras(m_dataset));
					}
				}
		);

		m_RBtnGraficoPastel = new JRadioButton("Gráfico de Pastel");
		m_RBtnGraficoPastel.setVisible(true);
		m_RBtnGraficoPastel.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						actionPerformedJFreeChart(new GenerarSalidaGraficoPastel(m_dataset));
					}
				}
		);
		m_RBtnConsola = new JRadioButton("Consola");
		m_RBtnConsola.setVisible(true);
		m_RBtnConsola.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						actionPerformedJFreeChart(new GenerarSalidaConsola(m_dataset));
					}
				}
		);

		m_BGrupoRadio = new ButtonGroup();

		m_BGrupoRadio.add(m_RBtnGraficoBarra);
		m_BGrupoRadio.add(m_RBtnGraficoPastel);
		m_BGrupoRadio.add(m_RBtnConsola);
	}

	private void generarPDFPerformedJFreeChart(IGenerarSalida generarSalidaGraficoBarras)
	{
		Thread hilo = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				ICrearPDF pdf = null;
				if(m_RBtnGraficoBarra.isSelected())
				{
					pdf = new CrearPDFBarras(m_salida.salidaPDF(), "F:\\informe.pdf");
					
				}
				else if(m_RBtnGraficoPastel.isSelected())
				{
					pdf = new CrearPDFPastel(m_salida.salidaPDF(), "F:\\informe.pdf");
				}
				pdf.escribirGraficoEnPDF();
			}
		});
		hilo.start();
		
	}
	private void actionPerformedJFreeChart(IGenerarSalida a_salida)
	{
		m_salida = a_salida;
		m_salida.salidaGrafica();
	}
}
