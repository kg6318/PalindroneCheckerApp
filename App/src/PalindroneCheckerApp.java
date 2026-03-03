import java.util.Scanner;

/**
 * ============================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 11: Object-Oriented Palindrome Service
 *
 * Description:
 * This class demonstrates palindrome validation using
 * object-oriented design.
 *
 * The palindrome logic is encapsulated inside a
 * PalindromeService class.
 *
 * This improves:
 * - Reusability
 * - Readability
 * - Separation of concerns
 *
 * @author Developer
 * @version 11.0
 */
public class PalindroneCheckerApp {

    /**
     * Application entry point for UC11.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("============================================================");
        System.out.println("         UC11: Object-Oriented Palindrome Service           ");
        System.out.println("============================================================");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        // Instantiate the PalindromeService (Encapsulation)
        PalindromeService service = new PalindromeService();
        boolean result = service.checkPalindrome(input);

        System.out.println("------------------------------------------------------------");
        System.out.println("Input     : \"" + input + "\"");
        System.out.println("Normalized: \"" + service.normalize(input) + "\"");
        System.out.println("Result    : " + (result
                ? "It IS a palindrome!"
                : "It is NOT a palindrome."));
        System.out.println("============================================================");

        scanner.close();
    }
}

/**
 * Service class that contains palindrome logic.
 *
 * Follows Single Responsibility Principle:
 * This class is solely responsible for palindrome validation.
 *
 * Data Structure used internally: char Array (two-pointer approach)
 */
class PalindromeService {

    /**
     * Checks whether the input string is a palindrome.
     *
     * Flow:
     * 1. Normalize the input string
     * 2. Convert to char array
     * 3. Compare using left and right pointers
     *
     * @param input Input string
     * @return true if palindrome, false otherwise
     */
    public boolean checkPalindrome(String input) {
        String normalized = normalize(input);

        // Convert to char array for internal array-based comparison
        char[] chars = normalized.toCharArray();

        int left  = 0;
        int right = chars.length - 1;

        // Two-pointer comparison
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /**
     * Normalizes the input string.
     *
     * - Converts to lowercase
     * - Removes spaces and non-alphanumeric characters
     *
     * @param input Raw input string
     * @return Normalized string
     */
    public String normalize(String input) {
        return input.toLowerCase().replaceAll("[^a-z0-9]", "");
    }
}
