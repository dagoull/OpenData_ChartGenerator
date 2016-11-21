package ull.herramientas.opendatachartgenerator;

public class Atributo {
	private String valor_;
	private String id_;
	
	public Atributo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Atributo(String nombre_) {
		super();
		this.valor_ = "";
		this.id_ = nombre_;
	}
	
	public Atributo(String valor_, String nombre_) {
		super();
		this.valor_ = valor_;
		this.id_ = nombre_;
	}

	public String getValor() {
		return valor_;
	}

	public void setValor(String valor_) {
		this.valor_ = valor_;
	}

	public String getId() {
		return id_;
	}

	public void setId(String id_) {
		this.id_ = id_;
	}


}
