package ull.herramientas.opendatachartgenerator.salida;
/**
 * \class CrearPDFConsola
 *	\brief Clase que crea y configura un documento pdf 
 * para imprirmir los datos
 * \author Orlandy Ariel Sánchez A.
 */
public class CrearPDFConsola extends CrearPDF
{
	public CrearPDFConsola(String aDatos,String aNombreFichero)
	{
		super(null,aDatos, aNombreFichero,500,870,false);
	}
}
