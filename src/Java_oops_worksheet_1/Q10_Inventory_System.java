package Java_oops_worksheet_1;
class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void displayProduct() {
        System.out.println(this); // Fix: Actually print the product
    }

    @Override
    public String toString() {
        return "id = " + id + "\t name = " + name + "\t price = " + price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

class Store{
    private Product[] products;
    Store(Product []products){
        this.products=products;
    }
    void displayAllProducts() {
        System.out.println("Display all products");
        if (products == null) {
            System.out.println("No products available.");
            return;
        }

        for (Product p : products) {
            if (p != null)
                System.out.println(p);
            else
                System.out.println("Null product found.");
        }
    }

    public Product findHighestPriceProduct() {
        if (products == null) {
            System.out.println("No products available.");
            return null;
        }

        double maxPrice = Double.MIN_VALUE;
        Product s = null;

        for (Product p : products) {
            if (p != null && p.getPrice() > maxPrice) {
                maxPrice = p.getPrice();
                s = p;
            }
        }

        return s;
    }

    public Product searchProductByName(String name) {
        if (products == null) {
            System.out.println("No products available.");
            return null;
        }

        for (Product p : products) {
            if (p != null && p.getName() != null && p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }

        return null;
    }

}
public class Q10_Inventory_System {
    public static void main(String ar[]){
// Create products
        Product product1 = new Product(1, "Laptop", 999.99);
        Product product2 = new Product(2, "Smartphone", 599.99);
        Product product3 = new Product(3, "Headphones", 199.99);
        Product product4 = new Product(4, "Smartwatch", 249.99);

        // Store the products in an array
        Product[] productList = { product1, product2, product3, product4 };

        // Create a store with the product array
        Store store = new Store(productList);
        store.displayAllProducts();

        // Find and display the product with the highest price
        Product highestPriceProduct = store.findHighestPriceProduct();
        System.out.println("\nProduct with the highest price:");
        highestPriceProduct.displayProduct();

        // Search for a product by name
        String searchName = "Laptop";
        Product searchedProduct = store.searchProductByName(searchName);
        if (searchedProduct != null) {
            System.out.println("\nProduct found with name '" + searchName + "':");
            searchedProduct.displayProduct();
        } else {
            System.out.println("\nNo product found with name '" + searchName + "'.");
        }
    }
}
