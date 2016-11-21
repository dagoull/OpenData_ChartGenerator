package ull.herramientas.opendatachartgenerator;

import java.util.ArrayList;

public class Instancia {
	private ArrayList<Atributo> inst_;
	
	public Instancia() {
		super();
		this.inst_ = new ArrayList<Atributo>();
	}

	public ArrayList<Atributo> getInst_() {
		return inst_;
	}

	public void setInst_(ArrayList<Atributo> inst_) {
		this.inst_ = inst_;
	}
	
	public void addAtributo(Atributo A) {
		inst_.add(A);
	}
	
	public void removeAtributo(Atributo A) {
		inst_.remove(A);
	}
	
	public String getValorItem(int pos) {
		return inst_.get(pos).getValor();
	}
	
	public void setValorItem(int pos, String val) {
		inst_.get(pos).setValor(val);
	}
	
	public String getIdItem(int pos) {
		return inst_.get(pos).getId();
	}
	
	public void setIdItem(int pos, String i) {
		inst_.get(pos).setId(i);
	}
}
