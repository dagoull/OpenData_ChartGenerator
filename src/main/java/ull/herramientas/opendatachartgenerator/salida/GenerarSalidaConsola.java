package ull.herramientas.opendatachartgenerator.salida;

import java.util.ArrayList;

import ull.herramientas.opendatachartgenerator.Dataset;
import ull.herramientas.opendatachartgenerator.Instancia;
/**
 * 
 * \class GenerarSalidaConsola
 * \brief clase encargarda de mostrar un informe de los turistas
 * este informe se mostrará por la consola, en ella mostrará
 * tuplas con la información barrio, numero de mujeres, numero de hombres
 * 
 * \author Orlandy Ariel Sánchez A.
 *
 */
public class GenerarSalidaConsola implements IGenerarSalida
{
	private Dataset m_dataset;
	private String m_salida;
	/**
	 * \brief Constructor que recibe un dataset
	 * \param a_dataset, dataset que contiene la información a representar.
	 */
	public GenerarSalidaConsola(Dataset a_dataset)
	{
		m_dataset = a_dataset;
		m_salida = "BARRIOS \t\t\tNºMujeres \t\tNºHombres\n";
		configurarSalida();
	}
	/**
	 * \brielf método que configura el texto que para su posterior representación.
	 */
	private void configurarSalida()
	{
		ArrayList<String> t_barrios= m_dataset.getColumna(2);
		
		for (int i = 0; i < t_barrios.size(); i++)
		{
			ArrayList<Instancia> t_arrInstancias=m_dataset.getRows();
			
				m_salida+=t_barrios.get(i)+"\t\t\t"+t_arrInstancias.get(i).getValorItem(48)+"\t\t"+t_arrInstancias.get(i).getValorItem(26)+"\n";
		}
	}
	@Override
	public void salidaGrafica()
	{
		System.out.println(m_salida);
	}
	@Override
	public  String salidaPDF()
	{
		return m_salida;
	}

}
