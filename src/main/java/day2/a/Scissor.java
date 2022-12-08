package day2.a;

public class Scissor implements Shape {

    @Override
    public int roundResult(String opponent) {
        if ("A".equals(opponent)) { // lost
            return 0;
        } else if ("C".equals(opponent)) { // draw
            return 3;
        }
        return 6; // won
    }

    @Override
    public int getShapeValue() {
        return 3;
    }
}
