package day2.b;

public class SelectedShape {

    public static Shape get(String selectedShape) {
        if ("X".equals(selectedShape)) {
            return new Rock();
        } else if ("Y".equals(selectedShape)) {
            return new Paper();
        }
        return new Scissor();
    }
}
