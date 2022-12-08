package day2.a;

public class Rock implements Shape {

    @Override
    public int roundResult(String opponent) {
        if ("B".equals(opponent)) { // lost
            return 0;
        } else if ("A".equals(opponent)) { // draw
            return 3;
        }
        return 6; // won
    }

    @Override
    public int getShapeValue() {
        return 1;
    }
}
