package ull.herramientas.opendatachartgenerator;

public class Atributo {
	private String valor_;
	private String id_;
	
	/**
	 * Constructor de la clase Atributo
	 */
	public Atributo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor por lo que le pasa un id
	 * y un valor nulo en la tabla
	 * @param nombre_
	 */
	public Atributo(String id) {
		super();
		this.valor_ = "";
		this.id_ = id;
	}
	
	/**
	 * Constructor por lo que se le pasa un id y un valor 
	 * @param valor_
	 * @param id
	 */
	public Atributo(String valor_, String id) {
		super();
		this.valor_ = valor_;
		this.id_ = id;
	}
	
	/**
	 * Metodo que retorna el valor del atributos
	 * @return
	 */
	public String getValor() {
		return valor_;
	}

	/**
	 * Metodo que modifica el valor del atributo
	 * @param valor_
	 */
	public void setValor(String valor_) {
		this.valor_ = valor_;
	}
	
	/**
	 * Metodo que retorna el id
	 * @return
	 */
	public String getId() {
		return id_;
	}
	
	/**
	 * Metodo que modifica el id
	 * @param id_
	 */
	public void setId(String id_) {
		this.id_ = id_;
	}
}
