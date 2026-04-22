package relationaldatabases.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import relationaldatabases.model.Product;

/**
 * 
 * @author alex
 * 21 abr 2026
 */
public class ProductDaoImpl implements ProductDao {

    private final static String postgresqlURL = "jdbc:postgresql://localhost:5432/postgres";
    // "jdbc:postgresql://192.168.1.170.5432/sample?ssl=true";

    private final static String username = "postgres";
    private final static String password = "admin";

    private static String dropTableSQL = "drop table if exists products";
    private static final String createTableSQL = """
        CREATE TABLE IF NOT EXISTS products (
            id SERIAL PRIMARY KEY,
            name VARCHAR(255) NOT NULL,
            description TEXT,
            price DECIMAL(10,2) NOT NULL,
            category VARCHAR(100),
            stock INTEGER DEFAULT 0,
            isActive BOOLEAN DEFAULT true,
            brand VARCHAR(100)
        )
        """;

    @Override
    public boolean insert(Product product) {
        //the ingredients that we need to do the task
        //insert sql
        String insertSQL = "insert into products(name, description, price, category, stock, isActive, brand) " +
                          "values(?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(postgresqlURL, username, password);
             PreparedStatement ps = conn.prepareStatement(insertSQL)) {
            
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setString(4, product.getCategory());
            ps.setInt(5, product.getStock());
            ps.setBoolean(6, product.isActive());
            ps.setString(7, product.getBrand());
     
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;  // Devuelve true si se insertó

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void update(Product product) {
        // TODO Auto-generated method stub
    }

    @Override
    public Product find(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Product findByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Product> findAll() {
        // TODO Auto-generated method stub
        return null;
    }
}
