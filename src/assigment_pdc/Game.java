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

    

    

  
  
}
