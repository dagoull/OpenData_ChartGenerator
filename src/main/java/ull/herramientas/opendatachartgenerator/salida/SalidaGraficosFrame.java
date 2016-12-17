package ull.herramientas.opendatachartgenerator.salida;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	private String m_rutaGuardarPDF;
	private String m_nombreSalidaFicheroPDF;
	private Dataset mDataset;
	private JFrame mVentana;

	// CONSTRUCTOR/ES Y MÉTODOS
	public SalidaGraficosFrame(Dataset aDataset)
	{
		mDataset = aDataset;
		initComponet();
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
						lanzarExploradorArchivos();
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
						actionPerformedJFreeChart(new GenerarSalidaGraficoBarras(mDataset),"/InformeGraficoDeBarras.PDF");
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
						actionPerformedJFreeChart(new GenerarSalidaGraficoPastel(mDataset),"/InformeGraficoDeBarras.PDF");
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
						actionPerformedJFreeChart(new GenerarSalidaConsola(mDataset),"/InformeConsola.PDF");
					}
				}
		);
		mBGrupoRadio = new ButtonGroup();
		mBGrupoRadio.add(mRBtnGraficoBarra);
		mBGrupoRadio.add(mRBtnGraficoPastel);
		mBGrupoRadio.add(mRBtnConsola);
	}
	private void lanzarExploradorArchivos()
	{
		FicheroSalidaPDFDialog fic=new FicheroSalidaPDFDialog(mVentana);
		fic.setVisible(true);
		generarPDFPerformedJFreeChart(fic.getRuta());
	}
	/**
	 * \brief Método que se invoca cuando se pulse en generar pdf,
	 * este se encargará de generar la salida adecuada.
	 */
	private void generarPDFPerformedJFreeChart(String a_directorio)
	{
		m_rutaGuardarPDF = a_directorio + m_nombreSalidaFicheroPDF;

		CrearPDF pdf = null;
		if (mRBtnGraficoBarra.isSelected())
		{
			pdf = new CrearPDFBarras((JFreeChart) mSalida.salidaPDF(), m_rutaGuardarPDF);
		} else if (mRBtnGraficoPastel.isSelected())
		{
			pdf = new CrearPDFPastel((JFreeChart) mSalida.salidaPDF(), m_rutaGuardarPDF);
		} else if (mRBtnConsola.isSelected())
		{
			pdf = new CrearPDFConsola((String) mSalida.salidaPDF(), m_rutaGuardarPDF);
		}
		pdf.escribirGraficoEnPDF();

	}
	/**
	 * \brief Método que crea la salida según se marquen los JRadioButton
	 * \param a_salida, tipo de salida a generar
	 * \param a_nombreFich, nombre del fichero .pdf
	 */
	private void actionPerformedJFreeChart(IGenerarSalida a_salida, String a_nombreFich)
	{
		m_nombreSalidaFicheroPDF = a_nombreFich;
		mSalida = a_salida;
		mSalida.salidaGrafica();
	}
}
