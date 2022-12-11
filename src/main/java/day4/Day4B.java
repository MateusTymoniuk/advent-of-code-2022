package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day4B {

    private static int overlaped = 0;

    public static void main(String[] args) {
        String filePath = "src/main/resources/day4.txt";
        String currentLine;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader reader = new BufferedReader(fileReader)) {
            while ((currentLine = reader.readLine()) != null) {
                checkSections(currentLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(overlaped);
    }

    private static void checkSections(String sectionsDescription) {
        String[] elvesSections = sectionsDescription.split(",");
        int[] sectionBoundaries1 = Arrays.stream(elvesSections[0].split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] sectionBoundaries2 = Arrays.stream(elvesSections[1].split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] lowerInterval = {sectionBoundaries1[0], sectionBoundaries2[0]};
        int[] upperInterval = {sectionBoundaries1[1], sectionBoundaries2[1]};
        checkIfSectionsAreContained(lowerInterval, upperInterval);
    }

    private static void checkIfSectionsAreContained(int[] lowerInterval, int[] upperInterval) {
        if (upperInterval[0] >= lowerInterval[1]
        && lowerInterval[0] <= upperInterval[1]) {
            overlaped++;
        }
    }
}
