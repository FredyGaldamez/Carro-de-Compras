package metodo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Articulo;
import model.Orden;

public class Menu {
	
	public static void menu(ArrayList<Articulo> listaArticulo, ArrayList<Articulo> carro) {
		boolean salir=false;
		while (!salir) {	
			// Menú Inicial
			System.out.println("Seleccione una opción");
			System.out.println("1- Mostrar productos");
			System.out.println("2- Agregar producto al carro de compras");
			System.out.println("3- Mostrar carro de compras");
			System.out.println("4- Vaciar carro");
			System.out.println("5- Pagar");
			System.out.println("6- Salir");
			
			String op = extracted().next();
			
			switch (op) {
				case "1": { // Mostrar lista de productos
					System.out.println("***************************************************");
					System.out.println("PRODUCTOS DISPONIBLES");
					Lista.mostrarLista(listaArticulo);
					break;
				}
				case "2": { // Agregar artículos
					System.out.println("Ingrese codigo de producto para ingresar");
					String codigoProducto = extracted().next();
					// Confirmación para agregar producto
					try {
						System.out.println("¿Agregar " + Lista.buscarPorCodigo(listaArticulo, codigoProducto).getNombre() + " al carrito por $" + Lista.buscarPorCodigo(listaArticulo, codigoProducto).getPrecio() + "?");
						if (confirmar()) {
							carro.add(Lista.buscarPorCodigo(listaArticulo, codigoProducto));
							System.out.println(Lista.buscarPorCodigo(listaArticulo, codigoProducto).getNombre() + " agregado correctamente.");
							System.out.println("***************************************************");
						} else {
							System.out.println("El producto " + Lista.buscarPorCodigo(listaArticulo, codigoProducto).getNombre() + " no se agregó");
							System.out.println("***************************************************");
						}
					} catch (Exception e) {
						System.out.println("Producto no encontrado");
						System.out.println("***************************************************");
					}	
					break;
				}
				case "3": { // Mostrar carro de compras
					
					System.out.println("***************************************************");
					System.out.println("CARRO DE COMPRAS");
					System.out.println("...................................................");
					if (carro.size() == 0) {
						System.out.println("No hay productos en su carro");
						System.out.println("***************************************************");
						
					} else {
						Lista.mostrarLista(carro);
						System.out.println("***************************************************");
					}
					
					break;
				}
				case "4": { // Vaciar carro
					carro.clear();
					System.out.println("El carro está vacío.");
					System.out.println("***************************************************");
					break;
				}
				case "5": { // Pago
					if (carro.size()==0) {
						System.out.println("El carro está vacío.");
						System.out.println("***************************************************");
					} else {
						boolean salirpago = false;
						while (!salirpago) {
							Scanner scpago = extracted();
							System.out.println("¿Cuál es su medio de pago?");
							System.out.println("1- Credito");
							System.out.println("2- Debito");
							System.out.println("3- Cancelar");
							String menupago = scpago.next();

							switch (menupago) { 
								case "1": { // Crédito
									if (pagarCredito(carro)) {
										crearOrden(carro);
										carro.clear();
										salirpago = true;
									}
									
									break;
								}
								case "2": { // Debito
									if (pagarDebito(carro)) {
										crearOrden(carro);
										carro.clear();
										salirpago = true;
									}
									break;
								}
								case "3": { // salir
									salirpago = true;
									break;
								}
								default:
									switchDefault(menupago);
									break;
								}	
						}
					}
					
					break;
					
				}
				case "6": {
					System.out.println("Hasta luego");
					salir = true;
					break;
				}
				default:
					switchDefault(op);
					break;
					
				}
		}
		
	}

	private static Scanner extracted() {
		return new Scanner(System.in);
	}

	private static boolean confirmar() {
		boolean output = false;
		boolean salir = false;
		while(!salir) {
			System.out.println("Ingrese Y para si o N para no");
			String respuesta = extracted().next();
			switch (respuesta.toUpperCase()) {
				case "Y": {
					output = true;
					salir = true;
					break;
				}
				case "N": {
					output = false;
					salir = true;
					break;
				}
				default:
					switchDefault(respuesta);
					break;
				}
		}
		return output;
	}

	private static void switchDefault(String menuop) {
		System.out.println("La opción \"" + menuop +"\" no es válida.");
		System.out.println("***************************************************");
	}

	private static boolean pagarCredito(ArrayList<Articulo> carro) {
		boolean output = false;
		System.out.println("¿Está seguro que desea pagar con crédito el total de $" + Lista.totalizar(carro) + "?");
		if (confirmar()) {
			boolean salir = false;
			System.out.println("¿Con cuantas cuotas desea pagar ? (0-24)");
			int nCuotas = 0;
			while (!salir) {
				try {
					nCuotas = extracted().nextInt();
					while (nCuotas < 0 | nCuotas > 24) {
						System.out.println("La cantidad de cuotas no es válida.");
						System.out.println("¿Con cuantas cuotas desea pagar? (0-24)");
						nCuotas = extracted().nextInt();
					}
					salir = true;
				} 
				catch (Exception e) {
					System.out.println("El valor ingresado no es válido");
					System.out.println("¿Con cuantas cuotas desea pagar? (0-24)");
				}
				
			}
			System.out.println("¿Está seguro que desea pagar con " + nCuotas + " cuotas?");
			if (confirmar()) {
				output = true;
			} 
		} 
		return output;
	}

	private static boolean pagarDebito(ArrayList<Articulo> carro) {
		boolean output = false;
		System.out.println("¿Está seguro que desea pagar con débito el total de $" + Lista.totalizar(carro) + "?");
		if (confirmar()) {
			output = true;
		} 
		return output;
	}

	private static void crearOrden(ArrayList<Articulo> carro) {
		System.out.println("¿Cuál es el nombre de quien recibe el producto?");
		String nombre = extracted().nextLine();
		System.out.println("¿Cuál es la dirección de despacho?");
		String direccion = extracted().nextLine();
		Orden od = new Orden(nombre, direccion, carro);
		try {
			metodo.ExcelExport.ordenToExcel(od);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Orden de despacho generada correctamente");
		System.out.println("***************************************************");
	}
	
	
}
