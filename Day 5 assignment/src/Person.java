import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Person {
    private String Firstname;
    private String Lastname;
    private LocalDate Dob;

    public Person(String firstname, String lastname, LocalDate dob) {
        this.Firstname = firstname;
        this.Lastname = lastname;
        this.Dob = dob;
    }
    public String getFirstname() {
        return Firstname;
    }
    public void setFirstname(String firstname) {
        this.Firstname = firstname;
    }
    public String getLastname() {
        return Lastname;
    }
    public void setLastname(String lastname) {
        this.Lastname = lastname;
    }
    public LocalDate getDob() {
        return Dob;
    }
    public void setDob(LocalDate dob) {
        this.Dob = dob;
    }
    public String getAdult(){
        int age = getAge();
        return (age>=18)?"Adult":"Child";
    }
    public int getAge(){
        LocalDate currentDate = LocalDate.now();
        return Period.between(Dob, currentDate).getYears();
    }
    public void display(){
        System.out.println("Firstname" + Firstname);
        System.out.println("Lastnae" + Lastname);
        System.out.println("Age" + getAge());
        System.out.println(getAdult());
    }
}
class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter Firstname: ");
            String firstname1 = sc.nextLine();
            System.out.println("Enter Lastname: ");
            String lastname1 = sc.nextLine();
            System.out.println("Enter Dob: ");
            LocalDate dob1 = LocalDate.parse(sc.nextLine());

            Person person1 = new Person(firstname1, lastname1, dob1);
            person1.display();
        } catch (DateTimeParseException e) {
            System.out.println("invalid date format. please enter the date in yyyy-mm-dd format.");
        } finally {
            sc.close();
        }
    }
}
