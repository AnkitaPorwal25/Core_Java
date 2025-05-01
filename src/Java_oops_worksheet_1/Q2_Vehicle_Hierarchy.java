package Java_oops_worksheet_1;
abstract class Vehicle{
    protected double speed;
    protected double fuelCapacity;

    Vehicle(double speed,double fuelCapacity){
        this.speed=speed;
        this.fuelCapacity=fuelCapacity;
    }
    abstract public double getMileage();
}
class Car extends Vehicle{
    Car(double speed,double fuelCapacity){
        super(speed,fuelCapacity);
    }
    @Override
    public double getMileage(){
        return (speed*0.5)/fuelCapacity;
    }
}
class Truck extends Vehicle{
    Truck(double speed,double fuelCapacity){
        super(speed,fuelCapacity);
    }
    @Override
    public double getMileage(){
        return (speed*0.3)/fuelCapacity;
    }
}
public class Q2_Vehicle_Hierarchy {
    public static void main(String ar[]){
        Car c1=new Car(70,190);
        System.out.println(c1.getMileage());

        Truck t1=new Truck(70,190);
        System.out.println(t1.getMileage());
    }
}
