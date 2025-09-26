// ==============================
// REVERSE A LINKED LIST IN JAVA
// Methods: Iterative, Recursive
// ==============================

public class LL_ReverseLinkedListDemo {

    // Our Linked List implementation
    static class MyLinkedList {
        Node head;   // head pointer

        // Node class
        class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        // Add node at end for testing
        public void addLast(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }

        // Print list
        public void printList() {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + " -> ");
                curr = curr.next;
            }
            System.out.println("null");
        }

        // ======================
        // 1. Reverse Iterative
        // Time: O(n), Space: O(1)
        // ======================
        public void reverseListIterative() {
            // Empty list or single node: nothing to reverse
            if (head == null || head.next == null) {
                return;
            }

            Node prevNode = null; // previous pointer starts null
            Node currNode = head; // current pointer at head
            Node nextNode;        // next pointer to keep track

            // Traverse list and reverse links one by one
            while (currNode != null) {
                nextNode = currNode.next;  // store next node
                currNode.next = prevNode;  // reverse link
                prevNode = currNode;       // move prev one step
                currNode = nextNode;       // move curr one step
            }
            // After loop prevNode points to new head
            head = prevNode;
        }

        // ======================
        // 2. Reverse Recursive
        // Time: O(n), Space: O(1) extra (but call stack O(n))
        // ======================
        public Node reverseListRecursive(Node head) {
            // Base case: empty or single node
            if (head == null || head.next == null) {
                return head;
            }

            // Reverse rest of the list recursively
            Node newHead = reverseListRecursive(head.next);

            // Reverse current node
            head.next.next = head;
            head.next = null;

            return newHead;
        }

        // Helper to call recursive reverse on this list
        public void reverseUsingRecursion() {
            head = reverseListRecursive(head);
        }
    }

    // MAIN for testing
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        System.out.println("Original list:");
        list.printList();

        // Iterative reverse
        list.reverseListIterative();
        System.out.println("Reversed list (Iterative):");
        list.printList();

        // Reverse again using recursion to get original back
        list.reverseUsingRecursion();
        System.out.println("Reversed list again (Recursive):");
        list.printList();
    }
}
