public class Vehicle {
    void move(){
        System.out.println("Vehicle is moving");
    }
    void move(int speed){
    System.out.println("Vehicle is moving at "+speed+"km/hr");
    }
}
class car extends Vehicle{
    void move(){
        System.out.println("car is moving");
    }
    void drive(){
        System.out.println("car is moving");
    }
}
class Bicyle extends Vehicle{
    void move(){
        System.out.println("bicyle is moving");
    }
    void pedal(){
        System.out.println("bicyle is being pedaled");
    }
}



