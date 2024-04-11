public class InputValid {
    public static boolean isValidLevelInput(String input) {
        return input.matches("[1-3]");
    }

    public static boolean isValidLetterInput(String input) {
        return input.matches("[a-zA-Z]");
    }
    
    
}
