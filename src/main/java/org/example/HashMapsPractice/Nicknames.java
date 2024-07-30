package org.example.HashMapsPractice;
import java.util.HashMap;

public class Nicknames {
        public static void main(String[] args) {
            // Create a new HashMap
            HashMap<String, String> nicknames = new HashMap<>();

            // Store the names and nicknames in the HashMap
            nicknames.put("matthew", "matt");
            nicknames.put("michael", "mix");
            nicknames.put("arthur", "artie");

            // Get Matthew's nickname from the HashMap
            String matthewNickname = nicknames.get("matthew");

            // Print Matthew's nickname
            System.out.println(matthewNickname);
        }

    }
