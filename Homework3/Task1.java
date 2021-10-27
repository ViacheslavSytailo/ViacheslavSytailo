import java.util.Random;

public class Task1 {


    public static void main(String[] args)
    {
        int[] array1 = {15, 8, 24, 41, 9, 84};
        Random random = new Random();
        int index = random.nextInt(array1.length);
        int indexRandom = array1[index];
        if ((indexRandom % 2) == 0) {
            System.out.println("I am lucky");
        } else {
            System.out.println("Run again");
        }
    }
}
