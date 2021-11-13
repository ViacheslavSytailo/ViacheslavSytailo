package homework5;

public class Martin extends Bird implements CanEat, CanFly
{
String beak;

    public Martin(String name, String type, String beak) {
        super(name, type);
        this.beak = beak;
    }


    @Override
    public void fly() {
        System.out.println("Martin is a flying creature");
    }

    @Override
    public void iAm() {
        System.out.println("Martin is a bird");
    }

    @Override
    public void eat() {
        System.out.println("Martin eat`s bugs");
    }

    @Override
    public Double speed(CanFly canfly) {
        double martinFlyingspeed = 100.19;
        return martinFlyingspeed;
    }

    @Override
    public Double speed() {
        return null;
    }
}
