import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

/**
 * ============================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 * Description:
 * This class demonstrates how different palindrome
 * validation algorithms can be selected dynamically
 * at runtime using the Strategy Design Pattern.
 *
 * At this stage, the application:
 * - Defines a common PalindromeStrategy interface
 * - Implements a concrete Stack based strategy
 * - Implements a concrete Deque based strategy
 * - Injects the strategy at runtime
 * - Executes the selected algorithm
 *
 * No performance comparison is done in this use case.
 * The focus is purely on algorithm interchangeability.
 *
 * The goal is to teach extensible algorithm design.
 *
 * @author Developer
 * @version 12.0
 */

import java.util.Stack;

public class PalindroneCheckerApp {

    /**
     * Application entry point for UC12.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("============================================================");
        System.out.println("     UC12: Strategy Pattern for Palindrome Algorithms       ");
        System.out.println("============================================================");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        System.out.println("------------------------------------------------------------");
        System.out.println("Select Algorithm Strategy:");
        System.out.println("  1 - Stack Strategy");
        System.out.println("  2 - Deque Strategy");
        System.out.print("Enter choice: ");
        int choice = Integer.parseInt(scanner.nextLine().trim());

        // Inject strategy dynamically at runtime (Strategy Pattern)
        PalindromeStrategy strategy;
        switch (choice) {
            case 1:
                strategy = new StackStrategy();
                break;
            case 2:
                strategy = new DequeStrategy();
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Stack Strategy.");
                strategy = new StackStrategy();
        }

        // Execute selected algorithm via common interface (Polymorphism)
        boolean result = strategy.checkPalindrome(input);

        System.out.println("------------------------------------------------------------");
        System.out.println("Strategy  : " + strategy.getStrategyName());
        System.out.println("Input     : \"" + input + "\"");
        System.out.println("Normalized: \"" + normalize(input) + "\"");
        System.out.println("Result    : " + (result
                ? "It IS a palindrome!"
                : "It is NOT a palindrome."));
        System.out.println("============================================================");

        scanner.close();
    }

    /**
     * Normalizes the input string by converting to lowercase
     * and removing all non-alphanumeric characters.
     *
     * @param input Raw input string
     * @return Normalized string
     */
    public static String normalize(String input) {
        return input.toLowerCase().replaceAll("[^a-z0-9]", "");
    }
}

/**
 * ============================================================
 * INTERFACE - PalindromeStrategy
 * ============================================================
 *
 * This interface defines a contract for all
 * palindrome checking algorithms.
 *
 * Any new algorithm must implement this interface
 * and provide its own validation logic.
 */
interface PalindromeStrategy {

    /**
     * Checks whether the input string is a palindrome.
     *
     * @param input Input string
     * @return true if palindrome, false otherwise
     */
    boolean checkPalindrome(String input);

    /**
     * Returns the name of the strategy.
     *
     * @return Strategy name
     */
    String getStrategyName();

    /**
     * Default normalization shared across all strategies.
     *
     * @param input Raw input string
     * @return Normalized string
     */
    default String normalize(String input) {
        return input.toLowerCase().replaceAll("[^a-z0-9]", "");
    }
}

/**
 * ============================================================
 * CLASS - StackStrategy
 * ============================================================
 *
 * Palindrome algorithm using Stack data structure.
 *
 * Flow:
 * 1. Push first half of characters onto Stack
 * 2. Pop and compare with second half
 * 3. If all match, it is a palindrome
 *
 * Data Structure: Stack (LIFO)
 */
class StackStrategy implements PalindromeStrategy {

    /**
     * Checks palindrome using Stack.
     *
     * @param input Input string
     * @return true if palindrome, false otherwise
     */
    @Override
    public boolean checkPalindrome(String input) {
        String normalized = normalize(input);
        int length = normalized.length();

        Stack<Character> stack = new Stack<>();

        // Push first half onto stack
        for (int i = 0; i < length / 2; i++) {
            stack.push(normalized.charAt(i));
        }

        // Start comparing from second half
        int start = (length % 2 == 0) ? length / 2 : length / 2 + 1;

        for (int i = start; i < length; i++) {
            if (stack.isEmpty() || stack.pop() != normalized.charAt(i)) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    /**
     * Returns the strategy name.
     *
     * @return Strategy name
     */
    @Override
    public String getStrategyName() {
        return "Stack Strategy";
    }
}

/**
 * ============================================================
 * CLASS - DequeStrategy
 * ============================================================
 *
 * Palindrome algorithm using Deque data structure.
 *
 * Flow:
 * 1. Insert all characters into Deque
 * 2. Remove from both front and rear simultaneously
 * 3. Compare until Deque is empty
 *
 * Data Structure: Deque (Double Ended Queue)
 */
class DequeStrategy implements PalindromeStrategy {

    /**
     * Checks palindrome using Deque.
     *
     * @param input Input string
     * @return true if palindrome, false otherwise
     */
    @Override
    public boolean checkPalindrome(String input) {
        String normalized = normalize(input);

        Deque<Character> deque = new ArrayDeque<>();

        // Insert all characters into deque
        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }

        // Compare front and rear using removeFirst() and removeLast()
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns the strategy name.
     *
     * @return Strategy name
     */
    @Override
    public String getStrategyName() {
        return "Deque Strategy";
    }
}
