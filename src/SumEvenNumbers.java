import java.util.Scanner;

public class SumEvenNumbers {
    public static int sumEvenNumbers(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            if ( num % 2 == 0 ) {
                sum += num;

            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] numbers = new int[size];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();
        }
        int sum = sumEvenNumbers(numbers);
        System.out.println("Sum of even numbers: " + sum);
        sc.close();
    }
}
