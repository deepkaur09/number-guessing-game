import java.util.*;

public class GuessNumber{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int correctNum = random.nextInt(101);
        System.out.print("Guess the number between 0 to 100: ");
        int guessedNum;
        int tries = 0;
        boolean matched = false;
        int maxTries = 5;

        while(!matched && maxTries > tries){
            guessedNum = sc.nextInt();
            tries++;

            if (guessedNum == correctNum){
                matched = true;
            }
            else if(guessedNum < correctNum && maxTries > tries){
                System.out.print("Guess a bigger number: ");
            }
            else if(guessedNum > correctNum && maxTries > tries){
                System.out.print("Guess a smaller number: ");
            }
        }
        if(matched){
            System.out.println("You took " + tries + " tries to guess the right number!");
        }
        else{
            System.out.println("Try again?");
        }
        sc.close();
    }
}