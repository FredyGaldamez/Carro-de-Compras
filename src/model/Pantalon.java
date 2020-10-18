package model;

public class Pantalon extends Articulo{

	public Pantalon(String codigo, int precio, String nombre, int talla, String marca, String color, int cantBolsillos) {
		super(codigo, precio, nombre, talla, marca);
		this.color = color;
		this.cantBolsillos = cantBolsillos;
	}

	@Override
	public String toString() {
		return "- Pantalon [codigo=" + codigo + ", precio=" + precio + ", nombre=" + nombre + ", talla=" + talla
				+ ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", cantBolsillos=" + cantBolsillos
				+ "]";
	}

}
