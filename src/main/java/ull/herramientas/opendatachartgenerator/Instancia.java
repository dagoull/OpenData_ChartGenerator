package ull.herramientas.opendatachartgenerator;

import java.util.ArrayList;

/**
 * \class Instancia
 * \brief Clase que almacenará las distintas instancias del dataset.
 * \author Joel Perez Ramos
 *
 */
public class Instancia {
	/**
	 * \brief ArrayList de tipo Atributo
	 */
	private ArrayList<Atributo> inst_;

	/**
	 * \brief Constructor que almacenará la instancia
	 */
	public Instancia() {
		super();
		this.inst_ = new ArrayList<Atributo>();
	}
	
	/**
	 * \brief Constructor que almacenará un conjunto de datos
	 * \param atributos
	 */
	public Instancia(Atributo[] atributos){
		this.inst_ = new ArrayList<Atributo>();
		for (int i = 0; i<atributos.length; i++)
			inst_.add(atributos[i]);
	}

	/**
	 * \brief Metodo que retorna la instancia
	 * \return
	 */
	public ArrayList<Atributo> getInst_() {
		return inst_;
	}

	/**
	 * \brief Metodo que modifica la instancia
	 * \param inst_
	 */
	public void setInst_(ArrayList<Atributo> inst_) {
		this.inst_ = inst_;
	}

	/**
	 * \brief Metodo que añade un atributo a la instancia
	 * \param A
	 */
	public void addAtributo(Atributo A) {
		inst_.add(A);
	}

	/**
	 * \brief Metodo que borra un atributo de la instancia
	 * \param A
	 */
	public void removeAtributo(Atributo A) {
		inst_.remove(A);
	}

	/**
	 * \brief Metodo que retorna el valor de una posicion
	 * de la instancia
	 * \param pos
	 * \return
	 */
	public String getValorItem(int pos) {
		return inst_.get(pos).getValor();
	}

	/**
	 * \brief Metodo que modifica el valor de una posicion
	 * de la instancia
	 * \param pos
	 * \param val
	 */
	public void setValorItem(int pos, String val) {
		inst_.get(pos).setValor(val);
	}

	/**
	 * \brief Metodo que retorna el id de una posicion
	 * de la instancia
	 * \param pos
	 * \return
	 */
	public String getIdItem(int pos) {
		return inst_.get(pos).getId();
	}

	/**
	 * \brief Metodo que modifica el id de una posicion
	 * de la instancia
	 * \param pos
	 * \param i
	 */
	public void setIdItem(int pos, String i) {
		inst_.get(pos).setId(i);
	}

	/**
	 * \brief Metodo que retorna el tamaño
	 * \return
	 */
	public int size() {
		return inst_.size();
	}
}
