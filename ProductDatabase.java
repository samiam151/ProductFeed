import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Not a real database.
 * This is the collection of Products added to this database.
 * Everything in the class is only accessed using the ProductDatabaseService
 * static methods. This is to ensure that there is only one database out there.
 */
public class ProductDatabase {
    private ArrayList<Product> products;
    private LocalDateTime dateCreated;
    private static boolean alreadyCreated = false;

    public ProductDatabase() throws Exception {
        // We only want one database, so this is meant to ensure that we only have one.
        if (alreadyCreated)
            throw new Exception("ProductDatabase already created. Please use the ProductDatabaseService.");

        products = new ArrayList<Product>();
        dateCreated = LocalDateTime.now();
        alreadyCreated = true;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product _product) {
        products.add(_product);
    }

    public void clear() {
        products.clear();
    }

    @Override
    public String toString() {
        return String.format("<ProductDatabase products='%s'>", products.size());
    }
}