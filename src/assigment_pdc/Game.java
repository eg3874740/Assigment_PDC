import java.util.HashSet;
import java.util.Set;

public class Game {
    private User user;
    private GameLevel gameLevel;
    private String secretWord;
    private StringBuilder displayWord;
    private final Set<Character> correctGuesses;
    private final Set<Character> incorrectGuesses;
    private int remainingAttempts;
    private static final int MAX_ATTEMPTS = 6;

    public Game(User user, GameLevel gameLevel) {
        this.user = user;
        this.gameLevel = gameLevel;
        this.correctGuesses = new HashSet<>();
        this.incorrectGuesses = new HashSet<>();
        initializeGame();
    }

    private void initializeGame() {
        secretWord = gameLevel.selectWord();
        remainingAttempts = MAX_ATTEMPTS;
        displayWord = new StringBuilder("_".repeat(secretWord.length()));
    }

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

    public String getDisplayWord() {
        return displayWord.toString().replace("", " ").trim();
    }

    public Set<Character> getIncorrectGuesses() {
        return incorrectGuesses;
    }

    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    public boolean isGameOver() {
        return remainingAttempts <= 0;
    }

    public boolean isWordGuessed() {
        return displayWord.indexOf("_") == -1;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public User getUser() {
        return user;
    }
}
