package relationaldatabases.dao;

import java.util.List;

import relationaldatabases.model.Product;

public interface ProductDao {

    /**
     * insert a product object to database
     * @param product
     * @return return true if inserted successfully, otherwise false
     */
    public boolean insert(Product product);

    /**
     * delete a product by id
     * @param id
     * @return
     */
    public boolean delete(long id);

    public void update(Product product);

    /**
     * find a product by its id
     * @param id
     * @return
     */ 
    public Product find(long id);

    /**
     * find a product by its name
     * @param name
     * @return
     */
    public Product findByName(String name);

    /**
     * retrieve all products 
     * @return a list of products
     */
    public List<Product> findAll();
}