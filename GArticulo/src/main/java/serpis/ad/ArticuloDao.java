package serpis.ad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArticuloDao {

	public static void load(Connection connection) throws SQLException{
		try (Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(App.sqlQuery); ) {
			while (rs.next()) {
				int numColumns = rs.getMetaData.get)
			}
		}
						
	}

}
