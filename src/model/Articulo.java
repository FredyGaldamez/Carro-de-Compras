package model;

public abstract class Articulo {
	protected String codigo;
	protected int precio; 
	protected String nombre;
	protected int talla; 
	protected String marca; // TODOS
	protected String modelo;
	protected String color;
	protected int cantBolsillos;
	public Articulo(String codigo, int precio, String nombre, int talla, String marca) {
		this.codigo = codigo;
		this.precio = precio;
		this.nombre = nombre;
		this.talla = talla;
		this.marca = marca;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTalla() {
		return talla;
	}
	public void setTalla(int talla) {
		this.talla = talla;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getCantBolsillos() {
		return cantBolsillos;
	}
	public void setCantBolsillos(int cantBolsillos) {
		this.cantBolsillos = cantBolsillos;
	}
	
	
	
	

}
