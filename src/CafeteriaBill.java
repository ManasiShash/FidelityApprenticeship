import java.util.Scanner;

public class CafeteriaBill {
    final static int Pizza_Price = 200, Puff_Price = 40, Pepsi_Price = 120;
    public static int calculateTotal( int quantity, int price){
        return quantity * price;
    }
    public static void main( String[] args ){
        Scanner sc = new Scanner( System.in );
        System.out.println(" Enter number of pizzas: ");
        int totalPizzacost = calculateTotal(sc.nextInt(), Pizza_Price);
        System.out.println(" Enter number of puffs: ");
        int totalPuffCost = calculateTotal(sc.nextInt(),Puff_Price);
        System.out.println(" Enter number of pepsi: ");
        int totalPepsiCost = calculateTotal(sc.nextInt(), Pepsi_Price);

        int grandTotal = totalPizzacost + totalPuffCost + totalPepsiCost;
        System.out.println("-----Bill Details-----");
        System.out.println("Total cost of Pizzas: Rs."+totalPizzacost);
        System.out.println("Total cost of Puffs: Rs."+totalPuffCost);
        System.out.println("Total cost of Pepsi: Rs."+totalPepsiCost);
        System.out.println("Grand Total Cost: Rs."+grandTotal);

        sc.close();
    }
}
