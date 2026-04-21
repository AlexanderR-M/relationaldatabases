package relationaldatabases;

import relationaldatabases.dao.ProductDao;
import relationaldatabases.dao.ProductDaoImpl;
import relationaldatabases.model.Product;

public class ProductDaoTest {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDaoImpl();
        productDao.insert(new Product(
                0,
                "Cinta de correr",
                "Cinta para gimnasio profesional",
                799.99,
                "Cardio",
                10,
                true,
                "FitnessPro"
        ));
    }
}