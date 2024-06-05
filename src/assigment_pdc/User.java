import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * The User class represents a user in the Hangman game and manages their score.
 * It interacts with a database to load and save the user's score.
 */

public class User {
    private String name;
    private int score;
    private static final String USERS_FILE = "resources/users.txt";

    /**
     * Constructs a User with the specified name and initializes their score.
     * The score is loaded from the database.
     * 
     * @param name the name of the user
     */
    public User(String name) {
        this.name = name;
        this.score = 0;
        loadScore();
    }

    /**
     * Loads the user's score from the database.
     * If the user does not exist in the database, the score remains 0.
     */
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

    /**
     * Adds the specified number of points to the user's score and saves the updated score to the database.
     * 
     * @param points the number of points to add to the score
     */
    public void addScore(int points) {
        score += points;
        saveScore();
    }

     /**
     * Saves the user's score to the database.
     * If the user does not exist in the database, a new entry is created.
     */
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


    /**
     * Returns the name of the user.
     * 
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the score of the user.
     * 
     * @return the score of the user
     */
    public int getScore() {
        return score;
    }
    
    
}
