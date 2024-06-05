/**
 *
 * @author doris
 */
public class Application {
    public static void main(String[] args) {
        // Initialize the GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {  //The run method creates and displays a new instance of HangmanGUI.
                new HangmanGUI();
            }
        });
    }
}
