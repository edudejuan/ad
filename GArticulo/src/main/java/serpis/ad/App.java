package serpis.ad;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class App {

		public  final static String sqlQuery ="SELECT * FROM Articulo order by id"; 
		public Connection connection ;
		public  App() {
		
		}
		private static App instance = new App();
		
		public void conexion(String sql) throws SQLException {
			connection= DriverManager.getConnection(sql);
		}
		public static App getInstance(){
			return instance;
		}
		public Connection getConnection() {
			return connection;
		}
		public void setConnection(Connection value) {
			connection=value;
		}
	
	}


