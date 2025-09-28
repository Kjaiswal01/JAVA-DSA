package STACK;

import java.util.*;

// =====================================
// Program: Push an element at the bottom of a stack
// Using recursion
// =====================================

public class StackProblem1 {

    // -------------------------------------
    // pushAtBottom() - Recursive Function
    // -------------------------------------
    // This method inserts 'data' at the **bottom** of the stack 's'
    // by using recursion.
    // Steps:
    // 1. If stack is empty → push data (base case).
    // 2. Otherwise pop the top element, call pushAtBottom()
    //    to insert data into the smaller stack,
    //    then push back the popped element.
    // -------------------------------------
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            // Base case: stack empty → directly push data
            s.push(data);
            return;
        }

        // Pop the top element
        int temp = s.pop();

        // Recursively insert data into the remaining stack
        pushAtBottom(s, data);

        // Push back the stored element to restore original order
        s.push(temp);
    }

    public static void main(String args[]) {
        // Create a stack using Java's built-in Stack class
        Stack<Integer> stack = new Stack<>();

        // Push initial elements
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Insert 4 at the **bottom** of the stack
        pushAtBottom(stack, 4);

        // Print all elements by popping (LIFO)
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
