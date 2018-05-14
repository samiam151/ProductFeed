import java.util.ArrayList;
/**
 * This program mocks a process that all eCommerce platforms have to 
 * include: a product feed. The product feed is a way in which a platform
 * gain accect a list of products from the back-office of a company and 
 * place them in a database sot that it can be indexed, searched, and displayed.
 * 
 * In the project folder is a text filed, tab-delimited, with a list of 11 products.
 * This program:
 *      1. Initializes an in-memory database, using a database service.
 *      2. Creates a ProductField object, given a filename of the product file.
 *      3. Runs the feed
 */
public class Main {
    public static void main(String[] args) {
        ProductDatabaseService.initialize();
        ProductFeed feed = new ProductFeed("products.txt");
    
        feed.run();

        // To make sure this worked, let's log out all the products
        ArrayList<Product> _products = ProductDatabaseService.getProducts();
        for (Product _product : _products) {
            System.out.println(_product);
        }
    }
}