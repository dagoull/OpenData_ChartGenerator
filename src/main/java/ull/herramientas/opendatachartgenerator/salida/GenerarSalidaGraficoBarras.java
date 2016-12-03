package ull.herramientas.opendatachartgenerator.salida;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import ull.herramientas.opendatachartgenerator.Dataset;
import ull.herramientas.opendatachartgenerator.Instancia;

/**
 * \class SalidaGraficosFrame \brief Clase que genera las salidas en grafico de
 * barras \author Orlandy Ariel Sánchez A.
 * 
 */
public class GenerarSalidaGraficoBarras implements IGenerarSalida
{ // ATRIBUTOS
	private DefaultCategoryDataset m_datasetChar;
	private List<List<String>> m_lista;
	private Dataset m_datasetN;
	private JFreeChart m_salida;

	// CONSTRUCTOR/ES Y METODOS
	public GenerarSalidaGraficoBarras(List<List<String>> arrayList)
	{
		m_lista = arrayList;
		//configurarDataSet();
		configurarDataSetPropio();
	}
	public GenerarSalidaGraficoBarras(Dataset a_data)
	{
		m_datasetN = a_data;
	}

	/**
	 * \brief Método configurar el DataSet
	 */
	private void configurarDataSet()
	{
		m_datasetChar = new DefaultCategoryDataset();
		for (int i = 0; i < m_lista.get(0).size(); i++)
		{
			m_datasetChar.addValue(i, "ayer", m_lista.get(0).get(i));
		}
		for (int i = 1; i < m_lista.get(0).size(); i++)
		{
			for (int j = 0; j < m_lista.get(i).size(); j++)
			{
				m_datasetChar.addValue(j, "ayer", m_lista.get(i).get(j));
			}
		}
	}
	//cambiar nombre de este método
	private void configurarDataSetPropio()
	{
		try
		{
			m_datasetN = new Dataset("http://www.santacruzdetenerife.es/opendata/dataset/8363b662-0bdc-47e1-b9f6-65b536714f29/resource/ee814891-ba52-4e7c-b9e6-017c1bc43b6b/download/barrios.csv");
		} catch (MalformedURLException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		m_datasetChar = new DefaultCategoryDataset();
		ArrayList<String> t_barrios= m_datasetN.getColumna(2);
		
		for (int i = 0; i < t_barrios.size(); i++)
		{
			ArrayList<Instancia> t_arrInstancias=m_datasetN.getRows();
			for (int j = 0; j < t_arrInstancias.size(); j++)
			{
				Instancia t_instancia = t_arrInstancias.get(i);
				
				m_datasetChar.addValue(Integer.parseInt(t_instancia.getValorItem(26))+0,m_datasetN.getNombreAtributo(26), t_barrios.get(i));//Hombres
				m_datasetChar.addValue(Integer.parseInt(t_instancia.getValorItem(48)),m_datasetN.getNombreAtributo(48), t_barrios.get(i));//Mujeres
			}
		}
	}

	@Override
	public JFreeChart salida()
	{
		m_salida = ChartFactory.createBarChart(
				"Playas de Tenerife", "Playa", "Turistas", m_datasetChar, PlotOrientation.HORIZONTAL, true, false, false
		);
		ChartFrame a = new ChartFrame("Grafico de Barras", m_salida);
		a.setVisible(true);
		a.setSize(1000, 1000);
		return m_salida;
	}

}
