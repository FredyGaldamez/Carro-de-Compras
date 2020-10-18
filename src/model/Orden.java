package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Orden {
	
	private String nombre;
	private String direccion;
	private ArrayList<Articulo> carro;
	private int monto;
	private LocalDate fecha;
	private String productCodes;
	
	public Orden(String nombre, String direccion, ArrayList<Articulo> carro) {
		this.direccion = direccion;
		this.nombre = nombre;
		this.carro = carro;
		setMonto(carro);
		setFecha();
		setProductCodes(carro);
	}
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Articulo> getCarro() {
		return carro;
	}
	public void setCarro(ArrayList<Articulo> carro) {
		this.carro = carro;
	}
	public int getMonto() {
		return monto;
	}
	private void setMonto(ArrayList<Articulo> carro) {
		int monto = 0;
		for (Articulo articulo : carro) {
			monto += articulo.getPrecio();
		}
		this.monto = monto;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	private void setFecha() {
		this.fecha = LocalDate.now();
	}

	public String getProductCodes() {
		return productCodes;
	}

	private void setProductCodes(ArrayList<Articulo> carro) {
		String[] pcodes = new String[carro.size()];
		for (int i = 0 ; i < carro.size(); i++) {
			pcodes[i] = carro.get(i).getCodigo();

		}
		this.productCodes = Arrays.deepToString(pcodes)
		.replace("[", "")
		.replace("]", "");
	}
	
	
	
	

}
