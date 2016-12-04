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

import org.jfree.chart.JFreeChart;

import ull.herramientas.opendatachartgenerator.Dataset;

/**
 * \class SalidaGraficosFrame
 * \brief ventana para generar salidas La clase genera la salida
 * dependiendo de la opción elegida por el usuario 
 * \author Orlandy Ariel Sánchez A.
 *
 */
public class SalidaGraficosFrame
{// ATRIBUTOS
	private JRadioButton mRBtnGraficoBarra;
	private JRadioButton mRBtnGraficoPastel;
	private JRadioButton mRBtnConsola;
	private ButtonGroup mBGrupoRadio;
	private JButton mBtnGenerar;
	private IGenerarSalida mSalida;

	private Dataset mDataset;
	private JFrame mVentana;

	// CONSTRUCTOR/ES Y MÉTODOS
	public SalidaGraficosFrame(Dataset aDataset)
	{
		mDataset = aDataset;
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
		mVentana = new JFrame("Salida");
		mVentana.getContentPane().setLayout(new BoxLayout(mVentana.getContentPane(), BoxLayout.Y_AXIS));
		mVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mVentana.setLocationRelativeTo(null);
		mVentana.setSize(300, 200);
		mVentana.setVisible(true);
		mVentana.add(mRBtnGraficoBarra);
		mVentana.add(mRBtnGraficoPastel);
		mVentana.add(mRBtnConsola);
		
		mVentana.add(mBtnGenerar);
	}

	/**
	 * \brief Método para configurar botón de generar
	 */
	private void configBoton()
	{
		mBtnGenerar = new JButton("Generar");
		mBtnGenerar.setVisible(true);
		mBtnGenerar.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						generarPDFPerformedJFreeChart();
					}
				}
		);
	}
	/**
	 * \brief Método para inicializar y configurar los radios.
	 */
	private void initRadioButton()
	{
		mRBtnGraficoBarra = new JRadioButton("Gráfico de Barra");
		mRBtnGraficoBarra.setVisible(true);
		
		mRBtnGraficoBarra.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						actionPerformedJFreeChart(new GenerarSalidaGraficoBarras(mDataset));
					}
				}
		);

		mRBtnGraficoPastel = new JRadioButton("Gráfico de Pastel");
		mRBtnGraficoPastel.setVisible(true);
		mRBtnGraficoPastel.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						actionPerformedJFreeChart(new GenerarSalidaGraficoPastel(mDataset));
					}
				}
		);
		mRBtnConsola = new JRadioButton("Consola");
		mRBtnConsola.setVisible(true);
		mRBtnConsola.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						actionPerformedJFreeChart(new GenerarSalidaConsola(mDataset));
					}
				}
		);
		mBGrupoRadio = new ButtonGroup();
		mBGrupoRadio.add(mRBtnGraficoBarra);
		mBGrupoRadio.add(mRBtnGraficoPastel);
		mBGrupoRadio.add(mRBtnConsola);
	}

	private void generarPDFPerformedJFreeChart()
	{
		Thread hilo = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				CrearPDF pdf = null;
				if(mRBtnGraficoBarra.isSelected())
				{
					pdf = new CrearPDFBarras((JFreeChart)mSalida.salidaPDF(), "F:\\barras.pdf");
					
				}
				else if(mRBtnGraficoPastel.isSelected())
				{
					pdf = new CrearPDFPastel((JFreeChart)mSalida.salidaPDF(), "F:\\pastel.pdf");
					pdf.escribirGraficoEnPDF();
				}
				else if(mRBtnConsola.isSelected())
				{
					pdf= new CrearPDFConsola((String)mSalida.salidaPDF(),"F:\\consola.pdf");
				}
				pdf.escribirGraficoEnPDF();
			}
		});
		hilo.start();
	}
	private void actionPerformedJFreeChart(IGenerarSalida a_salida)
	{
		mSalida = a_salida;
		mSalida.salidaGrafica();
	}
}
