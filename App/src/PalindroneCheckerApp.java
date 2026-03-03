import java.util.Scanner;

/**
 * ============================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 8: Linked List Based Palindrome Checker
 *
 * Description:
 * This class checks whether a string is a palindrome
 * using a LinkedList.
 *
 * Characters are added to the list and then compared
 * by removing elements from both ends:
 *
 * - removeFirst()
 * - removeLast()
 *
 * This demonstrates how LinkedList supports
 * double-ended operations for symmetric validation.
 *
 * @author Developer
 * @version 8.0
 */
public class PalindroneCheckerApp {

    /**
     * Inner Node class for Singly Linked List.
     */
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Application entry point for UC8.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("============================================================");
        System.out.println("       UC8: Linked List Based Palindrome Checker            ");
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
     * Checks whether the given string is a palindrome
     * using a Singly Linked List with Fast and Slow Pointer Technique.
     *
     * Flow:
     * 1. Convert normalized string to a singly linked list
     * 2. Find middle using fast and slow pointers
     * 3. Reverse the second half in-place
     * 4. Compare first half and reversed second half
     *
     * @param input The string to validate
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(String input) {
        String normalized = normalize(input);

        if (normalized.length() <= 1) return true;

        // Step 1: Build the linked list
        Node head = null;
        Node tail = null;
        for (char c : normalized.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Step 2: Find middle using fast and slow pointers
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Reverse the second half in-place
        Node secondHalf = reverseList(slow);

        // Step 4: Compare first half and reversed second half
        Node firstHalf = head;
        Node temp = secondHalf;
        boolean isPalin = true;

        while (temp != null) {
            if (firstHalf.data != temp.data) {
                isPalin = false;
                break;
            }
            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        return isPalin;
    }

    /**
     * Reverses a singly linked list in-place.
     *
     * @param head Head node of the list to reverse
     * @return New head of the reversed list
     */
    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
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
