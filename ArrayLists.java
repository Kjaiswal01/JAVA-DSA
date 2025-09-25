import java.util.ArrayList;
import java.util.Collections;

class ArrayLists {
    public static void main(String args[]) {
        // Create an ArrayList of Integer type
        ArrayList<Integer> list = new ArrayList<Integer>();

        // =============== Add Elements ===============
        // add() adds elements at the end of the list by default
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("Initial list: " + list);  // [1, 2, 3, 4]

        // =============== Get an Element ===============
        // get(index) returns the element at a given index (0-based indexing)
        int element = list.get(0); // element at index 0
        System.out.println("Element at index 0: " + element);

        // =============== Add Element in Between ===============
        // add(index, element) inserts element at given index, shifts subsequent elements
        list.add(1, 2); // Insert 2 at index 1
        System.out.println("After inserting 2 at index 1: " + list);

        // =============== Set Element (Replace) ===============
        // set(index, element) replaces element at index with new value
        list.set(0, 0); // Replace element at index 0 with 0
        System.out.println("After setting index 0 to 0: " + list);

        // =============== Delete Elements ===============
        // remove(index) deletes element at the given index
        list.remove(0); // Remove element at index 0
        System.out.println("After removing element at index 0: " + list);

        // =============== Size of List ===============
        // size() returns number of elements in the list
        int size = list.size();
        System.out.println("Size of list: " + size);

        // =============== Loop over List Elements ===============
        // Using a for loop to iterate through all elements
        System.out.print("List elements: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " "); // get(i) to access each element
        }
        System.out.println();

        // =============== Sorting the List ===============
        // Collections.sort() sorts elements of list in ascending order by default
        list.add(0); // Add another element (0) to see sorting
        Collections.sort(list); // Sorts list in ascending order
        System.out.println("After sorting: " + list);
    }
}
