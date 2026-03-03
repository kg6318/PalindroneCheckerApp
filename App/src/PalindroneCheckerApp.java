import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * ============================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 7: Deque Based Optimized Palindrome Checker
 *
 * Description:
 * This class validates a palindrome using a Deque
 * (Double Ended Queue).
 *
 * Characters are inserted into the deque and then
 * compared by removing elements from both ends:
 *
 * - removeFirst()
 * - removeLast()
 *
 * This avoids reversing the string and provides an
 * efficient front-to-back comparison approach.
 *
 * This use case demonstrates optimal bidirectional
 * traversal using Deque.
 *
 * @author Developer
 * @version 7.0
 */
public class PalindroneCheckerApp {

    /**
     * Application entry point for UC7.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("============================================================");
        System.out.println("       UC7: Deque-Based Optimized Palindrome Checker        ");
        System.out.println("============================================================");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        boolean result = isPalindrome(input);

        System.out.println("------------------------------------------------------------");
        System.out.println("Input     : \"" + input + "\"");
        System.out.println("Normalized: \"" + normalize(input) + "\"");
        System.out.println("Result    : " + (result
                ? "It IS a palindrome!"
                : "It is NOT a palindrome."));
        System.out.println("============================================================");

        scanner.close();
    }

    /**
     * Checks whether the given string is a palindrome using a Deque.
     *
     * Flow:
     * 1. Normalize the string (lowercase, remove non-alphanumeric chars)
     * 2. Insert each character into the Deque
     * 3. Repeatedly remove from both front and rear and compare
     * 4. If all comparisons match, it is a palindrome
     *
     * @param input The string to validate
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(String input) {
        String normalized = normalize(input);

        // Step 1: Insert all characters into the Deque
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }

        // Step 2: Compare front and rear using removeFirst() and removeLast()
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear  = deque.removeLast();

            if (front != rear) {
                return false;
            }
        }

        return true;
    }

    /**
     * Normalizes the input string by converting to lowercase
     * and removing all non-alphanumeric characters.
     *
     * @param input Raw input string
     * @return Normalized string
     */
    private static String normalize(String input) {
        return input.toLowerCase().replaceAll("[^a-z0-9]", "");
    }
}