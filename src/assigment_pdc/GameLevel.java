package Assignment_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

/**
 *
 * @author doris
 */
public class GameLevel {
    private int level;
    private List<String> words;

    public GameLevel(int level) throws IOException {
        this.level = level;
        loadWords();
    }

    //load words from word file, eg."level1", depending on the level you choose
    private void loadWords() throws IOException {
        String fileName = "resources/level" + level + ".txt";
        words = Files.readAllLines(Paths.get(fileName));
    }

    ////randomly select words
    public String selectWord() {
        return words.get(new Random().nextInt(words.size()));
    }
    
    
}
