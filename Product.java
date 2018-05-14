import java.lang.reflect.Field;

public class Product {
    private String brand;
    private String model;
    private String size;
    private double price;
    private int sku;
    private String option1;
    private String option2;
    private String option3;

    public Product() throws Exception { 
        throw new Exception("SKU required.");
    }

    public Product(int _sku) { sku = _sku; }

    // Using reflection to dynamically setting a new value to a given property.
    // The property fields are kept straight by using the PropertyFields static members
    // Learned this trick at my job!!
    public <T> void setProperty(String field, T value) {
        try {
            Field f = this.getClass().getDeclaredField(field);       
            f.set(this, value);
        } catch (NoSuchFieldException ex) {
            System.out.println("Field no found...");
            System.out.println(ex.getMessage());

        } catch (IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getProperty(String field) {
        String value = "";
        try {
            Field f = this.getClass().getDeclaredField(field);
            Object v = f.get(this);
            value = v.toString();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return value;
    }

    @Override
    public String toString() {
        return String.format("<Product sku='%s' model='%s' price='%s'>", sku, model, price);
    }
}