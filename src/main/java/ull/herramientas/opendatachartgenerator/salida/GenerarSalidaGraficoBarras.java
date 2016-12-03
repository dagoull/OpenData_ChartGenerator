package ull.herramientas.opendatachartgenerator.salida;

import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
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
	private Dataset m_datasetN;
	private JFreeChart m_salida;

	// CONSTRUCTOR/ES Y METODOS
	public GenerarSalidaGraficoBarras(Dataset a_data)
	{
		m_datasetN = a_data;
		
		configurarDatasetChart();
		salidaPDF();
		
	}
	/**
	 * \brief Método configurar el Dataset que se le pasará al gráfico.
	 */
	private void configurarDatasetChart()
	{
		/*Thread hilo= new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{*/
				m_datasetChar = new DefaultCategoryDataset();
				ArrayList<String> t_barrios= m_datasetN.getColumna(2);
				
				for (int i = 0; i < t_barrios.size(); i++)
				{
					ArrayList<Instancia> t_arrInstancias=m_datasetN.getRows();
					for (int j = 0; j < t_arrInstancias.size(); j++)
					{
						Instancia t_instancia = t_arrInstancias.get(i);
						
						m_datasetChar.addValue(Double.parseDouble(t_instancia.getValorItem(26)),m_datasetN.getNombreAtributo(26), t_barrios.get(i));//Hombres
						m_datasetChar.addValue(Double.parseDouble(t_instancia.getValorItem(48)),m_datasetN.getNombreAtributo(48), t_barrios.get(i));//Mujeres
					}
				}
				/*m_salida.notify();
				
				}
		});
		hilo.start();*/
		
	}
	@Override
	public void salidaGrafica()
	{
		ChartFrame graficoChartFrame = new ChartFrame("Grafico de Barras", m_salida);
		
		graficoChartFrame.setVisible(true);
		graficoChartFrame.setSize(1300, 1000);
	}
	@Override
	public JFreeChart salidaPDF()
	{
		m_salida = ChartFactory.createBarChart(
				"Gráfico de Barras", "Playa", "Turistas", m_datasetChar, PlotOrientation.VERTICAL, true, false, false
		);
		CategoryPlot t_plot = m_salida.getCategoryPlot();
		CategoryAxis t_xAxis= t_plot.getDomainAxis();
		t_xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);//cambia la orientación de las etiquetas
		return m_salida;
	}
}
