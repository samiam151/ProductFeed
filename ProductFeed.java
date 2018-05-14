import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ProductFeed {
    private File productFile;

    public ProductFeed() throws Exception {
        throw new Exception("Product file is required.");
    }

    public ProductFeed(String filename) {
        productFile = new File(filename);
    }

    public File getFile() { return productFile; }

    public void run() {
        try (
            Scanner input = new Scanner(new File("products.txt"))
        ) {
            input.nextLine(); // Clear the headers
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] values = line.split("\t");
                int sku = Integer.parseInt(values[4]);

                Product _product = new Product(sku);
                _product.setProperty(ProductFields.BRAND, values[0]);
                _product.setProperty(ProductFields.MODEL, values[1]);
                _product.setProperty(ProductFields.SIZE, values[2]);
                _product.setProperty(ProductFields.PRICE, Double.parseDouble(values[3]));
                _product.setProperty(ProductFields.OPTION1, values[5]);
                _product.setProperty(ProductFields.OPTION2, values[6]);
                _product.setProperty(ProductFields.OPTION3, values[7]);

                ProductDatabaseService.addProduct(_product);
             }
        } catch (FileNotFoundException ex) {  }

        System.out.println(ProductDatabaseService.getStatus());
    }

    @Override
    public String toString() {
        return String.format("<ProductFeed file='%s'>", productFile);
    }
}