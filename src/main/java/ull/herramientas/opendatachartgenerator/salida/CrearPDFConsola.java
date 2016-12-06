package ull.herramientas.opendatachartgenerator.salida;

import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
/**
 * \class CrearPDFConsola
 *	\brief Clase que crea y configura un documento pdf 
 * para imprirmir los datos
 * \author Orlandy Ariel Sánchez A.
 */
public class CrearPDFConsola implements ICrearPDF
{
	private int m_ancho;
	private int m_alto;
	private Document m_documento;
	private PdfWriter m_escribe;
	private String m_nombreFichero;
	private String m_datos;
	
	public CrearPDFConsola(String a_datos,String a_nombreFichero)
	{
		m_datos = a_datos;
		m_nombreFichero = a_nombreFichero;
		initComponent();
	}
	
	private void initComponent()
	{
		m_ancho = 870;
		m_alto = 500;
		m_escribe = null;
		m_documento = new Document();
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
			contentByte.addTemplate(template, 0, 0);
			m_documento.add(new Paragraph(m_datos));

		} catch (Exception e) {
			e.printStackTrace();
		}
		m_documento.close();
	}

}
