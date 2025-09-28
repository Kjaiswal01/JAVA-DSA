// Stack using Java-Collection-Framework
package STACK;  // package name STACK (optional)

// Importing all classes from java.util (including Stack class)
import java.util.*;

// Main class
public class StackJCF {
    public static void main(String args[]) {

        // ✅ Create a stack object of Integer type using Java's built-in Stack class
        Stack<Integer> stack = new Stack<>();

        // ✅ Push (add) elements on top of the stack
        stack.push(1); // stack = [1]
        stack.push(2); // stack = [1,2]
        stack.push(3); // stack = [1,2,3]
        stack.push(4); // stack = [1,2,3,4]

        // ✅ Loop until stack becomes empty
        while (!stack.isEmpty()) {
            // Peek returns the top element without removing it
            System.out.println(stack.peek());

            // Pop removes the top element from the stack
            stack.pop();
        }
    }
}
