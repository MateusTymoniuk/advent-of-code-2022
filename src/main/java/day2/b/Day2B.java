package day2.b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2B {

    static int totalScore = 0;

    public static void main(String[] args) {
        String filePath = "src/main/resources/day2.txt";
        String currentLine;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader reader = new BufferedReader(fileReader)) {
            while ((currentLine = reader.readLine()) != null) {
                String[] game = currentLine.split(" ");
                Result desiredResult = DesiredResult.get(game[1].trim());
                Shape shapeForResult = desiredResult.getShape(game[0].trim());
                int roundResult = desiredResult.getRoundResult(shapeForResult);
                totalScore += roundResult;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(totalScore);
    }
}
