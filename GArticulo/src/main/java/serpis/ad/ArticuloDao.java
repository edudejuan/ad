package serpis.ad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArticuloDao {
	
	public static void load(Connection connection) throws SQLException {
		try (Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(App.sqlQuery); ) {
			while (rs.next()) {
				int numColumns = rs.getMetaData().getColumnCount();
				for (int i = 1; i <= numColumns; i++) {
					//TODO
				}
			}
		}
	}



public static void insert(Connection connection, Articulo articulo) throws SQLException {
	//TODO
}

public static void update(Connection connection, Articulo articulo) throws SQLException {
	PreparedStatement stmtArticulo;
	String updateArticulo;
	
	updateArticulo = "UPDATE articulo SET categoria = ?, nombre = ?, precio = ? WHERE id = ?";
	
	stmtArticulo = connection.prepareStatement(updateArticulo);
	
	stmtArticulo.setLong(1, articulo.getCategoria());
	stmtArticulo.setString(2, articulo.getNombre());
	stmtArticulo.setBigDecimal(3, articulo.getPrecio());
	stmtArticulo.setLong(4, articulo.getId());
	
	stmtArticulo.executeUpdate();
	
}

}