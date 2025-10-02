package HASH;

import java.util.HashSet;
import java.util.Iterator;

public class Hashset {
    public static void main(String[] args) {
        // Create HashSet of Integer type
        HashSet<Integer> set = new HashSet<>();

        // ------------------------------
        // 1. Add Elements
        // ------------------------------
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1); // duplicate -> will be ignored (HashSet stores only unique values)

        // ------------------------------
        // 2. Size of Set
        // ------------------------------
        System.out.println("Size of set is: " + set.size()); // should be 3

        // ------------------------------
        // 3. Search Elements
        // ------------------------------
        if (set.contains(1)) {
            System.out.println("1 is present");
        }
        if (!set.contains(6)) {
            System.out.println("6 is absent");
        }

        // ------------------------------
        // 4. Delete Elements
        // ------------------------------
        set.remove(1);
        if (!set.contains(1)) {
            System.out.println("1 is removed & now absent");
        }

        // ------------------------------
        // 5. Print All Elements (unordered)
        // ------------------------------
        System.out.println("Set elements: " + set);

        // ------------------------------
        // 6. Iterate over Set
        // ------------------------------
        set.add(0); // adding another element
        Iterator<Integer> it = set.iterator();
        System.out.print("Iterating over set: ");
        while (it.hasNext()) {
            System.out.print(it.next() + ", ");
        }
        System.out.println();

        // ------------------------------
        // 7. Check Empty or Not
        // ------------------------------
        if (!set.isEmpty()) {
            System.out.println("Set is not empty");
        }
    }
}
