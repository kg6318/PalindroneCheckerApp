/**
 * ============================================================
 * MAIN CLASS - UseCase6PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 6: Queue + Stack Fairness Check
 *
 * Description:
 * This class demonstrates palindrome validation using
 * two different data structures:
 *
 * - Queue (FIFO - First In First Out)
 * - Stack (LIFO - Last In First Out)
 *
 * Characters are inserted into both structures and then
 * compared by removing from the front of the queue and
 * the top of the stack.
 *
 * If all characters match, the input string is confirmed
 * as a palindrome.
 *
 * This use case helps understand how FIFO and LIFO
 * behaviors can be combined for symmetric comparison.
 *
 * @author Developer
 * @version 6.0
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class UseCase6PalindromeCheckerApp {

    /**
     * Application entry point for UC6.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Define the input string to validate.
        String input = "civic";

        // Create a Queue to store characters in FIFO order.
        Queue<Character> queue = new LinkedList<>();

        // Create a Stack to store characters in LIFO order.
        Stack<Character> stack = new Stack<>();

        // Insert each character into both queue and stack.
        for (char c : input.toCharArray()) {
            queue.add(c);   // Enqueue - adds to rear
            stack.push(c);  // Push - adds to top
        }

        // Flag to track palindrome status.
        boolean isPalindrome = true;

        // Compare characters until the queue becomes empty.
        while (!queue.isEmpty()) {

            // Dequeue from front (FIFO order).
            char fromQueue = queue.poll();

            // Pop from top (LIFO - reverse order).
            char fromStack = stack.pop();

            // Compare both characters.
            if (fromQueue != fromStack) {
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