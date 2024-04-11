import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GameStats {
    
    private static final String USERS_FILE = "resources/users.txt";
    
    public void displayStats() {
        try {
            List<UserScore> scores = Files.readAllLines(Paths.get(USERS_FILE)).stream()
                    .map(line -> line.split(","))
                    .filter(parts -> parts.length == 2)
                    .map(parts -> new UserScore(parts[0], Integer.parseInt(parts[1])))
                    .sorted(Comparator.comparing(UserScore::getScore).reversed())
                    .collect(Collectors.toList());
            
            System.out.println("Leaderboard:");
            scores.forEach(score -> System.out.println(score.getName() + ": " + score.getScore()));
        } catch (IOException e) {
            System.out.println("An error occurred while reading scores: " + e.getMessage());
        }
    }
    
    private static class UserScore {
        private final String name;
        private final int score;
        
        public UserScore(String name, int score) {
            this.name = name;
            this.score = score;
        }
        
        public String getName() {
            return name;
        }
        
        public int getScore() {
            return score;
        }
    }
    
}
