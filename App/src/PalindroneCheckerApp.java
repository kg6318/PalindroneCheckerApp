import java.util.Scanner;

/**
 * ============================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 9: Recursive Palindrome Checker
 *
 * Description:
 * This class checks whether a string is a palindrome
 * using Recursion.
 *
 * The method calls itself by comparing characters
 * at the start and end positions:
 *
 * - Base Condition: stops recursion when indices meet or cross
 * - Recursive Case: compares outer characters and moves inward
 *
 * This demonstrates how the Call Stack manages
 * recursive method calls for symmetric validation.
 *
 * @author Developer
 * @version 9.0
 */
public class PalindroneCheckerApp {

    /**
     * Application entry point for UC9.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("============================================================");
        System.out.println("         UC9: Recursive Palindrome Checker                  ");
        System.out.println("============================================================");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        String normalized = normalize(input);
        boolean result = isPalindrome(normalized, 0, normalized.length() - 1);

        System.out.println("------------------------------------------------------------");
        System.out.println("Input     : \"" + input + "\"");
        System.out.println("Normalized: \"" + normalized + "\"");
        System.out.println("Result    : " + (result
                ? "It IS a palindrome!"
                : "It is NOT a palindrome."));
        System.out.println("============================================================");

        scanner.close();
    }

    /**
     * Recursively checks whether the given string is a palindrome.
     *
     * Flow:
     * 1. Base Condition: if start >= end, all characters matched — return true
     * 2. Compare characters at start and end index
     * 3. If mismatch — return false
     * 4. Recursive Case: move start forward and end backward
     *
     * @param str   The normalized string to validate
     * @param start Starting index
     * @param end   Ending index
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(String str, int start, int end) {

        // Base Condition: indices met or crossed — palindrome confirmed
        if (start >= end) {
            return true;
        }

        // Compare characters at current outer positions
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive Case: move inward and check remaining substring
        return isPalindrome(str, start + 1, end - 1);
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
