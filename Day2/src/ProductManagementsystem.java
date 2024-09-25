import java.util.Scanner;

public class ProductManagementsystem{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter details for product1 ");
        System.out.println("Product ID: " );
        int id1 = sc.nextInt();
        sc.nextLine();
        System.out.println("Product name ");
        String name1 = sc.nextLine();
        System.out.println("Product category");
        String category1 = sc.nextLine();

        System.out.println("Enter details for product2 ");
        System.out.println("Product ID: " );
        int id2 = sc.nextInt();
        sc.nextLine();
        System.out.println("Product name ");
        String name2 = sc.nextLine();
        System.out.println("Product category");
        String category2 = sc.nextLine();

        Product product1 = new Product(id1, name1, category1);
        Product product2 = new Product(id2, name2, category2);

        System.out.println("----Product details----");
        product1.displayProductdetails();
        System.out.println();
        product2.displayProductdetails();

        System.out.println("----Store Information----");
        Product.displayStoreName();

        sc.close();
    }
}
