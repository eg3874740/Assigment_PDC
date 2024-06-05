import java.util.ArrayList;
import java.util.List;

//The GameManager class manages users, games, game statistics, and the word bank for the Hangman game.
public class GameManager {
    private final List<User> users;
    private final List<Game> games;
    private final GameStats gameStats;
    private final Words wordBank;

    public GameManager() {
        this.users = new ArrayList<>();
        this.games = new ArrayList<>();
        this.gameStats = new GameStats();
        this.wordBank = new Words();
    }

    public void addUser(User user) {
        users.add(user);
    }

     /**
     * Starts a new game for the specified user at the given level.
     * 
     * @param user the user who will play the game
     * @param level the difficulty level of the game
     */
    
    public void startGame(User user, int level) {
        GameLevel gameLevel = new GameLevel(level, wordBank);
        Game game = new Game(user, gameLevel);
        games.add(game);
    }

    public Game getCurrentGame(User user) {
        for (Game game : games) {
            if (game.getUser().equals(user)) {
                return game;
            }
        }
        return null;
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
