import java.util.ArrayList;
/**
 * The database service was created so that I don't have to 
 * pass any database objects around as an argument to some method.
 * Also, using this as a proxy for any database operations, I can ensure that
 * there is only one database running on the program.
 */
public class ProductDatabaseService {
    private static ProductDatabase db;

    /**
     * Creates the one and only ProductDatabase object;
     */
    public static void initialize() {
        try {
            db = new ProductDatabase();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Adds one Product to the database
     */
    public static void addProduct(Product _product) {
        db.addProduct(_product);
    }


    /**
     * Returns all the products in the database;
     */
    public static ArrayList<Product> getProducts() {
        return db.getProducts();
    }

    /**
     * Clears the database
     */
    public static void clearDatabase() {
        db.clear();
    }

    /**
     * Shows how many products are in the database
     */
    public static String getStatus() {
        return db.toString();
    }
}