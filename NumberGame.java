import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        boolean playAgain = true;

        System.out.println("===== NUMBER GAME =====");

        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1; // 1 to 100
            int maxAttempts = 5;
            int attempts = 0;
            boolean guessedCorrectly = false;
            System.out.println("\nGuess the number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;
                if (guess == randomNumber) {
                    System.out.println("🎉 Correct! You guessed the number.");
                    guessedCorrectly = true;
                    score++;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You lost! The number was: " + randomNumber);
            }

            System.out.println("Current Score: " + score);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nFinal Score: " + score);
        System.out.println("Thank you for playing!");
        sc.close();
    }
}
