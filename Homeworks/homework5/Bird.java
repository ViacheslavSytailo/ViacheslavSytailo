package homework5;

public abstract class Bird
{
String name;
String type;

    public Bird(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public abstract void fly();
    public abstract void iAm();
}
