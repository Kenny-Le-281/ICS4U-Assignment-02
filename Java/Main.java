/*
* This program blows up a string into letters.
*
* @author  Kenny Le
* @version 1.0
* @since   2024-03-29
*/

import java.util.Scanner;

/**
 * This program blows up a string into letters
 *
 * @version 1.0
 * @since 2024-03-29
 */
final class Main {
    /**
     * Determines whether a character represents a digit.
     *
     * @param character The character to check
     * @return true if the character is a digit, otherwise false
     */
    public static boolean isDigit(char checkCharacter) {
        return Character.isDigit(checkCharacter);
    }

    /**
     * Blows up the input string based on the specified rules.
     *
     * @param userInput The input string to blow up
     * @return The blown up string
     */
    public static String blowUp(String userInput) {
        final StringBuilder blownUpString = new StringBuilder();

        for (int counter1 = 0; counter1 < userInput.length(); counter1++) {
            // Checks to see if the specific character is a digit
            if (isDigit(userInput.charAt(counter1))) {
                // Checks if next character is also a number
                if (counter1 + 1 < userInput.length() 
                    && isDigit(userInput.charAt(counter1 + 1))) {
                    // If yes, ignore the previous number
                    continue;
                } else {
                    // Multiplies letters by the digit
                    final int multiplier = Character.getNumericValue(userInput.charAt(counter1));
                    for (int counter2 = 0; counter2 < multiplier; counter2++) {
                        // Appends characters to a new string
                        // the same amount of times as the digit before it
                        blownUpString.append(userInput.charAt(counter1 + 1));
                    }
                }
            } else {
                // If value isn't a digit, append it to the new string
                continue;
            }
        }
        return blownUpString.toString();
    }

    /**
     * Main method to execute the program.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String that you want to blow up: ");
        final String userInput = scanner.nextLine();

        // Checks that user input is not empy then proceeds
        if (!userInput.isEmpty()) {
            final String finalString = blowUp(userInput);
            System.out.println("The blown up string is: " + finalString);
        } else {
            System.out.println("Invalid Input");
        }

        System.out.println("\nDone.");
    }
}
