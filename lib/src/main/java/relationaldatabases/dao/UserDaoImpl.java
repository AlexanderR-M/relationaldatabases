package relationaldatabases.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;import javax.print.attribute.UnmodifiableSetException;

import relationaldatabases.model.User;

/**
 * 
 * @author alex
 * 10 abr 2026
 */
public class UserDaoImpl implements UserDao{
	
	private final static String postgresqlURL = "jdbc:postgresql://localhost:5432/postgres";

    // "jdbc:postgresql://192.168.1.170.5432/sample?ssl=true";

    private final static String username = "postgres";

    private final static String password = "admin";

	@Override
	public boolean insert(User user) {
		//the ingredients that we need to do the task
		//insert sql
		String insertSQL = "insert into users(name, password, balance, age, phonenumber, isActive, gender, description)" + "values(?, ?, ?, ?, ?, ?, ?, ? )";
		/**
		 * create an object of connecton to establish
		 * a network connection with the database used in 
		 * our program
		 */
		try (Connection conn = DriverManager.getConnection(postgresqlURL, username, password);
				/**
				 * crete an object with prepareStatement which 
				 * allows us to prepare, send execute sqls
				 */
				PreparedStatement ps = conn.prepareStatement(insertSQL)) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setDouble(3,user.getBalance());
			ps.setString(4, user.getAge());
			ps.setInt(5, user.getPhonenumber());
			ps.setBoolean(6, user.isActive());
			ps.setString(7, user.getGender());
			ps.setString(8, user.getDescription());
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByEmail(String emal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
