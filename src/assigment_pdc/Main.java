// this is our main method to ask the user for inputs to reviece 
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameManager gameManager = new GameManager();

        //Introduction message
        System.out.println("Welcome to our Hangman game (without the hangman)!");

        // Ask the user for their name
        System.out.print("Please enter your name: ");
        String username = scanner.nextLine();

        boolean play = true;
        while (play) {
            GameMenu.displayMenu();
            System.out.println("Choose an option: " + username + "!");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Please choose your level 1, 2, or 3: ");
                    int level = Integer.parseInt(scanner.nextLine());
                    if (level < 1 || level > 3) {
                        System.out.println("Invalid level. Please choose 1, 2, or 3.");
                        break;
                    }
                    User user = new User(username); // Use the user's name
                    gameManager.addUser(user);
                    gameManager.startGame(user, level);
                    break;
                case "2":
                    System.out.println("Scores:");
                    gameManager.displayScores();
                    break;
                case "3":
                    System.out.println("Viewing Game Statistics:");
                    gameManager.displayGameStats(); // Call to display game statistics
                    break;
                case "4":
                    play = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
//Second part of the assigment now we have to implement our project into a GUI interFace 
