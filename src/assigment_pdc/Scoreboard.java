public class Scoreboard {
  
    private final List<User> users;

    public Scoreboard(List<User> users) {
        this.users = users;
    }

    public void displayScores() {
        System.out.println("===== Scoreboard =====");
        for (User user : users) {
            System.out.println(user.getName() + "'s score: " + user.getScore());
        }
        System.out.println("======================");
    }
}
