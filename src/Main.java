import java.util.Scanner;

class AvgCalculator {

    public static double calculateaverage(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] numbers = new int[n];
        System.out.println("Enter the elements in the array: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        double average = calculateaverage(numbers);
        System.out.println("The average is " + average);
        sc.close();
    }
}