import java.util.Collections;
import java.util.LinkedList;

public class LL_ReverseWithCollections {
    public static void main(String[] args) {
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);

        System.out.println("Original LinkedList: " + list2);

        // Collections.reverse() reverses order in-place
        Collections.reverse(list2);

        System.out.println("Reversed LinkedList using Collections: " + list2);
    }
}
