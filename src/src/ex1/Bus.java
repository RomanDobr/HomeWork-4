package src.ex1;

public class Bus extends Car {
    private static final int MAX_COUNT_PASSENGERS = 20;

    public Bus(boolean isClean, double length, double height, double width) {
        super(isClean, length, height, width);
    }



    @Override
    public String toString() {
        return "Bus{" +
                "maxCountPassengers=" + MAX_COUNT_PASSENGERS +
                '}' + super.toString();
    }
}
