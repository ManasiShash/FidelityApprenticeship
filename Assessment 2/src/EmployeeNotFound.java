import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound(String message) {
        super(message);
    }
}
class Employee{
    private String id;
    private String name;
    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
class EmployeeManager {
    private List<Employee> employees = new ArrayList<>();

    public void addEmp(Employee emp) {
        employees.add(emp);
    }

    public Employee findEmp(String id) throws EmployeeNotFound {
        return employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFound("employee with id: " + id + " not found"));
    }

    public List<Employee> getEmployeesstartingWithA() {
        return employees.stream()
                .filter(employee -> employee.getId().startsWith("A"))
                .collect(Collectors.toList());
    }
}
class Program2{
    public static void main(String[] args) {
        EmployeeManager em = new EmployeeManager();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of employee to add: ");
        int numofemp = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numofemp; i++) {
            System.out.println("Enter employee id: ");
            String id = sc.nextLine();
            System.out.println("Enter employee name: ");
            String name = sc.nextLine();
            em.addEmp(new Employee(id, name));
        }
        System.out.println("Enter employee id to find");
        String searchid = sc.nextLine();
        try {
            Employee emp1 = em.findEmp(searchid);
            System.out.println(emp1.getName());
        }catch (EmployeeNotFound e) {
            System.out.println(e.getMessage());
        }
        List<Employee>EmployeesstartingWithA = em.getEmployeesstartingWithA();
        System.out.println("Employees whose name starting With A.");
                if (EmployeesstartingWithA.isEmpty()) {
            System.out.println("No employee found");
        }else {
            EmployeesstartingWithA.forEach(emp -> System.out.println(emp.getName()));
        }
                sc.close();
    }
}
