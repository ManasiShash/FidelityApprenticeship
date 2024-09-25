import java.util.Scanner;

public class VoteEligibility {
    public static boolean isEligibleToVote( int age){
        return age>18;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter age");
        int age = sc.nextInt();
        if (isEligibleToVote(age)) {
            System.out.println("eligible");
        }else{
            System.out.println("not eligible");
        }
        sc.close();
    }
}
