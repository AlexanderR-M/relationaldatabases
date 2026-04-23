package relationaldbs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

	private final static String postgresqlURL = "jdbc:postgresql://localhost:5432/postgres";

    // "jdbc:postgresql://192.168.1.170.5432/sample?ssl=true";

    private final static String username = "postgres";

    private final static String password = "admin";
    
    public static Connection getConnection() {
    	try {
			return DriverManager.getConnection(postgresqlURL, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    	
    	
    }
}
