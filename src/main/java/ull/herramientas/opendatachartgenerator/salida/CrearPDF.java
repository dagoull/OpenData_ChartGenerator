package ull.herramientas.opendatachartgenerator.salida;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;

import org.jfree.chart.JFreeChart;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.DefaultFontMapper;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
/**
 * \class CrearPDF
 * \brief Clase abstracta utilizada imprimir en un documento pdf
 * esta clase será común a todas las clases de crear, según el tipo 
 * imprimirá gráficos (de varios tipos) o texto.
 * \author Orlandy Ariel Sánchez A.
 *
 */
public abstract class CrearPDF
{
	private int m_ancho;
	private int m_alto;
	private Document m_documento;
	private PdfWriter m_escribe;
	private String m_nombreFichero;
	private String m_datos;
	private JFreeChart m_grafico;
	/**
	 * \brief Constructor que recibe los datos de configuración de lo que imprimirá
	 * \param aGrafico, Gráfico a imprimir en pdf (siendo null si no existe gráfico).
	 * \param aDatos, Datos a imprimir, en caso de no exista gráfico.
	 * \param aNombreFichero, Nombre del fichero con el que se guardará el pdf
	 * \param aAncho, ancho del documento.(este tamaño se configurará dentro del docuento, que este puede ser mas o menos grande que lo que indica el ancho)
	 * \param aAlto, alto del documento.(este tamaño se configurará dentro del docuento, que este puede ser mas o menos grande que lo que indica el alto)
	 * \param aVertical, indica la orientación en la que se imprimirá el documento
	 */
	public CrearPDF(JFreeChart aGrafico,String aDatos,String aNombreFichero, int aAncho, int aAlto, boolean aVertical)
	{
		m_grafico = aGrafico;
		m_datos = aDatos;
		m_nombreFichero = aNombreFichero;
		m_ancho = aAncho;
		m_alto = aAlto;
		initComponent(aVertical);
	}
	/**
	 * \brief Método que inicalizará los atributos que se necesiten.
	 * \param vertical, indica la orientación en la que se configurará el documento.
	 */
	private void initComponent(boolean vertical)
	{
		if(!vertical)
			m_documento = new Document();
		else
			m_documento = new Document(PageSize.A4.rotate());
		m_escribe = null;
	}
	/**
	 * \brief Método que escribe el dontenido en el documento pdf.
	 */
	public void escribirGraficoEnPDF()
	{
		try {
			m_escribe = PdfWriter.getInstance(m_documento, new FileOutputStream(
					m_nombreFichero));
			m_documento.open();
			
			PdfContentByte contentByte = m_escribe.getDirectContent();
			PdfTemplate template = contentByte.createTemplate(m_ancho, m_alto);
			contentByte.addTemplate(template, 0, 0);
			
			if(m_grafico != null)
			{
				Graphics2D graphics2d = template.createGraphics(m_ancho, m_alto,
						new DefaultFontMapper());
				Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, m_ancho, m_alto);
				m_grafico.draw(graphics2d, rectangle2d);
				graphics2d.dispose();
			}
			else
			{
				m_documento.add(new Paragraph(m_datos));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		m_documento.close();
	}
}
