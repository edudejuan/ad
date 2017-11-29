package serpis.ad;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



		public class GArticulo {
			public static void main(String[] args) throws SQLException {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bdprueba", "root", "sistemas");
					Scanner scanner = new Scanner(System.in);
					int opcion;
					do {
						System.out.println("---------------------");
						System.out.println("SELECCIONE UNA OPCION");
						System.out.println("---------------------");			
						System.out.println("0 SALIR");
						System.out.println("1 NUEVO");
						System.out.println("2 EDITAR");
						System.out.println("3 ELIMINAR");
						System.out.println("4 CONSULTAR");
						System.out.println("5 LISTAR");
						System.out.println("---------------------");
						opcion = scanner.nextInt();
						switch (opcion) {
						case 1:
							Insertar(connection);
							break;
						case 2:
							Editar(connection);
							break;
						case 3:
							Eliminar(connection);
							break;
						case 4:
							Consultar(connection);					
							break;
						case 5:
							listar(connection);
							break;
						default:
							break;
						}
					} while (opcion!=0);
					connection.close();
				}
			private static void Consultar(Connection connection) {
				// TODO Auto-generated method stub
				
			}
			private static void Insertar(Connection connection) {
				// TODO Auto-generated method stub
				
			}
			private static void Editar(Connection connection) {
				// TODO Auto-generated method stub
				
			}
			private static void Eliminar(Connection connection) {
				// TODO Auto-generated method stub
				
			}
			public static void listar(Connection connection)throws SQLException {
				
	     }
	}

