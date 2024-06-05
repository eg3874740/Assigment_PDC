public class InputValid {

    /**
     * Validates if the given input is a valid level input.
     * A valid level input is a single digit between 1 and 3.
     * 
     * @param input the input string to be validated
     * @return true if the input is a valid level input, false otherwise
     */

    public static boolean isValidLevelInput(String input) {
        return input.matches("[1-3]");
    }

     /**
     * Validates if the given input is a valid letter input.
     * A valid letter input is a single alphabetical character (either uppercase or lowercase).
     * 
     * @param input the input string to be validated
     * @return true if the input is a valid letter input, false otherwise
     */
    public static boolean isValidLetterInput(String input) {
        return input.matches("[a-zA-Z]");
    }
    
    
}
