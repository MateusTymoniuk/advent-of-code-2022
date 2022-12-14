package day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day6 {

    private static int PROBLEM_A_PACKET_MARKER_SIZE = 4;
    private static int PROBLEM_B_MESSAGE_MARKER_SIZE = 14;

    public static void main(String[] args) {
        String filePath = "src/main/resources/day6.txt";
        String currentLine;
        int result = 0;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader reader = new BufferedReader(fileReader)) {
            while ((currentLine = reader.readLine()) != null) {
                result = processDatastream(currentLine, PROBLEM_B_MESSAGE_MARKER_SIZE);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
    }

    private static int processDatastream(String currentLine, int markerSize) {
        int j = markerSize;
        for (int i = 0; i <= currentLine.length() - markerSize; i++,j++) {
            String possibleMarker = currentLine.substring(i, j);
            long distinctChars = possibleMarker.chars()
                    .distinct()
                    .count();

            if (distinctChars == markerSize) {
                return j;
            }
        }
        return j;
    }
}
