package serpis.ad;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
	
	public enum Opciones { 
		SALIR, 
		NUEVO, 
		EDITAR, 
		ELIMINAR, 
		CONSULTAR, 
		LISTAR
	}	
	
	public static void leerArticulo(int modo) {
		Scanner scn = new Scanner(System.in);
		String nombre;
		BigDecimal precio;
		long id;
		
		switch (modo) {
		case 0:
			System.out.println("Introduce categoría del artículo:");
			//TODO
		}
	}
	
	public static int seleccionOpcion() {
		Scanner scn = new Scanner(System.in);
		String s = "\nError. Debes de introducir un número entre 0 y 5.";
		boolean valid = true;
		int seleccion = 0;
		
		do {
			try {
				seleccion = Integer.parseInt(scn.nextLine());
				if (seleccion < 0 || seleccion > 5) {
					valid = false;
					System.out.println(s);
				}
			} catch (NumberFormatException ex) {
				valid = false;
				System.out.println(s);
			}
		} while(!valid);
		
		scn.close();
		
		return seleccion;
	}
	
	public static void ejecutarOpcion() {
		Opciones opcion = Opciones.values()[seleccionOpcion()];
		
		switch (opcion) {
			case SALIR:
				//TODO 
				break;
			case NUEVO:
				//TODO
				break;
			case EDITAR:
				//TODO
				break;
			case ELIMINAR:
				//TODO
				break;
			case CONSULTAR:
				//TODO
				break;
			case LISTAR:
				//TODO
				break;
		}
	}
	
	public static void menu() {
		String s = ("MENÚ\n" + 
				"0. Salir.\n" + 
				"1. Nuevo.\n" +
				"2. Editar. \n" +
				"3. Eliminar\n "+
				"4. Consultar\n "+
				"5. Listar \n\n " +
				"Escoge una opción.");
		
		System.out.print(s);		
	}
	
	public static void main(String[] args) {
		//TODO
	}

}
