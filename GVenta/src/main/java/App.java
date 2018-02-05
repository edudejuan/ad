import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class App {

	public static Scanner tcl = new Scanner(System.in);
	
	public static int scanInt(String msg) {
		String line  = "";
		while(true) {
			try {
				int respuesta;
				do {
				System.out.println(msg);
				line = tcl.nextLine();
				respuesta =Integer.parseInt(line);
				}while(respuesta < 0 || respuesta > 5);
				return respuesta;
			}catch(NumberFormatException a) {
				System.out.println("Debe ser un numero ");
			}
		}
	}
	public static long scanLong() {
		while(true) {
			try {
				String line = tcl.nextLine();
				return Long.parseLong(line);
			}catch(NumberFormatException a) {
				System.out.println("Debe ser un numero ");
			}
		}
	}
	public static BigDecimal scanBigDecimal() {
		while(true) {
			try {
				String line = tcl.nextLine();
				BigDecimal scanned = new BigDecimal(line);
				return scanned;
			}catch(NumberFormatException a) {
				System.out.println("Debe ser un numero ");
			}
		}
	
	}}
