package STACK;

// StackDS.java
public class StackLL {

    // Inner class representing a single node of the linked list
    private static class Node {
        int data;       // Value stored in this node
        Node next;      // Reference to the next node

        Node(int data) {    // Constructor
            this.data = data;
            next = null;
        }
    }

    // Static inner class representing the Stack itself
    static class Stack {
        public static Node head = null; // Top of the stack

        // Push operation: insert element at the beginning
        public static void push(int data) {
            Node newNode = new Node(data); // Create new node
            if (head == null) {            // If stack empty
                head = newNode;            // new node becomes top
                return;
            }
            newNode.next = head;           // Link new node to old top
            head = newNode;                // Update top
        }

        // Check if stack is empty
        public static boolean isEmpty() {
            return head == null;
        }

        // Pop operation: remove and return top element
        public static int pop() {
            if (isEmpty()) {               // If empty, return -1
                return -1;
            }
            Node top = head;               // Store current top
            head = head.next;              // Move head to next
            return top.data;               // Return popped data
        }

        // Peek operation: return top element without removing it
        public static int peek() {
            if (isEmpty()) {               // If empty, return -1
                return -1;
            }
            Node top = head;               // Current top
            return top.data;               // Return its value
        }
    }

    public static void main(String args[]) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // Print and remove all elements from stack
        while (!stack.isEmpty()) {
            System.out.println(stack.peek()); // Print top element
            stack.pop();                      // Remove top element
        }
    }
}
