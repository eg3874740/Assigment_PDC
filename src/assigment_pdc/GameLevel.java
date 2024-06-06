import java.util.List;
import java.util.Random;

/**
 * The GameLevel class represents a level in the Hangman game.
 * It manages the words available for the specified level.
 */
public class GameLevel {
    private int level;
    private List<String> words;

    /**
     * Constructs a GameLevel with the specified level and word bank.
     * It retrieves the words corresponding to the level from the word bank.
     * 
     * @param level the difficulty level of the game
     * @param wordBank the word bank containing words for different levels
     */
    public GameLevel(int level, Words wordBank) {
        this.level = level;
        this.words = wordBank.getWordsForLevel(level);
    }

     /**
     * Selects a random word from the list of words for the current level.
     * If no words are available, it returns an empty string.
     * 
     * @return a randomly selected word for the level
     */
    public String selectWord() {
        if (words.isEmpty()) {
            return "";
        }
        return words.get(new Random().nextInt(words.size()));
    }
}
