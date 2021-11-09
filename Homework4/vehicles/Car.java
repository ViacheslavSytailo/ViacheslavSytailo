package vehicles;
import professions.Driver;
import details.Engine;

public class Car
{
    private String brand;
    private String type;
    private String weight;
    private Driver driver;
    private Engine engine;

    public Car(String brand, String type, String weight, Driver driver, Engine engine) {
        this.brand = brand;
        this.type = type;
        this.weight = weight;
        this.driver = driver;
        this.engine = engine;
    }

    public static void start()
    {
        System.out.println("Let`s drive");
    }

    public static void stop()
    {
        System.out.println("Stop");
    }

    public static void turnRight()
    {
        System.out.println("Turn right");
    }

    public static void turnLeft()
    {;
        System.out.println("Turn left");
    }

    public void printInfo() {
        System.out.println(this.brand);
        System.out.println(this.type);
        System.out.println(this.weight);
        System.out.println(this.driver);
        System.out.println(this.engine);
    }

}
