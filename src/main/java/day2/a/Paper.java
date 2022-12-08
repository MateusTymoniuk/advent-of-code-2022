package day2.a;

public class Paper implements Shape{

    @Override
    public int roundResult(String opponent) {
        if ("C".equals(opponent)) { // lost
            return 0;
        } else if ("B".equals(opponent)) { // draw
            return 3;
        }
        return 6; // won
    }

    @Override
    public int getShapeValue() {
        return 2;
    }
}
