package professions;

public class Driver extends Person
{
    private String name;
    private int expirience;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExpirience() {
        return expirience;
    }

    public void setExpirience(int expirience) {
        this.expirience = expirience;
    }

    public Driver(int age, String fullName, String name, int expirience) {
        super(age, fullName);
        this.name = name;
        this.expirience = expirience;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", expirience=" + expirience +
                '}';
    }
}
