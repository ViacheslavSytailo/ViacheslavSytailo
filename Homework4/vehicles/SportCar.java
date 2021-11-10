package vehicles;

import details.Engine;
import professions.Driver;

public class SportCar extends Car
{
    double speed;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public SportCar(String brand, String type, String weight, Driver driver, Engine engine, double speed) {
        super(brand, type, weight, driver, engine);
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "SportCar{" +
                "speed=" + speed +
                '}';
    }
}
