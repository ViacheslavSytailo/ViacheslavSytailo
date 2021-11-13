package homework5;

public class Swan extends Bird implements CanFly, CanSwim, CanEat
{
    public Swan(String name, String type) {
        super(name, type);
    }

    @Override
    public void fly() {
        System.out.println("Swan is a flying creature");
    }

    @Override
    public void iAm() {
        System.out.println("Swan is a bird");
    }


    @Override
    public Double speed(CanFly canfly) {
        double swanFlyingSpeed = 110.00;
        return swanFlyingSpeed;
    }

    @Override
    public Double speed() {
        return null;
    }

    @Override
    public void swim() {
        System.out.println("Swan can swim");
    }

    @Override
    public void eat() {
        System.out.println("Swan eat`s grass");
    }

    @Override
    public String toString() {
        return "Swan{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
