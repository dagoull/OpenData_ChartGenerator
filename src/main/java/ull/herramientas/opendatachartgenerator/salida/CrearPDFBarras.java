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
 * \class CrearPDFBarras
 *	\brief Clase que crea y configura un documento pdf 
 * para imprirmir los datos del gráfico de barras
 * \author Orlandy Ariel Sánchez A.
 */
public class CrearPDFBarras implements ICrearPDF
{
	private int m_ancho;
	private int m_alto;
	private JFreeChart m_grafico;
	private Document m_documento;
	private PdfWriter m_escribe;
	private String m_nombreFichero;
	/**
	 * \brief Constructor
	 * \param a_grafico, gráfico para imprimir en pdf
	 * \param a_nombreFichero, ruta del archivo donde se guardará
	 */
	public CrearPDFBarras(JFreeChart a_grafico, String a_nombreFichero)
	{
		m_grafico = a_grafico;
		m_nombreFichero = a_nombreFichero;
		initComponent();
	}
	/**
	 * \brief Método qeu inicializa los distintos atributos.
	 */
	private void initComponent()
	{
		m_ancho = 870;
		m_alto = 500;
		m_escribe = null;
		m_documento = new Document(PageSize.A4.rotate());/// Rota la página para poder representar mejor el gráfico
	}

	@Override
	public void escribirGraficoEnPDF()
	{
		try {
			m_escribe = PdfWriter.getInstance(m_documento, new FileOutputStream(
					m_nombreFichero));
			m_documento.open();
			
			PdfContentByte contentByte = m_escribe.getDirectContent();
			PdfTemplate template = contentByte.createTemplate(m_ancho, m_alto);
			Graphics2D graphics2d = template.createGraphics(m_ancho, m_alto,
					new DefaultFontMapper());
			Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, m_ancho, m_alto);

			m_grafico.draw(graphics2d, rectangle2d);
			
			graphics2d.dispose();
			contentByte.addTemplate(template, 0, 0);
			Paragraph texto = new Paragraph("Gráfico de Barras, representa los datos del turismo por barrio de Tenerife");
			m_documento.add(new Paragraph(texto));

		} catch (Exception e) {
			e.printStackTrace();
		}
		m_documento.close();
	}

}
