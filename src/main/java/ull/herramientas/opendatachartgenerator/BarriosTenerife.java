package ull.herramientas.opendatachartgenerator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class BarriosTenerife {
	private Dataset d_;
	
	public BarriosTenerife(String url) throws MalformedURLException, IOException{
			this.d_=new Dataset(url);
	}
	
	public ArrayList<String> getBarrios(){
		return d_.getColumna(2);
	}
	
}
