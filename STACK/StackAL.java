// Stack using Java-ArrayList
package STACK;

import java.util.ArrayList;

public class StackAL {

    // Static inner class 'Stack' implementing a stack using ArrayList
    static class Stack {
        // Underlying storage for stack elements
        ArrayList<Integer> list = new ArrayList<>();

        // Push operation: adds an element on top of the stack
        public void push(int data) {
            list.add(data);  // ArrayList adds at the end, which we treat as top
        }

        // Check if the stack is empty
        public boolean isEmpty() {
            return list.size() == 0;
        }

        // Pop operation: removes and returns the top element
        public int pop() {
            if (isEmpty()) {
                // If stack is empty, return -1 as an error code
                return -1;
            }
            // remove() removes and returns element at given index
            int top = list.remove(list.size() - 1); // last index = top of stack
            return top;
        }

        // Peek operation: returns the top element without removing it
        public int peek() {
            if (isEmpty()) {
                // If stack is empty, return -1 as an error code
                return -1;
            }
            // get() just reads element at index
            return list.get(list.size() - 1); // last index = top of stack
        }
    }

    public static void main(String args[]) {
        // Create a stack object
        Stack stack = new Stack();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // Pop and print all elements until the stack is empty
        while (!stack.isEmpty()) {
            // Look at the top element
            System.out.println(stack.peek());
            // Remove the top element
            stack.pop();
        }
    }
}

