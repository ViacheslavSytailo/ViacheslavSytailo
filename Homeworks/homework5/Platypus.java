package homework5;

public class Platypus extends Mammal implements CanSwim, CanEat
{
    public Platypus(String name, String type) {
        super(name, type);
    }


    @Override
    public void eat() {
        System.out.println("Platypus eat`s bugs");
    }


    @Override
    public void swim() {
        System.out.println("Platypus can swim");
    }

    @Override
    public String toString() {
        return "Platypus{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
