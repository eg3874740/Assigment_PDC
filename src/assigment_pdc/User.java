import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class User {
    private String name;
    private int score;
    private static final String USERS_FILE = "resources/users.txt";

    public User(String name) {
        this.name = name;
        this.score = 0;
        loadScore();
    }

    private void loadScore() {
        // Load the user's score from the file
        try {
            List<String> lines = Files.readAllLines(Paths.get(USERS_FILE));
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts[0].equals(name)) {
                    score = Integer.parseInt(parts[1]);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading scores: " + e.getMessage());
            
        }
    }

    public void addScore(int points) {
        score += points;
        saveScore();
    }

    private void saveScore() {
        // Save the user's score to the file
        try {
            List<String> lines = Files.readAllLines(Paths.get(USERS_FILE));
            List<String> updatedLines = new ArrayList<>();
            boolean userFound = false;
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts[0].equals(name)) {
                    updatedLines.add(name + "," + score);
                    userFound = true;
                } else {
                    updatedLines.add(line);
                }
            }
            if (!userFound) {
                updatedLines.add(name + "," + score);
            }
            Files.write(Paths.get(USERS_FILE), updatedLines);
        } catch (IOException e) {
            System.out.println("An error occurred while saving scores: " + e.getMessage());
        }
    }


    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
    
    
}
