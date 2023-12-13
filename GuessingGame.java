import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game!");
        playGame(input);
        System.out.println("Thanks for playing!");
        input.close();
    }

    public static void playGame(Scanner input) {
        final int LOWER_BOUND = 1;
        final int UPPER_BOUND = 100;
        final int MAX_ATTEMPTS = 15;
        int totalScore = 0;

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = generateRandomNumber(LOWER_BOUND, UPPER_BOUND);
            int attempts = 0;

            System.out.println("Guess the number between " + LOWER_BOUND + " and " + UPPER_BOUND + ":");
            while (attempts < MAX_ATTEMPTS) {
                int userGuess = getUserGuess(input);

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attempts++;
            }

            if (attempts == MAX_ATTEMPTS) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + targetNumber);
            }

            totalScore += MAX_ATTEMPTS - attempts;

            System.out.println("Your current score: " + totalScore);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = input.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }
    }

    public static int generateRandomNumber(int lowerBound, int upperBound) {
        Random random = new Random();
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }

    public static int getUserGuess(Scanner scanner) {
        int userGuess = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter your guess: ");
            if (scanner.hasNextInt()) {
                userGuess = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume the invalid input
            }
        }

        return userGuess;
    }
}
