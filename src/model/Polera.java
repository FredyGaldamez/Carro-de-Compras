package model;

public class Polera extends Articulo{

	public Polera(String codigo, int precio, String nombre, int talla, String marca, String color) {
		super(codigo, precio, nombre, talla, marca);
		this.color = color;
	}

	@Override
	public String toString() {
		return "- Polera [codigo=" + codigo + ", precio=" + precio + ", nombre=" + nombre + ", talla=" + talla
				+ ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", cantBolsillos=" + cantBolsillos
				+ "]";
	}
	

}
