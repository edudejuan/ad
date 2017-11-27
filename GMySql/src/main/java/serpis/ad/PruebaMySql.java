package serpis.ad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaMySql {

	public static void main(String[] args) throws SQLException {

	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bdprueba", "root", "sistemas");
	
	connection.close();
	try (Statement statement = connection.createStatement();
		    ResultSet resultset = statement.executeQuery( "SELECT * from categoria" )
		) {
		    while ( resultset.next() ) {
		        int numColumns = resultset.getMetaData().getColumnCount();
		        for ( int i = 1 ; i <= numColumns ; i++ ) {
		           // Column numbers start at 1.
		           // Also there are many methods on the result set to return
		           //  the column as a particular type. Refer to the Sun documentation
		           //  for the list of valid conversions.
		           System.out.println( "COLUMN " + i + " = " + resultset.getObject(i) );
		        }
		    }
		}
	connection.close();
	}

}
