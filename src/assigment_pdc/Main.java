// ENTRY POINT OF MY GUI

//this is our main method to ask the user for inputs
public class Main {
    public static void main(String[] args) {
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HangmanGUI();
            }
        });
    }
}
