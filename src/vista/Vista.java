package vista;

import java.util.ArrayList;


import model.Articulo;

public class Vista {

	public static void main(String[] args) {
		
		//Integrantes: Rodrigo Diaz, Jorge Poblete, Emmanuel Bustamante, Christopher Saavedra
		ArrayList<Articulo> listaArticulos = metodo.Lista.crearListaArticulos();
		ArrayList<Articulo> carro = new ArrayList<Articulo>();
		metodo.Menu.menu(listaArticulos, carro);
		

	}

}
