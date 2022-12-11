package day5;

public class CrateCommand {
    public String command;
    public int quantity;
    public int origin;
    public int destination;

    public CrateCommand(String command, int quantity, int origin, int destination) {
        this.command = command;
        this.quantity = quantity;
        this.origin = origin - 1;
        this.destination = destination - 1;
    }
}
