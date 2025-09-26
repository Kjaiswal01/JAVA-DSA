// ==============================
// BEST LINKED LIST QUESTIONS IN JAVA
// 1. Remove N-th Node from End
// 2. Check if Linked List is Palindrome
// 3. Detect Loop in a Linked List
// ==============================

public class LinkedListProblems {

    // Definition for singly-linked list node
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // ==============================
    // 1. Remove N-th Node from End
    // Time Complexity: O(n) (single pass to count + second to remove)
    // Space Complexity: O(1)
    // ==============================
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Edge case: if only one node
        if (head.next == null) {
            return null;
        }

        // 1st pass: count total nodes
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // If removing the head itself (n == size)
        if (n == size) {
            return head.next;
        }

        // Find the (size - n)th node (previous to target)
        int positionToFind = size - n; // position of prev node
        ListNode prev = head;
        int currentPos = 1; // we start from node1

        while (currentPos != positionToFind) {
            prev = prev.next;
            currentPos++;
        }

        // Remove target node by skipping it
        prev.next = prev.next.next;
        return head;
    }

    // ==============================
    // 2. Check if Linked List is Palindrome
    // Time Complexity: O(n)
    // Space Complexity: O(1) (reverse in-place)
    // ==============================

    // Helper to get middle node (slow-fast pointer)
    public static ListNode getMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // fast jumps 2 steps, slow 1 step
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow now at middle
        return slow;
    }

    // Helper to reverse linked list
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // temporarily store next
            curr.next = prev;          // reverse link
            prev = curr;               // move prev ahead
            curr = next;               // move curr ahead
        }
        return prev; // new head after reversal
    }

    public static boolean isPalindrome(ListNode head) {
        // Edge cases: 0 or 1 node is always palindrome
        if (head == null || head.next == null) {
            return true;
        }

        // 1. Find middle of list
        ListNode firstHalfEnd = getMiddle(head);

        // 2. Reverse second half of list
        ListNode secondHalfStart = reverse(firstHalfEnd.next);

        // 3. Compare first half and reversed second half
        ListNode firstHalfStart = head;
        while (secondHalfStart != null) {
            if (secondHalfStart.val != firstHalfStart.val) {
                return false;
            }
            secondHalfStart = secondHalfStart.next;
            firstHalfStart = firstHalfStart.next;
        }

        return true;
    }

    // ==============================
    // 3. Detect Loop in a Linked List (Floyd's Cycle Detection)
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ==============================
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // move 1 step
            fast = fast.next.next;   // move 2 steps

            if (fast == slow) {      // pointers meet => cycle
                return true;
            }
        }

        return false; // reached end => no cycle
    }

    // ==============================
    // MAIN METHOD: test the above
    // ==============================
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 1. Remove Nth from End (remove 2nd from end -> remove 4)
        head = removeNthFromEnd(head, 2);
        System.out.print("After removing 2nd from end: ");
        printList(head);

        // 2. Palindrome check
        // Create palindrome list: 1 -> 2 -> 2 -> 1
        ListNode pal = new ListNode(1);
        pal.next = new ListNode(2);
        pal.next.next = new ListNode(2);
        pal.next.next.next = new ListNode(1);
        System.out.println("Is palindrome? " + isPalindrome(pal));

        // 3. Detect cycle
        // Create cycle list: 1 -> 2 -> 3 -> 4 -> back to 2
        ListNode cycleHead = new ListNode(1);
        cycleHead.next = new ListNode(2);
        cycleHead.next.next = new ListNode(3);
        cycleHead.next.next.next = new ListNode(4);
        // make cycle: 4.next = 2
        cycleHead.next.next.next.next = cycleHead.next;
        System.out.println("Has cycle? " + hasCycle(cycleHead));
    }

    // Helper to print list (for testing non-cycle lists)
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
