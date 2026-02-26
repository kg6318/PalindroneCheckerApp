/**
 * ============================================================
 * MAIN CLASS - UseCase5PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 5: Stack Based Palindrome Checker
 *
 * Description:
 * This class validates a palindrome using a Stack
 * data structure which follows the LIFO principle.
 *
 * At this stage, the application:
 * - Pushes characters into a stack
 * - Pops them in reverse order
 * - Compares with original sequence
 * - Displays the result
 *
 * This maps stack behavior to reversal logic.
 *
 * @author Developer
 * @version 5.0
 */

import java.util.Stack;

public class UseCase5PalindromeCheckerApp {

    /**
     * Application entry point for UC5.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Declare and initialize the input string.
        String input = "noon";

        // Create a Stack to store characters.
        Stack<Character> stack = new Stack<>();

        // Push each character of the string into the stack.
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Assume palindrome initially.
        boolean isPalindrome = true;

        // Iterate again through original string.
        for (char c : input.toCharArray()) {

            // Pop character from stack (reverse order).
            char popped = stack.pop();

            // Compare popped character with original.
            if (c != popped) {
                isPalindrome = false;
                break;
            }
        }

        // Display the input string.
        System.out.println("Input : " + input);

        // Display the palindrome result.
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}