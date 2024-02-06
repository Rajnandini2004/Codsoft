import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static int randomNumber(int lower, int upper) {
        Random rand = new Random();
        return rand.nextInt(upper - lower + 1) + lower;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 6;
        int score = 0;
        String playAgain;

        do {
            int numberToGuess = randomNumber(lowerBound, upperBound);
            System.out.println(numberToGuess);

            int attempts = 0;
            System.out.println("------------------------------------------------");
            System.out.println("           🎯      NUMBER GAME     🎯          ");
            System.out.println("------------------------------------------------");
            System.out.println("Guess a number between " + lowerBound + " and " + upperBound);
            System.out.println();
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                System.out.println();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("------------------------------------------------");
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    System.out.println("------------------------------------------------");
                    score++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("🙄Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("------------------------------------------------");
                System.out.println(
                        "You've reached the maximum number of attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            System.out.println();
            playAgain = scanner.next();
            System.out.println("------------------------------------------------");
        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Your score: " + score);
        scanner.close();
    }
}
