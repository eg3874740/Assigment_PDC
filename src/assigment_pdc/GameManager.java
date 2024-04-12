import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final List<User> users;
    private final List<Game> games;
    private final GameStats gameStats; 
    Words wordBank = new Words();

    public GameManager() {
        this.users = new ArrayList<>();
        this.games = new ArrayList<>();
        this.gameStats = new GameStats(); 
    }

    // Adds a user to the game system
    public void addUser(User user) {
        users.add(user);
    }

    // Starts a new game for a user at a specified level
    public void startGame(User user, int level) {
        try {
            GameLevel gameLevel = new GameLevel(level, wordBank);
            Game game = new Game(user, gameLevel);
            games.add(game);
            game.playGame();
        } catch (IOException e) {
            System.out.println("An error occurred while starting the game: " + e.getMessage());
        }
    }

    // Displays the scores of all users
    public void displayScores() {
        Scoreboard scoreboard = new Scoreboard(users);
        scoreboard.displayScores();
    }

    // Gets the list of users
    public List<User> getUsers() {
        return users;
    }

    // Displays game statistics
    public void displayGameStats() {
        gameStats.displayStats();
    }
}
