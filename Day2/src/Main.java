//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        car car = new car();
        Bicyle bicyle = new Bicyle();
        car.move();
        car.move(60);
        car.drive();
        bicyle.move();
        bicyle.move(20);
        bicyle.pedal();

    }
}