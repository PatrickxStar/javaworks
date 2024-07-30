import java.util.HashMap;

public class PrintMeMyHashmap {

    // Method to print all keys in the hashmap
    public static void printKeys(HashMap<String, String> hashmap) {
        for (String key : hashmap.keySet()) {
            System.out.println(key);
        }
    }

    // Method to print keys in the hashmap that contain the given text
    public static void printKeysWhere(HashMap<String, String> hashmap, String text) {
        for (String key : hashmap.keySet()) {
            if (key.contains(text)) {
                System.out.println(key);
            }
        }
    }

    // Method to print values of keys in the hashmap that contain the given text
    public static void printValuesOfKeysWhere(HashMap<String, String> hashmap, String text) {
        for (String key : hashmap.keySet()) {
            if (key.contains(text)) {
                System.out.println(hashmap.get(key));
            }
        }
    }

    // Main method to demonstrate the functionality
    public static void main(String[] args) {
        // Example usage
        HashMap<String, String> hashmap = new HashMap<>();
        hashmap.put("f.e", "for example");
        hashmap.put("etc.", "and so on");
        hashmap.put("i.e", "more precisely");

        // Print all keys
        printKeys(hashmap);
        System.out.println("---");

        // Print keys containing "i"
        printKeysWhere(hashmap, "i");
        System.out.println("---");

        // Print values of keys containing ".e"
        printValuesOfKeysWhere(hashmap, ".e");
    }
}
