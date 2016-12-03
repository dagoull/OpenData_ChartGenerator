package ull.herramientas.opendatachartgenerator.salida;

import java.text.DecimalFormat;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import ull.herramientas.opendatachartgenerator.Dataset;
import ull.herramientas.opendatachartgenerator.Instancia;

public class GenerarSalidaGraficoPastel implements IGenerarSalida
{
	// ATRIBUTOS
	private DefaultPieDataset m_datasetChartPie;
	private JFreeChart m_salida;
	private Dataset m_datasetN;

	// CONSTRUCTOR/ES Y METODOS
	public GenerarSalidaGraficoPastel(Dataset a_dataset)
	{
		m_datasetN = a_dataset;
		configurarDataSet();
		salidaPDF();
	}

	/**
	 * \brief Método configurar el DataSet
	 */
	private void configurarDataSet()
	{
		m_datasetChartPie = new DefaultPieDataset();

		ArrayList<String> t_barrios = m_datasetN.getColumna(2);

		for (int i = 0; i < t_barrios.size(); i++)
		{
			ArrayList<Instancia> t_arrInstancias = m_datasetN.getRows();
			for (int j = 0; j < t_arrInstancias.size(); j++)
			{
				Instancia t_instancia = t_arrInstancias.get(i);
				Double t_totalTuristasPorBarrio = Double.parseDouble(t_instancia.getValorItem(26))
						+ Double.parseDouble(t_instancia.getValorItem(48));
				Double t_porcentajePorBarrio = t_totalTuristasPorBarrio / 100;
				m_datasetChartPie.setValue(t_barrios.get(i), t_porcentajePorBarrio);
			}
		}
	}

	@Override
	public void salidaGrafica()
	{

		// Mostrar Grafico
		ChartFrame graficoChartFrame = new ChartFrame("Pastel", m_salida);
		graficoChartFrame.setVisible(true);
		graficoChartFrame.setSize(1300, 1000);
	}

	@Override
	public JFreeChart salidaPDF()
	{
		m_salida = ChartFactory.createPieChart("Gráfico de Pastel", m_datasetChartPie, true, true, false);

		PiePlot plot = (PiePlot) m_salida.getPlot();// añade el porcetaje a la
													// etiqueta
		plot.setSimpleLabels(true);
		PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
				"{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%")
		);// Formatea el porcentaje
		plot.setLabelGenerator(gen);
		return m_salida;
	}

}
