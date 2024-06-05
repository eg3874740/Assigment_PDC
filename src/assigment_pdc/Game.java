import java.util.HashSet;
import java.util.Set;

//This class represents an instance of our game for a specific user.
public class Game {
    private User user;
    private GameLevel gameLevel;
    private String secretWord;
    private StringBuilder displayWord;
    private final Set<Character> correctGuesses;
    private final Set<Character> incorrectGuesses;
    private int remainingAttempts;
    private static final int MAX_ATTEMPTS = 6;

    /**
     * Constructs a Game for the specified user and game level.
     * Initializes the sets for correct and incorrect guesses and starts the game.
     * 
     * @param user the user playing the game
     * @param gameLevel the difficulty level of the game
     */

    public Game(User user, GameLevel gameLevel) {
        this.user = user;
        this.gameLevel = gameLevel;
        this.correctGuesses = new HashSet<>();
        this.incorrectGuesses = new HashSet<>();
        initializeGame();
    }

    
    //Initializes the game by selecting a secret word and setting up the display word and remaining attempts.
    private void initializeGame() {
        secretWord = gameLevel.selectWord();
        remainingAttempts = MAX_ATTEMPTS;
        displayWord = new StringBuilder("_".repeat(secretWord.length()));
    }

    /**
    *Processes a user's guess and updates the game state accordingly.
    *
    *@param guess the character guessed by the user
    */
    
    public void playGame(char guess) {
        if (correctGuesses.contains(guess) || incorrectGuesses.contains(guess)) {
            return;
        }

        if (secretWord.indexOf(guess) >= 0) {
            correctGuesses.add(guess);
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == guess) {
                    displayWord.setCharAt(i, guess);
                }
            }
        } else {
            incorrectGuesses.add(guess);
            remainingAttempts--;
        }
    }

    /**
     * Returns the current display word with guessed letters revealed.
     * 
     * @return the display word
     */
    public String getDisplayWord() {
        return displayWord.toString().replace("", " ").trim();
    }

    /**
     * Returns the set of incorrect guesses made by the user.
     * 
     * @return the set of incorrect guesses
     */
    public Set<Character> getIncorrectGuesses() {
        return incorrectGuesses;
    }

    /**
     * Returns the number of remaining attempts the user has.
     * 
     * @return the number of remaining attempts
     */
    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    /**
     * Checks if the game is over due to running out of attempts.
     * 
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        return remainingAttempts <= 0;
    }

    /**
     * Checks if the user has guessed the entire word.
     * 
     * @return true if the word is guessed, false otherwise
     */
    public boolean isWordGuessed() {
        return displayWord.indexOf("_") == -1;
    }

    /**
     * Returns the secret word of the game.
     * 
     * @return the secret word
     */
    public String getSecretWord() {
        return secretWord;
    }
    
     /**
     * Returns the user playing the game.
     * 
     * @return the user
     */
    public User getUser() {
        return user;
    }
}
