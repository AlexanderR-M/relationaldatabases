package relationaldatabases.model;

public class maquinas {
	
	//fields
	private String nombre;
	private String tipo;
	private int cantidad;
	private int sala;
	private String marca;
	private int precio;
	
	//getters and setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getSala() {
		return sala;
	}
	public void setSala(int sala) {
		this.sala = sala;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
	//constructor 
	
	public maquinas(String nombre, String tipo, int cantidad, int sala, String marca, int precio) {
		
		this.nombre = nombre;
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.sala = sala;
		this.marca = marca;
		this.precio = precio;
		
	}

	
	
	
	
	
	
}
