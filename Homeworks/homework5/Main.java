package homework5;


public class Main
{
    public static void main(String[] args)
    {
        RubberDuck rubberDuck = new RubberDuck("rubber", "rubberbeak", "Ducky", "rubberBird");
        Swan swan = new Swan("WhiteSwan","swan");
        Platypus platypus = new Platypus("Platy", "Platypus");
        Martin martin = new Martin("Marty", "martin", "beak");
        System.out.println(swan);
        swan.eat();
        platypus.swim();
    }
}
