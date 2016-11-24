package ull.herramientas.opendatachartgenerator.salida;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 * 
 * @author Orlandy Ariel Sánchez A.
 * 
 */
public class GenerarSalidaGraficoBarras implements IGenerarSalida
{	//ATRIBUTOS
	private DefaultCategoryDataset m_dataset = new DefaultCategoryDataset();
	private List<String> m_lista;
	private JFreeChart m_salida;
	//CONSTRUCTOR/ES Y METODOS
	public GenerarSalidaGraficoBarras(List<String> a_lista)
	{
		m_lista = a_lista;
		configurarDataSet();
	}
	/**
	 * Método configurar el DataSet
	 */
	private void configurarDataSet()
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
	}
	@Override
	public JFreeChart salida()
	{
		return m_salida;
	}

}
