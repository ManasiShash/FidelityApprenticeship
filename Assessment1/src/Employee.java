class Employee {
    int id;
    String name;
    float basicSalary;
    float bonus;
    float netSalary;

    public Employee(int id, String name, float basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
        this.bonus = 0.0f;
        this.netSalary = 0.0f;

    }

    public void calculateBonus(){
// will be overridden in subclass
    }
    public void calculateNetSalary(){
// will be overridden in subclass
    }
    public void displayDetails(){
        System.out.printf("Employee ID:%d\n ", id);
        System.out.printf("Employee Name: %s\n", name);
        System.out.printf("Employee Basic Salary: %.2f\n" , basicSalary);
        System.out.printf("Employee Bonus: %.2f", bonus);
        System.out.printf("Employee Net Salary: %.2f" , netSalary);
    }
}
class PermanentEmployee extends Employee {
    int pf;
    //constructor
    public PermanentEmployee(int id, String name, float basicSalary, int pf){
        super(id, name, basicSalary);
        this.pf=pf;
    }
    public void calculateBonus() {
        if (pf < 1000) {
            bonus = basicSalary * 0.10f;
        } else if (pf >= 1000 && pf < 1500) {
            bonus = basicSalary * 0.115f;
        } else if (pf >= 1500 && pf < 1800) {
            bonus = basicSalary * 0.12f;
        } else {
            bonus = basicSalary * 0.15f;
        }
    }
    // override
        public void calculateNetSalary(){
        calculateBonus();
        netSalary = basicSalary - pf +bonus;
    }
    public void displayDetails(){
        super.displayDetails();
        System.out.printf("PF: %d\n" ,pf);
    }
}
