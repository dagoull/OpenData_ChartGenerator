package ull.herramientas.opendatachartgenerator.salida;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 * Pruebas para la visualización de las playas
 * Datos ficticios
 * @author Orlandy Ariel Sánchez A.
 *
 */
public class GraficoDeBarras {

    public static void main(String[] args) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        System.out.println("hola taiga");
        dataset.setValue(100, "2014", "Playa Jardín");
        dataset.setValue(500, "2015", "Playa Jardín");
        dataset.setValue(400, "2016", "Playa Jardín");
        
        dataset.setValue(200, "2014", "Playa Chica ");
        dataset.setValue(100, "2015", "Playa Chica ");
        dataset.setValue(110, "2016", "Playa Chica ");
        
        dataset.setValue(315, "2014", "Playa de Bajamar");
        dataset.setValue(150, "2015", "Playa de Bajamar");
        dataset.setValue(300, "2016", "Playa de Bajamar");
        
        dataset.setValue(50, "2014", "Playa de Arenisco");
        dataset.setValue(20, "2015", "Playa de Arenisco");
        dataset.setValue(100, "2016", "Playa de Arenisco");
        
        dataset.setValue(500, "2014", "Playa de Almáciga");
        dataset.setValue(290, "2015", "Playa de Almáciga");
        dataset.setValue(300, "2016", "Playa de Almáciga");
        
        dataset.setValue(600, "2014", "Playa de Ajobo");
        dataset.setValue(800, "2015", "Playa de Ajobo");
        dataset.setValue(500, "2016", "Playa de Ajobo");
        
        JFreeChart chart = ChartFactory.createBarChart(
                "Playas de Tenerife",
                "Playa", 
                "Turistas", 
                dataset, 
                PlotOrientation.VERTICAL,
                true, 
                false, 
                false
        );
        
        //Mostramos la grafica en pantalla
        ChartFrame frame = new ChartFrame("Ejemplo Grafica de Barras", chart);
        frame.setSize(1000,700);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}