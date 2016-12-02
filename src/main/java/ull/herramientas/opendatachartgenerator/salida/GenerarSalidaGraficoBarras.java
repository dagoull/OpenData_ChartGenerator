package ull.herramientas.opendatachartgenerator.salida;

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
		m_datasetN= a_data;
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
		m_datasetChar = new DefaultCategoryDataset();
		String [] t_array= m_datasetN.getColumnas();
		for (int i = 0; i < t_array.length; i++)
		{
			ArrayList<Instancia> t_a= m_datasetN.getRows();
			for (int j = 0; j <t_a.size() ; j++)
			{
				Instancia aInst = t_a.get(j);
				m_datasetChar.addValue(Integer.parseInt(aInst.getValorItem(j)),m_datasetN.getNombreAtributo(j).toString(), t_array[i].toString());
			}
		}
	}

	@Override
	public JFreeChart salida()
	{
		m_salida = ChartFactory.createBarChart(
				"Playas de Tenerife", "Playa", "Turistas", m_datasetChar, PlotOrientation.VERTICAL, true, false, false
		);
		ChartFrame a = new ChartFrame("hola", m_salida);
		a.setVisible(true);
		a.setSize(500, 500);
		return m_salida;
	}

}
