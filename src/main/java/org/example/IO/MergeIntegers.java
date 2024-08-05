package org.example.IO;

import java.io.*;
import java.util.*;

public class MergeIntegers {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> mergedList = new ArrayList<>();
        Set<Integer> commonIntegers = new HashSet<>();

        // Reading integers from input1.txt and input2.txt
        try {
            list1 = readIntegersFromFile("src/main/resources/input1.txt");
            list2 = readIntegersFromFile("src/main/resources/input2.txt");
        } catch (FileNotFoundException e) {
            System.err.println("One of the input files was not found.");
            e.printStackTrace();
            return;
        } catch (IOException e) {
            System.err.println("An I/O error occurred while reading the input files.");
            e.printStackTrace();
            return;
        } catch (NumberFormatException e) {
            System.err.println("An invalid integer was found in the input files.");
            e.printStackTrace();
            return;
        }

        // Merging contents and maintaining original order
        mergedList.addAll(list1);
        mergedList.addAll(list2);

        // Identifying common integers
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        for (Integer num : set1) {
            if (set2.contains(num)) {
                commonIntegers.add(num);
            }
        }

        // Writing merged integers to merged.txt
        try {
            writeIntegersToFile("src/main/resources/merged.txt", mergedList);
        } catch (IOException e) {
            System.err.println("An I/O error occurred while writing to merged.txt.");
            e.printStackTrace();
        }

        // Writing common integers to common.txt
        try {
            writeIntegersToFile("src/main/resources/common.txt", new ArrayList<>(commonIntegers));
        } catch (IOException e) {
            System.err.println("An I/O error occurred while writing to common.txt.");
            e.printStackTrace();
        }
    }

    private static List<Integer> readIntegersFromFile(String fileName) throws IOException, NumberFormatException {
        List<Integer> integers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            integers.add(Integer.parseInt(line.trim()));
        }
        reader.close();
        return integers;
    }

    private static void writeIntegersToFile(String fileName, List<Integer> integers) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (Integer integer : integers) {
            writer.write(integer.toString());
            writer.newLine();
        }
        writer.close();
    }
}
