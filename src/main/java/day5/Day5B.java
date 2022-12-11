package day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day5B {

    private static List<String> tmpCrates = new ArrayList<>();
    private static List<Stack<Character>> listStack = new ArrayList<>();

    public static void main(String[] args) {
        String filePath = "src/main/resources/day5.txt";
        String currentLine;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader reader = new BufferedReader(fileReader)) {
            while ((currentLine = reader.readLine()) != null) {
                // check if movement
                if (currentLine.startsWith("m")) {
                    moveCrates(currentLine);
                } else { // if not, build stacks
                    buildStacks(currentLine);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        printTopCrates();
    }

    private static void buildStacks(String currentLine) {
        // check for stacks amount and build objects
        if (currentLine.contains("1")) {
            // check how many stacks to be created
            int numberOfStacks = Integer.parseInt(String.valueOf(currentLine.charAt(currentLine.length() - 1)));

            // parse cranes and add to stacks
            for (int i = 0; i < numberOfStacks; i++) {
                listStack.add(new Stack<>());
            }

            for (String crate : tmpCrates) {
                char[] crateItemsLine = crate.toCharArray();
                int i = 1; // first crate item starts at second position
                int j = 0;
                while (i < crateItemsLine.length) {
                    if (crateItemsLine[i] != ' ') {
                        // Adding to 0 because we need the first added element
                        // top be on top, so we always insert in the beginning
                        listStack.get(j).add(0, crateItemsLine[i]);
                    }
                    j++;
                    i += 4;
                }
            }
        } else if (!currentLine.isBlank()) {
            tmpCrates.add(currentLine);
        }
    }

    private static void moveCrates(String completeComand) {
        String[] splitCommand = completeComand.split(" ");
        CrateCommand command = new CrateCommand(splitCommand[0],
                Integer.parseInt(splitCommand[1]),
                Integer.parseInt(splitCommand[3]),
                Integer.parseInt(splitCommand[5])
        );

        Stack<Character> moveCrate = new Stack<>();
        for (int i = 0; i < command.quantity; i++) {
            Character crate = listStack.get(command.origin).pop();
            moveCrate.add(crate);
        }

        for (int i = 0; i < command.quantity; i++) {
            listStack.get(command.destination).add(moveCrate.pop());
        }
    }

    private static void printTopCrates() {
        listStack
                .stream()
                .map(Stack::peek)
                .forEach(System.out::print);
    }
}
