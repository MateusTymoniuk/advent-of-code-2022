package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1A {

    private static int maxCalories = 0;
    private static int tmpCalories = 0;

    public static void main(String[] args) {
        String filePath = "src/main/resources/day1.txt";
        String currentLine;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader reader = new BufferedReader(fileReader)) {
            while ((currentLine = reader.readLine()) != null) {
                findMaxCaloriesAmount(currentLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(maxCalories);
    }

    private static void findMaxCaloriesAmount(String currentLine) {
        if (currentLine.isBlank()) {
            if (tmpCalories > maxCalories) {
                maxCalories = tmpCalories;
            }
            tmpCalories = 0;
            return;
        }

        tmpCalories += Integer.parseInt(currentLine);
    }
}
