package relationaldatabases.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;import javax.print.attribute.UnmodifiableSetException;

import relationaldatabases.model.User;
import relationaldbs.util.DBHelper;

/**
 * 
 * @author alex
 * 10 abr 2026
 */
public class UserDaoImpl implements UserDao{
	
	

    private static String dropTableSQL = "drop table if exists users";
    private static final String createTableSQL = """
    	    CREATE TABLE IF NOT EXISTS users (
            id SERIAL PRIMARY KEY,
            name VARCHAR(255) NOT NULL,
            password VARCHAR(255) NOT NULL,
            balance DECIMAL(10,2) NOT NULL,
            age VARCHAR(50),
            phonenumber INTEGER,
            isActive BOOLEAN DEFAULT true,
            gender VARCHAR(20),
            description TEXT
        )
        """;;
    
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
		try (Connection conn = DBHelper.getConnection();
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
			ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(long id) {
		try {
			Connection conn = new DBHelper().getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE id = ?");
			
			ps.setLong(1, id);
			ps.executeUpdate();
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
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

	@Override
	public boolean createTable() {
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
				PreparedStatement ps = conn.prepareStatement(createTableSQL)) {
				ps.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	

}
