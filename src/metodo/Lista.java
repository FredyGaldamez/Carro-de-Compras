package metodo;

import java.util.ArrayList;

import model.Articulo;
import model.Pantalon;
import model.Polera;
import model.Zapato;

public class Lista {
	
	public static ArrayList<Articulo> crearListaArticulos() {
		ArrayList<Articulo> lista = new ArrayList<Articulo>();
		lista.add(new Pantalon("1000", 15000, "Variant Caqui Corto", 30, "Variant", "Caqui", 2));
		lista.add(new Pantalon("1001", 19000, "Variant Negro Largo", 30, "Variant", "Negro", 2));
		lista.add(new Polera("2002", 9000, "Variant Negro Largo", 29, "Variant", "Rojo"));
		lista.add(new Zapato("3003", 25000, "Mega CZ50", 34, "Mega", "CZ50"));
		lista.add(new Zapato("3004", 20000, "Mega CX50", 40, "Mega", "CX50"));
		
		return lista;
	}

	public static Articulo buscarPorCodigo(ArrayList<Articulo> listaArticulo, String codigo) {

		int indice = -1;
		for (int i=0; i < listaArticulo.size(); i++) {
			if (listaArticulo.get(i).getCodigo().equals(codigo)) {
				indice = i;
			}
			
		}
		return listaArticulo.get(indice);
	}
	
	public static void mostrarLista(ArrayList<Articulo> lista) {
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).toString());	
		}
	}
	
	public static int totalizar(ArrayList<Articulo> lista) {
		int totPago = 0;
		for (Articulo articulo : lista) {
			totPago += articulo.getPrecio();
		}
		return totPago;
	}

}
