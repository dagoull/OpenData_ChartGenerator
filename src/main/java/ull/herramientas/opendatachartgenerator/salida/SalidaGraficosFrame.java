package ull.herramientas.opendatachartgenerator.salida;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

/**
 * 
 * @author orlan
 *
 */
public class SalidaGraficosFrame
{//ATRIBUTOS
	private JRadioButton m_RBtnGraficoBarra;
	private JRadioButton m_RBtnGraficoPastel;
	private JRadioButton m_RBtnConsola;
	private JRadioButton m_RBtnPDF;
	private ButtonGroup m_BGrupoRadio;
	
	private IGenerarSalida m_salida;
	
	private JFrame m_Ventana;
	//CONSTRUCTOR/ES Y MÉTODOS
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
	 * Método para configurar y añadir los componentes a la ventana
	 */
	private void initVentana()
	{
		m_Ventana = new JFrame("Salida");
		m_Ventana.getContentPane().setLayout(new BoxLayout(m_Ventana.getContentPane(),BoxLayout.Y_AXIS));
		m_Ventana.setLocationRelativeTo(null);
		m_Ventana.setSize(400,300);
		m_Ventana.setVisible(true);
		m_Ventana.add(m_RBtnGraficoBarra);
		m_Ventana.add(m_RBtnGraficoPastel);
		m_Ventana.add(m_RBtnConsola);
		m_Ventana.add(m_RBtnPDF);
	}
	/**
	 * Método para inicializar y configurar los radios.
	 */
	private void initRadioButton()
	{
		m_RBtnGraficoBarra = new JRadioButton("Gráfico de Barra");
		m_RBtnGraficoBarra.setVisible(true);
		
		m_RBtnGraficoPastel = new JRadioButton("Gráfico de Pastel");
		m_RBtnGraficoPastel.setVisible(true);
		
		m_RBtnConsola = new JRadioButton("Consola");
		m_RBtnConsola.setVisible(true);
		
		m_RBtnPDF = new JRadioButton("PDF");
		m_RBtnPDF.setVisible(true);
		
		m_BGrupoRadio = new ButtonGroup();
		
		m_BGrupoRadio.add(m_RBtnGraficoBarra);
		m_BGrupoRadio.add(m_RBtnGraficoPastel);
		m_BGrupoRadio.add(m_RBtnConsola);
		m_BGrupoRadio.add(m_RBtnPDF);
	}
}
