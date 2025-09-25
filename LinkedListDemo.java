// ==============================
// LINKED LIST IN JAVA
// 1. Using Java Collection Framework (java.util.LinkedList)
// 2. Scratch Implementation of Singly Linked List
// ==============================

import java.util.LinkedList;

public class LinkedListDemo {

    // ==============================
    // PART 1: Built-in LinkedList Example
    // ==============================
    public static void builtInLinkedListDemo() {
        System.out.println("=== Built-in LinkedList Demo ===");

        // Create a LinkedList of Strings
        LinkedList<String> list = new LinkedList<String>();

        // Add elements at end by default
        list.add("is");
        list.add("a");
        list.addLast("list");          // add at last explicitly
        list.addFirst("this");         // add at first explicitly
        list.add(3, "linked");         // insert at index 3
        System.out.println("List after additions: " + list);

        // Access elements
        System.out.println("First element: " + list.get(0));
        System.out.println("Size: " + list.size());

        // Remove elements
        list.remove(3);                // remove at index 3
        list.removeFirst();            // remove first
        list.removeLast();             // remove last
        System.out.println("List after removals: " + list);

        System.out.println();
    }

    // ==============================
    // PART 2: Scratch Implementation
    // ==============================
    static class MyLinkedList {
        Node head;     // head of list
        private int size;  // track size of list

        MyLinkedList() {
            size = 0;
        }

        // Node class (inner)
        public class Node {
            String data;
            Node next;

            Node(String data) {
                this.data = data;
                this.next = null;
                size++;
            }
        }

        // Add node at beginning
        public void addFirst(String data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        // Add node at end
        public void addLast(String data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }

        // Insert node at a specific index (middle)
        public void addInMiddle(int index, String data) {
            if (index > size || index < 0) {
                System.out.println("Invalid Index value");
                return;
            }
            // size++ happens in Node constructor automatically
            Node newNode = new Node(data);
            if (head == null || index == 0) {
                newNode.next = head;
                head = newNode;
                return;
            }
            Node currNode = head;
            for (int i = 1; i < size; i++) {
                if (i == index) {
                    Node nextNode = currNode.next;
                    currNode.next = newNode;
                    newNode.next = nextNode;
                    break;
                }
                currNode = currNode.next;
            }
        }

        // Print the linked list
        public void printList() {
            Node currNode = head;
            while (currNode != null) {
                System.out.print(currNode.data + " -> ");
                currNode = currNode.next;
            }
            System.out.println("null");
        }

        // Remove first node
        public void removeFirst() {
            if (head == null) {
                System.out.println("Empty List, nothing to delete");
                return;
            }
            head = head.next;
            size--;
        }

        // Remove last node
        public void removeLast() {
            if (head == null) {
                System.out.println("Empty List, nothing to delete");
                return;
            }
            size--;
            if (head.next == null) {
                head = null;
                return;
            }
            Node currNode = head;
            Node lastNode = head.next;
            while (lastNode.next != null) {
                currNode = currNode.next;
                lastNode = lastNode.next;
            }
            currNode.next = null;
        }

        // Get current size
        public int getSize() {
            return size;
        }
    }

    // ==============================
    // MAIN METHOD: Run both demos
    // ==============================
    public static void main(String[] args) {
        // Built-in LinkedList demo
        builtInLinkedListDemo();

        // Scratch implementation demo
        System.out.println("=== Scratch Linked List Demo ===");
        MyLinkedList list = new MyLinkedList();

        // Add elements at end
        list.addLast("is");
        list.addLast("a");
        list.addLast("list");
        list.printList();

        // Add element at beginning
        list.addFirst("this");
        list.printList();
        System.out.println("Size: " + list.getSize());

        // Insert element in the middle (index 2)
        list.addInMiddle(2, "linked");
        list.printList();
        System.out.println("Size: " + list.getSize());

        // Remove first
        list.removeFirst();
        list.printList();

        // Remove last
        list.removeLast();
        list.printList();
    }
}
