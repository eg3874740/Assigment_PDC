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
            return "";
        }
        return words.get(new Random().nextInt(words.size()));
    }
}
