package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day4A {

    private static int containedSections = 0;

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
        System.out.println(containedSections);
    }

    private static void checkSections(String sectionsDescription) {
        String[] elvesSections = sectionsDescription.split(",");
        int[] sectionBoundaries1 = Arrays.stream(elvesSections[0].split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] sectionBoundaries2 = Arrays.stream(elvesSections[1].split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        checkIfSectionsAreContained(sectionBoundaries1, sectionBoundaries2);
    }

    private static void checkIfSectionsAreContained(int[] sectionBoundaries1, int[] sectionBoundaries2) {
        int lowerBoundaries = sectionBoundaries1[0] - sectionBoundaries2[0];
        int upperBoundaries = sectionBoundaries1[1] - sectionBoundaries2[1];

        if (lowerBoundaries <= 0 && upperBoundaries >= 0) {
            containedSections++;
        } else if (lowerBoundaries >= 0 && upperBoundaries <= 0) {
            containedSections++;
        }
    }
}
