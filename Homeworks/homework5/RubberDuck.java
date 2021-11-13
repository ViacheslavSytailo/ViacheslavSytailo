package homework5;

import java.util.Objects;

public class RubberDuck extends Bird implements CanSwim
{
 String material;
 String beak;

    public RubberDuck(String material, String beak, String name, String type) {
        super(name, type);
        this.material = material;
        this.beak = beak;
    }

    @Override
    public void fly() {
        System.out.println("RubberDuck is a flying creature");
    }

    @Override
    public void iAm() {
        System.out.println("RubberDuck is a rubber bird:)");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RubberDuck that = (RubberDuck) o;
        return Objects.equals(material, that.material) && Objects.equals(beak, that.beak);
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, beak);
    }

    @Override
    public String toString() {
        return "RubberDuck{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", material='" + material + '\'' +
                ", beak='" + beak + '\'' +
                '}';
    }


    @Override
    public void swim() {
        System.out.println("RubberDuck can sweam");
    }
}
