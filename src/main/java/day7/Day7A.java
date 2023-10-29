package day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day7A {

    public static void main(String[] args) {
        String filePath = "src/main/resources/day7.txt";
        String currentLine;
        int result = 0;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader reader = new BufferedReader(fileReader)) {
            while ((currentLine = reader.readLine()) != null) {

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
    }
}