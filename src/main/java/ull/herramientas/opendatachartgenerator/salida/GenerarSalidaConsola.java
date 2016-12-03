package ull.herramientas.opendatachartgenerator.salida;

import java.util.ArrayList;

import ull.herramientas.opendatachartgenerator.Dataset;
import ull.herramientas.opendatachartgenerator.Instancia;

public class GenerarSalidaConsola implements IGenerarSalida
{
	private Dataset m_dataset;
	private String m_salida;
	
	public GenerarSalidaConsola(Dataset a_dataset)
	{
		m_dataset = a_dataset;
		m_salida = "BARRIOS \t\t\tNºMujeres \t\tNºHombres\n";
		configurarSalida();
	}
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
	public void salida()
	{
		System.out.println(m_salida);
	}

}
