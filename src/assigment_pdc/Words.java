import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Words {
    
    private Map<Integer, List<String>> levelWords;
    private static final String RESOURCES_PATH = "resources/";

    public Words() {
        this.levelWords = new HashMap<>();
        loadAllWords();
    }

    private void loadAllWords() {
        for (int level = 1; level <= 3; level++) {
            try {
                List<String> words = Files.readAllLines(Paths.get(RESOURCES_PATH + "level" + level + ".txt"));
                levelWords.put(level, words);
            } catch (IOException e) {
                System.err.println("Failed to load words for level " + level + ": " + e.getMessage());
                // Optionally, initialize with an empty list to prevent NullPointerException
                levelWords.put(level, List.of());
            }
        }
    }

    public List<String> getWordsForLevel(int level) {
        return levelWords.getOrDefault(level, List.of());
    }
    
    
}
