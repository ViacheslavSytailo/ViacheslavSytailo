package homework6.Task1;

public class Test {
    public static void main(String[] args) {
        for(Week w : Week.values())
            System.out.println(w);
       Week fri = Week.FRIDAY;
        System.out.println(fri.ordinal());
    }


}
