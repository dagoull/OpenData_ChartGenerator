package ull.herramientas.opendatachartgenerator.salida;
/**
 * \interface ICrearPDF 
 * \brief intefaz para crear documentos pdf
 * \author Orlandy Ariel Sánchez A.
 *
 */
public interface ICrearPDF
{
	/**
	 * \brief método para escribir en un pdf
	 * este método crea y configura el documento para luego
	 * escribir el contenido deseado.
	 */
	public void escribirGraficoEnPDF();
}
