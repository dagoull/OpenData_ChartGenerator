package ull.herramientas.opendatachartgenerator.salida;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

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
	private List<List<String>> m_lista;
	private Dataset m_datasetN;
	private JFreeChart m_salida;

	// CONSTRUCTOR/ES Y METODOS
	public GenerarSalidaGraficoBarras(Dataset a_data)
	{
		m_datasetN = a_data;
		configurarDataSetPropio();
	}

	/**
	 * \brief Método configurar el DataSet
	 */

	//cambiar nombre de este método
	private void configurarDataSetPropio()
	{
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
	}

	@Override
	public void salida()
	{
		m_salida = ChartFactory.createBarChart(
				"Playas de Tenerife", "Playa", "Turistas", m_datasetChar, PlotOrientation.VERTICAL, true, false, false
		);
		ChartFrame graficoChartFrame = new ChartFrame("Grafico de Barras", m_salida);
		
		CategoryPlot t_plot = m_salida.getCategoryPlot();
		CategoryAxis t_xAxis= t_plot.getDomainAxis();
		t_xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);//cambia la orientación de las etiquetas
		
		graficoChartFrame.setVisible(true);
		graficoChartFrame.setSize(1300, 1000);
	}

}
