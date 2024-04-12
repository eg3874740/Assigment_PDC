import java.util.List;
import java.util.Random;

public class GameLevel {
    private int level;
    private List<String> words;

    public GameLevel(int level, Words wordBank) {
        this.level = level;
        this.words = wordBank.getWordsForLevel(level);
    }

    public String selectWord() {
        if (words.isEmpty()) {
            System.out.println("No words loaded for level " + level);
            return ""; // Return an empty string if no words are loaded
        }
        return words.get(new Random().nextInt(words.size()));
    }
}




