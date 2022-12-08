package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day1B {

    private static final int[] maxCalories = {0, 0, 0};
    private static int tmpCalories = 0;

    public static void main(String[] args) {
        String filePath = "src/main/resources/day1.txt";
        String currentLine;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader reader = new BufferedReader(fileReader)) {
            do {
                currentLine = reader.readLine();
                findMaxCaloriesAmount(currentLine);
            }
            while (currentLine != null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Arrays.stream(maxCalories).sum());
    }

    private static void findMaxCaloriesAmount(String currentLine) {
        if (currentLine == null || currentLine.isBlank()) {
            updateCaloriesArray();
            tmpCalories = 0;
            return;
        }

        tmpCalories += Integer.parseInt(currentLine);
    }

    private static void updateCaloriesArray() {
        int aux = tmpCalories;
        int tmp;
        for (int i = 0; i < maxCalories.length; i++) {
            if (aux > maxCalories[i]) {
                tmp = maxCalories[i];
                maxCalories[i] = aux;
                aux = tmp;
            }
        }
    }

}
