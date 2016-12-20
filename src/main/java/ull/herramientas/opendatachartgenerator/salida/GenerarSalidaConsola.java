package ull.herramientas.opendatachartgenerator.salida;

import java.util.ArrayList;
import java.util.logging.Logger;

import ull.herramientas.opendatachartgenerator.Dataset;
import ull.herramientas.opendatachartgenerator.Instancia;
/**
 * 
 * \class GenerarSalidaConsola
 * \brief clase encargarda de mostrar un informe de los turistas
 * este informe se mostrará por la consola, en ella mostrará
 * tuplas con la información barrio, numero de mujeres, numero de hombres
 * 
 * \author Orlandy Ariel Sánchez A.
 *
 */
public class GenerarSalidaConsola implements IGenerarSalida
{
	private Dataset mDataset;
	private StringBuilder mSalida;
	private final Logger mlogConsola = Logger.getLogger(""); /// Salida por consola.
	/**
	 * \brief Constructor que recibe un dataset
	 * \param aDataset, dataset que contiene la información a representar.
	 */
	public GenerarSalidaConsola(Dataset aDataset)
	{
		mDataset = aDataset;
		mSalida = new StringBuilder("BARRIOS \t\t\tNºMujeres \t\tNºHombres\n");
		configurarSalida();
	}
	/**
	 * \brielf método que configura el texto que para su posterior representación.
	 */
	private void configurarSalida()
	{
		ArrayList<String> tBarrios= mDataset.getColumna(2);
		
		for (int i = 0; i < tBarrios.size(); i++)
		{
			ArrayList<Instancia> tArrInstancias=mDataset.getRows();
			
				mSalida.append(tBarrios.get(i)+"\t\t\t"+tArrInstancias.get(i).getValorItem(48)+"\t\t"+tArrInstancias.get(i).getValorItem(26)+"\n");
		}
	}
	@Override
	public void salidaGrafica()
	{
		mlogConsola.log(null,mSalida.toString());
	}
	@Override
	public  StringBuilder salidaPDF()
	{
		return mSalida;
	}

}
