public class VehicleQ7 {
    void move(){
        System.out.println("Vehicle is moving");
    }
    void move(int speed){
        System.out.println("Vehicle is moving at "+speed+"km/hr");
    }
}
class car extends VehicleQ7{
    void move(){
        System.out.println("car is moving");
    }
    void drive(){
        System.out.println("car is moving");
    }
}
class Bicyle extends VehicleQ7{
    void move(){
        System.out.println("bicyle is moving");
    }
    void pedal(){
        System.out.println("bicyle is being pedaled");
    }
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
}




