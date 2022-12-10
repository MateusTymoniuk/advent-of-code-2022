package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3A {

    static List<Character> repeatedItems = new ArrayList<>();

    public static void main(String[] args) {
        String filePath = "src/main/resources/day3.txt";
        String currentLine;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader reader = new BufferedReader(fileReader)) {
            while ((currentLine = reader.readLine()) != null) {
                checkRucksack(currentLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(calculatePrioritySum());
    }

    private static void checkRucksack(String currentLine) {
        char[] lineItems = currentLine.toCharArray();
        int halfRucksackLength = lineItems.length / 2;
        char[] firstCompartment = Arrays.copyOfRange(lineItems, 0, halfRucksackLength);
        char[] secondCompartment = Arrays.copyOfRange(lineItems, halfRucksackLength, lineItems.length);
        for (char item1 : firstCompartment) {
            for (char item2 : secondCompartment) {
                if (item1 == item2) {
                    repeatedItems.add(item1);
                    return;
                }
            }
        }
    }

    private static int calculatePrioritySum() {
        return repeatedItems.stream()
                .map(item -> CharacterPriority.characterPriority.get(item))
                .mapToInt(Integer::intValue)
                .sum();
    }
}