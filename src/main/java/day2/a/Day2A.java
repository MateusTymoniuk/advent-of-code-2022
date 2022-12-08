package day2.a;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2A {

    static int totalScore = 0;

    public static void main(String[] args) {
        String filePath = "src/main/resources/day2.txt";
        String currentLine;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader reader = new BufferedReader(fileReader)) {
            while ((currentLine = reader.readLine()) != null) {
                String[] game = currentLine.split(" ");
                Shape selectedShape = SelectedShape.get(game[1].trim());
                int roundResult = selectedShape.roundResult(game[0].trim());
                int shapeValue =    selectedShape.getShapeValue();
                // find score for round
                //
                totalScore += roundResult + shapeValue;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(totalScore);
    }
}
