import professions.Driver;
import vehicles.Car;
import details.Engine;
import vehicles.SportCar;
import vehicles.Truck;

public class Main
{
    public static void main(String[] args)
    {
        Driver driver = new Driver(28, "ViacheslavS", "Viacheslav", 3);
        Driver driver1 = new Driver(42, "Andrew", "And", 2);
        Driver driver2 = new Driver(35, "John Rembo", "John", 10);
        Engine engine = new Engine(100, "Merlyn");
        Engine engine1 = new Engine(200, "DB");
        Engine engine2 = new Engine(100, "MAN");
        Car car = new Car("Aston Martin", "sedan", "10", driver, engine);
        SportCar sportCar = new SportCar("Ferrari", "8", "10", driver1, engine1,30.5);
        Truck truck = new Truck("Iveco","Truck", "10", driver2, engine2, 50);
        System.out.println(car);
        System.out.println(sportCar);
        System.out.println(truck);
        car.start();
        car.stop();
        car.turnRight();
        car.turnLeft();
        car.printInfo();
    }
}
