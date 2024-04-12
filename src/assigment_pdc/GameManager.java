import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final List<User> users;
    private final List<Game> games;
    private final GameStats gameStats; // Add this
    Words wordBank = new Words();

    public GameManager() {
        this.users = new ArrayList<>();
        this.games = new ArrayList<>();
        this.gameStats = new GameStats(); // Initialize this
    }

    public void addUser(User user) {
        users.add(user);
    }

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

    public void displayScores() {
        Scoreboard scoreboard = new Scoreboard(users);
        scoreboard.displayScores();
    }

    public List<User> getUsers() {
        return users;
    }
    
    public void displayGameStats() {
        gameStats.displayStats();
    }
}
