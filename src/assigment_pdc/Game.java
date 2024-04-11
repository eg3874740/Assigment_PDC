package Assignment_1;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author doris
 */

public class Game {
    private User user;
    private GameLevel gameLevel;
    private String secretWord;
    private StringBuilder displayWord;
    private final Set<Character> correctGuesses;
    private final Set<Character> incorrectGuesses;
    private int remainingAttempts;
    private static final int MAX_ATTEMPTS = 6;

    public Game(User user, GameLevel gameLevel) throws IOException {
        this.user = user;
        this.gameLevel = gameLevel;
        this.correctGuesses = new HashSet<>();
        this.incorrectGuesses = new HashSet<>();
        initializeGame();
    }

    private void initializeGame() throws IOException {
        secretWord = gameLevel.selectWord();
        remainingAttempts = MAX_ATTEMPTS;
        // Adding spaces between underscores for clarity.
        displayWord = new StringBuilder(String.join(" ", "_".repeat(secretWord.length()).split("")));
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        while (remainingAttempts > 0 && displayWord.indexOf("_") != -1) {
            System.out.println("\nWord: " + displayWord.toString());
            System.out.println("Incorrect Guesses: " + incorrectGuesses.toString());
            System.out.println("Guess a letter: ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.isEmpty() || input.length() > 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Invalid input. Please enter a single letter.");
                continue;
            }
            char guess = input.charAt(0);

            if (correctGuesses.contains(guess) || incorrectGuesses.contains(guess)) {
                System.out.println("Letter already guessed. Try a different one.");
                continue;
            }

            if (secretWord.indexOf(guess) >= 0) {
                correctGuesses.add(guess);
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == guess) {
                        displayWord.setCharAt(i * 2, guess);
                    }
                }
            } else {
                incorrectGuesses.add(guess);
                remainingAttempts--;
                System.out.println("Incorrect! Remaining attempts: " + remainingAttempts);
            }
        }
        endGame();
    }

    private void endGame() {
        String guessedWord = displayWord.toString().replace(" ", "");
        
        if (guessedWord.equals(secretWord)) {
            System.out.println("Congratulations! You've guessed the word: " + secretWord);
            user.addScore(10); // Adjust scoring as needed.
        } else {
            System.out.println("Game Over! The secret word was: " + secretWord);
        }
        System.out.println(user.getName() + ", your score is: " + user.getScore());
    }
        
    
}
