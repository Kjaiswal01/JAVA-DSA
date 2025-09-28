package STACK;

import java.util.*;

// ================================
// CODE TO REVERSE A STACK (USING RECURSION)
// ================================
public class StackProblem2 {

    // -----------------------------
    // pushAtBottom():
    // Inserts an element at the very bottom of a stack using recursion.
    // -----------------------------
    public static void pushAtBottom(Stack<Integer> s, int data) {
        // Base case: if stack is empty, just push data
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        // Step 1: Pop the top element
        int temp = s.pop();

        // Step 2: Recurse for the remaining stack
        pushAtBottom(s, data);

        // Step 3: Push the popped element back after insertion
        s.push(temp);
    }

    // -----------------------------
    // reverse():
    // Reverses a stack using recursion & pushAtBottom().
    // -----------------------------
    public static void reverse(Stack<Integer> s) {
        // Base case: empty stack
        if (s.isEmpty()) {
            return;
        }

        // Step 1: Pop the top element
        int top = s.pop();

        // Step 2: Reverse the remaining stack
        reverse(s);

        // Step 3: Push the popped element at bottom (so order reverses)
        pushAtBottom(s, top);
    }

    // -----------------------------
    // MAIN:
    // Demonstrates reversing a stack
    // -----------------------------
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();

        // Push elements onto stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Original Stack (top to bottom): " + stack);

        // Reverse the stack
        reverse(stack);

        System.out.println("Reversed Stack (top to bottom): " + stack);

        // Print and remove all elements to verify order
        System.out.println("Printing & popping reversed stack:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
