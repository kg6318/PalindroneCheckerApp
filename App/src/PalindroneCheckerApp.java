/**
 * ============================================================
 * MAIN CLASS - UseCase4PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 4: Character Array Based Validation
 *
 * Description:
 * This class validates a palindrome by converting
 * the string into a character array and comparing
 * characters using the two-pointer technique.
 *
 * At this stage, the application:
 * - Converts string to char array
 * - Uses start and end pointers
 * - Compares characters efficiently
 * - Displays the result
 *
 * This reduces extra memory usage.
 *
 * @author Developer
 * @version 4.0
 */

public class PalindroneCheckerApp {

    /**
     * Application entry point for UC4.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Declare and initialize the input string.
        String input = "radar";

        // Convert the string into a character array.
        char[] chars = input.toCharArray();

        // Initialize pointer at the beginning.
        int start = 0;

        // Initialize pointer at the end.
        int end = chars.length - 1;

        // Assume palindrome initially.
        boolean isPalindrome = true;

        // Continue comparison until pointers cross.
        while (start < end) {

            // Compare characters at start and end positions.
            if (chars[start] != chars[end]) {
                // Mismatch found - not a palindrome.
                isPalindrome = false;
                break;
            }

            // Move start pointer forward.
            start++;

            // Move end pointer backward.
            end--;
        }

        // Display the input string.
        System.out.println("Input : " + input);

        // Display the palindrome result.
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}