/*
* This program blows up a string into letters
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
public class Main {
    /**
     * Determines whether a character represents a digit.
     *
     * @param character The character to check
     * @return true if the character is a digit, otherwise false
     */
    public static boolean isDigit(char character) {
        return Character.isDigit(character);
    }

    /**
     * Blows up the input string based on the specified rules.
     *
     * @param userInput The input string to blow up
     * @return The blown up string
     */
    public static String blowUp(String userInput) {
        StringBuilder blownUpString = new StringBuilder();

        for (int i = 0; i < userInput.length(); i++) {
            // Checks if value is a digit
            if (isDigit(userInput.charAt(i))) {
                // Checks if next character is also a number
                if (i + 1 < userInput.length() && isDigit(userInput.charAt(i + 1))) {
                    // If yes, ignore the previous number
                    continue;
                } else {
                    // Multiplies letters by their respected values
                    int multiplier = Character.getNumericValue(userInput.charAt(i));
                    for (int j = 0; j < multiplier; j++) {
                        // Appends characters to a new string 
                        // the same amount of times as the digit before it
                        blownUpString.append(userInput.charAt(i + 1));
                    }
                }
            } else {
                // If value isn't a digit, append it to the new string
                blownUpString.append(userInput.charAt(i));
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String that you want to blow up: ");
        String userInput = scanner.nextLine();

        if (!userInput.isEmpty()) {
            String finalString = blowUp(userInput);
            System.out.println("The blown up string is: " + finalString);
        } else {
            System.out.println("Invalid Input");
        }

        System.out.println("\nDone.");
    }
}
