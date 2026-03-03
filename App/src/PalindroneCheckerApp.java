import java.util.Scanner;

/**
 * ============================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 10: Normalized Palindrome Validation
 *
 * Description:
 * This class validates a palindrome after preprocessing
 * the input string.
 *
 * Normalization includes:
 * - Removing spaces and symbols
 * - Converting to lowercase
 *
 * This ensures the palindrome check is logical rather
 * than character-format dependent.
 *
 * Example:
 * "A man a plan a canal Panama"
 *
 * @author Developer
 * @version 10.0
 */
public class PalindroneCheckerApp {

    /**
     * Application entry point for UC10.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("============================================================");
        System.out.println("    UC10: Case-Insensitive & Space-Ignored Palindrome       ");
        System.out.println("============================================================");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        String normalized = normalize(input);
        boolean result = isPalindrome(normalized);

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
     * Checks whether the normalized string is a palindrome
     * using a two-pointer approach on a character array.
     *
     * Flow:
     * 1. Convert normalized string to char array
     * 2. Use left and right pointers from both ends
     * 3. Compare characters moving inward
     * 4. If all match, return true
     *
     * @param normalized The preprocessed string
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(String normalized) {

        // Convert to char array for indexed access
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
     * Normalizes the input string using String preprocessing
     * and Regular Expressions.
     *
     * Steps:
     * - Convert to lowercase          → case-insensitive check
     * - Remove non-alphanumeric chars → space and symbol ignored
     *
     * @param input Raw input string
     * @return Normalized string
     */
    public static String normalize(String input) {
        // Step 1: Convert to lowercase
        String lower = input.toLowerCase();

        // Step 2: Remove spaces, symbols using regex
        String cleaned = lower.replaceAll("[^a-z0-9]", "");

        return cleaned;
    }
}
