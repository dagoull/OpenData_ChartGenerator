package ull.herramientas.opendatachartgenerator.salida;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class GenerarSalidaGraficoPastel implements IGenerarSalida
{
	// ATRIBUTOS
	private DefaultPieDataset m_dataset;
	private List<List<String>> m_lista;
	private JFreeChart m_salida;

	// CONSTRUCTOR/ES Y METODOS
	public GenerarSalidaGraficoPastel(List<List<String>> arrayList)
	{
		m_lista = arrayList;
		configurarDataSet();
	}

	/**
	 * \brief Método configurar el DataSet
	 */
	private void configurarDataSet()
	{
		m_dataset = new DefaultPieDataset();

		for (int i = 0; i < m_lista.get(0).size(); i++)
		{
			m_dataset.setValue(m_lista.get(0).get(i), i);
		}
	}

	@Override
	public void salida()
	{
		JFreeChart chart = ChartFactory.createPieChart("Grafico de Pastel", m_dataset, true, true, false);
		// Mostrar Grafico
		ChartFrame frame = new ChartFrame("Pastel", chart);
		frame.pack();
		frame.setVisible(true);
	}

}
