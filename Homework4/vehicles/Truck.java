package vehicles;

import details.Engine;
import professions.Driver;

public class Truck extends Car
{
    int carrying;

    public int getCarrying() {
        return carrying;
    }

    public void setCarrying(int carrying) {
        this.carrying = carrying;
    }

    public Truck(String brand, String type, String weight, Driver driver, Engine engine, int carrying) {
        super(brand, type, weight, driver, engine);
        this.carrying = carrying;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "carrying=" + carrying +
                '}';
    }
}
