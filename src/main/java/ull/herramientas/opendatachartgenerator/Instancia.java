package ull.herramientas.opendatachartgenerator;

import java.util.ArrayList;

public class Instancia {
	/**
	 * ArrayList de tipo Atributo
	 */
	private ArrayList<Atributo> inst_;
	
	/**
	 * Constructor que almacenará la instancia
	 */
	public Instancia() {
		super();
		this.inst_ = new ArrayList<Atributo>();
	}
	
	/**
	 * Metodo que retorna la instancia
	 * @return
	 */
	public ArrayList<Atributo> getInst_() {
		return inst_;
	}
	
	/**
	 * Metodo que modifica la instancia
	 * @param inst_
	 */
	public void setInst_(ArrayList<Atributo> inst_) {
		this.inst_ = inst_;
	}
	
	/**
	 * Metodo que añade un atributo a la instancia
	 * @param A
	 */
	public void addAtributo(Atributo A) {
		inst_.add(A);
	}
	
	/**
	 * Metodo que borra un atributo de la instancia
	 * @param A
	 */
	public void removeAtributo(Atributo A) {
		inst_.remove(A);
	}
	
	/**
	 * Metodo que retorna el valor de una posicion
	 * de la instancia
	 * @param pos
	 * @return
	 */
	public String getValorItem(int pos) {
		return inst_.get(pos).getValor();
	}
	
	/**
	 * Metodo que modifica el valor de una posicion
	 * de la instancia
	 * @param pos
	 * @param val
	 */
	public void setValorItem(int pos, String val) {
		inst_.get(pos).setValor(val);
	}
	
	/**
	 * Metodo que retorna el id de una posicion
	 * de la instancia
	 * @param pos
	 * @return
	 */
	public String getIdItem(int pos) {
		return inst_.get(pos).getId();
	}
	
	/**
	 * Metodo que modifica el id de una posicion
	 * de la instancia
	 * @param pos
	 * @param i
	 */
	public void setIdItem(int pos, String i) {
		inst_.get(pos).setId(i);
	}
	
	/**
	 * Metodo que retorna el tamaño
	 * @return
	 */
	public int size() {
		return inst_.size();
	}
}
