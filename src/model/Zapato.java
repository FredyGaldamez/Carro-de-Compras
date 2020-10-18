package model;

public class Zapato extends Articulo {

	public Zapato(String codigo, int precio, String nombre, int talla, String marca, String modelo) {
		super(codigo, precio, nombre, talla, marca);
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "- Zapato [codigo=" + codigo + ", precio=" + precio + ", nombre=" + nombre + ", talla=" + talla
				+ ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", cantBolsillos=" + cantBolsillos
				+ "]";
	}

}
