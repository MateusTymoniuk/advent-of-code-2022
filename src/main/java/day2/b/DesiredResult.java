package day2.b;

public class DesiredResult {
    public static Result get(String desiredResult) {
        if ("X".equals(desiredResult)) {
            return new Lose();
        } else if ("Y".equals(desiredResult)) {
            return new Draw();
        }
        return new Win();
    }
}
