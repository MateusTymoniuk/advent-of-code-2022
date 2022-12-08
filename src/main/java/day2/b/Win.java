package day2.b;

public class Win implements Result {
    @Override
    public int getRoundResult(Shape shape) {
        return 6 + shape.getShapeValue();
    }

    @Override
    public Shape getShape(String opponent) {
        if ("A".equals(opponent)) {
            return new Paper();
        } else if ("B".equals(opponent)) {
            return new Scissor();
        }
        return new Rock();
    }
}
