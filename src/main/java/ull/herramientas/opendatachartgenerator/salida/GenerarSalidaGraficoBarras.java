package ull.herramientas.opendatachartgenerator.salida;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * \class SalidaGraficosFrame \brief Clase que genera las salidas en grafico de
 * barras \author Orlandy Ariel Sánchez A.
 * 
 */
public class GenerarSalidaGraficoBarras implements IGenerarSalida
{ // ATRIBUTOS
	private DefaultCategoryDataset m_dataset;
	private List<List<String>> m_lista;
	private JFreeChart m_salida;

	// CONSTRUCTOR/ES Y METODOS
	public GenerarSalidaGraficoBarras(List<List<String>> arrayList)
	{
		m_lista = arrayList;
		configurarDataSet();
	}

	/**
	 * \brief Método configurar el DataSet
	 */
	private void configurarDataSet()
	{
		m_dataset = new DefaultCategoryDataset();
		for (int i = 0; i < m_lista.get(0).size(); i++)
		{
			m_dataset.addValue(i, "ayer", m_lista.get(0).get(i));
		}
		for (int i = 1; i < m_lista.get(0).size(); i++)
		{
			for (int j = 0; j < m_lista.get(i).size(); j++)
			{
				m_dataset.addValue(j, "ayer", m_lista.get(i).get(j));
			}
		}
	}

	@Override
	public JFreeChart salida()
	{
		m_salida = ChartFactory.createBarChart(
				"Playas de Tenerife", "Playa", "Turistas", m_dataset, PlotOrientation.VERTICAL, true, false, false
		);
		ChartFrame a = new ChartFrame("hola", m_salida);
		a.setVisible(true);
		a.setSize(500, 500);
		return m_salida;
	}

}
