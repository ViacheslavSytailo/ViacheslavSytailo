import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("If I drink, I die. If I eat, I am fine. What am I?”");
        Scanner scan = new Scanner(System.in);
        String answer;
        boolean exitRiddle;

        exitRiddle = false;

        for(int i = 1; i <= 3; i++)
        {
            if (exitRiddle == true) {
                break;
            }
            answer = scan.nextLine();

            switch (answer)
            {
                case "Fire":
                    System.out.println("Great!");
                    exitRiddle = true;
                    break;
                case "I don`t know":
                    System.out.println("Answer: Fire");
                    exitRiddle = true;
                    break;
                default:
                    System.out.println("Try again");
                    break;
            }
        }

    }
}
