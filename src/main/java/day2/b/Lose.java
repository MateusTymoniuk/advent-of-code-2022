package day2.b;

public class Lose implements Result {

    @Override
    public int getRoundResult(Shape shape) {
        return shape.getShapeValue();
    }

    @Override
    public Shape getShape(String opponent) {
        if ("A".equals(opponent)) { // rock
            return new Scissor();
        } else if ("B".equals(opponent)) { // paper
            return new Rock();
        }
        return new Paper(); // scissor
    }
}
