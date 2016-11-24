package ull.herramientas.opendatachartgenerator.salida;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 * \class SalidaGraficosFrame
 * \brief Clase que genera las salidas en grafico de barras
 * \author Orlandy Ariel Sánchez A.
 * 
 */
public class GenerarSalidaGraficoBarras implements IGenerarSalida
{	//ATRIBUTOS
	private DefaultCategoryDataset m_dataset;
	private List<List <String>> m_lista;
	private JFreeChart m_salida;
	//CONSTRUCTOR/ES Y METODOS
	public GenerarSalidaGraficoBarras(List<List<String>> a_lista)
	{
		m_lista = a_lista;
		configurarDataSet();
	}
	/**
	 * Método configurar el DataSet
	 */
	private void configurarDataSet()
	{
		m_dataset = new DefaultCategoryDataset();
		for (int i = 0; i < m_lista.size(); i++)
		{
			System.out.println("recorrer la estructura de datos");
			m_dataset.addValue(2, "ayer", "playa");
		}
		m_dataset.addValue(2, "ayer", "playa");
		m_dataset.addValue(2, "ayer", "playa");
	}
	@Override
	public JFreeChart salida()
	{
		m_salida = ChartFactory.createBarChart(
                "Playas de Tenerife",
                "Playa", 
                "Turistas", 
                m_dataset, 
                PlotOrientation.VERTICAL,
                true, 
                false, 
                false
        );
		return m_salida;
	}

}
