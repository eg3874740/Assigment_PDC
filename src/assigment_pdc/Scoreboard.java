//The Scoreboard class is responsible for maintaining and displaying the scores of users.

public class Scoreboard {
  
  // A list of users whose scores are being tracked
    private final List<User> users;

  //Constructs a Scoreboard with the specified list of users.
    public Scoreboard(List<User> users) {
        this.users = users;
    }

  //Displays the scores of all users in the scoreboard.
    public void displayScores() {
        System.out.println("===== Scoreboard =====");
        for (User user : users) {
            System.out.println(user.getName() + "'s score: " + user.getScore());
        }
        System.out.println("======================");
    }
}
