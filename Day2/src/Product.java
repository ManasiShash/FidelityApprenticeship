import java.sql.SQLOutput;
import java.util.Scanner;

class Product {
    private int productId;
    private String PrductName;
    private String category;
    private static String storeName = "TechStore";

    public Product(int productId, String prductName, String category) {
        this.productId = productId;
        this.PrductName = prductName;
        this.category = category;
    }
    public void displayProductdetails(){
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + PrductName);
        System.out.println("Category: " + category);
    }
    public static void displayStoreName(){
        System.out.println("Store Name: " + storeName);
    }
}

