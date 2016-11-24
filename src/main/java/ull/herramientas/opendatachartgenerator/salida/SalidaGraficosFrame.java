package ull.herramientas.opendatachartgenerator.salida;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

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
	private JRadioButton m_RBtnPDF;
	private ButtonGroup m_BGrupoRadio;
	private JButton m_BtnGenerar;
	private IGenerarSalida m_salida;

	private JFrame m_Ventana;

	// CONSTRUCTOR/ES Y MÉTODOS
	public SalidaGraficosFrame()
	{
		initComponet();
	}

	public static void main(String[] args)
	{
		new SalidaGraficosFrame();
	}

	private void initComponet()
	{
		initRadioButton();
		initVentana();
	}

	/**
	 * \brief Método para configurar y añadir los componentes a la ventana
	 */
	private void initVentana()
	{
		m_Ventana = new JFrame("Salida");
		m_Ventana.getContentPane().setLayout(new BoxLayout(m_Ventana.getContentPane(), BoxLayout.Y_AXIS));
		m_Ventana.setLocationRelativeTo(null);
		m_Ventana.setSize(400, 300);
		m_Ventana.setVisible(true);
		m_Ventana.add(m_RBtnGraficoBarra);
		m_Ventana.add(m_RBtnGraficoPastel);
		m_Ventana.add(m_RBtnConsola);
		m_Ventana.add(m_RBtnPDF);

		configBoton();
		m_Ventana.add(m_BtnGenerar);
	}

	/**
	 * \brief Método para configurar botón de generar
	 */
	private void configBoton()
	{
		m_BtnGenerar = new JButton("Generar");
		m_BtnGenerar.setVisible(true);
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
						actionPerformedJFreeChart(new GenerarSalidaGraficoBarras(new ArrayList<>()));
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
						actionPerformedJFreeChart(new GenerarSalidaGraficoBarras(new ArrayList<>()));
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
						actionPerformedJFreeChart(new GenerarSalidaGraficoBarras(new ArrayList<>()));
					}
				}
		);

		m_RBtnPDF = new JRadioButton("PDF");
		m_RBtnPDF.setVisible(true);
		m_RBtnPDF.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						actionPerformedJFreeChart(new GenerarSalidaGraficoBarras(new ArrayList<>()));
					}
				}
		);
		m_BGrupoRadio = new ButtonGroup();

		m_BGrupoRadio.add(m_RBtnGraficoBarra);
		m_BGrupoRadio.add(m_RBtnGraficoPastel);
		m_BGrupoRadio.add(m_RBtnConsola);
		m_BGrupoRadio.add(m_RBtnPDF);
	}

	private void actionPerformedJFreeChart(IGenerarSalida a_salida)
	{
		m_salida = a_salida;
		m_salida.salida();
	}
}
