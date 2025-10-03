package HASH;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        // 1. Creation
        HashMap<String, Integer> map = new HashMap<>();

        // 2. Insertion
        map.put("India", 120);
        map.put("US", 30);
        map.put("China", 150);

        // Print map
        System.out.println("Initial Map: " + map);

        // 3. Update value (China from 150 → 180)
        map.put("China", 180);
        System.out.println("After updating China: " + map);

        // 4. Searching
        if (map.containsKey("Indonesia")) {
            System.out.println("Indonesia is present in the map");
        } else {
            System.out.println("Indonesia is NOT present in the map");
        }

        // get() method
        System.out.println("Population of China: " + map.get("China")); // key exists
        System.out.println("Population of Indonesia: " + map.get("Indonesia")); // key doesn't exist → null

        // 5. Iteration (Method 1: using entrySet)
        System.out.println("\nIteration using entrySet:");
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " → " + e.getValue());
        }

        // 6. Iteration (Method 2: using keySet)
        System.out.println("\nIteration using keySet:");
        for (String key : map.keySet()) {
            System.out.println(key + " → " + map.get(key));
        }

        // 7. Removing a key
        map.remove("China");
        System.out.println("\nAfter removing China: " + map);
    }
}
