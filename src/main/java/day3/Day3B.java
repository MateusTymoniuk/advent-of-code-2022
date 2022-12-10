package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day3B {

    static List<Character> badges = new ArrayList<>();

    public static void main(String[] args) {
        String filePath = "src/main/resources/day3.txt";
        String currentLine;
        int lineNumber = 0;
        String[] elvesRucksack = new String[3];
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader reader = new BufferedReader(fileReader)) {
            while ((currentLine = reader.readLine()) != null) {
                if (lineNumber == 2) {
                    elvesRucksack[lineNumber] = currentLine;
                    checkRucksack(elvesRucksack);
                    lineNumber = 0;
                } else {
                    elvesRucksack[lineNumber] = currentLine;
                    lineNumber++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(calculatePrioritySum());
    }

    private static void checkRucksack(String[] currentLine) {
        Set<Character> elf1Items = new HashSet<>();
        Set<Character> elf2Items = new HashSet<>();
        Set<Character> elf3Items = new HashSet<>();

        char[] elf1ItemsTmp = currentLine[0].toCharArray();
        for (char item : elf1ItemsTmp) {
            elf1Items.add(item);
        }

        char[] elf2ItemsTmp = currentLine[1].toCharArray();
        for (char item : elf2ItemsTmp) {
            elf2Items.add(item);
        }

        char[] elf3ItemsTmp = currentLine[2].toCharArray();
        for (char item : elf3ItemsTmp) {
            elf3Items.add(item);
        }

        elf1Items.removeIf(e -> !elf2Items.contains(e));
        elf1Items.removeIf(e -> !elf3Items.contains(e));

        badges.addAll(elf1Items);
    }

    private static int calculatePrioritySum() {
        return badges.stream()
                .map(item -> CharacterPriority.characterPriority.get(item))
                .mapToInt(Integer::intValue)
                .sum();
    }
}