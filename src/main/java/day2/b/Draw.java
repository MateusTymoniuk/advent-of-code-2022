package day2.b;

public class Draw implements Result {
    @Override
    public int getRoundResult(Shape shape) {
        return 3 + shape.getShapeValue();
    }

    @Override
    public Shape getShape(String opponent) {
        if ("A".equals(opponent)) { // rock
            return new Rock();
        } else if ("B".equals(opponent)) { // paper
            return new Paper();
        }
        return new Scissor(); // scissor
    }
}
